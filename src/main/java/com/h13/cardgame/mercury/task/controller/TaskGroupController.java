package com.h13.cardgame.mercury.task.controller;

import com.h13.cardgame.mercury.system.vo.CardVO;
import com.h13.cardgame.mercury.task.service.TaskGroupService;
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
@RequestMapping("/task/taskGroup")
public class TaskGroupController {

    @Autowired
    TaskGroupService taskGroupSerivce;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<TaskGroupVO> list = taskGroupSerivce.list();
        ModelAndView mav = new ModelAndView("/task/taskGroup/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        TaskGroupVO taskGroup = taskGroupSerivce.show(id);
        ModelAndView mav = new ModelAndView("/task/taskGroup/show");
        mav.addObject("vo", taskGroup);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(TaskGroupVO taskGroup, HttpServletRequest request, HttpServletResponse response) {
        taskGroupSerivce.create(taskGroup);
        ModelAndView mav = new ModelAndView("redirect:/task/taskGroup/list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(TaskGroupVO taskGroup, HttpServletRequest request, HttpServletResponse response) {
        taskGroupSerivce.update(taskGroup);
        ModelAndView mav = new ModelAndView("redirect:/task/taskGroup/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        taskGroupSerivce.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/task/taskGroup/list");
        return mav;
    }

}
