package com.example.minilist;

import android.content.Intent;

import java.io.File;

public class MainPresenter {

    public final static String FILE_NAME = "miniList";

    private final MainActivity wireframe;

    public MainPresenter(MainActivity wireframe) {
        this.wireframe = wireframe;
        checkFileExists();
    }

    public void checkFileExists() {
        if (new File(wireframe.getFilesDir(), FILE_NAME).exists()) {
            wireframe.setExist();
        } else {
            wireframe.setNew();
        }
    }

    public void onEditButtonClicked() {
        wireframe.startActivity(new Intent(wireframe, EditActivity.class));
    }

    public void onNewButtonClicked() {
        wireframe.startActivity(new Intent(wireframe, EditActivity.class));
    }

    public void onShowButtonClicked() {
        wireframe.startActivity(new Intent(wireframe, WatchActivity.class));
    }

    public void onSettingsButtonClicked() {
        wireframe.startActivity(new Intent(wireframe, SettingsActivity.class));
    }

}
