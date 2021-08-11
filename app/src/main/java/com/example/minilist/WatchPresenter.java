package com.example.minilist;

import android.content.SharedPreferences;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.example.minilist.MainPresenter.FILE_NAME;
import static com.example.minilist.SettingsActivity.SETTINGS_TEXT_COLOR;
import static com.example.minilist.SettingsActivity.SETTINGS_TEXT_SIZE;

public class WatchPresenter {

    private final WatchActivity wireframe;

    public WatchPresenter(WatchActivity wireframe, SharedPreferences sharedPreferences) {
        this.wireframe = wireframe;
//       wireframe.setTextSize(sharedPreferences.getInt(SETTINGS_TEXT_SIZE, R.dimen.average_text_size));
        wireframe.setTextColor(sharedPreferences.getInt(SETTINGS_TEXT_COLOR, R.color.black));
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
