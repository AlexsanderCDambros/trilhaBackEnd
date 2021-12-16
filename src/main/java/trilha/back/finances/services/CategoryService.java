package trilha.back.finances.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.finances.entities.Category;
import trilha.back.finances.repositories.CategoryRepository;

import java.util.ArrayList;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public long idCategoryByName(String categoryName) {
        ArrayList<Category> result = categoryRepository.findByName(categoryName);
        return result.isEmpty() ? 0 : result.get(0).getId();
    };
}
