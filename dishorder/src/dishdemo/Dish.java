package dishdemo;

/**
 * jieyin
 * dishclass
 * Provide parameter construction method
 * Generate construction method
 */
public class Dish {
     int id;
     String name;//dishname
     double price;

    public Dish(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
