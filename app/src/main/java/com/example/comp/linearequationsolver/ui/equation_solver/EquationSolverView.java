package com.example.comp.linearequationsolver.ui.equation_solver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comp.linearequationsolver.R;
import com.example.comp.linearequationsolver.base.BaseFragment;
import com.example.comp.linearequationsolver.presenters.EquationSolverPresenter;
import com.example.comp.linearequationsolver.ui.graph_drawer.GraphDrawerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by COMP on 22.5.2018..
 */

public class EquationSolverView extends BaseFragment implements EquationSolverInterface.View {

    @BindView(R.id.etFirstX)
    EditText etFirstX;

    @BindView(R.id.etFirstY)
    EditText etFirstY;

    @BindView(R.id.etFirstZ)
    EditText etFirstZ;

    @BindView(R.id.etSecondX)
    EditText etSecondX;

    @BindView(R.id.etSecondY)
    EditText etSecondY;

    @BindView(R.id.etSecondZ)
    EditText etSecondZ;

    @BindView(R.id.btn_calculate)
    Button calculateNumbers;

    @BindView(R.id.btn_show_graph)
    Button showGraph;

    @BindView(R.id.tv_show_x_and_y)
    TextView tvShowXAndY;

    EquationSolverInterface.Presenter presenter = new EquationSolverPresenter();

    public static EquationSolverView newInstance() {
        return new EquationSolverView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.equation_solver, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareUI(view);

        presenter.setView(this);
    }

    private void prepareUI(View view) {
        ButterKnife.bind(this, view);

        etFirstX.addTextChangedListener(generalTextWatcher);
        etSecondX.addTextChangedListener(generalTextWatcher);
        etFirstY.addTextChangedListener(generalTextWatcher);
        etSecondY.addTextChangedListener(generalTextWatcher);
        etFirstZ.addTextChangedListener(generalTextWatcher);
        etSecondZ.addTextChangedListener(generalTextWatcher);
    }

    private TextWatcher generalTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.hashCode() == etFirstX.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            } else if (charSequence.hashCode() == etSecondX.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            } else if (charSequence.hashCode() == etFirstY.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            } else if (charSequence.hashCode() == etSecondY.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            } else if (charSequence.hashCode() == etFirstZ.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            } else if (charSequence.hashCode() == etSecondZ.getText().hashCode()) {
                presenter.onTextChanged(etFirstX.getText().toString(), etSecondX.getText().toString(),
                        etFirstY.getText().toString(), etSecondY.getText().toString(),
                        etFirstZ.getText().toString(), etSecondZ.getText().toString());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @OnClick(R.id.btn_calculate)
    public void calculateNumbers() {
        presenter.onCalculateClicked(etFirstX.getText().toString(), etSecondX.getText().toString(),
                etFirstY.getText().toString(), etSecondY.getText().toString(),
                etFirstZ.getText().toString(), etSecondZ.getText().toString());
    }

    @OnClick(R.id.btn_show_graph)
    public void showGraph() {
        presenter.onShowGraphClicked();
    }

    @Override
    public void showAcceptedCalculateColor() {
        calculateNumbers.setBackground(getResources().getDrawable(R.drawable.round_button_success));
    }

    @Override
    public void showOnHoldCalculateColor() {
        calculateNumbers.setBackground(getResources().getDrawable(R.drawable.round_button_on_hold));
    }

    @Override
    public void showErrorCalculateColor() {
        calculateNumbers.setBackground(getResources().getDrawable(R.drawable.round_button_error));
    }

    @Override
    public void navigateToShowGraph(double x1, double x2, double y1, double y2, double z1, double z2) {
        replaceFragment(R.id.fr_layout, GraphDrawerView.newInstance(x1, x2, y1, y2, z1, z2), true);
    }

    @Override
    public void showX1Error() {
        etFirstX.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showX2Error() {
        etSecondX.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showY1Error() {
        etFirstY.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showY2Error() {
        etSecondY.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showZ1Error() {
        etFirstZ.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showZ2Error() {
        etSecondZ.setError(getString(R.string.empty_field_error));
    }

    @Override
    public void showAcceptedShowGraphColor() {
        showGraph.setBackground(getResources().getDrawable(R.drawable.round_button_success));
    }

    @Override
    public void showInfinitySolutionsToast() {
        Toast.makeText(getActivity(), R.string.infinity_solutions_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoSolutionsToast() {
        Toast.makeText(getActivity(), R.string.no_solutions_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCalculateIsNotClickedToast() {
        Toast.makeText(getActivity(), R.string.calculate_not_clicked, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showXAndY(double pointX, double pointY) {
        tvShowXAndY.setText(String.format(getString(R.string.show_x_and_y), pointX, pointY));
    }

    @Override
    public void showInfinitySolutionsText(String equation) {
        tvShowXAndY.setText(String.format(getString(R.string.infinity_solutions_points), equation));
    }

    @Override
    public void showNoSolutionText() {
        tvShowXAndY.setText(R.string.no_solutions_points);
    }

    @Override
    public void showXandYTextView() {
        tvShowXAndY.setVisibility(View.VISIBLE);
    }
}
