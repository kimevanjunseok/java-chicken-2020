package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.exceptions.WrongInputNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SelectNumberTypeTest {

    @ParameterizedTest
    @DisplayName("입력이 1, 2, 3이 아니면 오류")
    @ValueSource(strings = {"0", "4"})
    void find_exception(String input) {
        assertThatThrownBy(() -> {
            SelectNumberType.find(input);
        }).isInstanceOf(WrongInputNumberException.class);
    }

    @Test
    @DisplayName("find test")
    void find() {
        assertThat(SelectNumberType.find("1").isTypeOne()).isTrue();
        assertThat(SelectNumberType.find("2").isTypeTwo()).isTrue();
        assertThat(SelectNumberType.find("3").isTypeThree()).isTrue();
    }
}
