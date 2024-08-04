package it.dkashtan.ticket_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

    List<Ticket> findByTitoloIgnoreCase(String titolo);

}
