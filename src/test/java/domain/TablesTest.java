package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.exceptions.WrongInputNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TablesTest {
    Tables tables;

    @BeforeEach
    void init() {
        tables = new Tables(TableRepository.tables());
    }

    @Test
    @DisplayName("tables의 사이즈 가져오기")
    void getSize() {
        assertThat(tables.getSize()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("input값의 테이블이 없으면 오류")
    @ValueSource(strings = {"a", "0", "4"})
    void findTable_Exception(String input) {
        assertThatThrownBy(() -> {
            tables.find(input);
        }).isInstanceOf(WrongInputNumberException.class);
    }

    @Test
    @DisplayName("테이블을 찾는지 테스트")
    void find_table() {
        assertThat(tables.find("1").toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("order가 들어갔는지 체크")
    void order() {
        Table table = tables.find("1");
        Menus menus = new Menus(MenuRepository.menus());
        tables.order(table, menus.find("1"), 1);
        assertThat(table.hasMenu()).isTrue();
    }
}
