package pl.pawel.shoppinglistapp2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class ShoppingList implements Serializable {

    @Id
    @Column(name = "list_id")
    private Integer id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "list")
    private Set<Product> products;



}
