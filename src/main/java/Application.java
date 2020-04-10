import domain.Menu;
import domain.MenuRepository;
import domain.Menus;
import domain.SelectNumberType;
import domain.Table;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        SelectNumberType selectNumberType = null;
        Tables tables = new Tables(TableRepository.tables());
        Menus menus = new Menus(MenuRepository.menus());

        while (selectNumberType == null || !selectNumberType.isTypeThree()) {
            OutputView.printMain();
            selectNumberType = SelectNumberType.find(InputView.inputSelectFunction());
            execute(selectNumberType, tables, menus);

        }
    }

    private static void execute(SelectNumberType selectNumberType, Tables tables, Menus menus) {
        if (selectNumberType.isTypeOne()) {
            executeSelectNumberOne(tables, menus);
            return ;
        }
        executeSelectNumberTwo(tables, menus);
    }

    private static void executeSelectNumberOne(Tables tables, Menus menus) {
        OutputView.printTables(tables);
        Table table = tables.find(InputView.inputTableNumber());
        OutputView.printMenus(menus);
        Menu menu = menus.find(InputView.inputMenuNumber());
        int count = Integer.parseInt(InputView.inputMenuQuantityNumber());
        tables.order(table, menu, count);
    }

    private static void executeSelectNumberTwo(Tables tables, Menus menus) {

    }
}
