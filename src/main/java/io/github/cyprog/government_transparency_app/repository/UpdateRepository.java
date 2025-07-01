package io.github.cyprog.government_transparency_app.repository;

import io.github.cyprog.government_transparency_app.entity.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Long> {
}
