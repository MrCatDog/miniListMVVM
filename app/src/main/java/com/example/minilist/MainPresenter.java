package com.example.minilist;

import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static android.content.Context.MODE_PRIVATE;

public class MainPresenter {

    public final static String FILE_NAME = "miniList";

    private enum state {exist, notExist}

    private final MainActivity wireframe;
    private Enum<state> status;

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
        if (status != state.exist) {
            wireframe.setExist();
            status = state.exist;
        }
    }

    public void newFile() {
        if (status != state.notExist) {
            wireframe.setNew();
            status = state.notExist;
        }
    }

    public void onEditButtonClicked() {
        wireframe.startEdit();
    }

    public void onNewButtonClicked() {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(wireframe.getFilesDir(), FILE_NAME))));
            OutputStreamWriter osw = new OutputStreamWriter(wireframe.openFileOutput(FILE_NAME, MODE_PRIVATE))
        ) {
            //есть два стула, разница не ясна
            Toast.makeText(wireframe, wireframe.getFilesDir().toString(), Toast.LENGTH_LONG).show();
            out.println("test");
            //osw.write("test");
            checkFileExists();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            Toast.makeText(wireframe, ioe.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            //откинуть снэк о невозможности создать
        }
    }

    public void onShowButtonClicked() {
        //todo
    }

    public void onSettingsButtonClicked() {
        //todo
    }
}
