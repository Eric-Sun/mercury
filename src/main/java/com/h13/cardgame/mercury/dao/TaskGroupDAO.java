package com.h13.cardgame.mercury.dao;

import com.h13.cardgame.mercury.task.vo.TaskGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-19
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TaskGroupDAO {

    @Autowired
    JdbcTemplate j;

    public void create(TaskGroupVO taskGroup) {
        String sql = "insert into task_group (name,next_task_group_id,last,create_time) " +
                "values (?,?,?,now())";
        j.update(sql, new Object[]{taskGroup.getName(), taskGroup.getNextTaskGroupId(), taskGroup.getLast()});
    }

    public void update(TaskGroupVO taskGroup) {
        String sql = "update task_group set name=?,next_task_group_id=?,last=?,update_time=now() where id=?";
        j.update(sql, new Object[]{taskGroup.getName(), taskGroup.getNextTaskGroupId(), taskGroup.getLast(), taskGroup.getId()});
    }

    public void delete(long id) {
        String sql = "delete from task_group where id=?";
        j.update(sql, new Object[]{id});
    }

    public List<TaskGroupVO> list() {
        String sql = "select * from task_group ";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<TaskGroupVO>(TaskGroupVO.class));
    }

    public TaskGroupVO show(long id) {
        String sql = "select * from task_group where id=?";
        return j.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<TaskGroupVO>(TaskGroupVO.class));
    }
}
