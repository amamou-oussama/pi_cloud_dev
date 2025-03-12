package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double reduction_percent;
    private Date date_debut;
    private Date date_fin;

    @ManyToOne
    private Set<Vol> vols;

    @ManyToOne
    private Set<Event> events;

    @ManyToOne
    private Pack pack;


}
