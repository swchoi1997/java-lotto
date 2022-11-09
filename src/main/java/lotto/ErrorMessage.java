package lotto;

public enum ErrorMessage {

    COMMON_MESSAGE("[ERROR] "),
    LOTTE_SIZE_INVALID("Lotto Number Length Is Incorrect. SIZE : "),
    LOTTE_NUMBER_DUPLICATION("Lotto Number Have Duplicate Number."),
    LOTTE_NUMBER_OUT_BOUND("Lotto Number Have Out Bound Number.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
