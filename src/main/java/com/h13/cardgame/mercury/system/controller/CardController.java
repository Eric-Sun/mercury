package com.h13.cardgame.mercury.system.controller;

import com.h13.cardgame.mercury.system.service.CardService;
import com.h13.cardgame.mercury.system.service.ConfigService;
import com.h13.cardgame.mercury.system.vo.CardVO;
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
 * Date: 13-6-18
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/system/card")
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<CardVO> list = cardService.list();
        ModelAndView mav = new ModelAndView("/system/card/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        CardVO card = cardService.show(id);
        ModelAndView mav = new ModelAndView("/system/card/show");
        mav.addObject("vo", card);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(CardVO card, HttpServletRequest request, HttpServletResponse response) {
        cardService.create(card);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(CardVO card, HttpServletRequest request, HttpServletResponse response) {
        cardService.update(card);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        cardService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }

}
