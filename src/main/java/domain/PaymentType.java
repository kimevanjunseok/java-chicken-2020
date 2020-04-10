package domain;

import domain.exceptions.WrongInputNumberException;
import java.util.Arrays;

public enum PaymentType {
    ONE("1") {
        @Override
        public double pay(Table table) {
            int money = 0;
            for (Menu menu : table.getTableMenus().keySet()) {
                money += table.getTableMenus().get(menu) * menu.getPrice();
            }
            return money;
        }
    },
    TWO("2") {
        @Override
        public double pay(Table table) {
            int money = 0;
            for (Menu menu : table.getTableMenus().keySet()) {
                money += table.getTableMenus().get(menu) * menu.getPrice();
            }
            return money * 0.95;
        }
    };

    private String number;

    PaymentType(String number) {
        this.number = number;
    }

    public abstract double pay(Table table);

    public static PaymentType find(String input) {
        return Arrays.stream(PaymentType.values())
            .filter(number -> number.number.equals(input))
            .findFirst()
            .orElseThrow(() -> new WrongInputNumberException("잘못된 결제 방식입니다."));
    }
}
