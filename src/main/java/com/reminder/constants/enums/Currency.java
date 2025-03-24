package com.reminder.constants.enums;

public enum Currency {
    INR("Indian Rupee", "₹"),
    USD("US Dollar", "$");

    private final String currencyName;
    private final String symbol;

    Currency(String currencyName, String symbol) {
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getSymbol() {
        return symbol;
    }
}
