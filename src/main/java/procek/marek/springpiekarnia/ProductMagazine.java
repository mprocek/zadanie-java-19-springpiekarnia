package procek.marek.springpiekarnia;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductMagazine {

    private List<Product> productList = new ArrayList<>();

    public ProductMagazine() {
        this.productList.add(new Product("bułka", 2.8, "https://piekarniagrzybki.pl/wp-content/uploads/2017/12/kajzerka-300x300.jpg"));
        this.productList.add(new Product("bagietka", 4.5, "https://piekarniagrzybki.pl/wp-content/uploads/2017/11/bagietka_pszenna-300x300.jpg"));
        this.productList.add(new Product("chleb", 6.0, "https://piekarniagrzybki.pl/wp-content/uploads/2017/11/sandomierski-300x300.jpg"));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getPriceProductName(String name){
        for(Product product:productList){
            if(product.getName().equals(name)){
                return product.getPrice();
            }
        }
        return 0;
    }
}
