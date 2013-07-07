package com.h13.cardgame.mercury.dao;

import com.alibaba.fastjson.JSON;
import com.h13.cardgame.mercury.task.vo.DropGroupDataVO;
import com.h13.cardgame.mercury.task.vo.DropGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DropGroupDAO {

    @Autowired
    JdbcTemplate j;

    public void create(DropGroupVO dropGroupVO) {
        String sql = "insert into drop_group (name,data,create_time) values (?,?,now())";
        j.update(sql, new Object[]{dropGroupVO.getName(), JSON.toJSONString(dropGroupVO.getData())});
    }

    public void update(DropGroupVO dropGroupVO) {
        String sql = "update drop_group set name=?,data=?,update_time=now() where id=?";
        j.update(sql, new Object[]{dropGroupVO.getName(), JSON.toJSONString(dropGroupVO.getData()), dropGroupVO.getId()});
    }


    public void delete(long id) {
        String sql = "delete from drop_group where id=?";
        j.update(sql, new Object[]{id});
    }

    public DropGroupVO show(long id) {
        String sql = "select id,name,data from drop_group where id=?";
        return j.queryForObject(sql, new Object[]{id}, new RowMapper<DropGroupVO>() {
            @Override
            public DropGroupVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                DropGroupVO vo = new DropGroupVO();
                vo.setId(rs.getLong(1));
                vo.setName(rs.getString(2));
                vo.setData(JSON.parseObject(rs.getString(3), DropGroupDataVO.class));
                return vo;
            }
        });
    }

    public List<DropGroupVO> list() {
        String sql = "select id,name,data from drop_group";
        return j.query(sql, new Object[]{}, new RowMapper<DropGroupVO>() {
            @Override
            public DropGroupVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                DropGroupVO vo = new DropGroupVO();
                vo.setId(rs.getLong(1));
                vo.setName(rs.getString(2));
                vo.setData(JSON.parseObject(rs.getString(3), DropGroupDataVO.class));
                return vo;
            }
        });
    }

}
