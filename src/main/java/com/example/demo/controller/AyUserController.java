package com.example.demo.controller;

import com.example.demo.error.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.properties.BookProperties;
import com.example.demo.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ay
 * @create 2019/07/03
 **/
@Controller
@RequestMapping("/ayUser")
public class AyUserController {

    @Resource
    private BookProperties bookProperties;

    @Resource
    private AyUserService ayUserService;

    @RequestMapping("/test")
    public String test(Model model) {
        //查询数据库所有用户
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users",ayUser);
        return "ayUser";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users",ayUser);
        //
        throw new BusinessException("业务异常");
    }

    @RequestMapping("/findByNameAndPasswordRetry")
    public String findByNameAndPasswordRetry(Model model) {
        AyUser ayUser = ayUserService.findByNameAndPasswordRetry("阿毅","123456");
        model.addAttribute("users",ayUser);
        return "success";
    }


}

