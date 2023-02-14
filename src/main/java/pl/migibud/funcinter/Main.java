package pl.migibud.funcinter;

class Main {
    public static void main(String[] args) {

        MyOwnInter myOwnInter = Integer::sum;


        myOwnInter.hello();

    }
}
