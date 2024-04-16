package ru.mirea.dentalclinic.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mirea.dentalclinic.data.entities.UserEntity;
import ru.mirea.dentalclinic.utils.result.Result;

public interface UserService {
    UserEntity save(UserEntity user);

    Result<UserEntity> create(UserEntity user);

    Result<UserEntity> getByUsername(String username);


    Result<UserEntity> getCurrentUser();
}
