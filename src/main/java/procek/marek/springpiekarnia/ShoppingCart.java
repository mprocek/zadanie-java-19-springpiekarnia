package procek.marek.springpiekarnia;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingCart {
    private List<Product> basket = new ArrayList<>();

    public void addProduct(Product product){
        basket.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "basket=" + basket +
                '}' + "<br/><br/><a href=\"/\">Kontynuuj zakupy</a><br/>";
    }
}
