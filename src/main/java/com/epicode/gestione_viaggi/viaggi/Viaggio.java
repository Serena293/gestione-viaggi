package com.epicode.gestione_viaggi.viaggi;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idViaggio;

    @NotNull(message = "La destinazione non può essere nulla")
    @Size(min = 3, max = 100, message = "La destinazione deve avere tra 3 e 100 caratteri")
    private String destinazione;

    @NotNull(message = "La data non può essere nulla")
    @Future(message = "Non puoi viaggiare indietro nel tempo")
    private LocalDate data;

    @NotNull(message = "Lo stato del viaggio non può essere nullo")
    private StatoViaggio stato;
}
