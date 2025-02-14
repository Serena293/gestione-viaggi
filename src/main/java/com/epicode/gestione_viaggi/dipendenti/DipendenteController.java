package com.epicode.gestione_viaggi.dipendenti;

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
        return ResponseEntity.ok(dipendenteService.salvaDipendente(dipendente));
    }

    // READ (Trova un dipendente per ID)
    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendente(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteService.trovaDipendente(id));
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
        dipendenteService.eliminaDipendente(id);
        return ResponseEntity.ok("Dipendente eliminato con successo");
    }
}
