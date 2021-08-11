package com.example.minilist;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RadioGroup;

import static com.example.minilist.SettingsActivity.SETTINGS_TEXT_COLOR;
import static com.example.minilist.SettingsActivity.SETTINGS_TEXT_SIZE;

public class SettingsPresenter {

    private final SettingsActivity wireframe;

    SettingsPresenter(SettingsActivity wireframe, SharedPreferences sharedPreferences) {
        this.wireframe = wireframe;
        switch (sharedPreferences.getInt(SETTINGS_TEXT_SIZE, R.dimen.average_text_size)) {
            case R.dimen.little_text_size:
                wireframe.setSizeRadio(R.id.radio_14);
                break;
            case R.dimen.big_text_size:
                wireframe.setSizeRadio(R.id.radio_18);
                break;
            default:
                wireframe.setSizeRadio(R.id.radio_16);
                break;
        }


        switch (sharedPreferences.getInt(SETTINGS_TEXT_COLOR, R.color.black)) {
            case R.color.burnt_umber:
                wireframe.setColorRadio(R.id.radio_burnt_umber);
                break;
            case R.color.kashmir_green:
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
        SharedPreferences.Editor save = PreferenceManager.getDefaultSharedPreferences(wireframe).edit();
        save.putInt(SETTINGS_TEXT_SIZE, size);
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
        save.putInt(SETTINGS_TEXT_COLOR, color);
        save.apply();
    }
}
