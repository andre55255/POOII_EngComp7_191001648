package com.bakehouse.helpers;

import com.bakehouse.domain.User;

public abstract class ApplicationUser {
    private static User user;
    
    private ApplicationUser() {
    }
    
    public static User getInstance() {
        return user;
    }
    
    public static void setLoginUser(User user) {
        ApplicationUser.user = user;
    }
}