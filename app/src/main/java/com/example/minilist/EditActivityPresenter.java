package com.example.minilist;

import java.io.FileOutputStream;
import java.io.IOException;

public class EditActivityPresenter {

    private final EditActivity wireframe;

    EditActivityPresenter(EditActivity wireframe) {
        this.wireframe = wireframe;
    }

    public void saveText(String text) {

        FileOutputStream fos = null;//а не проверить ли не занят ли файл?
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);//почему? и что с разрешением?
            fos.write(text.getBytes());
            //вернуть успех
        } catch (IOException ex) {
            //вернуть провал
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {
                //вернуть провал
            }
        }
    }
}
