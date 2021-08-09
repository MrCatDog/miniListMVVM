package com.example.minilist;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RadioGroup;

public class SettingsPresenter {

    private final SettingsActivity wireframe;

    SettingsPresenter(SettingsActivity wireframe) {
        this.wireframe = wireframe;
    }

    public void changeSize(RadioGroup radioGroup) {
        SharedPreferences.Editor save = PreferenceManager.getDefaultSharedPreferences(wireframe).edit();
        int size;
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_14:
                size = R.dimen.little_text_size;
                break;
            case R.id.radio_18:
                size = R.dimen.big_text_size;
                break;
            default:
                size = R.dimen.average_text_size;
                break;
        }
        save.putInt(SettingsActivity.SETTINGS_TEXT_SIZE, size);
        save.apply();
    }

    public void changeColor(RadioGroup radioGroup) {
        SharedPreferences.Editor save = PreferenceManager.getDefaultSharedPreferences(wireframe).edit();
        int color;
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_burnt_umber:
                color = R.color.burnt_umber;
                break;
            case R.id.radio_kashmir_green:
                color = R.color.kashmir_green;
                break;
            default:
                color = R.color.black;
                break;
        }
        save.putInt(SettingsActivity.SETTINGS_TEXT_COLOR, color);
        save.apply();
    }
}
