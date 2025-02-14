package com.epicode.gestione_viaggi.Prenotazioni;

import com.epicode.gestione_viaggi.viaggi.StatoViaggio;
import com.epicode.gestione_viaggi.viaggi.Viaggio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prenotazioni")
@RequiredArgsConstructor
public class PrenotazioniController {
    private final PrenotazioniService prenotazioniService;

    // CREATE
    @PostMapping
    public ResponseEntity<Prenotazioni> creaPrenotazione(@RequestBody Prenotazioni prenotazione) {
        return ResponseEntity.ok(prenotazioniService.salvaPrenotazione(prenotazione));
    }

    // READ (Trova una prenotazione per ID)
    @GetMapping("/{id}")
    public ResponseEntity<Prenotazioni> getPrenotazione(@PathVariable Long id) {
        return ResponseEntity.ok(prenotazioniService.trovaPrenotazione(id));
    }

    // READ (Trova tutte le prenotazioni)
    @GetMapping
    public ResponseEntity<List<Prenotazioni>> getPrenotazioni() {
        return ResponseEntity.ok(prenotazioniService.trovaPrenotazioni());
    }

    // UPDATE (Modifica una prenotazione esistente)
    @PutMapping("/{id}")
    public ResponseEntity<Prenotazioni> aggiornaPrenotazione(@PathVariable Long id, @RequestBody Prenotazioni dettagliPrenotazione) {
        return ResponseEntity.ok(prenotazioniService.aggiornaPrenotazione(id, dettagliPrenotazione));
    }

    // DELETE (Elimina una prenotazione per ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminaPrenotazione(@PathVariable Long id) {
        prenotazioniService.eliminaPrenotazione(id);
        return ResponseEntity.ok("Prenotazione eliminata con successo");
    }

    // ASSEGNA DIPENDENTE A VIAGGIO
    @PostMapping("/{id}/assegna")
    public ResponseEntity<Prenotazioni> assegnaDipendenteAViaggio(@PathVariable Long id, @RequestParam Long dipendenteId, @RequestParam Long viaggioId) {
        return ResponseEntity.ok(prenotazioniService.assegnaDipendenteAViaggio(id, dipendenteId, viaggioId));
    }


    // MODIFICA STATO VIAGGIO
    @PutMapping("/viaggi/{viaggioId}/stato")
    public ResponseEntity<Viaggio> modificaStatoViaggio(@PathVariable Long viaggioId, @RequestParam StatoViaggio nuovoStato) {
        return ResponseEntity.ok(prenotazioniService.modificaStatoViaggio(viaggioId, nuovoStato));
    }
}
