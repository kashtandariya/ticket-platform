package it.dkashtan.ticket_platform.repository;

import it.dkashtan.ticket_platform.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByUsername(String username);

    List<UserModel> findByStatusTrue();
}
