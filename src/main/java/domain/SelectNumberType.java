package domain;

import domain.exceptions.WrongInputNumberException;
import java.util.Arrays;

public enum SelectNumberType {
    ONE("1"),
    TWO("2"),
    THREE("3");

    private String number;

    SelectNumberType(String number) {
        this.number = number;
    }

    public static SelectNumberType find(String input) {
        return Arrays.stream(SelectNumberType.values())
            .filter(type -> type.number.equals(input))
            .findFirst()
            .orElseThrow(() -> new WrongInputNumberException("기능은 1, 2, 3만 있습니다. 다시 입력해주세요"));
    }

    public boolean isTypeOne() {
        return number.equals("1");
    }

    public boolean isTypeTwo() {
        return number.equals("2");
    }

    public boolean isTypeThree() {
        return number.equals("3");
    }
}
