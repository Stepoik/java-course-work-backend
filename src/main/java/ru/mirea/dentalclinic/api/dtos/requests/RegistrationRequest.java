package ru.mirea.dentalclinic.api.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
        @Size(min = 5, message = "Name required at least 5 letters")
        @Size(max = 100, message = "Too long name")
        @NotBlank(message = "Username shouldn't be empty")
        @JsonProperty("username")
        String username,
        @Size(min = 8, message = "Password required at least 5 letters")
        @NotBlank(message = "Password shouldn't be empty")
        @JsonProperty("password")
        String password,
        @JsonProperty("email")
        @Email(message = "Email not validated")
        String email,
        @JsonProperty("first_name")
        @NotBlank(message = "First name shouldn't be empty")
        @Size(min = 2, max = 30)
        String firstName,
        @JsonProperty("last_name")
        @NotBlank(message = "Last name shouldn't be empty")
        @Size(min = 2, max = 30)
        String lastName

) {
}
