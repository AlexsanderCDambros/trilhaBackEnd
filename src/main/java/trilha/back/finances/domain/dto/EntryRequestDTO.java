package trilha.back.finances.domain.dto;

import org.hibernate.validator.constraints.Length;
import trilha.back.finances.domain.entities.Entry;
import trilha.back.finances.domain.enums.EntryType;
import trilha.back.finances.domain.enums.validators.ValidateEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EntryRequestDTO {

    @NotEmpty(message = "name cannot be null")
    @Length(min = 3, max = 45, message = "name length needs to be between 3 and 45")
    private String name;

    @NotEmpty(message = "description cannot be null")
    @Length(min = 15, max = 150, message = "description length needs to be between 15 and 150")
    private String description;

    @NotEmpty(message = "type cannot be null")
    @Length(min = 3, max = 15, message = "type length needs to be between 3 and 15")
    @ValidateEnum(targetClassType = EntryType.class, message = "type should be expense or revenue")
    private String type;

    @NotNull(message = "amount cannot be null")
    @Min(value = 0, message ="amount should be equal or greater than 0")
    private Double amount;

    @NotNull(message = "date cannot be null")
    private Date date;

    @NotNull(message = "paid cannot be null")
    private Boolean paid;

    @NotEmpty(message = "categoryName cannot be null")
    @Length(min = 3, max = 15, message = "categoryName length needs to be between 3 and 15")
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
