package br.com.mio.di.bao.business;

import br.com.mio.di.bao.dao.DishesDao;
import br.com.mio.di.bao.enums.DishType;
import br.com.mio.di.bao.enums.Period;
import br.com.mio.di.bao.model.Dish;

import java.util.*;
import java.util.stream.Stream;

public class CreateDishes {

    private Map<Dish, Integer> dishMap = new HashMap<>();
    Set<Dish> dishes = new HashSet<>();

    public String createDishes(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        String strPeriod = tokenizer.nextToken().trim();
        Period period = getPeriod(strPeriod);
        while(tokenizer.hasMoreTokens()){
            DishType dishType = getDishType(tokenizer.nextToken().trim());
            Dish dish = findDish(period, dishType);
            createCount(dish);
            dishes.add(dish);
        }
        return createResult(new LinkedList<>(dishes));
    }

    private void createCount(Dish dish) {
        if(dishMap.containsKey(dish)) {
            dishMap.put(dish, dishMap.get(dish) + 1 );
        } else {
            dishMap.put(dish, 1);
        }
    }

    private Period getPeriod(String period) {
        Stream<Period> periods = Stream.of(Period.values());
        Optional<Period> toReturn = periods.filter(a -> a.getDescription().equalsIgnoreCase(period)).findFirst();
        return toReturn.orElseThrow( () ->  new IllegalArgumentException("Error"));
    }

    private DishType getDishType(String dishType) {
        Integer dishTypeValue = Integer.valueOf(dishType);
        Stream<DishType> dishTypes = Stream.of(DishType.values());
        Optional<DishType> toReturn = dishTypes.filter(a -> a.getId() == dishTypeValue).findFirst();
        return toReturn.orElseThrow( () ->  new IllegalArgumentException("Error"));
    }

    private Dish findDish(Period period, DishType dishType) {
        Optional<Dish> toReturn = DishesDao.getDishes()
                .stream().filter((a) -> a.getPeriod() == period && a.getDishType() == dishType).findFirst();
        return toReturn.orElseThrow( () ->  new IllegalArgumentException("Error"));
    }

    private String createResult(List<Dish> dishes) {
        String toReturn = "";
        Collections.sort(dishes, (a,b) -> a.getDishType().getId().compareTo(b.getDishType().getId()));
        for(Dish dish : dishes) {
            String value = dish.getValue();
            if(isEggs(dish) || isPotatoes(dish)) {
                value = format(dish, dishMap.get(dish));
            }
            toReturn += value +",";
        }
        return toReturn.substring(0, toReturn.length() - 1);
    }



    private String format(Dish dish, Integer count) {
        return dish.getValue()+"("+count+")";
    }

    private boolean isEggs(Dish dish) {
        return dish.getPeriod() == Period.MORNING && dish.getValue().equalsIgnoreCase("coffee") && dishMap.get(dish) > 1;
    }

    private boolean isPotatoes(Dish dish) {
        return dish.getPeriod() == Period.NIGHT &&  dish.getValue().equalsIgnoreCase("potato") && dishMap.get(dish) > 1;
    }


}
