package it.dkashtan.ticket_platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.dkashtan.ticket_platform.model.TicketModel;
import it.dkashtan.ticket_platform.model.NotesModel;
import it.dkashtan.ticket_platform.repository.TicketRepository;
import it.dkashtan.ticket_platform.repository.NotesRepository;
import it.dkashtan.ticket_platform.repository.UserRepository;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listTickets(Model model) {
        List<TicketModel> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets/list";
    }

    @GetMapping("/{id}")
    public String viewTicket(@PathVariable Integer id, Model model) {
        Optional<TicketModel> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            List<NotesModel> notes = notesRepository.findByTicket(ticket.get());
            model.addAttribute("notes", notes);
            return "tickets/detail";
        } else {
            return "redirect:/tickets";
        }
    }

    @GetMapping("/create")
    public String createTicketForm(Model model) {
        model.addAttribute("ticket", new TicketModel());
        model.addAttribute("users", userRepository.findAll());
        return "tickets/create";
    }

    @PostMapping("/create")
    public String createTicket(@ModelAttribute TicketModel ticket) {
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/edit/{id}")
    public String editTicketForm(@PathVariable Integer id, Model model) {
        Optional<TicketModel> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            model.addAttribute("users", userRepository.findAll());
            return "tickets/edit";
        } else {
            return "redirect:/tickets";
        }
    }

    @PostMapping("/edit/{id}")
    public String editTicket(@PathVariable Integer id, @ModelAttribute TicketModel ticket) {
        ticket.setId(id);
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Integer id) {
        ticketRepository.deleteById(id);
        return "redirect:/tickets";
    }
}
