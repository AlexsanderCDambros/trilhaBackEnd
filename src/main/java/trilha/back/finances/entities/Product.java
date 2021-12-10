package trilha.back.finances.entities;

public class Product extends BaseClass {
    private Double price;

    public Product() {
    }

    public Product(long id, String name, String description, Double price) {
        super(id, name, description);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
