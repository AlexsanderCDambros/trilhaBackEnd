package trilha.back.finances.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.finances.domain.entities.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
