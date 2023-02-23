package pl.migibud.exception;

class MigiException extends RuntimeException {


    public MigiException(String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) {

        try {

            throw new MigiException("Hello ");
        } catch (MigiException e) {
            String message = e.getMessage();
            System.out.println(message);
        }


    }
}
