package com.bakehouse.helpers;

import java.text.DecimalFormat;

public abstract class FormatInputs {
    public static String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }
}