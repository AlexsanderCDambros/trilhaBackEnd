package trilha.back.finances.entry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.finances.entry.entities.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
