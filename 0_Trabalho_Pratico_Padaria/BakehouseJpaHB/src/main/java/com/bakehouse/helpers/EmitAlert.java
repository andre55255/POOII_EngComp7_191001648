package com.bakehouse.helpers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class EmitAlert {
    private Component component;
    private String msg;
    
    
    public EmitAlert(Component component, String msg) {
        this.component = component;
        this.msg = msg;
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
    
    private Icon getIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                            .getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        return icon;
    }
    
    public void success() {
        JOptionPane.showMessageDialog(component, 
                msg, 
                "Sucesso", 
                JOptionPane.PLAIN_MESSAGE, 
                this.getIcon("/assets/ico-alert-success.png", 40, 40));
    }
    
    public void error() {
        JOptionPane.showMessageDialog(component, 
                msg, 
                "Erro", 
                JOptionPane.PLAIN_MESSAGE,
                this.getIcon("/assets/ico-alert-error.png", 40, 40));
    }
    
    public void warning() {
        JOptionPane.showMessageDialog(component, 
                msg, 
                "Aviso", 
                JOptionPane.PLAIN_MESSAGE,
                this.getIcon("/assets/ico-alert-warning.png", 40, 40));
    }
    
    public int confirm() {
        int res = JOptionPane.showConfirmDialog(component, 
                                      msg,
                                      "Confirme",
                                      JOptionPane.YES_NO_OPTION,
                                      JOptionPane.PLAIN_MESSAGE,
                                      this.getIcon("/assets/ico-confirm.png", 40, 40));
        
        return res;
    }
}