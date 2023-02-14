package pl.migibud.singletontest;

class MovieServiceImpl implements MovieService {
    @Override
    public void play() {
        System.out.println("Playing movie...");
    }
}
