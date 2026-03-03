package framework.data.model;

public class ExpectedResult {

    private boolean success;
    private String message;

    public ExpectedResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}