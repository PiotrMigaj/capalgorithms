package pl.migibud.dp.allpossibleways;

public class App {



    public static void main(String[] args) {



        System.out.println("Hello world");

        int result = allPossibleWays(2, 3);
        System.out.println(result);

    }

    public static int allPossibleWays(int n,int m){
        if (n==1||m==1){
            return 1;
        }
        return allPossibleWays(n-1,m)+allPossibleWays(n,m-1);
    }
}
