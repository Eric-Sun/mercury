package com.h13.cardgame.mercury.auth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h13.cardgame.mercury.auth.service.RoleService;
import com.h13.cardgame.mercury.auth.service.UserService;
import com.h13.cardgame.mercury.auth.vo.RoleVO;
import com.h13.cardgame.mercury.auth.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

        List<UserVO> userList = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("/auth/user/list");
        mav.addObject("userList", userList);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        long userId = new Long(req.getParameter("userId"));
        userService.delete(userId);
        ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        long userId = new Long(req.getParameter("userId"));
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        long roleId = new Long(req.getParameter("roleId"));
        userService.update(userId, name, pwd, roleId);
        ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        long roleId = new Long(req.getParameter("roleId"));
        userService.create(name, pwd, roleId);
        ModelAndView mav = new ModelAndView("redirect:/auth/user/list");
        return mav;
    }

    @RequestMapping("/preCreate")
    public ModelAndView preCreate(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        List<RoleVO> list = roleService.getAllRole();
        ModelAndView mav = new ModelAndView("/auth/user/create");
        mav.addObject("roleList", list);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long userId = new Long(req.getParameter("userId"));
        UserVO user = userService.getUser(userId);
        List<RoleVO> list = roleService.getAllRole();
        for (RoleVO vo : list) {
            if (vo.getId() == user.getRoleId())
                vo.setSelected(true);
        }
        ModelAndView mav = new ModelAndView("/auth/user/show");
        mav.addObject("user", user);
        mav.addObject("roleList", list);
        return mav;
    }

}
