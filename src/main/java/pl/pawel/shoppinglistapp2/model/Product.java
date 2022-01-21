package pl.pawel.shoppinglistapp2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
public class Product implements Serializable {


    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "list_id", nullable = false )
    private ShoppingList list;
    private boolean bought;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @OneToOne
    private User addedBy;
    private int count;


    public Product() {
    }

    public Product(String name, boolean bought, ProductCategory category, User addedBy, int count, ShoppingList list) {
        this.name = name;
        this.bought = bought;
        this.category = category;
        this.addedBy = addedBy;
        this.count = count;
        this.list = list;
    }
}
