package pl.migibud.enumfun;

class Main {

    public static void main(String[] args) {

        int points = Loot.CARROT.getPoints();
        System.out.println(points);

        int points2 = Loot.CARROT.getPoints();
        System.out.println(points);

    }

}
