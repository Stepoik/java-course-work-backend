package ru.mirea.dentalclinic.api.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDetailsRequest(
        @Size(min = 5, message = "Name required at least 5 letters")
        @Size(max = 100, message = "Too long name")
        @NotBlank(message = "Username shouldn't be empty")
        String username,
        @Size(min = 8, message = "Password required at least 5 letters")
        @NotBlank(message = "Password shouldn't be empty")
        String password
) {
}
