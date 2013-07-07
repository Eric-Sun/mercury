package com.h13.cardgame.mercury.task.controller;

import com.h13.cardgame.mercury.task.service.DropGroupService;
import com.h13.cardgame.mercury.task.service.TaskGroupService;
import com.h13.cardgame.mercury.task.vo.DropGroupVO;
import com.h13.cardgame.mercury.task.vo.TaskGroupVO;
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
 * Date: 13-6-19
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/task/dropGroup")
public class DropGroupController {

    @Autowired
    DropGroupService dropGroupService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<DropGroupVO> list = dropGroupService.list();
        ModelAndView mav = new ModelAndView("/task/dropGroup/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        DropGroupVO dropGroupVO = dropGroupService.show(id);
        ModelAndView mav = new ModelAndView("/task/dropGroup/show");
        mav.addObject("vo", dropGroupVO);
        int sum = dropGroupVO.getData().getCardDropList().size() - 1;
        mav.addObject("sum", sum);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "silverMin", required = false, defaultValue = "-1") int silverMin,
            @RequestParam(value = "silverMax", required = false, defaultValue = "-1") int silverMax,
            @RequestParam(value = "expMin,", required = false, defaultValue = "-1") int expMin,
            @RequestParam(value = "expMax", required = false, defaultValue = "-1") int expMax,
            @RequestParam(value = "cardId", required = false) Long[] cardList,
            @RequestParam(value = "weight", required = false) Integer[] weightList,
            HttpServletRequest request, HttpServletResponse response) {
        dropGroupService.create(name, silverMin, silverMax, expMin, expMax, cardList, weightList);
        ModelAndView mav = new ModelAndView("redirect:/task/dropGroup/list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(
            @RequestParam(value = "id", required = false, defaultValue = "0") long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "silverMin", required = false, defaultValue = "-1") int silverMin,
            @RequestParam(value = "silverMax", required = false, defaultValue = "-1") int silverMax,
            @RequestParam(value = "expMin,", required = false, defaultValue = "-1") int expMin,
            @RequestParam(value = "expMax", required = false, defaultValue = "-1") int expMax,
            @RequestParam(value = "cardId", required = false) Long[] cardList,
            @RequestParam(value = "weight", required = false) Integer[] weightList,
            HttpServletRequest request, HttpServletResponse response) {
        dropGroupService.update(id, name, silverMin, silverMax, expMin, expMax, cardList, weightList);
        ModelAndView mav = new ModelAndView("redirect:/task/dropGroup/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        dropGroupService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/task/dropGroup/list");
        return mav;
    }

}
