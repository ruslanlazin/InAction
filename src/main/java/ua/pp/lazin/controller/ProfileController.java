package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.*;

@Controller
@RequestMapping("/profile")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProfileController {


    private User user;
    private UserDao userDao;

    @Inject
    public ProfileController(User user, UserDao userDao) {
        this.user = user;
        this.userDao = userDao;
    }

    @RequestMapping("")
    public ModelAndView viewProfile() {

        ModelAndView profile = new ModelAndView("profile");
        Collections.sort(user.getThoughts());
        System.out.println(user);
        profile.addObject("user", user);
        return profile;
    }

    @RequestMapping("addThought")
    @ResponseBody
    public String addThought(@RequestParam String thought) {

        ModelAndView profile = new ModelAndView("profile");
        List<Thought> thoughts = user.getThoughts();
        thoughts.add(new Thought(thought, user));
        user = userDao.update(user);


//        User winston = new User();
//
//        winston.setLogin("churchill");
//        winston.setPassword("churchill");
//        winston.setEmail("churchiil@gov.uk");
//        winston.setName("Winston Spencer Churchill");
//        winston.setBirthday(new GregorianCalendar(1874, 10, 30));
//        winston.setAddress("10, Downing street, London");
//        winston.setPhone("+10(852)545-55-88");
//        winston.setPathToImage("/images/churchill.jpg");
//
//        List<String> skills = new ArrayList<>();
//        skills.add("drink");
//        skills.add("smoke");
//        skills.add("speak");
//        skills.add("win wars");
//        skills.add("lead");
//        winston.setSkills(skills);
//
//        List<Thought> thoughts1 = new ArrayList<>();
//        thoughts1.add(new Thought("Success is not final, failure is not fatal: " +
//                "it is the courage to continue that counts.", new Date(116, 8, 04), winston));
//        thoughts1.add(new Thought("A pessimist sees the difficulty in every opportunity;" +
//                " an optimist sees the opportunity in every difficulty.", new Date(116, 9, 05), winston));
//        thoughts1.add(new Thought("If you're going through hell, keep going.", new Date(116, 9, 12), winston));
//        winston.setThoughts(thoughts1);
//
//        userDao.persist(winston);

        return "OK";


    }
}
