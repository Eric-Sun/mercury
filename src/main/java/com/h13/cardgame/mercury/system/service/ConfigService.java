package com.h13.cardgame.mercury.system.service;

import com.h13.cardgame.mercury.dao.ConfigDAO;
import com.h13.cardgame.mercury.system.vo.ConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-17
 * Time: 下午6:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConfigService {

    @Autowired
    ConfigDAO configDAO;

    public List<ConfigVO> list() {
        return configDAO.list();
    }

    public void create(ConfigVO config) {
        configDAO.create(config);
    }

    public void delete(long id) {
        configDAO.delete(id);
    }

    public ConfigVO show(long id) {
        return configDAO.show(id);
    }

    public void update(ConfigVO config) {
        configDAO.update(config);
    }


}
