package br.unicap.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.agenda.model.Evento;
import br.unicap.agenda.service.EventoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/evento")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Evento evento) {
        evento = eventoService.create(evento);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(evento.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping()
    public ResponseEntity<List<Evento>> findAll(){
        return ResponseEntity.ok().body(eventoService.findAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        eventoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
