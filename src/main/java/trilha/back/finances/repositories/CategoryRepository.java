package trilha.back.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.finances.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
