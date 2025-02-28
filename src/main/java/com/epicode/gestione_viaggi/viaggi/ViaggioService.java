package com.epicode.gestione_viaggi.viaggi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ViaggioService {
    private final ViaggioRepository viaggiRepository;

    public List<Viaggio> trovaViaggi() {
        return List.copyOf(viaggiRepository.findAll()); // Converte Iterable in List
    }

    public Viaggio trovaViaggio(Long id) {
        return viaggiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio con ID " + id + " non trovato"));
    }

    public Viaggio salvaViaggio(Viaggio viaggio) {
        return viaggiRepository.save(viaggio);
    }

    public Viaggio aggiornaViaggio(Long id, Viaggio dettagliViaggio) {
        Viaggio viaggio = trovaViaggio(id);

        viaggio.setDestinazione(dettagliViaggio.getDestinazione());
        viaggio.setData(dettagliViaggio.getData());
        viaggio.setStato(dettagliViaggio.getStato());

        return viaggiRepository.save(viaggio);
    }

    public void eliminaViaggio(Long id) {
        viaggiRepository.deleteById(id);



    }
}
