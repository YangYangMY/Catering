package rsf2s1g2.utility;

import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class dummyScript {
    public static void FandBList(){
        ListInterface<FoodBeverage> foodlist = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> beveragelist = new List<FoodBeverage>(10);
        foodlist.add(new FoodBeverage("Fried Chicken", 6.0));
        foodlist.add(new FoodBeverage("Nasi Lemak", 2.0));
        foodlist.add(new FoodBeverage("Rendang Chicken", 6.5));
        foodlist.add(new FoodBeverage("Noodle", 2.5));
        foodlist.add(new FoodBeverage("Salad", 4.0));
        beveragelist.add(new FoodBeverage("Coke", 2.0));
        beveragelist.add(new FoodBeverage("Lemonade", 1.5));
        beveragelist.add(new FoodBeverage("Water", 0.5));
        beveragelist.add(new FoodBeverage("Milo", 1.8));
        beveragelist.add(new FoodBeverage("Honey Lemon", 3.5));
    }


}