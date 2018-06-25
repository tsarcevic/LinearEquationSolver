package com.example.comp.linearequationsolver.presenters;

import com.example.comp.linearequationsolver.ui.about.AboutInterface;

/**
 * Created by COMP on 9.6.2018..
 */

public class AboutPresenter implements AboutInterface.Presenter {

    private AboutInterface.View view;

    @Override
    public void setView(AboutInterface.View view) {
        this.view = view;
    }
}
