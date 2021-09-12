package com.example.minilist.watch;

import android.content.SharedPreferences;
import android.util.TypedValue;

import com.example.minilist.R;
import com.example.minilist.settings.SettingsPresenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.example.minilist.main.MainPresenter.FILE_NAME;
import static com.example.minilist.settings.SettingsActivity.SETTINGS_TEXT_COLOR;
import static com.example.minilist.settings.SettingsActivity.SETTINGS_TEXT_SIZE;

public class WatchPresenter {

    private final WatchWireframe wireframe;
    private final SharedPreferences sharedPreferences;

    public WatchPresenter(WatchWireframe wireframe, SharedPreferences sharedPreferences) {
        this.wireframe = wireframe;
        this.sharedPreferences = sharedPreferences;

        getTextColor();
        getTextSize();

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

    private void getTextColor() {
        int color;
        switch (sharedPreferences.getInt(SETTINGS_TEXT_COLOR, SettingsPresenter.BLACK_COLOR)) {
            case SettingsPresenter.UMBER_COLOR:
                color = R.color.burnt_umber;
                break;
            case SettingsPresenter.GREEN_COLOR:
                color = R.color.kashmir_green;
                break;
            default:
                color = R.color.black;
                break;
        }
        wireframe.setTextColor(color);
    }

    private void getTextSize() {
        int size;
        switch (sharedPreferences.getInt(SETTINGS_TEXT_SIZE, SettingsPresenter.AVERAGE_SIZE)) {
            case SettingsPresenter.LITTLE_SIZE:
                size = R.dimen.little_text_size;
                break;
            case SettingsPresenter.BIG_SIZE:
                size = R.dimen.big_text_size;
                break;
            default:
                size = R.dimen.average_text_size;
                break;
        }
        wireframe.setTextSize(size);
    }
}
