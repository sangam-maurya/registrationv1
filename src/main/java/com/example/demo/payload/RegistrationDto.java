package com.example.demo.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    @NotBlank
    @Size(min = 2 , message = "it is more then 2")
    private String name;
    @Email(message = "it is not email")
    private String email;
    @Size(min = 10 , max = 10 , message = "this is more then 10 ")
    private String mobile;
}