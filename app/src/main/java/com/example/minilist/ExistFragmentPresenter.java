package com.example.minilist;

public class ExistFragmentPresenter {

    private final ExistFragment wireframe;

    public ExistFragmentPresenter(ExistFragment wireframe) {
        this.wireframe = wireframe;
    }

    public void onEditButtonClicked() {
        wireframe.startCalcScreen();
    }

    public void onShowButtonClicked() {
        //todo
    }

    public void onSettingsButtonClicked() {
        //todo
    }

}
