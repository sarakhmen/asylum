package com.brawlstars.asylum.handler;

import com.brawlstars.asylum.model.User;
import com.brawlstars.asylum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;


/**
 * Redirects user to correct page depending on it roles
 */
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        HttpSession session = request.getSession();
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String currentUserEmail = authentication.getName();
        Optional<User> user = userService.findUserByEmail(currentUserEmail);
        session.setAttribute("user", user.orElseThrow(() -> new UsernameNotFoundException("User not found")));

        if (authorities.contains("ADMIN")) {
            response.sendRedirect("/admin/view");
        }
        else if (authorities.contains("DOCTOR")){
            response.sendRedirect("/doctor/view");
        }
        else {
            response.sendRedirect("/patient/view");
        }
    }
}