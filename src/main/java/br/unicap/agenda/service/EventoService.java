package br.unicap.agenda.service;

import br.unicap.agenda.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicap.agenda.repository.EventoRepository;

import java.util.List;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    public Evento create(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public void delete(Long id) {
        eventoRepository.deleteById(id);
    }
}
