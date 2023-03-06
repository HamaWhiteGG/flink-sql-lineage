package com.hw.lineage.server.application.assembler;

import com.hw.lineage.server.application.dto.TaskDTO;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.TaskId;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @description: DtoAssemblerTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class DtoAssemblerTest {

    @Test
    public void testFromTask() {
        Long time = System.currentTimeMillis();

        Task task = new Task().setTaskId(new TaskId(1L))
                .setTaskName("task_1")
                .setDescr("first task")
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
        assertThat(taskDTO.getCatalogId()).isEqualTo(1L);
        assertThat(taskDTO.getCreateUserId()).isZero();
        assertThat(taskDTO.getModifyUserId()).isZero();
        assertThat(taskDTO.getCreateTime()).isEqualTo(time);
        assertThat(taskDTO.getModifyTime()).isEqualTo(time);
    }
}
