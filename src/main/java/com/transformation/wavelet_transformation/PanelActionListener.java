/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transformation.wavelet_transformation;

import java.awt.event.ActionEvent;
import com.transformation.wavelet_transformation.MainDrawPanel;
import java.awt.event.ActionListener;
/**
 *
 * @author Глеб
 */
public class PanelActionListener implements ActionListener {
        
    @Override
    public void actionPerformed(ActionEvent e) {
        // try{
        MainDrawPanel.text_out.setText("" + e.getActionCommand());

        if (!MainDrawPanel.AField.getText().isEmpty()) {
            WaveletTransformations.A = Double.parseDouble(MainDrawPanel.AField.getText());
        }

        if (!MainDrawPanel.NaField.getText().isEmpty()) {
            WaveletTransformations.Na = Double.parseDouble(MainDrawPanel.NaField.getText());
        }

        if (!MainDrawPanel.alphaField.getText().isEmpty()) {
            WaveletTransformations.alpha = Double.parseDouble(MainDrawPanel.alphaField.getText());
        }
        
        //if (!betaField.getText().isEmpty()) {
            WaveletTransformations.beta = Double.parseDouble(MainDrawPanel.betaField.getText());
        //}
        
        if (!MainDrawPanel.deltaField.getText().isEmpty()) {
            WaveletTransformations.delta = Double.parseDouble(MainDrawPanel.deltaField.getText());
        }
        
        if (!MainDrawPanel.qField.getText().isEmpty()) {
            WaveletTransformations.q = Double.parseDouble(MainDrawPanel.qField.getText());
        }
        
        if (!MainDrawPanel.sigmaField.getText().isEmpty()) {
            WaveletTransformations.sigma = Double.parseDouble(MainDrawPanel.sigmaField.getText());
        }
        if (!MainDrawPanel.aField.getText().isEmpty()) {
            WaveletTransformations.a = Double.parseDouble(MainDrawPanel.aField.getText());
        }
        if (!MainDrawPanel.bField.getText().isEmpty()) {
            WaveletTransformations.b = Double.parseDouble(MainDrawPanel.bField.getText());
        }
        if (!MainDrawPanel.BField.getText().isEmpty()) {
            WaveletTransformations.B = Double.parseDouble(MainDrawPanel.BField.getText());
        }
        if (!MainDrawPanel.CField.getText().isEmpty()) {
            WaveletTransformations.C = Double.parseDouble(MainDrawPanel.CField.getText());
        }
        if (!MainDrawPanel.NbField.getText().isEmpty()) {
            WaveletTransformations.Nb = Double.parseDouble(MainDrawPanel.NbField.getText());
        }
        if (!MainDrawPanel.NcField.getText().isEmpty()) {
            WaveletTransformations.Nc = Double.parseDouble(MainDrawPanel.NcField.getText());
        }

        if(!(MainDrawPanel.fChart == null &&
             MainDrawPanel.psi1Chart == null && 
             MainDrawPanel.psi2Chart == null && 
             MainDrawPanel.F1Chart == null && 
             MainDrawPanel.F2Chart == null))
            MainDrawPanel.tabbedPane.removeAll();
        if (WaveletTransformations.A != 0 && WaveletTransformations.Na != 0) { // && alpha != 0 && delta != 0 && q != 0
            MainDrawPanel.tabbedPane.addTab("f(x)", MainDrawPanel.fillFChartPanel());
            if(WaveletTransformations.sigma != 0){
                MainDrawPanel.tabbedPane.addTab("psi1(x)", MainDrawPanel.fillPsi1ChartPanel());
                MainDrawPanel.tabbedPane.addTab("psi2(x)", MainDrawPanel.fillPsi2ChartPanel());
                if(WaveletTransformations.B != 0 && WaveletTransformations.C != 0 && 
                   WaveletTransformations.Nb != 0 && WaveletTransformations.Nc != 0){
                    MainDrawPanel.tabbedPane.addTab("F(a, bn)", MainDrawPanel.fillF1ChartPanel());
                    MainDrawPanel.tabbedPane.addTab("F(an, b)", MainDrawPanel.fillF2ChartPanel());
                    MainDrawPanel.tabbedPane.addTab("F(an, bm)", ImageCanvas.paintImage());
                    MainDrawPanel.tabbedPane.addTab("F(an, bm)", ImageCanvas.paintImage1());
                
                }        
            }
        }
    }
    
    
    
}
