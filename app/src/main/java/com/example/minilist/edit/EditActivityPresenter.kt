package com.example.minilist.edit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.example.minilist.main.MainPresenter.FILE_NAME;

public class EditActivityPresenter {

    private final EditActivity wireframe;

    EditActivityPresenter(EditActivity wireframe) {
        this.wireframe = wireframe;
        File source = new File(wireframe.getFilesDir(), FILE_NAME);
        if (source.exists()) {
            try (Scanner in = new Scanner(source)) {
                this.wireframe.setText(in.useDelimiter("\\Z").next());
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void saveText(String text) {
        File file = new File(wireframe.getFilesDir(), FILE_NAME);
        if (text.isEmpty()) {
            //del
            file.delete();
        } else {
            //save
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                out.write(text);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }


}
