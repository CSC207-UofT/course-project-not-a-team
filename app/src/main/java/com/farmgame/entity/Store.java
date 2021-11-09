package com.farmgame.entity;

import java.util.ArrayList;
import java.util.List;
import com.farmgame.entity.Player;

public class Store {
    List<Plants> totalProducts;             //we need to define later
    int StoreLevel;
    List<Plants> currentProducts;
    /**
     * User can use store to buy plants, sell plants. The price varies each day. Sold plants are
     * automatically stored into warehouse.
     * totalProducts is a List of plants sells in store in TOTAL
     * currentProducts ArrayList of plants that sells in store(current level)
     * @param StoreLevel an integer that shows the level of the store
     */
    public Store(Player player){
        //constructor, take StoreLevel as parameter, initiate ArrayList currentProducts given the StoreLevel
        this.StoreLevel = player.getLevel();
        currentProducts = new ArrayList<>();
        currentProducts = totalProducts.subList(0, StoreLevel);

    }
    public List<Plants> getCurrentProducts(){
        //return current products

        return currentProducts;
    }
    public int getStoreLevel(){
        //return store level
        return StoreLevel;
    }
    public void setStoreLevel(int level){
        //set store level
        this.StoreLevel = level;
        currentProducts = totalProducts.subList(0, level);
    }
    /*
    public List<Plants> buyingProducts(){
        Date date = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("ddMMyyyy");
        Random rand = new Random(Integer.parseInt(currentDate.format(date)));

        for (Plants item: currentProducts){
            System.out.println(item.getName, item.getPrice * rand);
        }
        List<Plants> result = new List<Plants>();


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the plant you want to buy and seperate by space: ");
        String[] input = reader.nextLine().split(" ");
        reader.close();
        for (String element : input) {
            for (Plants plant : currentProducts) {
                if (plant.getName == element) {
                    result.add(plant);
                    user.purchaseAmount(plant.getPrice*rand);
                }
            }
        }

        System.out.println("The products you bought are:");
        for (Plants plant : result){
            System.out.println(plant.getName);
        }
        return result;

    }

    public int sellingProducts(List<Plants> plants4sell){
        int price = 0;
        for(Plants item: plants4sell){
            price += item.getPrice;
        }
        return price;
    }

     */
}
