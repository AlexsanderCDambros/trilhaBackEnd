package trilha.back.finances.domain.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.finances.domain.dto.CategoryRequestDTO;
import trilha.back.finances.domain.entities.Category;
import trilha.back.finances.adapter.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private ModelMapper mapper;

    public CategoryService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public long idCategoryByName(String categoryName) {
        ArrayList<Category> result = categoryRepository.findByName(categoryName);
        return result.isEmpty() ? 0 : result.get(0).getId();
    };

    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

    public ResponseEntity findById(long id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else  {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    public ResponseEntity save(Category category) {
        return this.idCategoryByName(category.getName()) > 0 ?
                ResponseEntity.status(HttpStatus.FOUND).body("Category name already exists") :
                ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));
    }

    public ResponseEntity update(long id, Category category) {
        try {
            Category categoryToEdit = categoryRepository.findById(id)
                    .orElseThrow();
            categoryToEdit.setName(category.getName());
            categoryToEdit.setDescription(category.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(categoryToEdit));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }
    }

    public ResponseEntity delete(long id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else {
            categoryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("resource deleted successfully");
        }
    }

    public Category dtoToCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = mapper.map(categoryRequestDTO, Category.class);
        return category;
    }
}
