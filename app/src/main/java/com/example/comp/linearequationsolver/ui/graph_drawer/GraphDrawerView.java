package com.example.comp.linearequationsolver.ui.graph_drawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comp.linearequationsolver.R;
import com.example.comp.linearequationsolver.base.BaseFragment;
import com.example.comp.linearequationsolver.presenters.GraphDrawerPresenter;
import com.example.comp.linearequationsolver.ui.equation_solver.EquationSolverView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by COMP on 22.5.2018..
 */

public class GraphDrawerView extends BaseFragment implements GraphDrawerInterface.View {

    @BindView(R.id.gv_graph)
    GraphView graph;

    LineGraphSeries<DataPoint> firstFunctionGraph = new LineGraphSeries<DataPoint>();
    LineGraphSeries<DataPoint> secondFunctionGraph = new LineGraphSeries<DataPoint>();

    GraphDrawerInterface.Presenter presenter = new GraphDrawerPresenter();

    public static GraphDrawerView newInstance(double x1, double x2, double y1, double y2, double z1, double z2) {
        Bundle args = new Bundle();

        args.putDouble("x1", x1);
        args.putDouble("x2", x2);
        args.putDouble("y1", y1);
        args.putDouble("y2", y2);
        args.putDouble("z1", z1);
        args.putDouble("z2", z2);

        GraphDrawerView fragment = new GraphDrawerView();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.graph_drawer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.setView(this);

        setUI(view);
        getExtras();
    }

    private void setUI(View view) {
        ButterKnife.bind(this, view);
    }

    private void getExtras() {
        presenter.onExtrasReceived(getArguments().getDouble("x1"), getArguments().getDouble("x2")
                , getArguments().getDouble("y1"), getArguments().getDouble("y2")
                , getArguments().getDouble("z1"), getArguments().getDouble("z2"));
    }

    @OnClick(R.id.btn_back)
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    @Override
    public void navigateBack() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            replaceFragment(R.id.fr_layout, EquationSolverView.newInstance(), false);
        }
    }

    @Override
    public void setFirstEquationColor() {
        firstFunctionGraph.setColor(Color.CYAN);
    }

    @Override
    public void setSecondEquationColor() {
        secondFunctionGraph.setColor(Color.WHITE);
    }

    @Override
    public void setZoomingPossibilities() {
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
    }

    @Override
    public void showFirstGraph() {
        graph.addSeries(firstFunctionGraph);
    }

    @Override
    public void showSecondGraph() {
        graph.addSeries(secondFunctionGraph);
    }

    @Override
    public void setFirstEquationData(int i, double firstEquationY) {
        firstFunctionGraph.appendData(new DataPoint(i, firstEquationY), true, 200);
    }

    @Override
    public void setSecondEquationData(int i, double secondEquationY) {
        secondFunctionGraph.appendData(new DataPoint(i, secondEquationY), true, 200);
    }

    @Override
    public void setFirstPositiveEquationTitle(double firstEquationX, double firstEquationZ) {
        firstFunctionGraph.setTitle(String.format((getString(R.string.positive_numbers_graph_title)), firstEquationX, firstEquationZ));
    }

    @Override
    public void setSecondPositiveEquationTitle(double secondEquationX, double secondEquationZ) {
        secondFunctionGraph.setTitle(String.format((getString(R.string.positive_numbers_graph_title)), secondEquationX, secondEquationZ));
    }

    @Override
    public void setFirstNegativeEquationTitle(double firstEquationX, double firstEquationZ) {
        firstFunctionGraph.setTitle(String.format((getString(R.string.negative_numbers_graph_title)), firstEquationX, firstEquationZ));
    }

    @Override
    public void setSecondNegativeEquationTitle(double secondEquationX, double secondEquationZ) {
        secondFunctionGraph.setTitle(String.format((getString(R.string.negative_numbers_graph_title)), secondEquationX, secondEquationZ));

    }

    @Override
    public void setFirstEquationTitle(String equation) {
        firstFunctionGraph.setTitle(equation);
    }

    @Override
    public void setSecondEquationTitle(String equation) {
        secondFunctionGraph.setTitle(equation);
    }

    @Override
    public void showGraphLegend() {
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getLegendRenderer().setBackgroundColor(Color.TRANSPARENT);
    }
}
