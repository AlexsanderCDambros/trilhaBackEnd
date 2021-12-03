package trilha.back.finances.entities;

public class Category extends BaseClass {

    public Category() {
    }

    public Category(long id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
