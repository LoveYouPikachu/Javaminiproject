package dishdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * jyin
 * dishclass
 * Provide parameter construction method
 * Generate construction method
 */
public class DishApp {
    //prepare some dishes and show them to customers
    //Define collection (Show existing dishes )
    static List<Dish> dishList=new ArrayList<>();
    static List<Dish> Persondish=new ArrayList<>();
    //customer ordered dishes
    public static void main(String[] args)
    {
        initDish();
        //initialization
        Scanner s=new Scanner(System.in);
        while (true)
        {
            showMenu();
            int num=s.nextInt();
            //Judge the input number
            switch (num)
            {
                case 1:
                    while (true)
                    {
                        showDishMenu();
                        //Get input
                        int id=s.nextInt();
                        if(id==0)
                        {
                            break;
                        }
                        Dish dish=dishList.get(id-1);
                        System.out.println("You ordered "+dish.name);
                        Persondish.add(dish);
                    }
                case 2:
                    showPersonDish();
                    break;
                case 3:
                    buy();
                    return;
            }
        }
    }

    private static void showDishMenu()
    {
        System.out.println("----Please order----");
        for (int i = 0; i < dishList.size(); i++)
        {
            Dish dish=dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("----Enter the serial number to order, press 0 to return----");
    }
    private static void showPersonDish()
    {
        System.out.println("----You ordered dishes----");
        for (Dish dish:Persondish)
        {
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
    }
    private static void buy()
    {
        System.out.println("Please wait,checking");
        double total=0f;
        for (Dish dish:Persondish)
        {
            total+=dish.price;
        }
        System.out.println("Total price: "+total);
    }//Pay the bill
   public static void showMenu()
    {
        System.out.println("----Main menu ----");
        System.out.println("----Menu\t\t\t1");
        System.out.println("----OrderedDishes\t2");
        System.out.println("----Pay the bill\t3");
        System.out.println("----Select service based on number ");
    }
    //Initialize dishes
    public static void initDish()
    {
        Dish dish=new Dish(1,"pizza",29.0);
        dishList.add(dish);
        Dish dish2=new Dish(2,"chips",59.0);
        dishList.add(dish2);
        //Store dishes
        dishList.add(new Dish(3,"sandwich",21.0));
        dishList.add(new Dish(4,"hamburger",24.0));
        dishList.add(new Dish(5,"coke",55.0));
    }
}
