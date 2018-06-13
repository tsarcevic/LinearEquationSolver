package com.example.comp.linearequationsolver.ui.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comp.linearequationsolver.R;
import com.example.comp.linearequationsolver.base.BaseFragment;
import com.example.comp.linearequationsolver.presenters.AboutPresenter;

import butterknife.ButterKnife;

/**
 * Created by COMP on 26.5.2018..
 */

public class AboutView extends BaseFragment implements AboutInterface.View {

    AboutInterface.Presenter presenter = new AboutPresenter();

    public static AboutView newInstance() {
        return new AboutView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.setView(this);

        setUI(view);
    }

    private void setUI(View view) {
        ButterKnife.bind(this, view);
    }
}