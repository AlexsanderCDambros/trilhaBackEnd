package trilha.back.finances.entry.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Entry")
public class Entry implements Serializable, Comparable<Entry> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private boolean paid;

    @Column(nullable = false)
    private long categoryId;

    public Entry() {
    }

    public Entry(long id, String name, String description, String type, Double amount, Date date, boolean paid, long category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.categoryId = category;
    }

    @Override
    public int compareTo(Entry otherEntry) {
        return this.date.compareTo(otherEntry.getDate());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long category) {
        this.categoryId = category;
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
