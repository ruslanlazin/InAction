package ua.pp.lazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.entity.Thought;
import ua.pp.lazin.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired(    )
    User user;

    @RequestMapping("")
    public ModelAndView viewProfile(){

        ModelAndView profile = new ModelAndView("profile");
        profile.addObject("user", user);
        return profile;
    }

    @RequestMapping("addThought")
    public ModelAndView addThought(@RequestParam String thought){

        ModelAndView profile = new ModelAndView("profile");
        List<Thought> thoughts = user.getThoughts();
        thoughts.add(new Thought(thought));
        profile.addObject("user", user);
        return profile;
    }
}
