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

import java.util.Collections;
import java.util.List;

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
        if (user == null) {                                         //todo remove(Spring Security must do it?)
            ModelAndView error = new ModelAndView("error");
            error.addObject("message", "Session expired");
            return error;
        }
        ModelAndView profile = new ModelAndView("profile");
        profile.addObject("isMine", true);
        if (user.getRoles().contains("ROLE_ADMIN")) {
            profile.addObject("isAdmin", true);
        } else {
            profile.addObject("isAdmin", false);
        }
        Collections.sort(user.getThoughts());
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


