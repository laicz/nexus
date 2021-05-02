package com.zhou.haizhi.nexus.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/redirect/url")
public class RedirectUrlController {

    @GetMapping(value = "/send")
    public void send(@RequestParam(value = "url") String url, HttpServletResponse response) throws IOException {
        System.out.println("重定向到URL：" + url);
        response.sendRedirect(url);
    }

}
