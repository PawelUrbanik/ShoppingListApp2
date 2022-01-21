package pl.pawel.shoppinglistapp2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.pawel.shoppinglistapp2.model.Product;
import pl.pawel.shoppinglistapp2.model.ProductCategory;
import pl.pawel.shoppinglistapp2.model.ShoppingList;
import pl.pawel.shoppinglistapp2.model.User;
import pl.pawel.shoppinglistapp2.repository.ProductCategoryRepository;
import pl.pawel.shoppinglistapp2.repository.ProductRepository;
import pl.pawel.shoppinglistapp2.repository.ShoppingListRepository;
import pl.pawel.shoppinglistapp2.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private ShoppingListRepository shoppingListRepository;
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    private List<Product> products = new ArrayList<>();
    private List<ProductCategory> categories= new ArrayList<>();
    private List<ShoppingList> lists = new ArrayList<>();


    public DataLoader(UserRepository userRepository, ShoppingListRepository shoppingListRepository, ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.userRepository = userRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createUsers();
        createLists();
        createProducts();
    }

    private void createUsers() {
        User user = new User();
        user.setActive(true);
        user.setEmail("pawel@pawel.com");
        user.setName("Paweł");
        user.setPassword("passwdd1");
        userRepository.save(user);

        user = new User();
        user.setName("anna");
        user.setEmail("anna@anna.com");
        user.setActive(false);
        user.setPassword("anna1");
        userRepository.save(user);
    }
    private void createLists() {
        ShoppingList list = new ShoppingList();
        list.setName("Nazwa Lsity");
        list.setDescription("Opis listy");
        lists.add(list);
        shoppingListRepository.save(list);

        ShoppingList list1 = new ShoppingList();
        list1.setName("Lisyta 2");
        list1.setDescription("Krótki opis");
        lists.add(list1);
        shoppingListRepository.save(list1);
    }

    private void createProducts() {
        createCategories();
        Product product = new Product("Masło", false, categories.get(0), userRepository.getById(1L), 1, lists.get(0));
        Product product1 = new Product("Scierka", true, categories.get(1), userRepository.getById(2L), 2, lists.get(0));
        Product product2 = new Product("Wozek", true, categories.get(0), userRepository.getById(1L), 3, lists.get(0));
        products.add(product);
        products.add(product1);
        products.add(product2);
        productRepository.saveAll(products);
    }

    private void createCategories() {
        ProductCategory category = new ProductCategory("Spożywcze", "assets/images/spozywcze.png");
        ProductCategory category1 = new ProductCategory("Przemysłowe", "assets/images/spozywcze.png");
        ProductCategory category2= new ProductCategory("Dzieci", "assets/images/spozywcze.png");
        ProductCategory category3 = new ProductCategory("Inne", "assets/images/spozywcze.png");
        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        productCategoryRepository.saveAll(categories);
    }

}
