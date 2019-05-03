package com.carros.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String get() {
        return "API dos Carros";
    }

    @GetMapping("/userInfo")
    public String userInfo(@AuthenticationPrincipal UserDetails user) {
        return "> " + user;
    }

    @GetMapping("/userInfo2")
    @Secured({ "ROLE_admin" })
    public String userInfo2(@AuthenticationPrincipal UserDetails user) {
        return "> " + user;
    }

    @GetMapping("/userInfo3")
    @Secured({ "ROLE_USER" })
    public String userInfo3(@AuthenticationPrincipal UserDetails user) {
        return "> " + user;
    }
}
