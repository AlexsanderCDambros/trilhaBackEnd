package trilha.back.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.finances.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
