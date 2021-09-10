package com.example.minilist.main;

import java.io.File;

public class MainPresenter {

    public final static String FILE_NAME = "miniList";

    private final MainWireframe wireframe;

    public MainPresenter(MainWireframe wireframe) {
        this.wireframe = wireframe;
        checkFileExists();
    }

    public void checkFileExists() {
        if (new File(wireframe.getDir(), FILE_NAME).exists()) {
            wireframe.setExist();
        } else {
            wireframe.setNew();
        }
    }

    public void onEditButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.EDIT);
    }

    public void onNewButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.EDIT);
    }

    public void onShowButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.WATCH);
    }

    public void onSettingsButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.SETTINGS);
    }

}
