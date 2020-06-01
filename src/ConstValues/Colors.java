package ConstValues;

import java.awt.*;

public enum Colors {
    WILK(new Color(92, 92, 92)),
    OWCA(new Color(227, 227, 227)),
    LIS(new Color(255, 183, 38)),
    ZOLW(new Color(91, 201, 0)),
    ANTYLOPA(new Color(245, 190, 24)),
    CYBEROWCA(new Color(61, 56, 40)),
    TRAWA(new Color(171, 255, 87)),
    MLECZ(new Color(255, 255, 140)),
    GUARANA(new Color(255, 94, 77)),
    WILCZE_JAGODY(new Color(255, 140, 242)),
    BARSZ_SOSNOWSKIEGO(new Color(168, 28, 255)),
    CZLOWIEK(new Color(255, 0, 0));

    public final Color element;

    private Colors(Color element) {
        this.element = element;
    }

    public Color getColor() { return element; }
}
