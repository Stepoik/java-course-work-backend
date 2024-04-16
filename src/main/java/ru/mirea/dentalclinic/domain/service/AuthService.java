package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.api.dtos.requests.UserDetailsRequest;
import ru.mirea.dentalclinic.utils.result.Result;

public interface AuthService {
    Result<String> signUp(UserDetailsRequest userDetailsRequest);

    Result<String> signIn(UserDetailsRequest userDetailsRequest);
}
