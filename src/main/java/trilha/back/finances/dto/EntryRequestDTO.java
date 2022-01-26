package trilha.back.finances.dto;

import trilha.back.finances.entities.Entry;

import java.util.Date;

public class EntryRequestDTO {

    private String name;
    private String description;
    private String type;
    private Double amount;
    private Date date;
    private boolean paid;
    private String categoryName;

    public Entry transformToObject() {
        Entry entry = new Entry();

        entry.setName(name);
        entry.setDescription(description);
        entry.setType(type);
        entry.setAmount(amount);
        entry.setDate(date);
        entry.setPaid(paid);

        return entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
