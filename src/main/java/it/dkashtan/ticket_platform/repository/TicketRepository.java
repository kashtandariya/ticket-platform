package it.dkashtan.ticket_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.TicketModel;

public interface TicketRepository extends JpaRepository<TicketModel, Integer>{

}
