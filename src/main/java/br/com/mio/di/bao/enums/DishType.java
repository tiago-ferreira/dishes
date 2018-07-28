package br.com.mio.di.bao.enums;

public enum DishType {
    ENTREE(1),SIDE(2),DRINK(3),DESSERT(4);

    private Integer id;

    DishType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
