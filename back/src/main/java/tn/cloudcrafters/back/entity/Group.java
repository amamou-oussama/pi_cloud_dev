package tn.cloudcrafters.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_group;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

}
