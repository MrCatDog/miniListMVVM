package com.example.minilist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.example.minilist.MainPresenter.FILE_NAME;

public class WatchPresenter {

    private final WatchActivity wireframe;

    public WatchPresenter(WatchActivity wireframe) {
        this.wireframe = wireframe;
        try (BufferedReader in = new BufferedReader(new FileReader(new File(wireframe.getFilesDir(), FILE_NAME)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            int i = 0;
            while ((line = in.readLine()) != null) {
                stringBuilder.append(++i).append(line).append("\n");
            }
            this.wireframe.setText(stringBuilder.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
