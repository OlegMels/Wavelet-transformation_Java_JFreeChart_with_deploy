/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transformation.wavelet_transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Глеб
 */
public class ImageCanvas {
    
    protected static JComponent paintImage(){
        
        double scale = 2;
        
        int canvasHeight = (int) Math.round(scale*WaveletTransformations.Nb+2);
        int canvasWidth = (int) Math.round(scale*WaveletTransformations.Nc+2);
        
        surface = new BufferedImage(canvasHeight, canvasWidth, BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(surface));
        
        JPanel drawPanel = new JPanel(false);
        drawPanel.setLayout(new BorderLayout());                                // (int hgap, int vgap)
        drawPanel.add(view);
        
        Graphics g = surface.getGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0,0, canvasHeight, canvasWidth);
        

        double bn = -WaveletTransformations.B;
        double hb = 2*WaveletTransformations.B/WaveletTransformations.Nb;
        double an;
        double ha = 2*WaveletTransformations.C/WaveletTransformations.Nc;
        int array[] = new int[(int)Math.round(WaveletTransformations.Nb*WaveletTransformations.Nc)];
        boolean flagErr = true;
        int count = 0, min = 0, max = 0;
        for(int n = 0; n < WaveletTransformations.Nb; n++){
            bn += hb;
            an = -WaveletTransformations.C;
            for(int l = 0; l < WaveletTransformations.Nc; l++){
                an += ha;
                int value =  (int)Math.round(WaveletTransformations.F(an, bn)*1000);
                if(min > value) min = value;
                if(max < value) max = value;
                array[count] = value;
                count++;
            }
        }
        
        double rangeScale;
        if((max-min) > 0)
        rangeScale = 255.0/(max-min) ;
        else rangeScale = -255.0/(max-min) ;
        int bottomGap = min;
        if(min < 0) bottomGap = -min;
        System.out.println("mx "+max+", mn "+min+", rng "+rangeScale+", btm "+bottomGap);
        count = 0;
        for(int n = 0; n < WaveletTransformations.Nb; n++){
            for(int l = 0; l < WaveletTransformations.Nc; l++){
                try{
                    int value = (int)Math.round((bottomGap + array[count])*rangeScale);
                    if((count / 100) == 0)
                        System.out.print(value+" ,");
                    count++;
                    g.setColor(new Color(value, value, value));
                    int intScale = (int) Math.round(scale);
                    g.fillRect(intScale*n, intScale*l, intScale, intScale);
                    }
                catch(Exception e){
                    if(flagErr) {System.out.println("out of color range");
                    flagErr = false;
                    }
                    
                    
                }
            }
        }
        System.out.println();
        return drawPanel;
    }
    
    protected static JComponent paintImage1(){
        
        double scale = 2;
        
        int canvasHeight = (int) Math.round(scale*WaveletTransformations.Nb+2);
        int canvasWidth = (int) Math.round(scale*WaveletTransformations.Nc+2);
        
        surface = new BufferedImage(canvasHeight, canvasWidth, BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(surface));
        
        JPanel drawPanel = new JPanel(false);
        drawPanel.setLayout(new BorderLayout());                                // (int hgap, int vgap)
        drawPanel.add(view);
        
        Graphics g = surface.getGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0,0, canvasHeight, canvasWidth);
        

        double bn = -WaveletTransformations.B;
        double hb = 2*WaveletTransformations.B/WaveletTransformations.Nb;
        double an;
        double ha = 2*WaveletTransformations.C/WaveletTransformations.Nc;
        int array[] = new int[(int)Math.round(WaveletTransformations.Nb*WaveletTransformations.Nc)];
        boolean flagErr = true;
        int count = 0, min = 0, max = 0;
        for(int n = 0; n < WaveletTransformations.Nb; n++){
            bn += hb;
            an = -WaveletTransformations.C;
            for(int l = 0; l < WaveletTransformations.Nc; l++){
                an += ha;
                int value =  (int)Math.round(WaveletTransformations.F1(an, bn)*1000);
                if(min > value) min = value;
                if(max < value) max = value;
                array[count] = value;
                count++;
            }
        }
        double rangeScale;
        if((max-min) > 0)
        rangeScale = 255.0/(max-min) ;
        else rangeScale = -255.0/(max-min) ;
        int bottomGap = min;
        if(min < 0) bottomGap = -min;
        System.out.println("mx "+max+", mn "+min+", rng "+rangeScale+", btm "+bottomGap);
        count = 0;
        for(int n = 0; n < WaveletTransformations.Nb; n++){
            for(int l = 0; l < WaveletTransformations.Nc; l++){
                try{
                    int value = (int)Math.round((bottomGap + array[count])*rangeScale);
                    if((count / 100) == 0)
                        System.out.print(value+" ,");
                    count++;
                    g.setColor(new Color(value, value, value));
                    int intScale = (int) Math.round(scale);
                    g.fillRect(intScale*n, intScale*l, intScale, intScale);
                    }
                catch(Exception e){
                    if(flagErr) {System.out.println("out of color range");
                    flagErr = false;
                    }
                    
                    
                }
            }
        }
        System.out.println();
        return drawPanel;
    }
    
    private static JLabel view;
    private static BufferedImage surface;
    
}
