package com.bakehouse.main;

import com.bakehouse.gui_public.LoginGUI;

public class Main {

    public static void main(String[] args) {
        try {
            LoginGUI guiInitial = new LoginGUI();
            guiInitial.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}