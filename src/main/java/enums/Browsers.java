package enums;

public enum Browsers {
    CHROME("Chrome"),
    SAFARI("Safari");

    public String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }
}
