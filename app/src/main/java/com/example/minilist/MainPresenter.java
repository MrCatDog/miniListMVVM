package com.example.minilist;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.io.File;

public class MainPresenter {

    public final static String FILE_NAME = "miniList";

    private enum State {EXIST, NOT_EXIST}

    private final MainActivity wireframe;
    private State status;

    public MainPresenter(MainActivity wireframe) {
        this.wireframe = wireframe;
        //тут проверка на наличие файла
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
        //todo
    }

    public void onSettingsButtonClicked() {
        //todo
    }

    public void formAnswer(int resultCode, @Nullable Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            wireframe.showSnack(wireframe.getString(R.string.save_completed));
        } else {
            String extra = "";
            if(data != null) {
                extra = data.getStringExtra(EditActivity.EXTRA_ANSWER);
            }
            wireframe.showSnack(wireframe.getString(R.string.save_canceled).concat(extra));
        }
    }
}
