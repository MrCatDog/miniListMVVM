package com.example.minilist.settings;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RadioGroup;

import com.example.minilist.R;

import static com.example.minilist.settings.SettingsActivity.SETTINGS_TEXT_COLOR;
import static com.example.minilist.settings.SettingsActivity.SETTINGS_TEXT_SIZE;

public class SettingsPresenter {

    public static final int LITTLE_SIZE = 0;
    public static final int AVERAGE_SIZE = 1;
    public static final int BIG_SIZE = 2;

    public static final int BLACK_COLOR = 0;
    public static final int UMBER_COLOR = 1;
    public static final int GREEN_COLOR = 2;

    private final SettingsActivity wireframe;

    SettingsPresenter(SettingsActivity wireframe, SharedPreferences sharedPreferences) {
        this.wireframe = wireframe;
        switch (sharedPreferences.getInt(SETTINGS_TEXT_SIZE, AVERAGE_SIZE)) {
            case LITTLE_SIZE:
                wireframe.setSizeRadio(R.id.radio_little);
                break;
            case BIG_SIZE:
                wireframe.setSizeRadio(R.id.radio_big);
                break;
            default:
                wireframe.setSizeRadio(R.id.radio_avg);
                break;
        }


        switch (sharedPreferences.getInt(SETTINGS_TEXT_COLOR, BLACK_COLOR)) {
            case UMBER_COLOR:
                wireframe.setColorRadio(R.id.radio_burnt_umber);
                break;
            case GREEN_COLOR:
                wireframe.setColorRadio(R.id.radio_kashmir_green);
                break;
            default:
                wireframe.setColorRadio(R.id.radio_black);
                break;
        }

    }

    public void changeSize(RadioGroup radioGroup) {
        int size;
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_little:
                size = LITTLE_SIZE;
                break;
            case R.id.radio_big:
                size = BIG_SIZE;
                break;
            default:
                size = AVERAGE_SIZE;
                break;
        }
        SharedPreferences.Editor save = PreferenceManager.getDefaultSharedPreferences(wireframe).edit();
        save.putInt(SETTINGS_TEXT_SIZE, size);
        save.apply();
    }

    public void changeColor(RadioGroup radioGroup) {
        SharedPreferences.Editor save = PreferenceManager.getDefaultSharedPreferences(wireframe).edit();
        int color;
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_burnt_umber:
                color = UMBER_COLOR;
                break;
            case R.id.radio_kashmir_green:
                color = GREEN_COLOR;
                break;
            default:
                color = BLACK_COLOR;
                break;
        }
        save.putInt(SETTINGS_TEXT_COLOR, color);
        save.apply();
    }
}
