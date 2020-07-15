package com.dj.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/area")
public class AreaPageController {

    @RequestMapping("/toThree")
    public String toThree() {
        return "/three";
    }

    @RequestMapping("/toTree")
    public String toTree() {
        return "/tree";
    }

}
