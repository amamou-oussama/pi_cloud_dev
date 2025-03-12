package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Pack pack;

    @ManyToOne
    private Destination destination;

    @ManyToOne
    private Activite activity;

}
