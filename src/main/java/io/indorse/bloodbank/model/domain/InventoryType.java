package io.indorse.bloodbank.model.domain;

public enum InventoryType {

    WHOLE(35,100),
    PLASMA(360,54),
    RED_BLOOD_CELL(35,10),
    PLATELETE(5,1);

    private static InventoryType[] processedComponent = new InventoryType[3];
    static{
        processedComponent[0]=InventoryType.PLASMA;
        processedComponent[1]=InventoryType.RED_BLOOD_CELL;
        processedComponent[2]=InventoryType.PLATELETE;
    }

    int shelfLifeInDays;
    int percentageOfWholeBlood;

    InventoryType(int shelfLifeInDays, int percentageOfWholeBlood) {
        this.shelfLifeInDays = shelfLifeInDays;
        this.percentageOfWholeBlood = percentageOfWholeBlood;
    }

    public int getShelfLifeInDays() {
        return shelfLifeInDays;
    }

    public int getPercentageOfWholeBlood() {
        return percentageOfWholeBlood;
    }

    public static InventoryType[] getProcessComponents(){
        return processedComponent;
    }
}
