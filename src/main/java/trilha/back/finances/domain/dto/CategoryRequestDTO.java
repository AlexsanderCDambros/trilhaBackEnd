package trilha.back.finances.domain.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import trilha.back.finances.domain.entities.Category;

import javax.validation.constraints.NotEmpty;

@Getter
public class CategoryRequestDTO {

    @NotEmpty(message = "name cannot be null")
    @Length(min = 3, max = 15, message = "name length needs to be between 3 and 15")
    private String name;

    @NotEmpty(message = "description cannot be null")
    @Length(min = 15, max = 50, message = "description length needs to be between 15 and 150")
    private String description;

    public Category transformToObject() {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return category;
    }
}
