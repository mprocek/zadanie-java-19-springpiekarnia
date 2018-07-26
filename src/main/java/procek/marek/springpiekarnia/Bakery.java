package procek.marek.springpiekarnia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "offer";
    }

    @PostMapping("/addbasket")
    public String basket(@RequestParam String name, @RequestParam int quantity){
        shoppingCart.addProduct(name,quantity);
        return "add";
    }

    @ResponseBody
    @GetMapping("/basket")
    public String showBasket(){
        return shoppingCart.toString();
    }

    @ResponseBody
    @GetMapping("/sum")
    public String showSum(){
        return "Do zapłaty " + shoppingCart.sumProduct() + " zł"
                + "<br/><br/><a href=\"/\">Kontynuuj zakupy</a><br/>";
    }



}
