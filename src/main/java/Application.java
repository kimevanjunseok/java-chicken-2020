import Controller.Controller;
import domain.MenuRepository;
import domain.Menus;
import domain.TableRepository;
import domain.Tables;

public class Application {

    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());
        Menus menus = new Menus(MenuRepository.menus());
        Controller controller = Controller.getInstance();
        controller.execute(tables, menus);
    }
}
