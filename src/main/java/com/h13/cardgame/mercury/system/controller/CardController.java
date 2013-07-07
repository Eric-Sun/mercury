package com.h13.cardgame.mercury.system.controller;

import com.h13.cardgame.mercury.system.service.CardService;
import com.h13.cardgame.mercury.system.service.ConfigService;
import com.h13.cardgame.mercury.system.vo.*;
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
        Object card = cardService.show(id);
        if (card instanceof SquardCardVO) {
            ModelAndView mav = new ModelAndView("/system/card/showSquard");
            mav.addObject("vo", (SquardCardVO) card);
            return mav;
        } else if (card instanceof EquipmentCardVO) {
            ModelAndView mav = new ModelAndView("/system/card/showEquipment");
            mav.addObject("vo", (EquipmentCardVO) card);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("/system/card/showUnits");
            mav.addObject("vo", (UnitsCardVO) card);
            return mav;
        }
    }


    @RequestMapping("/createUnits")
    public ModelAndView createUnits(UnitsCardVO unitsCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.createUnits(unitsCardVO);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }

    @RequestMapping("/createEquipment")
    public ModelAndView createEquipment(EquipmentCardVO equipmentCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.createEquipment(equipmentCardVO);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }

    @RequestMapping("/createSquard")
    public ModelAndView createSquard(SquardCardVO squardCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.createSquard(squardCardVO);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }


    @RequestMapping("/updateSquard")
    public ModelAndView updateSquard(SquardCardVO squardCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.updateSquard(squardCardVO);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }

    @RequestMapping("/updateEquipment")
    public ModelAndView updateEquipment(EquipmentCardVO equipmentCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.updateEquipment(equipmentCardVO);
        ModelAndView mav = new ModelAndView("redirect:/system/card/list");
        return mav;
    }

    @RequestMapping("/updateUnits")
    public ModelAndView updateUnits(UnitsCardVO unitsCardVO, HttpServletRequest request, HttpServletResponse response) {
        cardService.updateUnits(unitsCardVO);
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
