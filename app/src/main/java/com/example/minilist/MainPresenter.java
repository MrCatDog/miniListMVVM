package com.example.minilist;

import java.io.File;

public class MainPresenter {

    public final static String FILE_NAME = "miniList";

    private enum State {EXIST, NOT_EXIST}

    private final MainActivity wireframe;
    private State status;

    public MainPresenter(MainActivity wireframe) {
        this.wireframe = wireframe;
        checkFileExists();
    }

    public void checkFileExists() {
        if (new File(wireframe.getFilesDir(), FILE_NAME).exists()) {
            fileExist();
        } else {
            newFile();
        }
    }

    public void fileExist() {
        if (status != State.EXIST) {
            wireframe.setExist();
            status = State.EXIST;
        }
    }

    public void newFile() {
        if (status != State.NOT_EXIST) {
            wireframe.setNew();
            status = State.NOT_EXIST;
        }
    }

    public void onEditButtonClicked() {
        wireframe.startEdit();
    }

    public void onNewButtonClicked() {
        wireframe.startEdit();
    }

    public void onShowButtonClicked() {
        wireframe.startViewing();
    }

    public void onSettingsButtonClicked() {
        //todo
    }

}
