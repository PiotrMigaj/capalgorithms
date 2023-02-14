package pl.migibud.singletontest;

class MovieFactory {
    static MovieService createBean(String beanName) {

        switch (beanName) {
            case "movieService":
                return MovieServiceSingleton.MOVIE_SERVICE.getInstance();
            default:
                throw new IllegalArgumentException("There is no bean with such a name: " + beanName);
        }
    }


    private enum MovieServiceSingleton {

        MOVIE_SERVICE(new MovieServiceImpl());

        private final MovieService movieService;

        MovieServiceSingleton(MovieService movieService) {
            this.movieService = movieService;
        }

        private MovieService getInstance() {
            return this.movieService;
        }
    }

}
