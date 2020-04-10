package domain;

import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
    }

    public void orderMenu(Menu menu) {

    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
