package com.h13.cardgame.mercury.task.controller;

import com.h13.cardgame.mercury.task.service.TaskService;
import com.h13.cardgame.mercury.task.vo.TaskGroupVO;
import com.h13.cardgame.mercury.task.vo.TaskVO;
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
 * Date: 13-6-24
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/task/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List<TaskVO> list = taskService.list();
        ModelAndView mav = new ModelAndView("/task/task/list");
        mav.addObject("voList", list);
        return mav;
    }


    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        long id = new Long(request.getParameter("id"));
        TaskVO task = taskService.show(id);
        ModelAndView mav = new ModelAndView("/task/task/show");
        mav.addObject("vo", task);
        return mav;
    }


    @RequestMapping("/create")
    public ModelAndView create(TaskVO task,
                               @RequestParam(value = "energy", required = false) int energy,
                               @RequestParam(value = "silver", required = false) int silver,
                               @RequestParam(value = "gold", required = false) int gold,
                               HttpServletRequest request, HttpServletResponse response) {
        taskService.create(task, energy, silver, gold);
        ModelAndView mav = new ModelAndView("redirect:/task/task/list");
        return mav;
    }


    @RequestMapping("/update")
    public ModelAndView update(TaskVO task,
                               @RequestParam(value = "energy", required = false) int energy,
                               @RequestParam(value = "silver", required = false) int silver,
                               @RequestParam(value = "gold", required = false) int gold,
                               HttpServletRequest request, HttpServletResponse response) {
        taskService.update(task, energy, silver, gold);
        ModelAndView mav = new ModelAndView("redirect:/task/task/list");
        return mav;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(
            @RequestParam(value = "id", required = false) long id,
            HttpServletRequest request, HttpServletResponse response) {
        taskService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/task/task/list");
        return mav;
    }
}

