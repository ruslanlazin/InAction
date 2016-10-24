package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.dao.UserDao;
import ua.pp.lazin.dto.UserWrap;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping()
public class FrendsProfileController {

    private UserWrap userWrap;
    private UserDao userDao;

    @Autowired
    public FrendsProfileController(UserWrap userWrap, UserDao userDao) {
        this.userWrap = userWrap;
        this.userDao = userDao;
    }

    @RequestMapping("/friendsProfile")
    public ModelAndView viewProfile(@RequestParam long id) {
        if (id == userWrap.getUser().getId()) {
            return new ModelAndView("redirect:/profile");
        }
        User user = userDao.getUserbyId(id);
        if (user == null) {
            ModelAndView error = new ModelAndView("error");
            error.addObject("message", "Such user does not exist");
            return error;
        }
        Collections.sort(user.getThoughts());
        ModelAndView friendsProfile = new ModelAndView("profile");
        friendsProfile.addObject("isMine", false);
        friendsProfile.addObject("isAdmin", false);
        friendsProfile.addObject("user", user);
        return friendsProfile;
    }
}