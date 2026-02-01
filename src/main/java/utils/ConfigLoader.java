package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties = new Properties();

    static {
        try (InputStream is = ConfigLoader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is != null) {
                properties.load(is);
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config.properties");
        }
    }

    public static boolean isHighlightEnabled() {
        return Boolean.parseBoolean(
                properties.getProperty("highlight.enabled", "false")
        );
    }

    public static int getHighlightDuration() {
        return Integer.parseInt(
                properties.getProperty("highlight.duration", "300")
        );
    }
}
