package com.hw.lineage.server.application.assembler;

import com.hw.lineage.server.application.dto.*;
import com.hw.lineage.server.domain.entity.*;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description: TaskAssembler
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Mapper(componentModel = "spring")
public interface DtoAssembler {
    DtoAssembler INSTANCE = Mappers.getMapper(DtoAssembler.class);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "catalogId.value", target = "catalogId")
    @Mapping(source = "taskSource.value", target = "taskSource")
    TaskDTO fromTask(Task task);

    @Mapping(source = "catalogId.value", target = "catalogId")
    @Mapping(source = "pluginId.value", target = "pluginId")
    CatalogDTO fromCatalog(Catalog catalog);

    @Mapping(source = "functionId.value", target = "functionId")
    @Mapping(source = "catalogId.value", target = "catalogId")
    FunctionDTO fromFunction(Function function);

    @Mapping(source = "pluginId.value", target = "pluginId")
    PluginDTO fromPlugin(Plugin plugin);

    List<TaskDTO> fromTaskList(List<Task> taskList);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskSqlDTO fromTaskSql(TaskSql taskSql);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskLineageDTO fromTaskLineage(TaskLineage taskLineage);

    List<FunctionDTO> fromFunctionList(List<Function> functionList);

    @Mapping(source = "userId.value", target = "userId")
    UserDTO fromUser(User user);

    @Mapping(source = "user.userId.value", target = "userId")
    UserDTO fromUserPermissions(User user, List<Permission> permissionList);

    @Mapping(source = "user.userId.value", target = "userId")
    UserDTO fromUserRoles(User user, List<Role> roleList);


    @Mapping(source = "roleId.value", target = "roleId")
    RoleDTO fromRole(Role role);

    @Mapping(source = "permissionId.value", target = "permissionId")
    PermissionDTO fromPermission(Permission permission);
}
