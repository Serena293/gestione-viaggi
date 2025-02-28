package com.epicode.gestione_viaggi.Prenotazioni;

import com.epicode.gestione_viaggi.dipendenti.Dipendente;
import com.epicode.gestione_viaggi.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPrenotazione;
    @OneToOne
    @JoinColumn(name = "idViaggio")
    private Viaggio viaggio;
    @ManyToOne // un dipendente può avere più prenotazioni
    @JoinColumn(name = "idDipendente")
    private Dipendente dipendente;
}
