package com.example.minilist;

import android.content.SharedPreferences;
import android.util.TypedValue;

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
        //обжаю такие длинные портянки
        //размер сильно превышает тот, что указан в dimens, но это из-за домножения на значения из DisplayMetrics. Для чистого значения нужно использовать Resources.getValue()
        wireframe.setTextSize(wireframe.getResources().getDimension(sharedPreferences.getInt(SETTINGS_TEXT_SIZE, R.dimen.average_text_size)));
//        TypedValue val = new TypedValue();
//        wireframe.getResources().getValue(R.dimen.average_text_size, val, true);
//        if(val.type == TypedValue.TYPE_DIMENSION) {
//            wireframe.setTextSize(val.getFloat()); //API 22
//        }
        //блин, чо так трудна, я просто хочу размер получить без сумасшедшей метрики
        wireframe.setTextColor(wireframe.getResources().getColor(sharedPreferences.getInt(SETTINGS_TEXT_COLOR, R.color.black)));

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
