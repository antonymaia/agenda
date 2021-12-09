package br.unicap.agenda.repository;

import org.springframework.stereotype.Repository;

import br.unicap.agenda.model.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
}
