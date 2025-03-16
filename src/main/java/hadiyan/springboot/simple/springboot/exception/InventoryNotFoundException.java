package hadiyan.springboot.simple.springboot.exception;

public class InventoryNotFoundException extends  RuntimeException{
    public InventoryNotFoundException(String message) {
        super(message);
    }
}
