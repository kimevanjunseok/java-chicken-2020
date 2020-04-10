package domain;

import domain.exceptions.IsNotCollectTableNumberException;
import java.util.Iterator;
import java.util.List;

public class Tables implements Iterable<Table> {
    private List<Table> tables;

    public Tables(List<Table> tables) {
        this.tables = tables;
    }

    public int getSize() {
        return tables.size();
    }

    public Table find(String input) {
        return tables.stream()
            .filter(table -> table.toString().equals(input))
            .findFirst()
            .orElseThrow(() -> new IsNotCollectTableNumberException("테이블이 존재하지 않습니다."));
    }

    private Table find(Table orderTable) {
        return tables.stream()
            .filter(table -> table.equals(orderTable))
            .findFirst()
            .orElseThrow(() -> new IsNotCollectTableNumberException("테이블이 존재하지 않습니다."));
    }

    public void order(Table table, Menu menu, int count) {
        find(table).orderMenu(menu, count);
    }

    @Override
    public Iterator<Table> iterator() {
        return tables.iterator();
    }
}
