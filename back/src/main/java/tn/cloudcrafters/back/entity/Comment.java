package tn.cloudcrafters.back.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comment;
    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    private String content;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reaction> reactions = new HashSet<>();
}
