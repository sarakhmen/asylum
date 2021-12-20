package com.brawlstars.asylum.controller;

import com.brawlstars.asylum.dto.AppointmentDto;
import com.brawlstars.asylum.dto.AppointmentRequestDto;
import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.model.RequestAppointment;
import com.brawlstars.asylum.model.User;
import com.brawlstars.asylum.service.AppointmentService;
import com.brawlstars.asylum.service.RequestAppointmentService;
import com.brawlstars.asylum.util.ObjectMapperUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    RequestAppointmentService requestAppointmentService;

    @GetMapping("/appointment")
    public String appointmentsView(Principal principal, Model model) {
        List<Appointment> appointmentModelList = appointmentService.getAllAppointmentsByPatientEmail(principal.getName());
        List<AppointmentDto> appointmentDtoList = ObjectMapperUtils.mapAll(appointmentModelList, AppointmentDto.class);
        model.addAttribute("appointments", appointmentDtoList);
        return "appointment";
    }

    @PostMapping("/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId){
        appointmentService.deleteAppointmentById(appointmentId);
        return "redirect:/patient/appointment";
    }

    @GetMapping("/appointment/request")
    public String createAppointment(Principal principal, Model model) {
        AppointmentRequestDto appointmentRequestDto = new AppointmentRequestDto();
        model.addAttribute("requestAppointment", appointmentRequestDto);
        List<RequestAppointment> requests = requestAppointmentService.getAllRequestAppointmentsByPatientEmail(principal.getName());
        List<AppointmentRequestDto> appointmentRequestDtos = ObjectMapperUtils.mapAll(requests, AppointmentRequestDto.class);
        model.addAttribute("requests", appointmentRequestDtos);
        return "appointmentRequest";
    }
    @PostMapping("requestAppointment/decline/{id}")
    public String declineRequestAppointment(@PathVariable int id){
        requestAppointmentService.declineRequestAppointment(id);
        return "redirect:/patient/appointment/request";
    }
    @PostMapping("/create/requestAppointment")
    public String createRequestApointment(@Valid @ModelAttribute("requestAppointment") AppointmentRequestDto appointment,
                                          BindingResult bindingResult, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = ObjectMapperUtils.map(session.getAttribute("user"), User.class);

        String positionExist = appointment.getDoctorPosition();
        if (positionExist != null && positionExist.isEmpty()) {
            bindingResult.rejectValue("doctorPosition", "error.appointment",
                    "*Doctor position cannot be empty");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors: " + bindingResult.getAllErrors());
            return "appointmentRequest";
        }


        RequestAppointment requestAppointment = new RequestAppointment();
        requestAppointment.setDoctorPosition(positionExist);
        requestAppointment.setUser(user);
        System.out.println(requestAppointment);
        requestAppointmentService.save(requestAppointment);
        return "redirect:/patient/appointment/request";
    }
}
