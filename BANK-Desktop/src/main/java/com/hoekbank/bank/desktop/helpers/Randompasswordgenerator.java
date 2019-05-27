package com.hoekbank.bank.desktop.helpers;
import java.security.SecureRandom;
import java.util.Random;
 //dit is gememaakt door Rogier Rijsdijk
public class Randompasswordgenerator {
    //Hier is gebruik gemaakt van de Random functie en een string die alle mogelijke getallen numbers en symbolen weergeeft die in het gegenereerde wachtwoord kunnen voorkomen.
   private static final Random RANDOM = new SecureRandom();
   private static final String GETALLETTERSYMBOOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*_=+-/";
  //Hier staat de berekening van het gegenereerde wachtwoord. 
    public static String generatePassword(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(GETALLETTERSYMBOOL.charAt(RANDOM.nextInt(GETALLETTERSYMBOOL.length())));  
        }
        return new String(returnValue);
    }
}