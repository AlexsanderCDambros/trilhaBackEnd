package trilha.back.finances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Category;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.repositories.EntryRepository;
import trilha.back.finances.services.EntryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private EntryService entryService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(entryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        Optional<Entry> result = entryRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found");
        } else  {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Entry entry) {
        return entryService.validateCategoryById(entry.getCategoryId()) ?
                ResponseEntity.status(HttpStatus.CREATED).body(entryRepository.save(entry)) :
                ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Category not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Entry entry) {
        try {
            Entry entryToEdit = entryRepository.findById(id)
                    .orElseThrow();
            entryToEdit.setName(entry.getName());
            entryToEdit.setDescription(entry.getDescription());
            entryToEdit.setCategoryId(entry.getCategoryId());
            entryToEdit.setPaid(entry.isPaid());
            entryToEdit.setDate(entry.getDate());
            entryToEdit.setAmount(entry.getAmount());
            entryToEdit.setType(entry.getType());
            return entryService.validateCategoryById(entry.getCategoryId()) ?
                    ResponseEntity.status(HttpStatus.OK).body(entryRepository.save(entryToEdit)) :
                    ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Category not found");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Entry not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        entryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("resource deleted successfully");
    }

}
