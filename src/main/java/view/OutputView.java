package view;

import domain.Menu;
import domain.Menus;
import domain.Table;

import domain.Tables;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ORDER_LINE = "└ ₩ ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final Tables tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        final int size = tables.getSize();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    private static void printTopLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(Tables tables) {
        for (Table table : tables.getTables()) {
            if (table.hasMenu()) {
                printOrderLine();
            } else {
                printNotOrderLine();
            }
        }
        System.out.println();
    }

    private static void printOrderLine() {
        System.out.print(BOTTOM_ORDER_LINE);
    }

    private static void printNotOrderLine() {
        System.out.print(BOTTOM_LINE);
    }

    private static void printTableNumbers(final Tables tables) {
        for (final Table table : tables.getTables()) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenus(final Menus menus) {
        for (final Menu menu : menus.getMenus()) {
            System.out.println(menu);
        }
    }
}
