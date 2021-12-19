package com.brawlstars.asylum.controller;


import com.brawlstars.asylum.dto.UserDto;
import com.brawlstars.asylum.model.User;
import com.brawlstars.asylum.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Processes registration requests
 */
@Log4j2
@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        log.info("signup page successfully set up");
        return "signup";
    }

    @PostMapping("/signup")
    public String createNewUser(@Valid UserDto user, BindingResult bindingResult, HttpServletRequest request){
        Optional<User> userExist = userService.findUserByEmail(user.getEmail());
        if (userExist.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "*There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors: " + bindingResult.getAllErrors());
            return "signup";
        }

        User userModel = new User();
        BeanUtils.copyProperties(user, userModel);
        userService.saveUser(userModel);
        log.info("User successfully signed up");
        return "redirect:/login";
    }

}
