/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uploadfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author cesar
 */
//@ManagedBean(name = "fileupload")
@Named("fileupload")
@RequestScoped
public class FileUpload {

    private Part file;
    private String text;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
        if (null != file) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String string = reader.readLine();
                StringBuilder builder = new StringBuilder();

                while (string != null) {
                    builder.append(string);
                    string = reader.readLine();
                }

                text = builder.toString();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);

            }
            System.out.println("archivo de lectura completo");
        } else {
            System.out.println("esto es nulo");
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
