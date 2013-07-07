package com.h13.cardgame.mercury.dao;

import com.alibaba.fastjson.JSON;
import com.h13.cardgame.mercury.system.vo.CardType;
import com.h13.cardgame.mercury.system.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        String sql = "insert into card (name,icon,card_type,spec_data,`desc`,create_time)" +
                " values (?,?,?,?,?,now())";
        j.update(sql, new Object[]{card.getName(),
                card.getIcon(), card.getCardType().name(), JSON.toJSONString(card.getSpecData()), card.getDesc()});
    }


    public void update(CardVO card) {
        String sql = "update card set name=?,icon=?,card_type=?,spec_data=?,`desc`=? where id=?";
        j.update(sql, new Object[]{card.getName(),
                card.getIcon(), card.getCardType().name(), JSON.toJSONString(card.getSpecData()),
                card.getDesc(), card.getId()});
    }

    public void delete(long id) {
        String sql = "delete from card where id=?";
        j.update(sql, new Object[]{id});
    }

    public CardVO show(long id) {
        String sql = "select name,icon,card_type,spec_data,`desc`,id from card where id=?";
        return j.queryForObject(sql, new Object[]{id}, new RowMapper<CardVO>() {
            @Override
            public CardVO mapRow(ResultSet rs, int i) throws SQLException {
                CardVO card = new CardVO();
                card.setName(rs.getString(1));
                card.setIcon(rs.getString(2));
                card.setCardType(CardType.valueOf(rs.getString(3)));
                card.setSpecData(JSON.parseObject(rs.getString(4), Map.class));
                card.setDesc(rs.getString(5));
                card.setId(rs.getInt(6));
                return card;
            }
        });
    }

    public List<CardVO> list() {
        String sql = "select name,icon,card_type,spec_data,`desc`,id from card";
        return j.query(sql, new Object[]{}, new RowMapper<CardVO>() {
            @Override
            public CardVO mapRow(ResultSet rs, int i) throws SQLException {
                CardVO card = new CardVO();
                card.setName(rs.getString(1));
                card.setIcon(rs.getString(2));
                card.setCardType(CardType.valueOf(rs.getString(3)));
                card.setSpecData(JSON.parseObject(rs.getString(4), Map.class));
                card.setDesc(rs.getString(5));
                card.setId(rs.getInt(6));
                return card;
            }
        });
    }

}
