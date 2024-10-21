package day08;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{    
    public static void main(String[] args) 
    {
        List<Product> products = new ArrayList<>();
        LocalDate idCreated = LocalDate.of(2024, 10, 21);

        Date createDt = Date.from(idCreated.atStartOfDay(ZoneId.systemDefault()).toInstant()); // use system zone?

        products.add(new Product(1L, "Mouse", "Mouse input", "Computer", 99.00f, createDt));
        products.add(new Product(2L, "Keyboard", "Alphanumeric input", "Computer", 235.50f, createDt));
        products.add(new Product(3L, "15.6 Inch Monitor", "Display Panel", "Computer", 157.50f, createDt));
        products.add(new Product(4L, "Huawei Pura 70 Ultra", "Huawei Phone", "Mobile", 900.00f, createDt));
        products.add(new Product(5L, "Huawei Mate 50 Pr", "Huawei Phone", "Mobile", 1200.00f, createDt));
        products.add(new Product(6L, "iPhone 16 Pro", "iPhone", "Mobile", 2000.00f, createDt));
        products.add(new Product(7L, "iPhone 14 Pro", "iPhone", "Mobile", 1800.00f, createDt));

        // for(Product product: products)
        // {
        //     System.out.println(product);
        // }

        List<Product> filteredProducts = new ArrayList<>();

        filteredProducts = products.stream().filter(p -> p.getProdCategory().equals("Mobile") && (p.getPrice() >1500.00f)).collect(Collectors.toList()); // lambda string function?
        filteredProducts.forEach(System.out::println);


        // for (Product product : products)
        // {
        //     if (product.getPrice() > )
        // }
    }
}
