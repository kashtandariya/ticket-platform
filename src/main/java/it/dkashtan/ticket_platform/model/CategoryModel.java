package it.dkashtan.ticket_platform.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @OneToMany(mappedBy = "category")
    private List<TicketModel> tickets;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        this.tickets = tickets;
    }
}
