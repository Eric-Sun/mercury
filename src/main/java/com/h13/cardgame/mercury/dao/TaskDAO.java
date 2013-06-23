package com.h13.cardgame.mercury.dao;

import com.alibaba.fastjson.JSON;
import com.h13.cardgame.mercury.task.vo.ConditionVO;
import com.h13.cardgame.mercury.task.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-20
 * Time: 下午5:31
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TaskDAO {

    @Autowired
    JdbcTemplate j;

    public void create(TaskVO task) {
        String sql = "insert into task (task_group_id,name,description,condition,drop_group_id,count,cooldown,last,create_time)" +
                " values (?,?,?,?,?,?,?,?,now())";
        j.update(sql, new Object[]{task.getTaskGroupId(), task.getName(), task.getDescription(),
                JSON.toJSONString(task.getCondition()), task.getDropGroupId(),
                task.getCount(), task.getCooldown(), task.getLast()});
    }

    public void update(TaskVO task) {
        String sql = "update task set task_group_id=?,name=?,description=?,condition=?,drop_group_id=?,count=?,cooldown=?,last=?,update_time=now()" +
                "where id=?";
        j.update(sql, new Object[]{task.getTaskGroupId(), task.getName(), task.getDescription(),
                JSON.toJSONString(task.getCondition()), task.getDropGroupId(),
                task.getCount(), task.getCooldown(), task.getLast(), task.getId()});
    }

    public void delete(long id) {
        String sql = "delete from task where id=?";
        j.update(sql, new Object[]{id});
    }

    public TaskVO show(long id) {
        String sql = "select id,task_group_id,name,description,condition,drop_group_id,count,cooldown,last from task where id=?";
        return j.queryForObject(sql, new Object[]{}, new RowMapper<TaskVO>() {
            @Override
            public TaskVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                TaskVO vo = new TaskVO();
                vo.setId(rs.getLong(1));
                vo.setTaskGroupId(rs.getLong(2));
                vo.setName(rs.getString(3));
                vo.setDescription(rs.getString(4));
                vo.setCondition(JSON.parseObject(rs.getString(5), ConditionVO.class));
                vo.setDropGroupId(rs.getLong(6));
                vo.setCount(rs.getInt(7));
                vo.setCooldown(rs.getInt(8));
                vo.setLast(rs.getInt(9));
                return vo;
            }
        });
    }

    public List<TaskVO> list() {
        String sql = "select id,task_group_id,name,description,condition,drop_group_id,count,cooldown,last from task";
        return j.query(sql, new Object[]{}, new RowMapper<TaskVO>() {
            @Override
            public TaskVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                TaskVO vo = new TaskVO();
                vo.setId(rs.getLong(1));
                vo.setTaskGroupId(rs.getLong(2));
                vo.setName(rs.getString(3));
                vo.setDescription(rs.getString(4));
                vo.setCondition(JSON.parseObject(rs.getString(5), ConditionVO.class));
                vo.setDropGroupId(rs.getLong(6));
                vo.setCount(rs.getInt(7));
                vo.setCooldown(rs.getInt(8));
                vo.setLast(rs.getInt(9));
                return vo;
            }
        });
    }
}
