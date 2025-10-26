/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.portal.rh.employee.exception.NoSuchEmployeeProjectException;
import com.portal.rh.employee.model.EmployeeProject;
import com.portal.rh.employee.service.EmployeeProjectLocalServiceUtil;
import com.portal.rh.employee.service.persistence.EmployeeProjectPersistence;
import com.portal.rh.employee.service.persistence.EmployeeProjectUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EmployeeProjectPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.portal.rh.employee.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeProjectUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmployeeProject> iterator = _employeeProjects.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeProject employeeProject = _persistence.create(pk);

		Assert.assertNotNull(employeeProject);

		Assert.assertEquals(employeeProject.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		_persistence.remove(newEmployeeProject);

		EmployeeProject existingEmployeeProject =
			_persistence.fetchByPrimaryKey(newEmployeeProject.getPrimaryKey());

		Assert.assertNull(existingEmployeeProject);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployeeProject();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeProject newEmployeeProject = _persistence.create(pk);

		newEmployeeProject.setEmployeeId(RandomTestUtil.nextLong());

		newEmployeeProject.setProjectId(RandomTestUtil.nextLong());

		newEmployeeProject.setAllocatedHours(RandomTestUtil.nextInt());

		newEmployeeProject.setGroupId(RandomTestUtil.nextLong());

		newEmployeeProject.setCompanyId(RandomTestUtil.nextLong());

		_employeeProjects.add(_persistence.update(newEmployeeProject));

		EmployeeProject existingEmployeeProject = _persistence.findByPrimaryKey(
			newEmployeeProject.getPrimaryKey());

		Assert.assertEquals(
			existingEmployeeProject.getEmployeeProjectId(),
			newEmployeeProject.getEmployeeProjectId());
		Assert.assertEquals(
			existingEmployeeProject.getEmployeeId(),
			newEmployeeProject.getEmployeeId());
		Assert.assertEquals(
			existingEmployeeProject.getProjectId(),
			newEmployeeProject.getProjectId());
		Assert.assertEquals(
			existingEmployeeProject.getAllocatedHours(),
			newEmployeeProject.getAllocatedHours());
		Assert.assertEquals(
			existingEmployeeProject.getGroupId(),
			newEmployeeProject.getGroupId());
		Assert.assertEquals(
			existingEmployeeProject.getCompanyId(),
			newEmployeeProject.getCompanyId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		EmployeeProject existingEmployeeProject = _persistence.findByPrimaryKey(
			newEmployeeProject.getPrimaryKey());

		Assert.assertEquals(existingEmployeeProject, newEmployeeProject);
	}

	@Test(expected = NoSuchEmployeeProjectException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmployeeProject> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"RH_EmployeeProject", "employeeProjectId", true, "employeeId", true,
			"projectId", true, "allocatedHours", true, "groupId", true,
			"companyId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		EmployeeProject existingEmployeeProject =
			_persistence.fetchByPrimaryKey(newEmployeeProject.getPrimaryKey());

		Assert.assertEquals(existingEmployeeProject, newEmployeeProject);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeProject missingEmployeeProject = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingEmployeeProject);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmployeeProject newEmployeeProject1 = addEmployeeProject();
		EmployeeProject newEmployeeProject2 = addEmployeeProject();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeProject1.getPrimaryKey());
		primaryKeys.add(newEmployeeProject2.getPrimaryKey());

		Map<Serializable, EmployeeProject> employeeProjects =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, employeeProjects.size());
		Assert.assertEquals(
			newEmployeeProject1,
			employeeProjects.get(newEmployeeProject1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployeeProject2,
			employeeProjects.get(newEmployeeProject2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmployeeProject> employeeProjects =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeProjects.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmployeeProject newEmployeeProject = addEmployeeProject();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeProject.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmployeeProject> employeeProjects =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeProjects.size());
		Assert.assertEquals(
			newEmployeeProject,
			employeeProjects.get(newEmployeeProject.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmployeeProject> employeeProjects =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeProjects.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeProject.getPrimaryKey());

		Map<Serializable, EmployeeProject> employeeProjects =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeProjects.size());
		Assert.assertEquals(
			newEmployeeProject,
			employeeProjects.get(newEmployeeProject.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeProjectLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmployeeProject>() {

				@Override
				public void performAction(EmployeeProject employeeProject) {
					Assert.assertNotNull(employeeProject);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeProject.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeProjectId",
				newEmployeeProject.getEmployeeProjectId()));

		List<EmployeeProject> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmployeeProject existingEmployeeProject = result.get(0);

		Assert.assertEquals(existingEmployeeProject, newEmployeeProject);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeProject.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeProjectId", RandomTestUtil.nextLong()));

		List<EmployeeProject> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmployeeProject newEmployeeProject = addEmployeeProject();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeProject.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeProjectId"));

		Object newEmployeeProjectId = newEmployeeProject.getEmployeeProjectId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeProjectId", new Object[] {newEmployeeProjectId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmployeeProjectId = result.get(0);

		Assert.assertEquals(existingEmployeeProjectId, newEmployeeProjectId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeProject.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeProjectId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeProjectId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmployeeProject addEmployeeProject() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeProject employeeProject = _persistence.create(pk);

		employeeProject.setEmployeeId(RandomTestUtil.nextLong());

		employeeProject.setProjectId(RandomTestUtil.nextLong());

		employeeProject.setAllocatedHours(RandomTestUtil.nextInt());

		employeeProject.setGroupId(RandomTestUtil.nextLong());

		employeeProject.setCompanyId(RandomTestUtil.nextLong());

		_employeeProjects.add(_persistence.update(employeeProject));

		return employeeProject;
	}

	private List<EmployeeProject> _employeeProjects =
		new ArrayList<EmployeeProject>();
	private EmployeeProjectPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}