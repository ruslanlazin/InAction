package ua.pp.lazin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/counter")
public class CounterController {

    private AtomicInteger counter = new AtomicInteger(0);

    @RequestMapping
    @ResponseBody
    public String count() {
        System.out.println(counter.incrementAndGet());
        return "Ok";
    }

}
