package domain;

public enum PaymentType {
    ONE {
        @Override
        public double pay(Table table) {
            int money = 0;
            for (Menu menu : table.getTableMenus().keySet()) {
                money += table.getTableMenus().get(menu) * menu.getPrice();
            }
            return money;
        }
    },
    TWO {
        @Override
        public double pay(Table table) {
            int money = 0;
            for (Menu menu : table.getTableMenus().keySet()) {
                money += table.getTableMenus().get(menu) * menu.getPrice();
            }
            return money * 0.95;
        }
    };

    public abstract double pay(Table table);
}
