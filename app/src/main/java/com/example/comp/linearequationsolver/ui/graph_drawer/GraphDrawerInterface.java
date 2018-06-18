package com.example.comp.linearequationsolver.ui.graph_drawer;

/**
 * Created by COMP on 22.5.2018..
 */

public interface GraphDrawerInterface {

    interface View {

        void setFirstEquationData(int i, double firstEquationY);

        void setSecondEquationData(int i, double secondEquationY);

        void setFirstEquationColor();

        void setSecondEquationColor();

        void setZoomingPossibilities();

        void showFirstGraph();

        void showSecondGraph();

        void showGraphLegend();

        void navigateBack();

        void setFirstEquationTitle(String equation);

        void setSecondEquationTitle(String equation);

        void showPoint(double pointX, double pointY);
    }

    interface Presenter {
        void setView(View view);

        void onExtrasReceived(double x1, double x2, double y1, double y2, double z1, double z2, boolean isOnlyOnePointSelected);

        void onBackPressed();
    }
}
