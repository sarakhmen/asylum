package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    @NotBlank
    @Email(message = "*Please provide a valid Email")
    private String email;

    @NotBlank
    @Length(min = 4, message = "*Your password must have at least 4 characters")
    private String password;

    @NotBlank(message = "*Please provide a name")
    private String firstName;

    @NotBlank(message = "*Please provide a second name")
    private String secondName;

    @NotBlank(message = "*Please provide a patronymic")
    private String patronymic;

    @NotBlank(message = "*Please provide an address")
    private String address;

    @NotBlank(message = "*Please provide a phone number")
    private String phone;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar dateOfBirth;

    private Boolean active;

}
