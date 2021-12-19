package com.brawlstars.asylum.controller;

import com.brawlstars.asylum.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService;
    @GetMapping("??")
    public String appointmentsView(HttpServletRequest httpServletRequest) {
        //??
        return "appointment";
    }

    //

    //
    ///
}
