
package com.transformation.wavelet_transformation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Глеб
 */
public class MainDrawPanel extends JPanel {
    

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

    
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new MainDrawPanel(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    MainDrawPanel(){
        
        super(new GridLayout(1, 1));
        
        tabbedPane = new JTabbedPane();
        JSplitPane verticalSplitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, makeFieldsPanelWithGridLayout());
        verticalSplitPanel.setDividerLocation(500);
        this.add(verticalSplitPanel);
        
    }
    
    protected JComponent makeFieldsPanelWithGridLayout() {
        
        
        fieldsPanel = new JPanel(false);
        fieldsPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        JPanel hPanel = new JPanel(false);
        
        GridLayout gridLayout =  new GridLayout(0, 8);
        hPanel.setLayout(gridLayout);

        hPanel.add(new JLabel("A :"));
        hPanel.add(AField);
        hPanel.add(new JLabel("Na :"));
        hPanel.add(NaField);
        hPanel.add(new JLabel("alpha :"));
        hPanel.add(alphaField);
        hPanel.add(new JLabel("delta :"));
        hPanel.add(deltaField);
        hPanel.add(new JLabel("beta :"));
        hPanel.add(betaField);
        hPanel.add(new JLabel("sigma :"));
        hPanel.add(sigmaField);
        hPanel.add(new JLabel("q :"));
        hPanel.add(qField);
        hPanel.add(new JLabel(""));
        hPanel.add(new JLabel(""));
        hPanel.add(new JLabel("B :"));
        hPanel.add(BField);
        hPanel.add(new JLabel("C :"));
        hPanel.add(CField);
        hPanel.add(new JLabel("Nb :"));
        hPanel.add(NbField);
        hPanel.add(new JLabel("Nc :"));
        hPanel.add(NcField);
        hPanel.add(new JLabel("a :"));
        hPanel.add(aField);
        hPanel.add(new JLabel("b :"));
        hPanel.add(bField);
        
        AField.setText("10");
        NaField.setText("100");
        alphaField.setText("2");
        betaField.setText("2");
        qField.setText("1");
        sigmaField.setText("1");
        deltaField.setText("3");
        deltaField.setText("2");
        BField.setText("15");
        CField.setText("10");
        NbField.setText("500");
        NcField.setText("250");
        aField.setText("1");
        bField.setText("6");
        
        fieldsPanel.add(hPanel);
        hPanel.add(redrawButton = new JButton(" Redraw Plots! "));
        hPanel.add(savePresetBtn = new JButton(" Save Preset"));
        hPanel.add(loadPresetBtn = new JButton(" Load Preset "));
        text_out.setText("1_demo_record");
        hPanel.add(text_out);
        redrawButton.addActionListener(new PanelActionListener());
        savePresetBtn.addActionListener(new SavePresetListener());
        loadPresetBtn.addActionListener(new LoadPresetListener());
        return fieldsPanel;
    }
    
    
    protected static ChartPanel fillFChartPanel() {
        fSeries = new XYSeries("f(x)");

        double x = -WaveletTransformations.A;
        double h = 2 * WaveletTransformations.A / WaveletTransformations.Na;
        for (int k = 0; k < WaveletTransformations.Na; k++) {
            x += h;
            fSeries.add(x, WaveletTransformations.f(x));
        }
        fDataset = new XYSeriesCollection();
        fDataset.addSeries(fSeries);
        return fChart = new ChartPanel(ChartFactory.createXYLineChart("", "x", " f(x)", fDataset, PlotOrientation.VERTICAL, true, true, false));
    }

    protected static ChartPanel fillPsi1ChartPanel() {
        psi1Series = new XYSeries("");

        double x = -WaveletTransformations.A;
        double h = 2 * WaveletTransformations.A / WaveletTransformations.Na;
        for (int k = 0; k < WaveletTransformations.Na; k++) {
            x += h;
            psi1Series.add(x, WaveletTransformations.psi1(x));
        }
        psi1Dataset = new XYSeriesCollection();
        psi1Dataset.addSeries(psi1Series);
        return psi1Chart = new ChartPanel(ChartFactory.createXYLineChart("", "x", " psi1(x)", psi1Dataset, PlotOrientation.VERTICAL, true, true, false));

    }

    protected static ChartPanel fillPsi2ChartPanel() {
        psi2Series = new XYSeries("");

        double x = -WaveletTransformations.A;
        double h = 2 * WaveletTransformations.A / WaveletTransformations.Na;
        for (int k = 0; k < WaveletTransformations.Na; k++) {
            x += h;
            psi2Series.add(x, WaveletTransformations.psi2(x));
        }
        psi2Dataset = new XYSeriesCollection();
        psi2Dataset.addSeries(psi2Series);
        return psi2Chart = new ChartPanel(ChartFactory.createXYLineChart("", "x", " psi2(x)", psi2Dataset, PlotOrientation.VERTICAL, true, true, false));

    }

    protected static ChartPanel fillF1ChartPanel() {
        F1Psi1Series = new XYSeries("Psi1");
        F1Psi2Series = new XYSeries("Psi2");
        
        double bn = -WaveletTransformations.B;
        double hb = 2 * WaveletTransformations.B / WaveletTransformations.Nb;
        
        for(int n = 0; n < WaveletTransformations.Nb; n++){
            bn += hb;
            F1Psi1Series.add( bn, WaveletTransformations.F(WaveletTransformations.a, bn));
            F1Psi2Series.add( bn, WaveletTransformations.FF(WaveletTransformations.a, bn));
        }
        F1Dataset = new XYSeriesCollection();
        F1Dataset.addSeries(F1Psi1Series);
        F1Dataset.addSeries(F1Psi2Series);
        return F1Chart = new ChartPanel(ChartFactory.createXYLineChart("", "x", "F(a,bn)", F1Dataset, PlotOrientation.VERTICAL, true, true, false));
    }

    protected static ChartPanel fillF2ChartPanel() {
        F2Psi1Series = new XYSeries("Psi1");
        F2Psi2Series = new XYSeries("Psi2");
        
        double an = -WaveletTransformations.C;
        double hc = 2 * WaveletTransformations.C / WaveletTransformations.Nc;
        
        for (int n = 0; n < WaveletTransformations.Nc; n++){
            an += hc;
            F2Psi1Series.add(an, WaveletTransformations.F(an, WaveletTransformations.b));
            F2Psi2Series.add(an, WaveletTransformations.FF(an, WaveletTransformations.b));
        }
        F2Dataset = new XYSeriesCollection();
        F2Dataset.addSeries(F2Psi1Series);
        F2Dataset.addSeries(F2Psi2Series);
        return F2Chart = new ChartPanel(ChartFactory.createXYLineChart("", "x", "F(an, b)", F2Dataset, PlotOrientation.VERTICAL, true, true, false));
        
    }

    protected static JFrame frame;
    protected static JPanel fChartPanel, psi1ChartPanel, psi2ChartPanel, F1ChartPanel, F2ChartPanel, F3ChartPanel, fieldsPanel;
    protected static ChartPanel fChart, psi1Chart, psi2Chart, F1Chart, F2Chart, F3Chart;
    protected static JTabbedPane tabbedPane;
    protected static JTextField AField = new JTextField(7), BField = new JTextField(7), CField = new JTextField(7), 
               alphaField = new JTextField(7), betaField = new JTextField(7), sigmaField = new JTextField(7), 
               deltaField = new JTextField(7), qField = new JTextField(7), 
               NaField = new JTextField(7), NbField = new JTextField(7), NcField = new JTextField(7),
               aField = new JTextField(7), bField = new JTextField(7);
    protected static JTextArea text_out = new JTextArea();
    protected static JButton redrawButton,savePresetBtn,loadPresetBtn;
    protected static XYSeriesCollection fDataset, psi1Dataset, psi2Dataset, F1Dataset, F2Dataset, F3Dataset;
    protected static XYSeries fSeries, psi1Series, psi2Series, F1Psi1Series, F1Psi2Series, F2Psi1Series, F2Psi2Series, F3Series;
    
    protected static final int DEFAULT_WIDTH = 950;
    protected static final int DEFAULT_HEIGHT = 600;
    
    //
    static JSlider sliderA, sliderB, colorScaleSlider;
    //
    
}
