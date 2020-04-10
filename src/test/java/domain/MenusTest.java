package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.exceptions.WrongInputNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenusTest {
    Menus menus;

    @BeforeEach
    void init() {
        menus = new Menus(MenuRepository.menus());
    }

    @Test
    @DisplayName("메뉴가 8개 맞나 테스트")
    void getMenus() {
        assertThat(menus.getMenus().size()).isEqualTo(8);
    }

    @ParameterizedTest
    @DisplayName("없는 메뉴 오류처리")
    @ValueSource(strings = {"0", "-1", "a"})
    void find_Exception(String input) {
        assertThatThrownBy(() -> {
            menus.find(input);
        }).isInstanceOf(WrongInputNumberException.class);
    }

    @Test
    @DisplayName("menu 찾기 테스트")
    void find() {
        assertThat(menus.find("1").toString()).isEqualTo("[치킨] 1 - 후라이드 : 16000원");
    }
}
