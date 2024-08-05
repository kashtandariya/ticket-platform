package it.dkashtan.ticket_platform.service;

import java.util.List;
import java.util.Optional;

import it.dkashtan.ticket_platform.model.TicketModel;

public interface TicketService {
	
	public Optional<TicketModel> findById(Integer id);

	public List<TicketModel> findAll();

	public List<TicketModel> findByCategoryType(String categoryType);

	public List<TicketModel> findByStatus(String status);
}
