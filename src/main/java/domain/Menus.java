package domain;

import domain.exceptions.WrongSelectNumberException;
import java.util.Iterator;
import java.util.List;

public class Menus implements Iterable<Menu> {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }

    public Menu find(String input) {
        return menus.stream()
            .filter(menu -> menu.isSameNumber(input))
            .findFirst()
            .orElseThrow(() -> new WrongSelectNumberException("메뉴에 없는 번호입니다."));
    }
}
