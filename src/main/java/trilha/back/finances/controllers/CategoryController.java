package trilha.back.finances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Category;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.repositories.CategoryRepository;
import trilha.back.finances.services.CategoryService;
import trilha.back.finances.services.EntryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else  {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Category category) {
        return categoryService.idCategoryByName(category.getName()) > 0 ?
                ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Category name already exists") :
                ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Category category) {
        try {
            Category categoryToEdit = categoryRepository.findById(id)
                    .orElseThrow();
            categoryToEdit.setName(category.getName());
            categoryToEdit.setDescription(category.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(categoryToEdit));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Category not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("resource deleted successfully");
    }

}
