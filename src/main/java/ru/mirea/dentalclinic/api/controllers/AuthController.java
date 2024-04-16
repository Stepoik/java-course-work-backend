package ru.mirea.dentalclinic.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.dentalclinic.api.dtos.reponses.JwtAuthResponse;
import ru.mirea.dentalclinic.api.dtos.requests.UserDetailsRequest;
import ru.mirea.dentalclinic.domain.service.AuthService;
import ru.mirea.dentalclinic.utils.result.Result;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity singUp(@RequestBody @Valid UserDetailsRequest userDetailsRequest) {
        Result<String> token = authService.signUp(userDetailsRequest);
        if (token.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(token.getException().getMessage());
        }
        return ResponseEntity.ok(new JwtAuthResponse(
                token.getValue()
        ));
    }
    @PostMapping("/sign-in")
    public ResponseEntity singIn(@RequestBody @Valid UserDetailsRequest userDetailsRequest) {
        Result<String> token = authService.signIn(userDetailsRequest);
        if (token.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(token.getException().getMessage());
        }
        return ResponseEntity.ok(new JwtAuthResponse(
                token.getValue()
        ));
    }
}
