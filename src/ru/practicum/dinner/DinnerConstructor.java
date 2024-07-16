package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    Random random = new Random();

    void addNewDish(String type, String name) {
        if (menu.containsKey(type)) {
            if (menu.get(type).contains(name)) {
                System.out.println("Данное блюдо уже есть в данном спсике");
            } else {
                menu.get(type).add(name);
            }
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(name);
            menu.put(type, dishes);
            System.out.println("Блюдо " + name + " добавлено в список " + type);
        }
    }

    void generateDishCombo(int numberOfCombo, ArrayList<String> types) {
        for (int i = 0; i < numberOfCombo; i++) {
            ArrayList<String> newCombo = new ArrayList<>();
            for (String type : types) {
                int dishNumber = random.nextInt(menu.get(type).size());
                String dish = menu.get(type).get(dishNumber);
                newCombo.add(dish);
            }
            System.out.println("Комбо " + (i+1) + " : " + newCombo );
        }
    }
}
