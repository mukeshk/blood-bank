package io.indorse.bloodbank.model.domain;

public enum InventoryType {

    WHOLE(35,100),
    PLASMA(360,54),
    RED_BLOOD_CELL(35,10),
    PLATELETE(5,1);

    int shelfLifeInDays;
    int percentageOfWholeBlood;

    InventoryType(int shelfLifeInDays, int percentageOfWholeBlood) {
        this.shelfLifeInDays = shelfLifeInDays;
        this.percentageOfWholeBlood = percentageOfWholeBlood;
    }
}
