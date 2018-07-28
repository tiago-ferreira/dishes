package br.com.mio.di.bao;

import br.com.mio.di.bao.business.DishBusiness;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    DishBusiness dishBusiness;

    @BeforeEach
    public void init() {
        dishBusiness = new DishBusiness();
    }


    @Test
    public void firstCase() {
        String input = "morning, 1, 2, 3";
        String result = dishBusiness.createDishes(input);
        String expected = "eggs, toast, coffee";
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void secondCase() {
        String input = "morning, 2, 1, 3";
        String result = dishBusiness.createDishes(input);
        String expected = "eggs, toast, coffee";
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void thirdCase() {
        String input = "morning, 1, 2, 3, 4";
        String result = dishBusiness.createDishes(input);
        String expected = "eggs, toast, coffee, error";
        Assertions.assertEquals(result, expected);
    }


    @Test
    public void fourCase() {
        String input = "morning, 1, 2, 3, 3, 3";
        String result = dishBusiness.createDishes(input);
        String expected = "eggs, toast, coffee(x3)";
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void fiveCase() {
        String input = "night, 1, 2, 3, 4";
        String result = dishBusiness.createDishes(input);
        String expected = "steak, potato, wine, cake";
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void sixCase() {
        String input = "night, 1, 2, 2, 4";
        String result = dishBusiness.createDishes(input);
        String expected = "steak, potato(x2), cake";
        Assertions.assertEquals(result, expected);
    }
}
