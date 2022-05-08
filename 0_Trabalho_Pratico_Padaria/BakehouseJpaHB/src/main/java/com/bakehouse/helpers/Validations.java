package com.bakehouse.helpers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public abstract class Validations {
    public static boolean email(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }
    
    public static boolean stringIsNullOrEmpty(String value) {
        if (value == null)
            return true;
        if (value.trim().length() <= 0)
            return true;
        
        return false;
    }
}