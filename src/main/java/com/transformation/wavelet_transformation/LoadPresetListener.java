/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transformation.wavelet_transformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;

/**
 *
 * @author olega
 */
public class LoadPresetListener implements ActionListener {

    
    @Override
    public void actionPerformed(ActionEvent e) {
        MainDrawPanel.frame.setBounds(0,0,500,500);
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.showOpenDialog(MainDrawPanel.frame);
        File file =dialog.getSelectedFile();
        if (dialog.getSelectedFile().exists()){
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)))){
                //String line;
                /*while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }*/
                MainDrawPanel.AField.setText(reader.readLine());
                MainDrawPanel.BField.setText(reader.readLine());
                MainDrawPanel.CField.setText(reader.readLine());
                MainDrawPanel.alphaField.setText(reader.readLine());
                MainDrawPanel.betaField.setText(reader.readLine());
                MainDrawPanel.sigmaField.setText(reader.readLine());
                MainDrawPanel.deltaField.setText(reader.readLine());
                MainDrawPanel.qField.setText(reader.readLine());
                MainDrawPanel.NaField.setText(reader.readLine());
                MainDrawPanel.NbField.setText(reader.readLine());
                MainDrawPanel.NcField.setText(reader.readLine());
                MainDrawPanel.aField.setText(reader.readLine());
                MainDrawPanel.bField.setText(reader.readLine());
                reader.close();
            } catch (IOException ex) {
                // log error
                ex.getMessage();

            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
