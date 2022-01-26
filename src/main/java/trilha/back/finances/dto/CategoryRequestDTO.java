package trilha.back.finances.dto;

import lombok.Getter;
import trilha.back.finances.entities.Category;

@Getter
public class CategoryRequestDTO {

    private String name;
    private String description;

    public Category transformToObject() {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return category;
    }
}
