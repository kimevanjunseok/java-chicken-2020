package Controller;

import domain.Menu;
import domain.Menus;
import domain.SelectNumberType;
import domain.Table;
import domain.Tables;
import domain.exceptions.WrongInputNumberException;
import view.InputView;
import view.OutputView;

public class Controller {
    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }

    public void execute(Tables tables, Menus menus) {
        SelectNumberType selectNumberType = null;
        while (selectNumberType == null || !selectNumberType.isTypeThree()) {
            try {
                OutputView.printMain();
                selectNumberType = SelectNumberType.find(InputView.inputSelectFunction());
                operate(selectNumberType, tables, menus);
            } catch (WrongInputNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void operate(SelectNumberType selectNumberType, Tables tables, Menus menus) {
        if (selectNumberType.isTypeOne()) {
            executeSelectNumberOne(tables, menus);
        }
    }

    private void executeSelectNumberOne(Tables tables, Menus menus) {
        OutputView.printTables(tables);
        Table table = getFindTable(tables);
        OutputView.printMenus(menus);
        Menu menu = getFindMenu(menus);
        int count = getQuantityNumber();
        tables.order(table, menu, count);
    }

    private Table getFindTable(Tables tables) {
        Table table = null;
        while (table == null) {
            table = getCorrectTable(tables);
        }
        return table;
    }

    private Table getCorrectTable(Tables tables) {
        try {
            return tables.find(InputView.inputTableNumber());
        } catch (WrongInputNumberException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Menu getFindMenu(Menus menus) {
        Menu menu = null;
        while (menu == null) {
            menu = getCorrectMenu(menus);
        }
        return menu;
    }

    private Menu getCorrectMenu(Menus menus) {
        try {
            return menus.find(InputView.inputMenuNumber());
        } catch (WrongInputNumberException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int getQuantityNumber() {
        int count = 0;
        while (count == 0) {
            count = getCorrectQuantityNumber(InputView.inputMenuQuantityNumber());
        }
        return count;
    }

    private int getCorrectQuantityNumber(String input) {
        try {
            validate(input);
            return Integer.parseInt(input);
        } catch (WrongInputNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private void validate(String input) {
        validateIsNumber(input);
        validateIsRangeNumber(input);
    }

    private void validateIsNumber(String input) {
        if (!isNumber(input)) {
            throw new WrongInputNumberException("숫자로 입력해 주세요.");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (WrongInputNumberException e) {
            return false;
        }
    }

    private void validateIsRangeNumber(String input) {
        int count = Integer.parseInt(input);
        if (count < 1 ||  count > 99) {
            throw new WrongInputNumberException("수량은 1 ~ 99까지 가능 합니다.");
        }
    }

    private void executeSelectNumberTwo(Tables tables, Menus menus) {

    }
}
