package it.dkashtan.ticket_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;

import it.dkashtan.ticket_platform.repository.OperatoreRepository;
import it.dkashtan.ticket_platform.repository.TicketRepository;

public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private OperatoreRepository operatoreRepository;
	
	
}
