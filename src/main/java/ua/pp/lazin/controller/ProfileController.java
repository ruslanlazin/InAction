package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.dto.UserWrap;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import java.util.*;

@Controller
@RequestMapping()
public class ProfileController {

    private UserWrap userWrap;
    private UserDao userDao;

    @Autowired
    public ProfileController(UserWrap userWrap, UserDao userDao) {
        this.userWrap = userWrap;
        this.userDao = userDao;
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile() {
        User user = userWrap.getUser();
        if (user == null) {
            ModelAndView error = new ModelAndView("error");
            error.addObject("message", "Such user does not exist");
            return error;
        }
        ModelAndView profile = new ModelAndView("profile");
        Collections.sort(user.getThoughts());
        System.out.println(user);
        profile.addObject("user", user);
        return profile;
    }

    @RequestMapping("/profile/addThought")
    @ResponseBody
    public String addThought(@RequestParam String thought) {
        User user = userWrap.getUser();
        List<Thought> thoughts = user.getThoughts();
        thoughts.add(new Thought(thought, user));
        userWrap.setUser(userDao.update(user));
        return "OK";
    }
}

//        User winston = new User();//
//        winston.setLogin("vas");
//        winston.setPassword("vas");
//        winston.setEmail("vasya123@mail.ru");
//        winston.setName("Вася борщаговский");
//        winston.setBirthday(new GregorianCalendar(1997, 1, 27));
//        winston.setAddress("Борщага");
//        winston.setPhone("Нормальный");
//        winston.setPathToImage("/images/vas.jpg");
//
//        List<String> skills = new ArrayList<>();
//        skills.add("Решаю вопросы");
//        winston.setSkills(skills);
//
//        winston.setProfession("Нормальный пацан");
//
//        List<Thought> thoughts1 = new ArrayList<>();
//        thoughts1.add(new Thought("Пацики, семки есть?", new Date(116, 8, 3), winston));
//        thoughts1.add(new Thought("Может по пиву?", new Date(116, 9, 7), winston));
//        thoughts1.add(new Thought("Чет вы парни говорите непоняно", new Date(116, 9, 11), winston));
//        thoughts1.add(new Thought("Не, ну хорош мямлить, нормально пишите!", new Date(116, 9, 15), winston));
//        winston.setThoughts(thoughts1);
//
//        userDao.persist(winston);


