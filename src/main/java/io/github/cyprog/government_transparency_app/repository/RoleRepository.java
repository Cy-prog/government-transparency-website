package io.github.cyprog.government_transparency_app.repository;

import io.github.cyprog.government_transparency_app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByName(String name);

}
