package my.project.OnlineShopWithSpringBoot.exception;

public class InvalidOrderIdException extends RuntimeException {
    public InvalidOrderIdException(String message) {
        super(message);
    }
}
