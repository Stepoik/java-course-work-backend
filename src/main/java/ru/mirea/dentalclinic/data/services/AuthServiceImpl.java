package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.api.dtos.requests.UserDetailsRequest;
import ru.mirea.dentalclinic.data.entities.UserEntity;
import ru.mirea.dentalclinic.domain.service.AuthService;
import ru.mirea.dentalclinic.domain.service.UserService;
import ru.mirea.dentalclinic.utils.JwtService;
import ru.mirea.dentalclinic.utils.result.Result;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    @Override
    public Result<String> signUp(UserDetailsRequest userDetailsRequest) {
        UserEntity user = UserEntity.builder()
                .username(userDetailsRequest.username())
                .password(passwordEncoder.encode(userDetailsRequest.password()))
                .role(UserEntity.Role.ROLE_USER)
                .build();

        Result<UserEntity> createdUser = userService.create(user);
        if (createdUser.getResultType() == Result.ResultType.FAILURE) {
            return Result.failure(createdUser.getException());
        }
        String jwt = jwtService.generateToken(user);
        return Result.success(jwt);
    }

    @Override
    public Result<String> signIn(UserDetailsRequest userDetailsRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDetailsRequest.username(),
                userDetailsRequest.password()
        ));
        UserDetails user = userDetailsService
                .loadUserByUsername(userDetailsRequest.username());
        var jwt = jwtService.generateToken(user);
        return Result.success(jwt);
    }
}
