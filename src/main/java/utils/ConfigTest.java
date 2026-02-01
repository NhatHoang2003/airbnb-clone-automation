package utils;

public class ConfigTest {
    public static void main(String[] args) {
        System.out.println("BASE_URL = " + ConfigReader.getBaseUrl());
        System.out.println("BROWSER  = " + ConfigReader.getBrowser());
    }
}
