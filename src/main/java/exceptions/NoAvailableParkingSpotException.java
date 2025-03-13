package exceptions;

public class NoAvailableParkingSpotException extends Exception {
    public NoAvailableParkingSpotException(String message) {
        super(message);
    }
}
