package day08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{    
    public static void main(String[] args) throws IOException 
    {
        List<Product> products = new ArrayList<>();

        if (args.length > 0)
        {
            String[] arguments = args[0].split("/");
            File newDir = new File(arguments[0]);

        }

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


       // write the list of filtered objs to a file
       FileWriter fw = new FileWriter(args[0], false);
       BufferedWriter bw = new BufferedWriter(fw);
       
       Iterator<Product> iterator = filteredProducts.iterator(); // what's iterator, what does it return?

       while(iterator.hasNext())
       {
        bw.append(iterator.next().toString());
        bw.newLine();
       }

       bw.flush();
       bw.close();
       fw.close();
       

       // use Comparator to perform sorting (Java has a built-in function called Comparator, in this case we are comparing products)
       // single column comparison    
       Comparator<Product> comparator = Comparator.comparing(p -> p.getProdName()); // comparing expects a function, p -> p.getName, lambda, lambda is a function, which meant p = p.getName 
       // trf to the ref method become product::getName
       // can be written as  Comparator<Product> comparator = Comparator.comparing(Product::getProdName);

       products.sort(comparator);
       products.forEach(System.out::println);

       products.sort(comparator.reversed());
       products.forEach(System.out::println);

       // Sort an array of string "Bernard" "Zachary" "Alpha" "Theophilis" "Sammy" "Christopher" 
       String arr[] = {"Bernard", "Zachary", "Alpha", "Theophilis", "Sammy", "Christopher" };
       
       // Sort asc and print
       Arrays.sort(arr);
       System.out.println("Sorted in ascending order: " + Arrays.toString(arr)); // or arr.toString()
       
       // Sort dsc and print
       Arrays.sort(arr, Collections.reverseOrder()); // what is comparator?
       System.out.println("Sorted in descending order: " + Arrays.toString(arr)); // or arr.toString()

    }
}
