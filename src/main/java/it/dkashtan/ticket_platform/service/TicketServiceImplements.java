package it.dkashtan.ticket_platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dkashtan.ticket_platform.model.TicketModel;
import it.dkashtan.ticket_platform.repository.TicketRepository;

@Service
public class TicketServiceImplements implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Optional<TicketModel> findById(Integer id) {
		return ticketRepository.findById(id);
		}

	@Override
	public List<TicketModel> findAll() {
		 return ticketRepository.findAll();
	}

	@Override
	public List<TicketModel> findByCategoryType(String categoryType) {
		return ticketRepository.findByCategoryType(categoryType);
	}

	@Override
	public List<TicketModel> findByStatus(String status) {
		return ticketRepository.findByStatus(status);
	}

}
