package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        }).isInstanceOf(IsNotCollectTableNumberException.class);
    }
}
