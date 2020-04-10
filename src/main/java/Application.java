import domain.MenuRepository;
import domain.Menus;
import domain.Table;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printMain();
        InputView.inputSelectFunction();
        Tables tables = new Tables(TableRepository.tables());

        OutputView.printTables(tables);

        Table table = tables.find(InputView.inputTableNumber());

        Menus menus = new Menus(MenuRepository.menus());
        OutputView.printMenus(menus);

    }
}
