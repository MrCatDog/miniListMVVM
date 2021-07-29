package com.example.minilist;

public class MainPresenter {

    private final MainActivity wireframe;
    private int selectedFragment = 0;

    public MainPresenter(MainActivity wireframe) {
        this.wireframe = wireframe;
        //тут проверка на наличие файла
        fileExist();
    }

    public void fileExist() {
        if(selectedFragment != R.id.existFileFragment) {
            wireframe.setExistFragment();
            selectedFragment = R.id.existFileFragment;
        }

    }

    public void newFile() {
        if(selectedFragment != R.id.newFileFragment) {
            wireframe.setNewFragment();
            selectedFragment = R.id.newFileFragment;
        }
    }
}
