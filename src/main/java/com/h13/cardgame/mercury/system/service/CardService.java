package com.h13.cardgame.mercury.system.service;

import com.h13.cardgame.mercury.dao.CardDAO;
import com.h13.cardgame.mercury.system.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CardService {

    @Autowired
    CardDAO cardDAO;

    public void create(CardVO card) {
        cardDAO.create(card);
    }

    public void update(CardVO card) {
        cardDAO.update(card);
    }

    public void delete(long id) {
        cardDAO.delete(id);
    }

    public CardVO show(long id) {
        return cardDAO.show(id);
    }

    public List<CardVO> list() {
        return cardDAO.list();
    }

}
