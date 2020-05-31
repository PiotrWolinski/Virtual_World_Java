package ConstValues;

import java.awt.*;

public enum OrganismsEnum {
    WILK(0),
    OWCA(1),
    LIS(2),
    ZOLW(3),
    ANTYLOPA(4),
    CyberOwca(5),
    TRAWA(6),
    MLECZ(7),
    GUARANA(8),
    WILCZE_JAGODY(9),
    BARSZCZ_SOSNOWSKIEGO(10),
    SUMA_ORGANIZMOW(11);

    public final int id;

    private OrganismsEnum(int id) {
        this.id = id;
    }

    public int getId() { return id; }
}
