package com.h13.cardgame.mercury.dao;

import com.h13.cardgame.mercury.system.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CardDAO {

    @Autowired
    JdbcTemplate j;

    public void create(CardVO card) {
        String sql = "insert into card (name,icon,card_type,attack_min,attack_max,defence_min,defence_max,random_slot_count," +
                "`desc`,create_time) values (?,?,?,?,?,?,?,?,?,now())";
        j.update(sql, new Object[]{card.getName(),
                card.getIcon(), card.getCardType().name(), card.getAttackMin(),
                card.getAttackMax(), card.getDefenceMin(), card.getDefenceMax(), card.getRandomSlotCount(), card.getDesc()});
    }


    public void update(CardVO card) {
        String sql = "update card set name=?,icon=?,card_type=?,attack_min=?,attack_max=?,defence_min=?,defence_max=?," +
                "random_slot_count=?,`desc`=? where id=?";
        j.update(sql, new Object[]{card.getName(),
                card.getIcon(), card.getCardType().name(), card.getAttackMin(),
                card.getAttackMax(), card.getDefenceMin(), card.getDefenceMax(), card.getRandomSlotCount(), card.getDesc(),
                card.getId()});
    }

    public void delete(long id) {
        String sql = "delete from card where id=?";
        j.update(sql, new Object[]{id});
    }

    public CardVO show(long id) {
        String sql = "select * from card where id=?";
        return j.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<CardVO>(CardVO.class));
    }

    public List<CardVO> list() {
        String sql = "select * from card";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<CardVO>(CardVO.class));
    }

}
