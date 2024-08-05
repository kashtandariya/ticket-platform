package it.dkashtan.ticket_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dkashtan.ticket_platform.model.NotesModel;
import it.dkashtan.ticket_platform.model.TicketModel;

public interface NotesRepository extends JpaRepository<NotesModel, Integer>{

	List<NotesModel> findByTicket(TicketModel ticket);
}
