package io.github.cyprog.government_transparency_app.repository;

import io.github.cyprog.government_transparency_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
