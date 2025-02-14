package com.epicode.gestione_viaggi.dipendenti;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dipendente")
@RequiredArgsConstructor
public class DipendenteController {
    private final DipendenteService dipendenteService;

    // CREATE
    @PostMapping
    public ResponseEntity<Dipendente> creaDipendente(@RequestBody Dipendente dipendente) {
        if (dipendente == null) {
            throw new IllegalArgumentException("Errore nella creazione di un dipendente");
        }
        return ResponseEntity.ok(dipendenteService.salvaDipendente(dipendente));
    }

    // READ (Trova un dipendente per ID)
    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendente(@PathVariable Long id) {
        Dipendente dipendente = dipendenteService.trovaDipendente(id);
        if (dipendente == null) {
            throw new EntityNotFoundException("Dipendente non trovato con ID " + id);
        }
        return ResponseEntity.ok(dipendente);
    }

    // READ (Trova tutti i dipendenti)
    @GetMapping
    public ResponseEntity<List<Dipendente>> getDipendenti() {
        return ResponseEntity.ok(dipendenteService.trovaDipendenti());
    }

    // UPDATE (Modifica un dipendente esistente)
    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> aggiornaDipendente(@PathVariable Long id, @RequestBody Dipendente dettagliDipendente) {
        return ResponseEntity.ok(dipendenteService.aggiornaDipendente(id, dettagliDipendente));
    }

    // DELETE (Elimina un dipendente per ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminaDipendente(@PathVariable Long id) {
        try {
            dipendenteService.eliminaDipendente(id);
            return ResponseEntity.ok("Dipendente eliminato");
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("Dipendente non trovato con ID " + id);
        }
    }
}
