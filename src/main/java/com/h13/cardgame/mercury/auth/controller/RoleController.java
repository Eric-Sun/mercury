package com.h13.cardgame.mercury.auth.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h13.cardgame.mercury.auth.service.PermissionService;
import com.h13.cardgame.mercury.auth.service.RoleService;
import com.h13.cardgame.mercury.auth.vo.PermissionVO;
import com.h13.cardgame.mercury.auth.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

        List<RoleVO> userList = roleService.getAllRole();
        ModelAndView mav = new ModelAndView("/auth/role/list");
        mav.addObject("roleList", userList);
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        long id = new Long(req.getParameter("id"));
        roleService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
        return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        String name = req.getParameter("name");
        String[] permissionIdArray = req
                .getParameterValues("permissionIdArray");
        roleService.create(name, permissionIdArray);
        ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
        return mav;
    }

    @RequestMapping("/preCreate")
    public ModelAndView preCreate(HttpServletRequest req, HttpServletResponse resp) {
        List<PermissionVO> permissionList = permissionService
                .getAllPermission();
        ModelAndView mav = new ModelAndView("/auth/role/create");
        mav.addObject("permissionList", permissionList);
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        long id = new Long(req.getParameter("id"));
        String name = req.getParameter("name");
        String[] permissionIdArray = req
                .getParameterValues("permissionIdArray");
        roleService.update(id, name, permissionIdArray);
        ModelAndView mav = new ModelAndView("redirect:/auth/role/list");
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        long id = new Long(req.getParameter("id"));
        RoleVO roleVO = roleService.fetchRole(id);
        List<PermissionVO> pList = permissionService.getAllPermission();
        for (PermissionVO vo : pList) {
            if (roleVO.getPermissionList().contains(vo))
                vo.setSelected(true);
        }
        roleVO.setPermissionList(pList);
        ModelAndView mav = new ModelAndView("/auth/role/show");
        mav.addObject("roleVO", roleVO);
        return mav;
    }

}
