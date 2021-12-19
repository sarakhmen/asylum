package com.brawlstars.asylum.controller;

import com.brawlstars.asylum.dto.AppointmentCreationDto;
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

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/admin/appointment/create")
    public String createAppointment(Model model){
        AppointmentCreationDto appointmentCreationDto = new AppointmentCreationDto();
        model.addAttribute("appointment", appointmentCreationDto);
        return "appointmentCreation";
    }

    @GetMapping({"/patient/appointment", "/doctor/appointment"})
    public String appointmentsView(Principal principal, Model model, HttpServletRequest httpServletRequest) {
        List<Appointment> appointmentModelList = appointmentService.getAllAppointmentsByUserEmail(principal.getName());
        List<AppointmentDto> appointmentDtoList = ObjectMapperUtils.mapAll(appointmentModelList, AppointmentDto.class);
        System.out.println(appointmentDtoList);
        model.addAttribute("appointments", appointmentDtoList);
        return "appointment";
    }

    @GetMapping("/patient/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId, HttpServletRequest request) throws MalformedURLException {
//        appointmentService.deleteAppointmentById(appointmentId);
        String redirectPath = new URL(request.getRequestURL().toString()).getPath().split("/delete")[0];
        return "redirect:" + redirectPath;
    }

}
