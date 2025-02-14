package com.epicode.gestione_viaggi.viaggi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/viaggio")
@RequiredArgsConstructor
public class ViaggioController {

    private final ViaggioService viaggioService;

    @PostMapping
    public Viaggio creaViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.salvaViaggio(viaggio);
    }

    @GetMapping("/{id}")
    public Viaggio trovaViaggio(@PathVariable Long id) {
        return viaggioService.trovaViaggio(id);
    }

    @GetMapping
    public List<Viaggio> trovaViaggi() {
        return viaggioService.trovaViaggi();
    }

    @DeleteMapping("/{id}")
    public void eliminaViaggio(@PathVariable Long id) {
        viaggioService.eliminaViaggio(id);
    }

    @PutMapping("/{id}")
    public Viaggio aggiornaViaggio(@PathVariable Long id, @RequestBody Viaggio dettagliViaggio) {
        return viaggioService.aggiornaViaggio(id, dettagliViaggio);
    }
}
