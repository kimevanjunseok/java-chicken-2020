package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TablesTest {

    @Test
    @DisplayName("tables의 사이즈 가져오기")
    void getSize() {
        Tables tables = new Tables(TableRepository.tables());
        assertThat(tables.getSize()).isEqualTo(6);
    }
}
