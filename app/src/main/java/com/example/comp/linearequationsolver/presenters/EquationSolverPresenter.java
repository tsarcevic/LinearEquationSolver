package com.example.comp.linearequationsolver.presenters;

import com.example.comp.linearequationsolver.ui.equation_solver.EquationSolverInterface;
import com.example.comp.linearequationsolver.utils.MathUtils;

/**
 * Created by COMP on 22.5.2018..
 */

public class EquationSolverPresenter implements EquationSolverInterface.Presenter {

    private EquationSolverInterface.View view;

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double z1;
    private double z2;

    private double pointX;
    private double pointY;

    private boolean isCalculateClicked = false;
    private boolean isOnlyOnePointSelected = false;

    @Override
    public void setView(EquationSolverInterface.View view) {
        this.view = view;
    }

    @Override
    public void onShowGraphClicked() {
        if (isCalculateClicked) {
            view.navigateToShowGraph(x1, x2, y1, y2, z1, z2, isOnlyOnePointSelected);
        } else {
            view.showCalculateIsNotClickedToast();
        }
    }

    @Override
    public void onResetClicked() {
        isCalculateClicked = false;

        view.deleteNumbers();
        view.showDeclinedShowGraphColor();
        view.hideXAndYTextView();
        view.hideResetButton();
    }

    @Override
    public void onCalculateClicked(String x1, String x2, String y1, String y2, String z1, String z2) {
        if (checkIfNumberInputsAreFilled(x1, x2, y1, y2, z1, z2) && !checkIfNumberInputsAreZeros(x1, x2, y1, y2, z1, z2)
                && !checkIfXAndYAreZeros(x1, x2, y1, y2)) {

            this.x1 = Double.parseDouble(x1);
            this.x2 = Double.parseDouble(x2);
            this.y1 = Double.parseDouble(y1);
            this.y2 = Double.parseDouble(y2);
            this.z1 = Double.parseDouble(z1);
            this.z2 = Double.parseDouble(z2);

            view.showAcceptedShowGraphColor();

            view.showXAndYTextView();

            view.showResetButton();

            if (MathUtils.calculateDeterminant(this.x1, this.x2, this.y1, this.y2) == 0) {
                if (MathUtils.calculateDeterminantX(this.y1, this.y2, this.z1, this.z2) == 0) {
                    view.showInfinitySolutionsToast();
                    view.showInfinitySolutionsText(MathUtils.calculateEquationWithX(this.x1, this.y1, this.z1));
                } else {
                    view.showNoSolutionsToast();
                    view.showNoSolutionText();
                }
            } else {
                pointX = MathUtils.calculateDeterminantX(this.y1, this.y2, this.z1, this.z2) /
                        MathUtils.calculateDeterminant(this.x1, this.x2, this.y1, this.y2);
                pointY = MathUtils.calculateDeterminantY(this.x1, this.x2, this.z1, this.z2) /
                        MathUtils.calculateDeterminant(this.x1, this.x2, this.y1, this.y2);

                isOnlyOnePointSelected = true;

                view.showXAndY(pointX, pointY);
            }

            isCalculateClicked = true;
        }
    }

    private boolean checkIfXAndYAreZeros(String x1, String x2, String y1, String y2) {
        boolean xAndYAreZeros = false;

        if ((Double.parseDouble(x1) == 0) || (Double.parseDouble(x2) == 0) || (Double.parseDouble(y1) == 0)
                || (Double.parseDouble(y2) == 0)) {
            view.showXAndYAreZerosToast();
            xAndYAreZeros = true;
        }

        return xAndYAreZeros;
    }

    private boolean checkIfNumberInputsAreZeros(String x1, String x2, String y1, String y2, String z1, String z2) {
        boolean numberInputsZeroFlag = false;

        if ((Double.parseDouble(x1) == 0) && (Double.parseDouble(x2) == 0) && (Double.parseDouble(y1) == 0)
                && (Double.parseDouble(y2) == 0) && (Double.parseDouble(z1) == 0) && (Double.parseDouble(z2) == 0)) {
            numberInputsZeroFlag = true;
            view.showAllZerosToast();
        }

        return numberInputsZeroFlag;
    }

    private boolean checkIfNumberInputsAreFilled(String x1, String x2, String y1, String y2, String z1, String z2) {
        boolean numberInputsFilledFlag = true;

        if (x1.isEmpty()) {
            view.showX1Error();
            numberInputsFilledFlag = false;
        }

        if (x2.isEmpty()) {
            view.showX2Error();
            numberInputsFilledFlag = false;
        }

        if (y1.isEmpty()) {
            view.showY1Error();
            numberInputsFilledFlag = false;
        }

        if (y2.isEmpty()) {
            view.showY2Error();
            numberInputsFilledFlag = false;
        }

        if (z1.isEmpty()) {
            view.showZ1Error();
            numberInputsFilledFlag = false;
        }

        if (z2.isEmpty()) {
            view.showZ2Error();
            numberInputsFilledFlag = false;
        }

        return numberInputsFilledFlag;
    }

    @Override
    public void onTextChanged(String x1, String x2, String y1, String y2, String z1, String z2) {
        if (!x1.isEmpty() && !x2.isEmpty() && !y1.isEmpty() && !y2.isEmpty() && !z1.isEmpty() && !z2.isEmpty()
                && !checkIfXAndYAreZeros(x1, x2, y1, y2)) {
            view.showAcceptedCalculateColor();
        } else if (x1.isEmpty() && x2.isEmpty() && y1.isEmpty() && y2.isEmpty() && z1.isEmpty() && z2.isEmpty()) {
            view.showErrorCalculateColor();
        } else {
            view.showOnHoldCalculateColor();
        }
    }
}