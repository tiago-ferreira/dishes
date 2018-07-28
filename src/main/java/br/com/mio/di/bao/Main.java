package br.com.mio.di.bao;

import br.com.mio.di.bao.business.DishBusiness;

public class Main {

    public static void main(String[] args) {
        String input = "";
        for(String a : args) {
            input += a;
        }
        DishBusiness createDishes = new DishBusiness();
        String resp = createDishes.createDishes(input);
        System.out.println(resp);
    }
}
