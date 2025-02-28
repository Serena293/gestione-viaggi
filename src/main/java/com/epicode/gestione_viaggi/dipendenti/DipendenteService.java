package com.epicode.gestione_viaggi.dipendenti;

import com.epicode.gestione_viaggi.viaggi.Viaggio;
import com.epicode.gestione_viaggi.viaggi.ViaggioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;

    // CREATE
    public Dipendente salvaDipendente(DipendenteDTO dipendenteDTO) {
        Viaggio viaggio = viaggioRepository.findById(dipendenteDTO.getIdViaggio())
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato con ID " + dipendenteDTO.getIdViaggio()));

        Dipendente dipendente = new Dipendente(
                null, // ID viene generato automaticamente
                dipendenteDTO.getNome(),
                dipendenteDTO.getCognome(),
                dipendenteDTO.getUsername(),
                dipendenteDTO.getEmail(),
                viaggio
        );

        return dipendenteRepository.save(dipendente);
    }

    // READ (Trova dipendente per ID)
    public Dipendente trovaDipendente(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente con ID " + id + " non trovato"));
    }

    // READ (Trova tutti i dipendenti)
    public List<Dipendente> trovaDipendenti() {
        return dipendenteRepository.findAll();
    }

    // UPDATE
    public Dipendente aggiornaDipendente(Long id, DipendenteDTO dettagliDipendenteDTO) {
        Dipendente dipendente = trovaDipendente(id);

        Viaggio viaggio = viaggioRepository.findById(dettagliDipendenteDTO.getIdViaggio())
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato con ID " + dettagliDipendenteDTO.getIdViaggio()));

        dipendente.setNome(dettagliDipendenteDTO.getNome());
        dipendente.setCognome(dettagliDipendenteDTO.getCognome());
        dipendente.setEmail(dettagliDipendenteDTO.getEmail());
        dipendente.setViaggio(viaggio);

        return dipendenteRepository.save(dipendente);
    }

    // DELETE
    public void eliminaDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
