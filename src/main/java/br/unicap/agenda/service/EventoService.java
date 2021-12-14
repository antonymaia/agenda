package br.unicap.agenda.service;

import br.unicap.agenda.model.Evento;
import br.unicap.agenda.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicap.agenda.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Evento> evento = eventoRepository.findById(id);
        if(evento.isPresent() == false){
            throw new ObjectNotFoundException("Evento não encontrado");
        }
        eventoRepository.deleteById(id);
    }
}
