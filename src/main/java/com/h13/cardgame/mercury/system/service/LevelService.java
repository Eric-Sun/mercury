package com.h13.cardgame.mercury.system.service;

import com.h13.cardgame.mercury.dao.LevelDAO;
import com.h13.cardgame.mercury.system.vo.LevelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LevelService {

    @Autowired
    LevelDAO levelDAO;

    public void create(LevelVO level) {
        levelDAO.create(level);
    }

    public void update(LevelVO level) {
        levelDAO.update(level);
    }

    public LevelVO show(long id) {
        return levelDAO.show(id);
    }

    public List<LevelVO> list() {
        return levelDAO.list();
    }

    public void delete(long id) {
        levelDAO.delete(id);
    }
}

