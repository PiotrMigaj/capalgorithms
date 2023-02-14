package pl.migibud.singletontest;

class App {

    public static void main(String[] args) {

        MovieService movieService = MovieFactory.createBean("movieService");
        movieService.play();

        MovieService movieService1 = MovieFactory.createBean("fdf");
        movieService1.play();

        System.out.println(movieService == movieService1);

    }

}
