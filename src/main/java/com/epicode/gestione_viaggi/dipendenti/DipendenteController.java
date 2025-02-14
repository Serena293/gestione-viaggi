package com.epicode.gestione_viaggi.dipendenti;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dipendente")
@RequiredArgsConstructor
public class DipendenteController {
    private final DipendenteService dipendenteService;

    // CREATE: Crea un nuovo dipendente
    @PostMapping
    public ResponseEntity<Dipendente> creaDipendente(@RequestBody @Valid DipendenteDTO dipendenteDTO) {
        if (dipendenteDTO == null) {
            throw new IllegalArgumentException("Errore nella creazione di un dipendente");
        }
        Dipendente dipendente = dipendenteService.salvaDipendente(dipendenteDTO);
        return ResponseEntity.ok(dipendente);
    }

    // READ: Trova un dipendente per ID
    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendente(@PathVariable Long id) {
        Dipendente dipendente = dipendenteService.trovaDipendente(id);
        return ResponseEntity.ok(dipendente);
    }

    // READ: Trova tutti i dipendenti
    @GetMapping
    public ResponseEntity<List<Dipendente>> getDipendenti() {
        return ResponseEntity.ok(dipendenteService.trovaDipendenti());
    }

    // UPDATE: Modifica un dipendente esistente
    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> aggiornaDipendente(@PathVariable Long id, @RequestBody @Valid DipendenteDTO dettagliDipendenteDTO) {
        Dipendente dipendenteAggiornato = dipendenteService.aggiornaDipendente(id, dettagliDipendenteDTO);
        return ResponseEntity.ok(dipendenteAggiornato);
    }

    // DELETE: Elimina un dipendente per ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminaDipendente(@PathVariable Long id) {
        dipendenteService.eliminaDipendente(id);
        return ResponseEntity.ok("Dipendente eliminato con successo");
    }
}
