package utils;

import java.util.Random;

public class DataGenerator {

    public static String generatePhone() {
        Random rand = new Random();
        return "9" + (rand.nextInt(900000000) + 100000000);
    }

    public static String generateBusinessName() {
    	
    	String characters = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder name = new StringBuilder("Test ");

        for (int i = 0; i < 5; i++) {

            int index = (int) (Math.random() * characters.length());
            name.append(characters.charAt(index));
        }

        return name.toString();
    }
    
    public static String generateEmail(String businessName) {
 
        return businessName
                .toLowerCase()
                .replace(" ", "_")
                + "@gmail.com";
    }
}