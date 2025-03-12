package tn.cloudcrafters.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String username;
    private String email;
    private String password;
    private  String profile_picture;
    private LocalDateTime date_of_birth;
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Message> receivedMessages = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reaction> reactions = new HashSet<>();


    public User(Long id_user, String username, String email, String password, String profile_picture, LocalDateTime date_of_birth, LocalDateTime created_at) {
        this.id_user = id_user;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile_picture = profile_picture;
        this.date_of_birth = date_of_birth;
        this.created_at = created_at;
    }

    public User() {

    }
}
