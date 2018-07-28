package br.com.mio.di.bao;

import br.com.mio.di.bao.business.CreateDishes;

public class Main {

    public static void main(String[] args) {
        String input = "night, 1, 2, 2, 4";
        CreateDishes createDishes = new CreateDishes();
        String resp = createDishes.createDishes(input);
        System.out.println(resp);
    }
}
