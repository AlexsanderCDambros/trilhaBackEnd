package trilha.back.finances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trilha.back.finances.entities.Category;
import trilha.back.finances.entities.Entry;

import java.util.Date;

@SpringBootApplication
public class FinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancesApplication.class, args);

		System.out.println("Objects created filled");

		Category category = new Category(1,"name","description");
		System.out.println(category.toString());

		Entry entry = new Entry(1,"name","description",
				"type",200.00,new Date(),true,1);
		System.out.println(entry.toString());

		System.out.println("Now the objects created empties");

		Category category2 = new Category();
		category2.setId(2);
		category2.setName("name");
		category2.setDescription("description");
		System.out.println(category2.toString());

		Entry entry2 = new Entry();
		entry2.setId(2);
		entry2.setName("name");
		entry2.setDescription("description");
		entry2.setType("type");
		entry2.setAmount(200.00);
		entry2.setDate(new Date());
		entry2.setPaid(true);
		entry2.setCategoryId(2);
		System.out.println(entry2.toString());
	}

}
