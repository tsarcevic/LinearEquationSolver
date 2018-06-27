package com.example.comp.linearequationsolver.ui.equation_solver;

/**
 * Created by COMP on 22.5.2018..
 */

public interface EquationSolverInterface {

    interface View {

        void navigateToShowGraph(double x1, double x2, double y1, double y2, double z1, double z2, boolean isOnlyOnePointSelected);

        void showX1Error();

        void showX2Error();

        void showY1Error();

        void showY2Error();

        void showZ1Error();

        void showZ2Error();

        void showAcceptedShowGraphColor();

        void showInfinitySolutionsToast();

        void showNoSolutionsToast();

        void showXAndY(double pointX, double pointY);

        void showInfinitySolutionsText(String equation);

        void showNoSolutionText();

        void showCalculateIsNotClickedToast();

        void showAcceptedCalculateColor();

        void showOnHoldCalculateColor();

        void showErrorCalculateColor();

        void showXAndYTextView();

        void showAllZerosToast();

        void showResetButton();

        void deleteNumbers();

        void showDeclinedShowGraphColor();

        void showXAndYAreZerosToast();

        void hideXAndYTextView();

        void hideResetButton();
    }

    interface Presenter {

        void setView(View view);

        void onShowGraphClicked();

        void onCalculateClicked(String x1, String x2, String y1, String y2, String z1, String z2);

        void onTextChanged(String x1, String x2, String y1, String y2, String z1, String z2);

        void onResetClicked();
    }
}
