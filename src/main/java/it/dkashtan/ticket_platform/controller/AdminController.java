package it.dkashtan.ticket_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.dkashtan.ticket_platform.repository.OperatoreRepository;
import it.dkashtan.ticket_platform.repository.TicketRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private OperatoreRepository operatoreRepository;
	
	
}
