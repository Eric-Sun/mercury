package com.h13.cardgame.mercury.auth.service;

import java.util.List;

import com.h13.cardgame.mercury.auth.vo.UserVO;
import com.h13.cardgame.mercury.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<UserVO> getAllUsers() {
        List<UserVO> userList = userDAO.getAllUsers();
        return userList;
    }

    public void delete(long userId) {
        userDAO.delete(userId);
    }

    public void update(long userId, String name, String pwd, long roleId) {
        userDAO.update(userId, name, pwd, roleId);
    }

    public long create(String name, String pwd, long roleId) {
        return userDAO.create(name, pwd, roleId);
    }

    public UserVO login(String name, String pwd) {
        UserVO vo = userDAO.isUserExist(name, pwd);
        return vo;
    }

    public UserVO getUser(long userId) {
        return userDAO.getUser(userId);
    }


    public boolean modifyPassowrd(String name, String oldpwd, String newpwd) {
        return userDAO.modifyPassowrd(name, oldpwd, newpwd);
    }

}
