insert into lineage.bas_user (user_id, username, password, locked, create_time, modify_time, invalid) values (1, 'demo', 'demo', 0, 1674565178000, 1674565178000, 0);
insert into lineage.bas_user (user_id, username, password, locked, create_time, modify_time, invalid) values (2, 'admin', 'admin', 0, 1674565178000, 1674565178000, 0);
insert into lineage.bas_user (user_id, username, password, locked, create_time, modify_time, invalid) values (3, 'HamaWhite', '123456', 0, 1674565178000, 1674565178000, 0);
insert into lineage.bas_user (user_id, username, password, locked, create_time, modify_time, invalid) values (4, 'Asteria', '123456', 0, 1674565178000, 1674565178000, 0);
insert into lineage.bas_user (user_id, username, password, locked, create_time, modify_time, invalid) values (5, 'Cattleya', '123456', 0, 1674565178000, 1674565178000, 0);

insert into lineage.bas_role (role_id, role_name, create_time, modify_time, invalid) values (1, 'USER', 1674565178000, 1674565178000, 0);
insert into lineage.bas_role (role_id, role_name, create_time, modify_time, invalid) values (2, 'ADMIN', 1674565178000, 1674565178000, 0);

insert into lineage.rel_role_user (rid, role_id, user_id, invalid) values (1, 1, 1, 0);
insert into lineage.rel_role_user (rid, role_id, user_id, invalid) values (2, 2, 2, 0);
insert into lineage.rel_role_user (rid, role_id, user_id, invalid) values (3, 1, 3, 0);
insert into lineage.rel_role_user (rid, role_id, user_id, invalid) values (4, 1, 4, 0);
insert into lineage.rel_role_user (rid, role_id, user_id, invalid) values (5, 1, 5, 0);

insert into lineage.bas_permission (permission_id, permission_group, permission_name, permission_code, create_time, modify_time, invalid) values (1, 'plugins', 'add plugin', 'system:plugin:add', 1674565178000, 1674565178000, 0);
insert into lineage.bas_permission (permission_id, permission_group, permission_name, permission_code, create_time, modify_time, invalid) values (2, 'plugins', 'edit plugin', 'system:plugin:edit', 1674565178000, 1674565178000, 0);
insert into lineage.bas_permission (permission_id, permission_group, permission_name, permission_code, create_time, modify_time, invalid) values (3, 'plugins', 'delete plugin', 'system:plugin:delete', 1674565178000, 1674565178000, 0);
insert into lineage.bas_permission (permission_id, permission_group, permission_name, permission_code, create_time, modify_time, invalid) values (4, 'plugins', 'disable plugin', 'system:plugin:disable', 1674565178000, 1674565178000, 0);
insert into lineage.bas_permission (permission_id, permission_group, permission_name, permission_code, create_time, modify_time, invalid) values (5, 'plugins', 'list plugin', 'system:plugin:list', 1674565178000, 1674565178000, 0);

insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (1, 1, 5, 0);
insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (2, 2, 1, 0);
insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (3, 2, 2, 0);
insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (4, 2, 3, 0);
insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (5, 2, 4, 0);
insert into lineage.rel_role_permission (rid, role_id, permission_id, invalid) values (6, 2, 5, 0);

insert into lineage.bas_plugin (plugin_id, plugin_name, descr, create_user_id, modify_user_id, create_time, modify_time, invalid) values (1, 'flink1.14.x', 'Field lineage plugin for flink1.14', 2, 2, 1674565178000, 1674565178000, 0);
insert into lineage.bas_plugin (plugin_id, plugin_name, descr, create_user_id, modify_user_id, create_time, modify_time, invalid) values (2, 'flink1.16.x', 'Field lineage plugin for flink1.16', 2, 2, 1674565178000, 1674565178000, 0);

insert into lineage.bas_catalog (catalog_id, catalog_name, catalog_type, default_database, descr, create_user_id, modify_user_id, create_time, modify_time, invalid) values (1, 'default', 0, 'default', 'Flink default catalog', 1, 1, 1674565178000, 1674565178000, 0);

insert into lineage.bas_task (task_id, task_name, descr, plugin_id, catalog_id, task_source, create_user_id, modify_user_id, create_time, modify_time, invalid) values (1, 'first_demo', 'first demo job', 1, 1, 'RFJPUCBUQUJMRSBJRiBFWElTVFMgb2RzX215c3FsX3VzZXJzOwpDUkVBVEUgVEFCTEUgSUYgTk9UIEVYSVNUUyBvZHNfbXlzcWxfdXNlcnMgKAogICAgaWQgQklHSU5UIFBSSU1BUlkgS0VZIE5PVCBFTkZPUkNFRCwKICAgIG5hbWUgU1RSSU5HLAogICAgYmlydGhkYXkgVElNRVNUQU1QKDMpLAogICAgdHMgVElNRVNUQU1QKDMpLAogICAgcHJvY190aW1lIGFzIHByb2N0aW1lICgpCiAgKQpXSVRICiAgKAogICAgJ2Nvbm5lY3Rvcic9J215c3FsLWNkYycsCiAgICAnaG9zdG5hbWUnPScxMjcuMC4wLjEnLAogICAgJ3BvcnQnPSczMzA2JywKICAgICd1c2VybmFtZSc9J3Jvb3QnLAogICAgJ3Bhc3N3b3JkJz0neHh4JywKICAgICdzZXJ2ZXItdGltZS16b25lJz0nQXNpYS9TaGFuZ2hhaScsCiAgICAnZGF0YWJhc2UtbmFtZSc9J2RlbW8nLAogICAgJ3RhYmxlLW5hbWUnPSd1c2VycycKICApOwoKCkRST1AgVEFCTEUgSUYgRVhJU1RTIGR3ZF9odWRpX3VzZXJzOwpDUkVBVEUgVEFCTEUgSUYgTk9UIEVYSVNUUwogIGR3ZF9odWRpX3VzZXJzICgKICAgIGlkIEJJR0lOVCBQUklNQVJZIEtFWSBOT1QgRU5GT1JDRUQsCiAgICBuYW1lIFNUUklORywKICAgIGNvbXBhbnlfbmFtZSBTVFJJTkcsCiAgICBiaXJ0aGRheSBUSU1FU1RBTVAoMyksCiAgICB0cyBUSU1FU1RBTVAoMyksCiAgICBgcGFydGl0aW9uYCBWQVJDSEFSKDIwKQogICkgUEFSVElUSU9ORUQgQlkgKGBwYXJ0aXRpb25gKQpXSVRICiAgKAogICAgJ2Nvbm5lY3Rvcic9J2h1ZGknLAogICAgJ3RhYmxlLnR5cGUnPSdDT1BZX09OX1dSSVRFJywKICAgICdyZWFkLnN0cmVhbWluZy5lbmFibGVkJz0ndHJ1ZScsCiAgICAncmVhZC5zdHJlYW1pbmcuY2hlY2staW50ZXJ2YWwnPScxJwogICk7CgoKSU5TRVJUIElOVE8KICBkd2RfaHVkaV91c2VycwpTRUxFQ1QKICBpZCwKICBuYW1lLAogIG5hbWUgYXMgY29tcGFueV9uYW1lLAogIGJpcnRoZGF5LAogIHRzLAogIERBVEVfRk9STUFUKGJpcnRoZGF5LCAneXl5eU1NZGQnKQpGUk9NCiAgb2RzX215c3FsX3VzZXJzOw==', 1, 1, 1674565178000, 1674565178000, 0);
insert into lineage.bas_task (task_id, task_name, descr, plugin_id, catalog_id, task_source, create_user_id, modify_user_id, create_time, modify_time, invalid) values (2, 'second_demo', 'second demo job', 2, 1, 'RFJPUCBUQUJMRSBJRiBFWElTVFMgb2RzX215c3FsX3VzZXJzOwpDUkVBVEUgVEFCTEUgSUYgTk9UIEVYSVNUUyBvZHNfbXlzcWxfdXNlcnMgKAogICAgaWQgQklHSU5UIFBSSU1BUlkgS0VZIE5PVCBFTkZPUkNFRCwKICAgIG5hbWUgU1RSSU5HLAogICAgYmlydGhkYXkgVElNRVNUQU1QKDMpLAogICAgdHMgVElNRVNUQU1QKDMpLAogICAgcHJvY190aW1lIGFzIHByb2N0aW1lICgpCiAgKQpXSVRICiAgKAogICAgJ2Nvbm5lY3Rvcic9J215c3FsLWNkYycsCiAgICAnaG9zdG5hbWUnPScxMjcuMC4wLjEnLAogICAgJ3BvcnQnPSczMzA2JywKICAgICd1c2VybmFtZSc9J3Jvb3QnLAogICAgJ3Bhc3N3b3JkJz0neHh4JywKICAgICdzZXJ2ZXItdGltZS16b25lJz0nQXNpYS9TaGFuZ2hhaScsCiAgICAnZGF0YWJhc2UtbmFtZSc9J2RlbW8nLAogICAgJ3RhYmxlLW5hbWUnPSd1c2VycycKICApOwoKCkRST1AgVEFCTEUgSUYgRVhJU1RTIGR3ZF9odWRpX3VzZXJzOwpDUkVBVEUgVEFCTEUgSUYgTk9UIEVYSVNUUwogIGR3ZF9odWRpX3VzZXJzICgKICAgIGlkIEJJR0lOVCBQUklNQVJZIEtFWSBOT1QgRU5GT1JDRUQsCiAgICBuYW1lIFNUUklORywKICAgIGNvbXBhbnlfbmFtZSBTVFJJTkcsCiAgICBiaXJ0aGRheSBUSU1FU1RBTVAoMyksCiAgICB0cyBUSU1FU1RBTVAoMyksCiAgICBgcGFydGl0aW9uYCBWQVJDSEFSKDIwKQogICkgUEFSVElUSU9ORUQgQlkgKGBwYXJ0aXRpb25gKQpXSVRICiAgKAogICAgJ2Nvbm5lY3Rvcic9J2h1ZGknLAogICAgJ3RhYmxlLnR5cGUnPSdDT1BZX09OX1dSSVRFJywKICAgICdyZWFkLnN0cmVhbWluZy5lbmFibGVkJz0ndHJ1ZScsCiAgICAncmVhZC5zdHJlYW1pbmcuY2hlY2staW50ZXJ2YWwnPScxJwogICk7CgoKSU5TRVJUIElOVE8KICBkd2RfaHVkaV91c2VycwpTRUxFQ1QKICBpZCwKICBuYW1lLAogIG5hbWUgYXMgY29tcGFueV9uYW1lLAogIGJpcnRoZGF5LAogIHRzLAogIERBVEVfRk9STUFUKGJpcnRoZGF5LCAneXl5eU1NZGQnKQpGUk9NCiAgb2RzX215c3FsX3VzZXJzOw==', 1, 1, 1674565178000, 1674565178000, 0);








