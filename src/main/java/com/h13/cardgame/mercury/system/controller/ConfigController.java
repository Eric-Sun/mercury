package com.h13.cardgame.mercury.system.controller;

import com.h13.cardgame.mercury.system.service.ConfigService;
import com.h13.cardgame.mercury.system.vo.ConfigVO;
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
 * Date: 13-6-17
 * Time: 下午6:49
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/system/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<ConfigVO> list = configService.list();
        ModelAndView mav = new ModelAndView("/system/config/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        ConfigVO configVO = configService.show(id);
        ModelAndView mav = new ModelAndView("/system/config/show");
        mav.addObject("vo", configVO);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(ConfigVO config, HttpServletRequest request, HttpServletResponse response) {
        configService.create(config);
        ModelAndView mav = new ModelAndView("redirect:/system//list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(ConfigVO config, HttpServletRequest request, HttpServletResponse response) {
        configService.update(config);
        ModelAndView mav = new ModelAndView("redirect:/system/config/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        configService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/system/config/list");
        return mav;
    }


}
