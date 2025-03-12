package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_emission;
    private Double montant_total;
    private String details_prestations;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "facture")
    @JoinColumn(name = "id_paiement")
    private Paiement paiement;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
