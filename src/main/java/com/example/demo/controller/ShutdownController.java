package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Ay
 * @create 2019/07/03
 **/
@Controller
@RequestMapping("/test")
public class ShutdownController {

    @RequestMapping("/long-process")
    public String pause() throws InterruptedException {
        Thread.sleep(20*1000);
        System.out.println("Process finished");
        return "Process finished";
    }
}

