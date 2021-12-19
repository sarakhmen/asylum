package com.brawlstars.asylum.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class AdminController {
<<<<<<< Updated upstream

=======
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    UserService userService;


    @GetMapping("/appointment")
    public String appointmentsView(Model model) {
        List<Appointment> appointmentModelList = appointmentService.getAllAppointments();
        List<AppointmentDto> appointmentDtoList = ObjectMapperUtils.mapAll(appointmentModelList, AppointmentDto.class);
        System.out.println(appointmentDtoList);
        model.addAttribute("appointments", appointmentDtoList);
        return "appointment";
    }

    @PostMapping("/appointment/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
        return "redirect:/admin/appointment";
    }

    @GetMapping("/appointment/create")
    public String createAppointment(Model model) {
        AppointmentCreationDto appointmentCreationDto = new AppointmentCreationDto();
        model.addAttribute("appointment", appointmentCreationDto);
        return "appointmentCreation";
    }

    @PostMapping("/appointment/create")
    public String confirmAppointmentCreation(@Valid @ModelAttribute("appointment") AppointmentCreationDto appointment,
                                             BindingResult bindingResult) {
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
        return "redirect:/admin/appointment";
    }
>>>>>>> Stashed changes
}
