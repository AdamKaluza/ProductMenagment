package labs.pm.app;

import labs.pm.data.*;

import java.math.BigDecimal;
import java.util.*;

public class Shop {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager("en-GB");

        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
      //  pm.printProductReport(101);
        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice Hot cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Goood tea");
        pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect");
        pm.reviewProduct(101, Rating.THREE_STAR, "Add some lemon");
     //   pm.printProductReport(101);

        pm.createProduct(102, "Coffee", BigDecimal.valueOf(6.99), Rating.NOT_RATED);
        pm.reviewProduct(102, Rating.THREE_STAR, "coffee was ok");
        pm.reviewProduct(102, Rating.ONE_STAR, "coffee was terrible");
        pm.reviewProduct(102, Rating.FIVE_STAR, "Perfect with spoons of sugar");
      //  pm.printProductReport(102);

        Comparator<Product> ratingSorter = (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());
       // pm.printProducts(ratingSorter);
       // pm.printProducts((p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
       // pm.printProducts((p1,p2) -> p2.getPrice().compareTo(p1.getPrice()));
       // pm.printProducts(priceSorter);
        pm.printProducts(ratingSorter.thenComparing(priceSorter));
        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());


    }
}
