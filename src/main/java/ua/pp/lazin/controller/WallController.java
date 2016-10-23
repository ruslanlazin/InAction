package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import java.util.List;
//
//@Controller
//@RequestMapping("/wall")
//public class WallController {
//
//    private User user;
//
//    @Autowired()
//    WallController(User user) {
//        this.user = user;
//    }
//
//    @RequestMapping("")
//    public ModelAndView viewProfile() {
//
//        ModelAndView profile = new ModelAndView("profile");
//        profile.addObject("user", user);
//        return profile;
//    }
//
//}
