package enums;

public enum ErrorMessages {
    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNKNOWN_APPLICATION("Unknown mobile app");

    public String value;
    ErrorMessages(String value){
        this.value = value;
    }
}
