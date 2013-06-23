package com.h13.cardgame.mercury.system.controller;

import com.h13.cardgame.mercury.system.service.ConfigService;
import com.h13.cardgame.mercury.system.service.LevelService;
import com.h13.cardgame.mercury.system.vo.ConfigVO;
import com.h13.cardgame.mercury.system.vo.LevelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-18
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/system/level")
public class LevelController {

    @Autowired
    LevelService levelSerivce;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<LevelVO> list = levelSerivce.list();
        ModelAndView mav = new ModelAndView("/system/level/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        LevelVO level = levelSerivce.show(id);
        ModelAndView mav = new ModelAndView("/system/level/show");
        mav.addObject("vo", level);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(LevelVO level, HttpServletRequest request, HttpServletResponse response) {
        levelSerivce.create(level);
        ModelAndView mav = new ModelAndView("redirect:/system/level/list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(LevelVO level, HttpServletRequest request, HttpServletResponse response) {
        levelSerivce.update(level);
        ModelAndView mav = new ModelAndView("redirect:/system/level/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        levelSerivce.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/system/level/list");
        return mav;
    }
}
