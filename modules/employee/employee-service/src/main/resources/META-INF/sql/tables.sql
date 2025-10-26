create table RH_Department (
	departmentId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	active_ BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table RH_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	fullName VARCHAR(75) null,
	email VARCHAR(75) null,
	departmentId LONG,
	position VARCHAR(75) null,
	active_ BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table RH_EmployeeProject (
	employeeProjectId LONG not null primary key,
	employeeId LONG,
	projectId LONG,
	allocatedHours INTEGER,
	groupId LONG,
	companyId LONG
);

create table RH_Project (
	projectId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	active_ BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);