create index IX_A342580B on RH_Employee (departmentId, active_);
create unique index IX_ED6ECBEF on RH_Employee (email[$COLUMN_LENGTH:75$]);
create unique index IX_286E9C33 on RH_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);