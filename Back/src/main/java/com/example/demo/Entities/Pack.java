package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String packName;
    @Enumerated (EnumType.STRING)
    private PackType packType;
    private String packDescription;
    private Date date_debut;
    private Date date_fin;

    @OneToOne(cascade = CascadeType.ALL)
    private Vol vol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pack")
    private Set<Promotion> promotion;

}
