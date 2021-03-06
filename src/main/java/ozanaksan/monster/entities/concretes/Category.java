package ozanaksan.monster.entities.concretes;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity

public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name ="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "categories")
    private List<Product> products;

}
