package pl.pawel.shoppinglistapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import pl.pawel.shoppinglistapp2.model.ShoppingList;

@SpringBootApplication
public class ShoppingListApp2Application implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApp2Application.class, args);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(ShoppingList.class);
    }
}
