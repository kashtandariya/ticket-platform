package it.dkashtan.ticket_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.dkashtan.ticket_platform.model.Operatore;
import it.dkashtan.ticket_platform.model.Ticket;
import it.dkashtan.ticket_platform.repository.OperatoreRepository;
import it.dkashtan.ticket_platform.repository.TicketRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private OperatoreRepository operatoreRepository;

	// Dashboard principale per l'admin
	@GetMapping("/dashboard")
	public String adminDashboard(Model model) {
		List<Ticket> tickets = ticketRepository.findAll();
		model.addAttribute("tickets", tickets);
		return "admin/dashboard";
	}

	//creazione ticket
	@GetMapping("/ticket/create")
	public String createTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("operatori", operatoreRepository.findByDisponibile(true));
		return "admin/ticket-form";
	}

	//assegnazione ticket
	@PostMapping("/ticket/save")
	public String saveTicket(@ModelAttribute Ticket ticket, @RequestParam("operatoreId") Integer operatoreId) {
		Operatore operatore = operatoreRepository.findById(operatoreId).orElse(null);
		if (operatore != null) {
			ticket.setOperatore(operatore);
		}
		ticketRepository.save(ticket);
		return "redirect:/admin/dashboard";
	}

	//modifica ticket
	@GetMapping("/ticket/edit")
	public String editTicket(@RequestParam("id") Integer id, Model model) {
		Ticket ticket = ticketRepository.findById(id).orElse(null);
		model.addAttribute("ticket", ticket);
		model.addAttribute("operatori", operatoreRepository.findByDisponibile(true));
		return "admin/ticket-form";
	}

	//Elimina un ticket
	@PostMapping("/ticket/delete")
	public String deleteTicket(@RequestParam("id") Integer id) {
		ticketRepository.deleteById(id);
		return "redirect:/admin/dashboard";
	}
}
