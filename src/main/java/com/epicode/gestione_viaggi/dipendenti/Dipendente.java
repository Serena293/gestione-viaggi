package com.epicode.gestione_viaggi.dipendenti;

import com.epicode.gestione_viaggi.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDipendente;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    @ManyToOne // Ogni dipendente può effettuare più viaggi
    @JoinColumn(name = "idViaggio")
    private Viaggio viaggio;
}
