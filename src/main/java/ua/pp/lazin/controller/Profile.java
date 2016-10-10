package ua.pp.lazin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.lazin.entity.Thought;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class Profile {

    @RequestMapping
    public ModelAndView viewProfile(){
        ModelAndView profile = new ModelAndView("profile");
        List<Thought> thoughts = new ArrayList<>();
        thoughts.add(new Thought("Success is not final, failure is not fatal: " +
                                    "it is the courage to continue that counts."));
        thoughts.add(new Thought("A pessimist sees the difficulty in every opportunity;" +
                                    " an optimist sees the opportunity in every difficulty."));
        thoughts.add(new Thought("If you're going through hell, keep going."));

        profile.addObject("thoughts", thoughts);
        return profile;
    }

}
