package framework.enums;

public enum MainMenu {
    HOME("Home"),
    ABOUT("About"),
    SERVICES("Services"),
    PRICING("Pricing"),
    CONTACT("Contact"),;

    private final String text;

    MainMenu(String text) { this.text = text; }

    public String getText() {
        return text;
    }
}


