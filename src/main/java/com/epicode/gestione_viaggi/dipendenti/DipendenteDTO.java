package com.epicode.gestione_viaggi.dipendenti;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteDTO {
    @NotNull(message = "Il nome non può essere nullo")
    @Size(min = 2, max = 50, message = "Il nome deve avere tra 2 e 50 caratteri")
    private String nome;

    @NotNull(message = "Il cognome non può essere nullo")
    @Size(min = 2, max = 50, message = "Il cognome deve avere tra 2 e 50 caratteri")
    private String cognome;

    private String username;

    @Email(message = "L'email non è valida")
    @NotNull(message = "L'email non può essere nulla")
    private String email;

    @NotNull(message = "Il campo viaggio non può essere nullo")
    private Long idViaggio;
}
