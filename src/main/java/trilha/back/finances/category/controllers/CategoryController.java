package trilha.back.finances.category.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.category.dtos.CategoryRequestDTO;
import trilha.back.finances.category.entities.Category;
import trilha.back.finances.category.services.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CategoryRequestDTO dto) {
        Category category = categoryService.dtoToCategory(dto);
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody @Valid CategoryRequestDTO dto) {
        Category category = categoryService.dtoToCategory(dto);
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return categoryService.delete(id);
    }

}
