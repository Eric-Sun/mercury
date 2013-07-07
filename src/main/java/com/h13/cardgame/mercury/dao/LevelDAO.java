package com.h13.cardgame.mercury.dao;

import com.h13.cardgame.mercury.system.vo.LevelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class LevelDAO {

    @Autowired
    JdbcTemplate j;

    public void create(LevelVO level) {
        String sql = "insert into level (level,exp,energy,s_storage_size,e_storage_size,troop_size,create_time) values (?,?,?,?,?,?,now())";
        j.update(sql, new Object[]{level.getLevel(), level.getExp(), level.getEnergy(), level.getSStorageSize(), level.getEStorageSize(), level.getTroopSize()});
    }

    public void update(LevelVO level) {
        String sql = "update level set level=?,exp=?,energy=?,s_storage_size=?,e_storage_size=?,troop_size=? where id=?";
        j.update(sql, new Object[]{level.getLevel(), level.getExp(), level.getEnergy(), level.getSStorageSize(), level.getEStorageSize(), level.getTroopSize(), level.getId()});
    }

    public void delete(long id) {
        String sql = "delete from level where id=?";
        j.update(sql, new Object[]{id});
    }

    public LevelVO show(long id) {
        String sql = "select * from level where id =?";
        return j.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<LevelVO>(LevelVO.class));
    }

    public List<LevelVO> list() {
        String sql = "select * from level ";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<LevelVO>(LevelVO.class));
    }


}
