package restaurant.App.Exceptions;

public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String ms){
        super();
        this.message = ms;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
