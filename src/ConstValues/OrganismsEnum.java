package ConstValues;

import java.awt.*;

public enum OrganismsEnum {
    WILK(0),
    OWCA(1),
    LIS(2),
    ZOLW(3),
    ANTYLOPA(4),
    TRAWA(5),
    MLECZ(6),
    GUARANA(7),
    WILCZE_JAGODY(8),
    BARSZCZ_SOSNOWSKIEGO(9),
    SUMA_ORGANIZMOW(10);

    public final int id;

    private OrganismsEnum(int id) {
        this.id = id;
    }

    public int getId() { return id; }
}
