package com.TaskBoard.TaskBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.TaskBoard.TaskBoard.services.TasksService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TasksService objTasksService;


    @GetMapping("/") //vista pagina inicial
    public String showViewFormCoder(Model objModel){


        return "mainPage";
    }
}
