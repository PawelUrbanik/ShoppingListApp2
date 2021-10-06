package pl.pawel.shoppinglistapp2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {


    @Id
    private Integer id;
    private String name;
    private Integer listId;
    private boolean bought;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
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

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
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
        return bought == product.bought && count == product.count && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(listId, product.listId) && Objects.equals(addedBy, product.addedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, listId, bought, addedBy, count);
    }
}
