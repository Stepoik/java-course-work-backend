package ru.mirea.dentalclinic.data.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.UserEntity;
import ru.mirea.dentalclinic.data.repositories.UserRepository;
import ru.mirea.dentalclinic.domain.service.UserService;
import ru.mirea.dentalclinic.exceptions.UserExistException;
import ru.mirea.dentalclinic.utils.result.Result;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public final String USER_NOT_FOUND = "User with this name not found";
    private final UserRepository repository;
    @Override
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public Result<UserEntity> create(UserEntity user) {
        if (repository.existsByUsername(user.getUsername())) {
            return Result.failure(new UserExistException());
        }
        return Result.success(save(user));
    }

    @Override
    public Result<UserEntity> getByUsername(String username) {
        var user = repository.findUserEntityByUsername(username);
        return user.map(Result::success).orElseGet(() -> Result.failure(new UsernameNotFoundException(USER_NOT_FOUND)));
    }

    @Override
    public Result<UserEntity> getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
