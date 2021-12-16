package trilha.back.finances.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.finances.repositories.CategoryRepository;

@Service
public class EntryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean validateCategoryById(long idCategory) {
        return categoryRepository.existsById(idCategory);
    }

}
