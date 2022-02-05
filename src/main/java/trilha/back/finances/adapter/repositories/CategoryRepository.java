package trilha.back.finances.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.finances.domain.entities.Category;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    ArrayList<Category> findByName(String name);
}
