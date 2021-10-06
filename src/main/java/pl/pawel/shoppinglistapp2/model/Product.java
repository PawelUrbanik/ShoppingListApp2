package pl.pawel.shoppinglistapp2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {


    @Id
    @Column(name = "product_id")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingList getList() {
        return list;
    }

    public void setList(ShoppingList list) {
        this.list = list;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return bought == product.bought && count == product.count && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(list, product.list) && Objects.equals(addedBy, product.addedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, list, bought, addedBy, count);
    }
}
