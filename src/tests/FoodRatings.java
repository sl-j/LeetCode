package tests;

import java.util.*;

class FoodRatings {

    public class foodRan{
        String food;
        int ran;
        foodRan(String food,int ran){
            this.food = food;
            this.ran = ran;
        }

    }

    String[] foods;
    String[] cuisines;
    int[] ratings;
    Map<String, TreeSet<foodRan>> cuisineToFood;
    Map<String,String> foodToCuisines;
    Map<String,foodRan> map;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        cuisineToFood = new HashMap<>();
        foodToCuisines = new HashMap<>();
        map = new HashMap<>();
        for(int i = 0;i < foods.length;i++){
            if(!cuisineToFood.containsKey(cuisines[i])){
                cuisineToFood.put(cuisines[i], new TreeSet<>((o1,o2) -> o1.ran != o2.ran ? o1.ran - o2.ran : o1.food.compareTo(o2.food)));
            }
            foodRan foodRan = new foodRan(foods[i], ratings[i]);
            TreeSet<FoodRatings.foodRan> set = cuisineToFood.get(cuisines[i]);
            set.add(foodRan);
            map.put(foods[i], foodRan);
            foodToCuisines.put(foods[i],cuisines[i]);
        }

    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisines.get(food);

        TreeSet<foodRan> foodRanSet = cuisineToFood.get(cuisine);
        foodRanSet.remove(map.get(food));
        foodRan foodRan1 = new foodRan(food, newRating);
        foodRanSet.add(foodRan1);
        map.remove(food);
        map.put(food,foodRan1);
        cuisineToFood.put(cuisine,foodRanSet);
    }

    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).first().food;
    }


}