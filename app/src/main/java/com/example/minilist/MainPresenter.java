package com.example.minilist;

public class MainPresenter {

    private enum state {exist, notExist}

    private final MainActivity wireframe;
    private Enum<state> status;

    public MainPresenter(MainActivity wireframe) {
        this.wireframe = wireframe;
        //тут проверка на наличие файла
        fileExist();
    }

    public void fileExist() {
        if(status != state.exist) {
            wireframe.setExist();
            status = state.exist;
        }

    }

    public void newFile() {
        if(status != state.notExist) {
            wireframe.setNew();
            status = state.notExist;
        }
    }

    public void editBtnClicked() {

    }
}
