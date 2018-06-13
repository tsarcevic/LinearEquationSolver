package com.example.comp.linearequationsolver.presenters;

import com.example.comp.linearequationsolver.ui.graph_drawer.GraphDrawerInterface;
import com.example.comp.linearequationsolver.utils.MathUtils;

/**
 * Created by COMP on 22.5.2018..
 */

public class GraphDrawerPresenter implements GraphDrawerInterface.Presenter {

    GraphDrawerInterface.View view;

    private double firstEquationParameterX;
    private double firstEquationParameterZ;
    private double secondEquationParameterX;
    private double secondEquationParameterZ;
    private double firstEquationY;
    private double secondEquationY;

    @Override
    public void setView(GraphDrawerInterface.View view) {
        this.view = view;
    }

    @Override
    public void onBackPressed() {
        view.navigateBack();
    }

    @Override
    public void onExtrasReceived(double x1, double x2, double y1, double y2, double z1, double z2) {
        calculateEquations(x1, x2, y1, y2, z1, z2);
    }

    private void calculateEquations(double x1, double x2, double y1, double y2, double z1, double z2) {
        firstEquationParameterX = -(x1 / y1);
        firstEquationParameterZ = -(z1 / y1);

        secondEquationParameterX = -(x2 / y2);
        secondEquationParameterZ = -(z2 / y2);

        /*if (firstEquationParameterZ < 0) {
            view.setFirstNegativeEquationTitle(firstEquationParameterX, firstEquationParameterZ);
        } else {
            view.setFirstPositiveEquationTitle(firstEquationParameterX, firstEquationParameterZ);
        }

        if (secondEquationParameterZ < 0) {
            view.setSecondNegativeEquationTitle(secondEquationParameterX, secondEquationParameterZ);
        } else {
            view.setSecondPositiveEquationTitle(secondEquationParameterX, secondEquationParameterZ);
        }*/

        view.setFirstEquationTitle(MathUtils.calculateEquationWithY(x1, y1, z1));
        view.setSecondEquationTitle(MathUtils.calculateEquationWithY(x1, y2, z2));

        calculateGraphPoints(-(x1/y1), -(x2/y2), -(z1/y1), -(z2/y2));//firstEquationParameterX, secondEquationParameterX, firstEquationParameterZ, secondEquationParameterZ);
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
