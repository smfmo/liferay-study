/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import com.portal.rh.employee.exception.NoSuchEmployeeProjectException;
import com.portal.rh.employee.model.EmployeeProject;
import com.portal.rh.employee.model.EmployeeProjectTable;
import com.portal.rh.employee.model.impl.EmployeeProjectImpl;
import com.portal.rh.employee.model.impl.EmployeeProjectModelImpl;
import com.portal.rh.employee.service.persistence.EmployeeProjectPersistence;
import com.portal.rh.employee.service.persistence.EmployeeProjectUtil;
import com.portal.rh.employee.service.persistence.impl.constants.RHPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the employee project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeProjectPersistence.class)
public class EmployeeProjectPersistenceImpl
	extends BasePersistenceImpl<EmployeeProject>
	implements EmployeeProjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeProjectUtil</code> to access the employee project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeProjectImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EmployeeProjectPersistenceImpl() {
		setModelClass(EmployeeProject.class);

		setModelImplClass(EmployeeProjectImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeProjectTable.INSTANCE);
	}

	/**
	 * Caches the employee project in the entity cache if it is enabled.
	 *
	 * @param employeeProject the employee project
	 */
	@Override
	public void cacheResult(EmployeeProject employeeProject) {
		entityCache.putResult(
			EmployeeProjectImpl.class, employeeProject.getPrimaryKey(),
			employeeProject);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee projects in the entity cache if it is enabled.
	 *
	 * @param employeeProjects the employee projects
	 */
	@Override
	public void cacheResult(List<EmployeeProject> employeeProjects) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeProjects.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeProject employeeProject : employeeProjects) {
			if (entityCache.getResult(
					EmployeeProjectImpl.class,
					employeeProject.getPrimaryKey()) == null) {

				cacheResult(employeeProject);
			}
		}
	}

	/**
	 * Clears the cache for all employee projects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeProjectImpl.class);

		finderCache.clearCache(EmployeeProjectImpl.class);
	}

	/**
	 * Clears the cache for the employee project.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeProject employeeProject) {
		entityCache.removeResult(EmployeeProjectImpl.class, employeeProject);
	}

	@Override
	public void clearCache(List<EmployeeProject> employeeProjects) {
		for (EmployeeProject employeeProject : employeeProjects) {
			entityCache.removeResult(
				EmployeeProjectImpl.class, employeeProject);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeProjectImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeProjectImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee project with the primary key. Does not add the employee project to the database.
	 *
	 * @param employeeProjectId the primary key for the new employee project
	 * @return the new employee project
	 */
	@Override
	public EmployeeProject create(long employeeProjectId) {
		EmployeeProject employeeProject = new EmployeeProjectImpl();

		employeeProject.setNew(true);
		employeeProject.setPrimaryKey(employeeProjectId);

		employeeProject.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeProject;
	}

	/**
	 * Removes the employee project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project that was removed
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	@Override
	public EmployeeProject remove(long employeeProjectId)
		throws NoSuchEmployeeProjectException {

		return remove((Serializable)employeeProjectId);
	}

	/**
	 * Removes the employee project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee project
	 * @return the employee project that was removed
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	@Override
	public EmployeeProject remove(Serializable primaryKey)
		throws NoSuchEmployeeProjectException {

		Session session = null;

		try {
			session = openSession();

			EmployeeProject employeeProject = (EmployeeProject)session.get(
				EmployeeProjectImpl.class, primaryKey);

			if (employeeProject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeProjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeProject);
		}
		catch (NoSuchEmployeeProjectException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeProject removeImpl(EmployeeProject employeeProject) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeProject)) {
				employeeProject = (EmployeeProject)session.get(
					EmployeeProjectImpl.class,
					employeeProject.getPrimaryKeyObj());
			}

			if (employeeProject != null) {
				session.delete(employeeProject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeProject != null) {
			clearCache(employeeProject);
		}

		return employeeProject;
	}

	@Override
	public EmployeeProject updateImpl(EmployeeProject employeeProject) {
		boolean isNew = employeeProject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeProject);
			}
			else {
				employeeProject = (EmployeeProject)session.merge(
					employeeProject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeProjectImpl.class, employeeProject, false, true);

		if (isNew) {
			employeeProject.setNew(false);
		}

		employeeProject.resetOriginalValues();

		return employeeProject;
	}

	/**
	 * Returns the employee project with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee project
	 * @return the employee project
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	@Override
	public EmployeeProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeProjectException {

		EmployeeProject employeeProject = fetchByPrimaryKey(primaryKey);

		if (employeeProject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeProjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeProject;
	}

	/**
	 * Returns the employee project with the primary key or throws a <code>NoSuchEmployeeProjectException</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	@Override
	public EmployeeProject findByPrimaryKey(long employeeProjectId)
		throws NoSuchEmployeeProjectException {

		return findByPrimaryKey((Serializable)employeeProjectId);
	}

	/**
	 * Returns the employee project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project, or <code>null</code> if a employee project with the primary key could not be found
	 */
	@Override
	public EmployeeProject fetchByPrimaryKey(long employeeProjectId) {
		return fetchByPrimaryKey((Serializable)employeeProjectId);
	}

	/**
	 * Returns all the employee projects.
	 *
	 * @return the employee projects
	 */
	@Override
	public List<EmployeeProject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @return the range of employee projects
	 */
	@Override
	public List<EmployeeProject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee projects
	 */
	@Override
	public List<EmployeeProject> findAll(
		int start, int end,
		OrderByComparator<EmployeeProject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee projects
	 */
	@Override
	public List<EmployeeProject> findAll(
		int start, int end,
		OrderByComparator<EmployeeProject> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EmployeeProject> list = null;

		if (useFinderCache) {
			list = (List<EmployeeProject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEPROJECT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEPROJECT;

				sql = sql.concat(EmployeeProjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeProject>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee projects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeProject employeeProject : findAll()) {
			remove(employeeProject);
		}
	}

	/**
	 * Returns the number of employee projects.
	 *
	 * @return the number of employee projects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEPROJECT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeProjectId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEPROJECT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeProjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee project persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		EmployeeProjectUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeProjectUtil.setPersistence(null);

		entityCache.removeCache(EmployeeProjectImpl.class.getName());
	}

	@Override
	@Reference(
		target = RHPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = RHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = RHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMPLOYEEPROJECT =
		"SELECT employeeProject FROM EmployeeProject employeeProject";

	private static final String _SQL_COUNT_EMPLOYEEPROJECT =
		"SELECT COUNT(employeeProject) FROM EmployeeProject employeeProject";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeProject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeProject exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeProjectPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}