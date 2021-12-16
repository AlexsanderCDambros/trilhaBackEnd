package trilha.back.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.finances.entities.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
