package io.github.cyprog.government_transparency_app.service;

import io.github.cyprog.government_transparency_app.dto.UserDto;
import io.github.cyprog.government_transparency_app.entity.User;

public interface UserService {
    void registerUser(UserDto userDto);
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
