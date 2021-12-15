package trilha.back.finances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Category;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.repositories.EntryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Entry> findById(@PathVariable long id) {
        return entryRepository.findById(id);
    }

    @PostMapping
    public Entry save(@RequestBody Entry entry) {
        return entryRepository.save(entry);
    }

    @PutMapping("/{id}")
    public Entry update(@PathVariable long id, @RequestBody Entry entry) {
        Entry entryToEdit = entryRepository.findById(id)
                .orElseThrow();
        entryToEdit.setName(entry.getName());
        entryToEdit.setDescription(entry.getDescription());
        entryToEdit.setCategoryId(entry.getCategoryId());
        entryToEdit.setPaid(entry.isPaid());
        entryToEdit.setDate(entry.getDate());
        entryToEdit.setAmount(entry.getAmount());
        entryToEdit.setType(entry.getType());
        return entryRepository.save(entryToEdit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        entryRepository.deleteById(id);
    }

}
