package com.h13.cardgame.mercury.dao;


import com.h13.cardgame.mercury.system.vo.ConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfigDAO {

    @Autowired
    JdbcTemplate j;

    public void create(ConfigVO config) {
        String sql = "insert into config(name,`key`,value,create_time) values (?,?,?,now())";
        j.update(sql, new Object[]{config.getName(), config.getKey(), config.getValue()});
    }

    public void update(ConfigVO config) {
        String sql = "update config set name=?,`key`=?,value=?,update_time=now() where id=?";
        j.update(sql, new Object[]{config.getName(), config.getKey(), config.getValue(), config.getId()});
    }

    public void delete(long id) {
        String sql = "delete from config where id=?";
        j.update(sql, new Object[]{id});
    }

    public List<ConfigVO> list() {
        String sql = "select id,name,`key`,value from config ";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<ConfigVO>(ConfigVO.class));
    }

    public ConfigVO show(long id) {
        String sql = "select id,name,`key`,value from config where id=?";
        return j.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<ConfigVO>(ConfigVO.class));
    }
}
