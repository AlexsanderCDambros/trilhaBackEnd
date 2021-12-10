package trilha.back.finances.controllers;

import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    private List<Entry> list = new ArrayList<Entry>();

    @GetMapping
    public List<Entry> getAll() {
        Collections.sort(this.list);
        return this.list;
    }

    @PostMapping
    public Integer save(@RequestBody Entry entry) {
        this.list.add(entry);
        return this.list.size();
    }

}
