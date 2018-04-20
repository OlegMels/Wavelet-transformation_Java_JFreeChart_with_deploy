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
public class SavePresetListener implements ActionListener {
    //AField, BField, CField, alphaField, betaField, sigmaField, deltaField, qField, NaField, NbField, NcField, aField, bField;
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainDrawPanel.AField.getText();
        MainDrawPanel.frame.setBounds(0,0,500,500);
        JFileChooser dialog = new JFileChooser();

        //dialog.setFileSelectionMode(dialog.showSaveDialog(dialog));
        dialog.showSaveDialog(MainDrawPanel.frame);
        //if (dialog.getSelectedFile().exists()){
            File file =dialog.getSelectedFile();
             try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file)))){
                //String line;
                /*while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }*/
                if ((!MainDrawPanel.AField.getText().isEmpty())
                        &&(!MainDrawPanel.BField.getText().isEmpty())
                        &&(!MainDrawPanel.CField.getText().isEmpty())
                        &&(!MainDrawPanel.alphaField.getText().isEmpty())
                        &&(!MainDrawPanel.betaField.getText().isEmpty())
                        &&(!MainDrawPanel.sigmaField.getText().isEmpty())
                        &&(!MainDrawPanel.deltaField.getText().isEmpty())
                        &&(!MainDrawPanel.qField.getText().isEmpty())
                        &&(!MainDrawPanel.NaField.getText().isEmpty())
                        &&(!MainDrawPanel.NbField.getText().isEmpty())
                        &&(!MainDrawPanel.NcField.getText().isEmpty())
                        &&(!MainDrawPanel.aField.getText().isEmpty())
                        &&(!MainDrawPanel.bField.getText().isEmpty())
                        ) {


                    String s=MainDrawPanel.AField.getText()+ " \n";
                    writer.write(s);
                    writer.write(MainDrawPanel.BField.getText()+ " \n");
                    writer.write(MainDrawPanel.CField.getText()+ " \n");
                    writer.write(MainDrawPanel.alphaField.getText()+ " \n");
                    writer.write(MainDrawPanel.betaField.getText()+ " \n");
                    writer.write(MainDrawPanel.sigmaField.getText()+ " \n");
                    writer.write(MainDrawPanel.deltaField.getText()+ " \n");
                    writer.write(MainDrawPanel.qField.getText()+ " \n");
                    writer.write(MainDrawPanel.NaField.getText()+ " \n");
                    writer.write(MainDrawPanel.NbField.getText()+ " \n");
                    writer.write(MainDrawPanel.NcField.getText()+ " \n");
                    writer.write(MainDrawPanel.aField.getText()+ " \n");
                    writer.write(MainDrawPanel.bField.getText()+ " \n");
                    writer.flush();
                    writer.close();
                }
            } catch (IOException ex) {
                // log error


                ex.getMessage();
            }
        //}
    }
    
}
