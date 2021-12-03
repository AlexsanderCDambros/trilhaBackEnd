package trilha.back.finances.controllers;

import org.springframework.web.bind.annotation.*;
import trilha.back.finances.entities.Category;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private List<Category> list = new ArrayList<Category>();

    @GetMapping
    public List<Category> getAll() {
        return this.list;
    }

    @PostMapping
    public Integer save(@RequestBody Category category) {
        this.list.add(category);
        return this.list.size();
    }

}
