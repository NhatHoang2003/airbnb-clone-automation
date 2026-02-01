package framework.enums;

import org.openqa.selenium.remote.Browser;

public enum BrowserType implements Browser {
    CHROME,
    FIREFOX,
    EDGE,
    INTERNET_EXPLORER,
    ;

    @Override
    public String browserName() {
        return "";
    }
}
