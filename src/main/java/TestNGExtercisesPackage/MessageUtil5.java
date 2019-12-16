package TestNGExtercisesPackage;

public class MessageUtil5 {
    private String message;

    // Constructor
    // @param message to be printed
    public MessageUtil5(String message) {
        this.message = message;
    }

    // prints the message
    public String printMessage() {
        System.out.println(message);
        return message;
    }

    // add "Hi!" to the message
    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
