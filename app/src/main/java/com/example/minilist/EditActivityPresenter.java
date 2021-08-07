package com.example.minilist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.minilist.MainPresenter.FILE_NAME;

public class EditActivityPresenter {

    private final EditActivity wireframe;

    private String text;

    EditActivityPresenter(EditActivity wireframe) {
        this.wireframe = wireframe;
        File source = new File(wireframe.getFilesDir(), FILE_NAME);
        if (source.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                text = stringBuilder.toString();
                this.wireframe.setText(text);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                //откинуть снэк о невозможности чтения, СТОП, а это возможно в этом случае? хотя почему бы и нет
            }
        } else {
            text = "";
        }
    }

    public void saveText(String text) {
        File file = new File(wireframe.getFilesDir(), FILE_NAME);
        if (text.isEmpty()) {
            //del
            if (file.exists()) {
                file.delete();
            }
        } else {
            //save
            if (!text.equals(this.text)) {
                try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                    out.write(text);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


}
