package com.jb.couponsys.clr;



public enum Color {
    RESET("\033[0m"),
    BLUE_BOLD("\033[1;34m"),
    GREEN_BOLD("\033[1;32m"),
    WHITE_BOLD("\033[1;37m");


    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
