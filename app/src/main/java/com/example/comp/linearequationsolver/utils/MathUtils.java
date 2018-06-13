package com.example.comp.linearequationsolver.utils;

import java.text.NumberFormat;

/**
 * Created by COMP on 26.5.2018..
 */

public class MathUtils {

    private static NumberFormat nf = NumberFormat.getNumberInstance();

    public static Double calculateDeterminant(double x1, double x2, double y1, double y2) {
        return (x1 * y2) - (x2 * y1);
    }

    public static Double calculateDeterminantX(double y1, double y2, double z1, double z2) {
        return (-z1 * y2) - (-z2 * y1);
    }

    public static Double calculateDeterminantY(double x1, double x2, double z1, double z2) {
        return (x1 * -z2) - (x2 * -z1);
    }

    public static String calculateEquationWithY(double x, double y, double z) {
        String equation;

        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        double parameterX = -(x / y);
        double parameterZ = -(z / y);

        if (parameterZ < 0) {
            equation = "y = " + nf.format(parameterX) + "x " + nf.format(parameterZ);
        } else {
            equation = "y = " + nf.format(parameterX) + "x + " + nf.format(parameterZ);
        }

        return equation;
    }

    public static String calculateEquationWithX(double x, double y, double z) {
        String equation;

        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        double parameterY = -(y / x);
        double parameterZ = -(z / x);

        if (parameterZ < 0) {
            equation = "x = " + nf.format(parameterY) + "y " + nf.format(parameterZ);
        } else {
            equation = "x = " + nf.format(parameterY) + "y + " + nf.format(parameterZ);
        }

        return equation;
    }
}
