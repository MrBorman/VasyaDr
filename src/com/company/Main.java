package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 2;
        HashMap<String, Dish> dishes = new HashMap<String, Dish>();
        for (int i = 0; i < n; i++) {
            String d = "sandwich" + i;
            int c = 7;
            int z = 3;
            Dish dish = new Dish(d,c,z);
            for (int j = 0; j < z; j++) {
                String s = "butter" + j;
                int a = 10;
                Units u = Units.g;
                Ingredient ingredient = new Ingredient(s, a, u);
                dish.ingredients.add(ingredient);
            }
            dishes.put(dish.getName(),dish);
        }

        int k = 7;
        HashMap<String,PriceCatalog> priceMap = new HashMap<String,PriceCatalog>();
        for (int i = 0; i < k; i++) {
            String t = "butter" + i;
            int p = 9 + i;
            int a = 480;
            Units u = Units.g;
            PriceCatalog priceCatalog = new PriceCatalog(t,p,a,u);
            priceMap.put(t,priceCatalog);
        }

        int m = 8;
        HashMap<String,FoodCatalog> foodMap = new HashMap<String,FoodCatalog>();
        for (int i = 0; i < m; i++) {
            String t = "butter" + i;
            int a = 100;
            Units u = Units.g;
            double pr = 0.8;
            double f = 72.5;
            double ch = 1.3;
            double fv = 661;
            FoodCatalog foodCatalog = new FoodCatalog(t,a,u,pr,f,ch,fv);
            foodMap.put(t, foodCatalog);
        }

        HashMap<String, Integer> sumIngredient = new HashMap<String, Integer>();
        for (Dish d:
             dishes.values()) {
            for (Ingredient i:
                 d.ingredients) {
                if (!sumIngredient.containsKey(i.getName())) {
                    sumIngredient.put(i.getName(), i.getCount());
                } else {
                    sumIngredient.put(i.getName(),sumIngredient.get(i.getName()) + i.getCount());
                }
            }
        }

        for (String i:
             sumIngredient.keySet()) {
            System.out.println("Key is " + i);
            System.out.println("Value is " + sumIngredient.get(i));
        }

    }

    public static int parseInt (String text) {
        int t = Integer.parseInt(text);
        return t;
    }
}

class Dish {
    private String name;
    private int countIngredients;
    HashSet<Ingredient> ingredients = new HashSet<Ingredient>();
    private int countFriends;
    Dish(String name, int countFriends, int countIngredients) {
        this.name = name;
        this.countFriends = countFriends;
        this.countIngredients = countIngredients;
    }
    public String getName() {
        return name;
    }

}

class Ingredient {
    private String name;
    private int count;
    Units unit;

    Ingredient(String name, int count, Units unit) {
        this.name = name;
        this.count = count;
        this.unit = unit;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}

class PriceCatalog {
    private String name;
    private int price;
    private int count;
    Units unit;
    PriceCatalog(String name, int price, int count, Units unit) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.unit = unit;
    }
}

class FoodCatalog {
    private String name;
    private int count;
    Units unit;
    private double protein;
    private double fat;
    private double carbohydrates;
    private double calorie;

    FoodCatalog(String name,int count, Units unit, double protein, double fat, double carbohydrates, double calorie) {
        this.calorie = calorie;
        this.carbohydrates = carbohydrates;
        this.count = count;
        this.fat = fat;
        this.name = name;
        this.protein = protein;
        this.unit = unit;
    }

}

enum Units {
    g,
    kg,
    l,
    ml,
    cnt,
    tens
}


