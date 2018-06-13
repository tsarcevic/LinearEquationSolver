package com.example.comp.linearequationsolver.presenters;

import com.example.comp.linearequationsolver.ui.main_activity.MainActivityInterface;

/**
 * Created by COMP on 6.6.2018..
 */

public class MainActivityPresenter implements MainActivityInterface.Presenter {

    private MainActivityInterface.View view;

    @Override
    public void setView(MainActivityInterface.View view) {
        this.view = view;
    }

    @Override
    public void onAboutIconPressed() {
        view.navigateToAbout();
    }

    @Override
    public void onBackPressed() {
        view.navigateBack();
    }

    @Override
    public void onUIFinished() {
        view.showFirstScreen();
    }
}
