package it.dkashtan.ticket_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import it.dkashtan.ticket_platform.model.NotesModel;
import it.dkashtan.ticket_platform.model.TicketModel;
import it.dkashtan.ticket_platform.repository.NotesRepository;
import it.dkashtan.ticket_platform.repository.TicketRepository;

import java.util.Optional;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/add/{ticketId}")
    public String addNote(@PathVariable Integer ticketId, @RequestParam String text) {
        Optional<TicketModel> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            NotesModel note = new NotesModel();
            note.setText(text);
            note.setTicket(ticket.get());
            notesRepository.save(note);
        }
        return "redirect:/tickets/" + ticketId;
    }
}
