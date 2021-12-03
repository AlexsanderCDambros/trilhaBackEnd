package trilha.back.finances.entities;

import java.util.Date;

public class Entry extends BaseClass {
    private String type;
    private Double amount;
    private Date date;
    private boolean paid;
    private long categoryId;

    public Entry() {
    }

    public Entry(long id, String name, String description, String type, Double amount, Date date, boolean paid, long categoryId) {
        super(id, name, description);
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", paid=" + paid +
                ", categoryId=" + categoryId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
