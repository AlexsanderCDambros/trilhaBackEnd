package trilha.back.finances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.dto.EntryRequestDTO;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.services.CategoryService;
import trilha.back.finances.services.EntryService;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/chart")
    public ResponseEntity getChartCategory() {
        return entryService.generateChartDTO();
    }

    @GetMapping
    public ResponseEntity findAll() {
        return entryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return entryService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody EntryRequestDTO dto) {
        Entry entry = dto.transformToObject();
        entry.setCategoryId(categoryService.idCategoryByName(dto.getName()));
        return entryService.save(entry);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody EntryRequestDTO dto) {
        Entry entry = dto.transformToObject();
        entry.setCategoryId(categoryService.idCategoryByName(dto.getName()));
        return entryService.update(id, entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return entryService.delete(id);
    }

}
