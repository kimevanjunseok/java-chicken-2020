package domain;

import domain.exceptions.IsNotCollectTableNumberException;
import java.util.Collections;
import java.util.List;

public class Tables {
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public int getSize() {
        return tables.size();
    }

    public List<Table> getTables() {
        return Collections.unmodifiableList(tables);
    }

    public Table find(String input) {
        return tables.stream()
            .filter(table -> table.toString().equals(input))
            .findFirst()
            .orElseThrow(() -> new IsNotCollectTableNumberException("테이블이 존재하지 않습니다."));
    }
}
