package com.matriksmobile.case1;

public enum YearEnum {

    FIRSTYEAR(0),
    SECONDYEAR(1),
    THIRDYEAR(2),
    FOURTHYEAR(3);

    private int value;

    YearEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
