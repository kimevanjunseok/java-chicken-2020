package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> menus = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void orderMenu(Menu menu, int count) {
        if (!menus.containsKey(menu)) {
            menus.put(menu, count);
            return ;
        }
        menus.put(menu, menus.get(menu) + count);
    }

    public boolean hasMenu() {
        return !menus.isEmpty();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
