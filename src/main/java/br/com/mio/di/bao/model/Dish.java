package br.com.mio.di.bao.model;

import br.com.mio.di.bao.enums.DishType;
import br.com.mio.di.bao.enums.Period;

import java.util.Objects;

public class Dish {

    private Period period;
    private DishType dishType;
    private String value;

    public Dish() {
        this.period = Period.MORNING;
        this.dishType = DishType.DESSERT;
        this.value = "error";
    }

    public Dish(Period period, DishType dishType, String value) {
        this.period = period;
        this.dishType = dishType;
        this.value = value;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return period == dish.period &&
                dishType == dish.dishType &&
                Objects.equals(value, dish.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, dishType, value);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "period=" + period +
                ", dishType=" + dishType +
                ", value='" + value + '\'' +
                '}';
    }
}
