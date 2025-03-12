package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private String methode_paiement;
    private Date date_paiement;
    private String statut;
    private String discount_code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    private Facture facture;

}
