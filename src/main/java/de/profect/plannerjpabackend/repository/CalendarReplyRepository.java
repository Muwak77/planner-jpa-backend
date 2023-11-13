package de.profect.plannerjpabackend.repository;

import de.profect.plannerjpabackend.model.CalendarReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarReplyRepository extends JpaRepository<CalendarReply, Long> {
}
