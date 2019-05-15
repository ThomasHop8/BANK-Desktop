package com.hoekbank.bank.desktop.helpers;
import java.security.SecureRandom;
import java.util.Random;
 
public class Randompasswordgenerator {
    private static final Random RANDOM = new SecureRandom();
   private static final String GETALLETTERSYMBOOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*_=+-/";
  
    public static String generatePassword(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(GETALLETTERSYMBOOL.charAt(RANDOM.nextInt(GETALLETTERSYMBOOL.length())));  
        }
        return new String(returnValue);
    }
}