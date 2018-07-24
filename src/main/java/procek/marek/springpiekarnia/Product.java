package procek.marek.springpiekarnia;

public class Product {
    private String name;
    private double price;
    private int count;
    private String imageUrl;


    public Product(String name, double price, int count, String imageUrl) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.imageUrl = imageUrl;
    }

    public Product(){

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
