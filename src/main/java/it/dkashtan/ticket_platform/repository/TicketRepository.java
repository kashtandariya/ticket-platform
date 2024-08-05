package it.dkashtan.ticket_platform.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.dkashtan.ticket_platform.model.TicketModel;
import it.dkashtan.ticket_platform.model.UserModel;

public interface TicketRepository extends JpaRepository<TicketModel, Integer> {

    List<TicketModel> findByCategoryType(String categoryType);

    List<TicketModel> findByStatus(String status);

    List<TicketModel> findByTitleContaining(String title);

	List<TicketModel> findByUser(UserModel user);
}
