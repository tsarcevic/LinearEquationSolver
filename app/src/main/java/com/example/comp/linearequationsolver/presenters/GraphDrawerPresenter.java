package com.example.comp.linearequationsolver.presenters;

import com.example.comp.linearequationsolver.ui.graph_drawer.GraphDrawerInterface;
import com.example.comp.linearequationsolver.utils.MathUtils;

/**
 * Created by COMP on 22.5.2018..
 */

public class GraphDrawerPresenter implements GraphDrawerInterface.Presenter {

    private GraphDrawerInterface.View view;

    private double firstEquationY;
    private double secondEquationY;

    @Override
    public void setView(GraphDrawerInterface.View view) {
        this.view = view;
    }

    @Override
    public void onExtrasReceived(double x1, double x2, double y1, double y2, double z1, double z2, boolean isOnlyOnePointSelected) {
        calculateEquations(x1, x2, y1, y2, z1, z2);
        calculatePoint(x1, x2, y1, y2, z1, z2, isOnlyOnePointSelected);
    }

    private void calculatePoint(double x1, double x2, double y1, double y2, double z1, double z2, boolean isOnlyOnePointSelected) {
        if (isOnlyOnePointSelected) {
            double pointX = MathUtils.calculateDeterminantX(y1, y2, z1, z2) / MathUtils.calculateDeterminant(x1, x2, y1, y2);
            double pointY = MathUtils.calculateDeterminantY(x1, x2, z1, z2) / MathUtils.calculateDeterminant(x1, x2, y1, y2);

            view.showPoint(pointX, pointY);
            view.setCalculatedPointTitle(pointX, pointY);
        }
    }

    private void calculateEquations(double x1, double x2, double y1, double y2, double z1, double z2) {

        view.setFirstEquationTitle(MathUtils.calculateEquationWithY(x1, y1, z1));
        view.setSecondEquationTitle(MathUtils.calculateEquationWithY(x1, y2, z2));

        calculateGraphPoints(-(x1 / y1), -(x2 / y2), -(z1 / y1), -(z2 / y2));
    }

    private void calculateGraphPoints(double x1, double x2, double z1, double z2) {
        for (int i = -100; i < 101; i++) {
            firstEquationY = x1 * i + z1;
            secondEquationY = x2 * i + z2;

            view.setFirstEquationData(i, firstEquationY);
            view.setSecondEquationData(i, secondEquationY);
        }

        view.setFirstEquationColor();
        view.setSecondEquationColor();

        view.setZoomingPossibilities();
        view.showFirstGraph();
        view.showSecondGraph();

        view.showGraphLegend();
    }
}
