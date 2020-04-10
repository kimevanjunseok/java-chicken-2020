package domain;

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

}
