package enums;

public enum Properties {
    AUT("aut"),
    SUT("sut"),
    TEST_PLATFORM("platform"),
    DRIVER("driver"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    DONT_STOP_APP("wait");

    public String value;

    Properties(String value) {
        this.value = value;
    }
}
