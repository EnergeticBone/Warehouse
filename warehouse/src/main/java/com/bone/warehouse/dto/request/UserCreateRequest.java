package com.bone.warehouse.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {
    @NotBlank(message = "BLANK_USERNAME")
    @Size(min = 8, max = 20, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "PASSWORD_TOO_SHORT")
    @Size(max = 20, message = "PASSWORD_TOO_LONG")
    @NotBlank(message = "BLANK_PASSWORD")
    private String password;

    @Size(min = 8, message = "PASSWORD_TOO_SHORT")
    @Size(max = 20, message = "PASSWORD_TOO_LONG")
    @NotBlank(message = "BLANK_PASSWORD")
    private String confirmPassword;

    @NotBlank(message = "BLANK_FIRSTNAME")
    private String firstName;

    @NotBlank(message = "BLANK_LASTNAME")
    private String lastName;
    private LocalDate dob;
}
