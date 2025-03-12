package tn.cloudcrafters.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_report;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReportStatus status = ReportStatus.PENDING;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
