package utils;

public class StepDelayUtil {

    private static final boolean ENABLED =
            Boolean.parseBoolean(ConfigReader.getConfig("step.delay.enabled"));

    private static final int DELAY =
            Integer.parseInt(ConfigReader.getConfig("step.delay.ms"));

    public static void waitAfterStep() {
        if (!ENABLED) return;
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ignored) {}
    }
}
