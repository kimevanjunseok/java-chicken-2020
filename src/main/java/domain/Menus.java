package domain;

import domain.exceptions.WrongInputNumberException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu find(String input) {
        return menus.stream()
            .filter(menu -> menu.isSameNumber(input))
            .findFirst()
            .orElseThrow(() -> new WrongInputNumberException("메뉴에 없는 번호입니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menus menus1 = (Menus) o;
        return Objects.equals(menus, menus1.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menus);
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }
}
