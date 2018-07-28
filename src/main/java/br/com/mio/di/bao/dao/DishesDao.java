package br.com.mio.di.bao.dao;

import br.com.mio.di.bao.enums.DishType;
import br.com.mio.di.bao.enums.Period;
import br.com.mio.di.bao.model.Dish;

import java.util.LinkedList;
import java.util.List;

public class DishesDao {

    private static List<Dish> dishes = new LinkedList<Dish>();

    static {
        dishes.add(new Dish(Period.MORNING, DishType.ENTREE, "eggs"));
        dishes.add(new Dish(Period.NIGHT, DishType.ENTREE, "steak"));
        dishes.add(new Dish(Period.MORNING, DishType.SIDE, "toast"));
        dishes.add(new Dish(Period.NIGHT, DishType.SIDE, "potato"));
        dishes.add(new Dish(Period.MORNING, DishType.DRINK, "coffee"));
        dishes.add(new Dish(Period.NIGHT, DishType.DRINK, "wine"));
        dishes.add(new Dish(Period.MORNING, DishType.DESSERT, "error"));
        dishes.add(new Dish(Period.NIGHT, DishType.DESSERT, "cake"));
    }

    public static List<Dish> getDishes() {
        return dishes;
    }

}
