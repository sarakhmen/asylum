package com.brawlstars.asylum.controller;

import com.brawlstars.asylum.dto.AppointmentCreationDto;
import com.brawlstars.asylum.dto.AppointmentDto;
import com.brawlstars.asylum.dto.AppointmentRequestDto;
import com.brawlstars.asylum.dto.DoctorDto;
import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.model.Doctor;
import com.brawlstars.asylum.model.RequestAppointment;
import com.brawlstars.asylum.model.User;
import com.brawlstars.asylum.service.AppointmentService;
import com.brawlstars.asylum.service.DoctorService;
import com.brawlstars.asylum.service.RequestAppointmentService;
import com.brawlstars.asylum.service.UserService;
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
import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    UserService userService;
    @Autowired
    RequestAppointmentService requestAppointmentService;

    @GetMapping("/appointmentRequest")
    public String requestsView(Model model){
        List<RequestAppointment> requestAppointmentList = requestAppointmentService.getAllRequestAppointments();
        List<AppointmentRequestDto> appointmentRequestDtos = ObjectMapperUtils.mapAll(requestAppointmentList, AppointmentRequestDto.class);
        model.addAttribute("appointments", appointmentRequestDtos);
        AppointmentCreationDto appointmentCreationDto = new AppointmentCreationDto();
        model.addAttribute("appointment", appointmentCreationDto);
        return "appointmentRequestsAdmin";
    }

    @GetMapping("/appointment")
    public String appointmentsView(Model model) {
        List<Appointment> appointmentModelList = appointmentService.getAllAppointments();
        List<AppointmentDto> appointmentDtoList = ObjectMapperUtils.mapAll(appointmentModelList, AppointmentDto.class);
        model.addAttribute("appointments", appointmentDtoList);
        return "appointment";
    }

    @PostMapping("/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
        return "redirect:/admin/appointment";
    }

    @PostMapping("/requestAppointment/delete/{requestAppointmentId}")
    public String deleteRequestAppointment(@PathVariable int requestAppointmentId) {
        requestAppointmentService.deleteRequestAppointmentById(requestAppointmentId);
        return "redirect:/admin/appointmentRequest";
    }

    @GetMapping("/requestAppointment/accept/{requestAppointmentId}")
    public String acceptRequestAppointment(@PathVariable int requestAppointmentId, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();

        AppointmentCreationDto appointmentCreationDto = new AppointmentCreationDto();

        RequestAppointment requestAppointment = requestAppointmentService.getById(requestAppointmentId);


        List<Doctor> doctorList = doctorService.getAllDoctors();
        List<DoctorDto> doctorDtos = ObjectMapperUtils.mapAll(doctorList, DoctorDto.class);
        appointmentCreationDto.setDoctors(doctorDtos);

        appointmentCreationDto.setDoctorPosition(requestAppointment.getDoctorPosition());
        appointmentCreationDto.setPatientEmail(requestAppointment.getUser().getEmail());
        appointmentCreationDto.setId(requestAppointment.getId());


        session.setAttribute("appointmentAttribute", appointmentCreationDto);

        model.addAttribute("appointmentCreation", appointmentCreationDto);
        return "appointmentCreation";
    }

    @PostMapping("/appointment/create")
    public String confirmAppointmentCreation(@Valid @ModelAttribute("appointmentCreation") AppointmentCreationDto appointment,
                                             BindingResult bindingResult, HttpServletRequest request) {
        AppointmentCreationDto appointmentCreationDto = (AppointmentCreationDto) request.getSession().getAttribute("appointmentAttribute");

        System.out.println("/n/n"+ appointmentCreationDto);
        System.out.println(appointment+"\n\n");

        Optional<Doctor> doctorExist = Optional
                .ofNullable(doctorService
                        .getDoctorByUserEmail(appointment.getDoctorEmail()));
        if (doctorExist.isEmpty()) {
            bindingResult.rejectValue("doctorEmail", "error.appointment",
                    "*This doctor doesn't work in our hospital");
        }
        Optional<User> userExists =
                userService.findUserByEmail(appointment.getPatientEmail());
        if (userExists.isEmpty()) {
            bindingResult.rejectValue("patientEmail", "error.appointment",
                    "*This patient hasn't been registered in our hospital");
        }
        Optional<Appointment> appointmentExist = appointmentService
                .getAppointmentByDate(
                        appointment.getDoctorEmail(),
                        appointment.getDateOfAppointment());
        if (appointmentExist.isPresent()) {
            bindingResult
                    .rejectValue("dateOfAppointment", "error.appointment",
                            "*This date for this doctor isn't available");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors: " + bindingResult.getAllErrors());
            return "appointmentCreation";
        }

        Appointment appointmentModel = new Appointment();
        appointmentModel.setDoctor(doctorExist.get());
        appointmentModel.setPatient(userExists.get());
        appointmentModel.setDate(appointment.getDateOfAppointment());
        appointmentService.save(appointmentModel);
        requestAppointmentService.deleteRequestAppointmentById(appointmentCreationDto.getId());
        return "redirect:/admin/appointment";
    }
}