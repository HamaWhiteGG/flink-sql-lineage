package com.lineage.server.application.assembler;

import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.vo.CatalogId;
import com.lineage.server.domain.vo.PluginId;
import com.lineage.server.domain.vo.TaskId;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @description: DtoAssemblerTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/31 9:41 AM
 */
public class DtoAssemblerTest {

    @Test
    public void testFromTask() {
        Long time = System.currentTimeMillis();

        Task task = new Task().setTaskId(new TaskId(1L))
                .setTaskName("task_1")
                .setDescr("first task")
                .setPluginId(new PluginId(1L))
                .setCatalogId(new CatalogId(1L));
        task.setCreateUserId(0L)
                .setModifyUserId(0L)
                .setCreateTime(time)
                .setModifyTime(time);

        TaskDTO taskDTO = DtoAssembler.INSTANCE.fromTask(task);

        assertThat(taskDTO).isNotNull();
        assertThat(taskDTO.getTaskId()).isEqualTo(1L);
        assertThat(taskDTO.getTaskName()).isEqualTo("task_1");
        assertThat(taskDTO.getDescr()).isEqualTo("first task");
        assertThat(taskDTO.getPluginId()).isEqualTo(1L);
        assertThat(taskDTO.getCatalogId()).isEqualTo(1L);
        assertThat(taskDTO.getCreateUserId()).isZero();
        assertThat(taskDTO.getModifyUserId()).isZero();
        assertThat(taskDTO.getCreateTime()).isEqualTo(time);
        assertThat(taskDTO.getModifyTime()).isEqualTo(time);
    }
}
