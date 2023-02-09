package com.lineage.server.infrastructure.persistence.converter;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.vo.CatalogId;
import com.lineage.server.domain.vo.PluginId;
import com.lineage.server.domain.vo.TaskId;
import com.lineage.server.domain.vo.TaskSource;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @description: DataConverterTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/31 2:40 PM
 */
public class DataConverterTest {

    private Long time = System.currentTimeMillis();

    @Test
    public void testToTask() {
        TaskDO taskDO = new TaskDO();
        taskDO.setTaskId(1L);
        taskDO.setTaskName("task_1");
        taskDO.setDescr("first task");
        taskDO.setPluginId(1L);
        taskDO.setCatalogId(1L);
        taskDO.setTaskSource("SELECT 1");
        taskDO.setCreateUserId(0L);
        taskDO.setModifyUserId(0L);
        taskDO.setCreateTime(time);
        taskDO.setModifyTime(time);

        Task task = DataConverter.INSTANCE.toTask(taskDO);

        assertThat(task).isNotNull();
        assertThat(task.getTaskId()).isEqualTo(new TaskId(1L));
        assertThat(task.getTaskName()).isEqualTo("task_1");
        assertThat(task.getDescr()).isEqualTo("first task");
        assertThat(task.getPluginId()).isEqualTo(new PluginId(1L));
        assertThat(task.getCatalogId()).isEqualTo(new CatalogId(1L));
        assertThat(task.getTaskSource()).isEqualTo(new TaskSource("SELECT 1"));
        assertThat(task.getCreateUserId()).isZero();
        assertThat(task.getModifyUserId()).isZero();
        assertThat(task.getCreateTime()).isEqualTo(time);
        assertThat(task.getModifyTime()).isEqualTo(time);
    }

    @Test
    public void testFromTask() {

        Task task = new Task().setTaskName("task_1")
                .setDescr("first task")
                .setPluginId(new PluginId(1L))
                .setCatalogId(new CatalogId(1L));
        task.setCreateUserId(0L)
                .setModifyUserId(0L)
                .setCreateTime(time)
                .setModifyTime(time);

        TaskDO taskDO = DataConverter.INSTANCE.fromTask(task);

        assertThat(taskDO).isNotNull();
        assertThat(taskDO.getTaskId()).isNull();
        assertThat(taskDO.getTaskName()).isEqualTo("task_1");
        assertThat(taskDO.getDescr()).isEqualTo("first task");
        assertThat(taskDO.getPluginId()).isEqualTo(1L);
        assertThat(taskDO.getCatalogId()).isEqualTo(1L);
        assertThat(taskDO.getCreateUserId()).isZero();
        assertThat(taskDO.getModifyUserId()).isZero();
        assertThat(taskDO.getCreateTime()).isEqualTo(time);
        assertThat(taskDO.getModifyTime()).isEqualTo(time);

        task.setTaskId(new TaskId(1L));
        taskDO = DataConverter.INSTANCE.fromTask(task);
        assertThat(taskDO.getTaskId()).isEqualTo(1L);
    }
}
