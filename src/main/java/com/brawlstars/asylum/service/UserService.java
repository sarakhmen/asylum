package com.brawlstars.asylum.service;


import com.brawlstars.asylum.model.Role;
import com.brawlstars.asylum.model.Treatment;
import com.brawlstars.asylum.model.User;
import com.brawlstars.asylum.repository.RoleRepository;
import com.brawlstars.asylum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(long id){
        return userRepository.findUserById(id);
    }

    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User savePatient(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("PATIENT");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    @Transactional
    public User banHandler(long id) {
        User user = findUserById(id);
        user.setActive(!user.getActive());
        return userRepository.save(user);
    }

}