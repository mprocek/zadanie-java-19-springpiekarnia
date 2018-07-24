package procek.marek.springpiekarnia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Bakery {

    private ProductMagazine productMagazine;
    private ShoppingCart shoppingCart;

    public Bakery(ProductMagazine productMagazine, ShoppingCart shoppingCart) {
        this.productMagazine = productMagazine;
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/")
    public String bakery(Model model){
        model.addAttribute("productMagazine",productMagazine.getProductList());
        model.addAttribute("addProduct", new Product());
        return "offer";
    }

    @PostMapping("/addbasket")
    public String basket(Product addProduct){
        shoppingCart.addProduct(addProduct);
        return "redirect:/add.html";
    }

    @GetMapping("/add.html")
    public String addPage(){
        return "add";
    }

    @ResponseBody
    @GetMapping("/basket")
    public String showBasket(){
        return shoppingCart.toString();
    }



}
