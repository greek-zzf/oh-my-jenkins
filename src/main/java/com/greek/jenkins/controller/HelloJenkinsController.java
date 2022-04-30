package com.greek.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhaofeng Zhou
 * @date 2022/4/28 16:15
 */
@RestController
public class HelloJenkinsController {
    @GetMapping("/index")
    public String helloJenkins() {
        return "oh-my-jenkins";
    }
}
