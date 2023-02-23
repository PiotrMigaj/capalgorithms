package pl.migibud.enumfun;

enum Loot {

    CARROT("NORMAL", "CARROT");


    private final String explosionType;
    private final String vegeType;
    private int points;

    Loot(String explosionType, String vegeType) {
        this.explosionType = explosionType;
        this.vegeType = vegeType;
        setPoints();
    }

    private void setPoints() {
        if (explosionType.equals("NORMAL") && vegeType.equals("CARROT")) {
            points = 50;
        }
        if (explosionType.equals("SPECIAL") && vegeType.equals("CARROT")) {
            points = 100;
        }
    }

    public int getPoints() {
        return points;
    }
}
