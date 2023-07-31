package exceptions;

public class ExceptionHandling {
    public static void handleException(Exception exception) {
        System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        exception.printStackTrace();
        throw new RuntimeException(exception);
    }
}