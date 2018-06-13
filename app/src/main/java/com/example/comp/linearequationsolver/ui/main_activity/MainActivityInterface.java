package com.example.comp.linearequationsolver.ui.main_activity;

/**
 * Created by COMP on 6.6.2018..
 */

public interface MainActivityInterface {

    interface View {

        void navigateToAbout();

        void navigateBack();

        void showFirstScreen();
    }

    interface Presenter {

        void setView(View view);

        void onAboutIconPressed();

        void onBackPressed();

        void onUIFinished();
    }
}
