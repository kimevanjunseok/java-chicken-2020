package domain;

import java.util.Iterator;
import java.util.List;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        menus = menus;
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }
}
