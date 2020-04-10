package domain;

import domain.exceptions.WrongInputNumberException;
import java.util.Collections;
import java.util.List;

public class Menus {
    private List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public Menu find(String input) {
        return menus.stream()
            .filter(menu -> menu.isSameNumber(input))
            .findFirst()
            .orElseThrow(() -> new WrongInputNumberException("메뉴에 없는 번호입니다."));
    }
}
