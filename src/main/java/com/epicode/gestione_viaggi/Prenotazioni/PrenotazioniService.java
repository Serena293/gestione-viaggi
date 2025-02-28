package com.epicode.gestione_viaggi.Prenotazioni;

import com.epicode.gestione_viaggi.dipendenti.Dipendente;
import com.epicode.gestione_viaggi.dipendenti.DipendenteRepository;
import com.epicode.gestione_viaggi.viaggi.StatoViaggio;
import com.epicode.gestione_viaggi.viaggi.Viaggio;
import com.epicode.gestione_viaggi.viaggi.ViaggioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrenotazioniService {
    private final PrenotazioniRepository prenotazioniRepository;
    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;

    // CREATE
    public Prenotazioni salvaPrenotazione(Prenotazioni prenotazione) {
        return prenotazioniRepository.save(prenotazione);
    }

    // READ (Trova prenotazione per ID)
    public Prenotazioni trovaPrenotazione(Long id) {
        return prenotazioniRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenotazione con ID " + id + " non trovata"));
    }

    // READ (Trova tutte le prenotazioni)
    public List<Prenotazioni> trovaPrenotazioni() {
        return List.copyOf(prenotazioniRepository.findAll());
    }

    // UPDATE
    public Prenotazioni aggiornaPrenotazione(Long id, Prenotazioni dettagliPrenotazione) {
        Prenotazioni prenotazione = trovaPrenotazione(id);

        prenotazione.setViaggio(dettagliPrenotazione.getViaggio());
        prenotazione.setDipendente(dettagliPrenotazione.getDipendente());

        return prenotazioniRepository.save(prenotazione);
    }

    // DELETE
    public void eliminaPrenotazione(Long id) {
        prenotazioniRepository.deleteById(id);
    }

    // ASSEGNA DIPENDENTE A VIAGGIO
    public Prenotazioni assegnaDipendenteAViaggio(Long id, Long dipendenteId, Long viaggioId) {
        Prenotazioni prenotazione = trovaPrenotazione(id);
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new RuntimeException("Dipendente con ID " + dipendenteId + " non trovato"));
        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new RuntimeException("Viaggio con ID " + viaggioId + " non trovato"));

        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);

        return prenotazioniRepository.save(prenotazione);
    }

    // MODIFICA STATO VIAGGIO
    public Viaggio modificaStatoViaggio(Long viaggioId, StatoViaggio nuovoStato) {
        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new RuntimeException("Viaggio con ID " + viaggioId + " non trovato"));

        viaggio.setStato(nuovoStato);
        return viaggioRepository.save(viaggio);
    }
}
