package ConstValues;

import java.awt.*;

public enum Colors {
    WILK(Color.black),
    OWCA(Color.white),
    LIS(Color.orange),
    ZOLW(Color.green.brighter()),
    ANTYLOPA(Color.orange.brighter()),
    TRAWA(Color.green),
    MLECZ(Color.lightGray),
    GUARANA(Color.orange.darker()),
    WILCZE_JAGODY(Color.pink),
    BARSZ_SOSNOWSKIEGO(Color.MAGENTA.darker());

    public final Color element;

    private Colors(Color element) {
        this.element = element;
    }

    public Color getColor() { return element; }
}