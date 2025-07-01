package io.github.cyprog.government_transparency_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "updates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Update {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content;

    private String category; // e.g., "Funds", "War Status", "Poverty"

    private LocalDateTime createdAt;
}
