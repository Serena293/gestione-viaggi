package com.epicode.gestione_viaggi.dipendenti;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;

    // CREATE
    public Dipendente salvaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    // READ (Trova dipendente per ID)
    public Dipendente trovaDipendente(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente con ID " + id + " non trovato"));
    }

    // UPDATE
    public Dipendente aggiornaDipendente(Long id, Dipendente dettagliDipendente) {
        Dipendente dipendente = trovaDipendente(id); // Trova il dipendente esistente

        dipendente.setNome(dettagliDipendente.getNome());
        dipendente.setCognome(dettagliDipendente.getCognome());
        dipendente.setEmail(dettagliDipendente.getEmail());

        return dipendenteRepository.save(dipendente);
    }

    // DELETE
    public void eliminaDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
