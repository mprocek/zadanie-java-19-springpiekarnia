package procek.marek.springpiekarnia;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ShoppingCart {

    private Map<String,Integer> basketMap;
    private ProductMagazine product;

    public ShoppingCart(){
        this.basketMap = new HashMap<>();
        this.product = new ProductMagazine();
    }

    public void addProduct(String name, Integer quantity) {

       if (basketMap.isEmpty()){
           basketMap.put(name, quantity);
        } else {
           if (isItem(name,quantity)) {
               basketMap.put(name, quantity + basketMap.get(name));
           } else {
               basketMap.put(name, quantity);
           }
       }
    }

    public boolean isItem(String name, Integer quantity) {
        for (Map.Entry<String, Integer> entry : basketMap.entrySet()) {
            if (entry.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return basketMap + "<br/><br/><a href=\"/\">Kontynuuj zakupy</a><br/>";
    }

    public double sumProduct(){
        double sum=0;

        for(Map.Entry<String,Integer> entry : basketMap.entrySet()){
            sum+=entry.getValue()*product.getPriceProductName(entry.getKey());
        }
        return sum;
    }
}
