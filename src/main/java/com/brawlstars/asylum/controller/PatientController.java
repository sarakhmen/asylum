package com.brawlstars.asylum.controller;

import com.brawlstars.asylum.dto.AppointmentDto;
import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.service.AppointmentService;
import com.brawlstars.asylum.util.ObjectMapperUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment")
    public String appointmentsView(Principal principal, Model model) {
        List<Appointment> appointmentModelList = appointmentService.getAllAppointmentsByPatientEmail(principal.getName());
        List<AppointmentDto> appointmentDtoList = ObjectMapperUtils.mapAll(appointmentModelList, AppointmentDto.class);
        System.out.println(appointmentDtoList);
        model.addAttribute("appointments", appointmentDtoList);
        return "appointment";
    }

    @PostMapping("/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId){
        appointmentService.deleteAppointmentById(appointmentId);
        return "redirect:/patient/appointment";
    }
}
