package io.github.cyprog.government_transparency_app.service;

import io.github.cyprog.government_transparency_app.entity.Update;
import io.github.cyprog.government_transparency_app.entity.User;
import io.github.cyprog.government_transparency_app.repository.UpdateRepository;
import io.github.cyprog.government_transparency_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with email: " + email));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    @Service
    @RequiredArgsConstructor
    public static class UpdateService {

        private final UpdateRepository updateRepository;

        public List<Update> getAllUpdates() {
            return updateRepository.findAll();
        }

        public Update getUpdateById(Long id) {
            return updateRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Update not found with id: " + id));
        }
    }
}
