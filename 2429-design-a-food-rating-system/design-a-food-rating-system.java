class Food {
    String name;
    int rating;
    Food(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}

class FoodRatings {

    Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();
    Map<String, String> foodCuisineMap = new HashMap<>();
    Map<String, Integer> foodRatingsMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int len = foods.length;
        for(int i=0;i<len;i++) {
            if(cuisineMap.get(cuisines[i])==null) {
                cuisineMap.put(cuisines[i], new TreeSet<>((f1, f2) -> {
                    if(f1.rating!=f2.rating) return f2.rating-f1.rating;
                    return f1.name.compareTo(f2.name);
                }));
            }
            cuisineMap.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
            foodCuisineMap.put(foods[i], cuisines[i]);
            foodRatingsMap.put(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        int rating = foodRatingsMap.get(food);
        if(cuisine!=null) {
            cuisineMap.get(cuisine).add(new Food(food, newRating));
            foodRatingsMap.put(food,newRating);
        }
    }
    
    public String highestRated(String cuisine) {
        Food temp = cuisineMap.get(cuisine).first();
        while(temp.rating!=foodRatingsMap.get(temp.name)) {
            cuisineMap.get(cuisine).pollFirst();
            temp =  cuisineMap.get(cuisine).first();
        }
        return cuisineMap.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */