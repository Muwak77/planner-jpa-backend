package de.profect.plannerjpabackend.repository;

import de.profect.plannerjpabackend.model.CalendarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarUserRepository extends JpaRepository<CalendarUser, Long> {
}
