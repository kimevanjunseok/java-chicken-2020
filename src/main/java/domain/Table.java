package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return number == table.number &&
            Objects.equals(menus, table.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, menus);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
