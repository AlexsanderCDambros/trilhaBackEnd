package trilha.back.finances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Category;
import trilha.back.finances.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable long id) {
        return categoryRepository.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable long id, @RequestBody Category category) {
        Category categoryToEdit = categoryRepository.findById(id)
                .orElseThrow();
        categoryToEdit.setName(category.getName());
        categoryToEdit.setDescription(category.getDescription());
        return categoryRepository.save(categoryToEdit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryRepository.deleteById(id);
    }

}
