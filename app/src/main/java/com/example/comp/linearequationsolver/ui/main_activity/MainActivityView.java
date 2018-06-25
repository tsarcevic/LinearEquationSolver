package com.example.comp.linearequationsolver.ui.main_activity;

import android.os.Bundle;

import com.example.comp.linearequationsolver.R;
import com.example.comp.linearequationsolver.base.BaseActivity;
import com.example.comp.linearequationsolver.presenters.MainActivityPresenter;
import com.example.comp.linearequationsolver.ui.about.AboutView;
import com.example.comp.linearequationsolver.ui.equation_solver.EquationSolverView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityView extends BaseActivity implements MainActivityInterface.View {

    MainActivityInterface.Presenter presenter = new MainActivityPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.setView(this);

        setUI();
    }

    private void setUI() {
        ButterKnife.bind(this);

        presenter.onUIFinished();
    }

    @Override
    public void showFirstScreen() {
        addFragment(R.id.fr_layout, EquationSolverView.newInstance());
    }


    @OnClick(R.id.iv_about)
    public void onAboutPressed() {
        presenter.onAboutIconPressed();
    }

    @OnClick(R.id.iv_back)
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    @Override
    public void navigateToAbout() {
        replaceFragment(R.id.fr_layout, AboutView.newInstance(), true);
    }

    @Override
    public void navigateBack() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
