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

    @OneToOne
    private User addedBy;
    private int count;


    public Product() {
    }
}
