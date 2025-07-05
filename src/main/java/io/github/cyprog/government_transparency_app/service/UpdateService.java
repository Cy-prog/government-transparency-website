package io.github.cyprog.government_transparency_app.service;

import io.github.cyprog.government_transparency_app.entity.Update;
import io.github.cyprog.government_transparency_app.repository.UpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateService {

    private final UpdateRepository updateRepository;

    public List<Update> getAllUpdates() {
        return updateRepository.findAll();
    }

    public Update getUpdateById(Long id) {
        return updateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Update not found with id: " + id));
    }


    public void save(Update update) {
        updateRepository.save(update);
    }
}
