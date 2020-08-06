import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CurlCurrent extends JPanel {
    public static double max = 0;

    CurlCurrent() {
        setSize(800,600);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke = new BasicStroke(4);
        g2.setStroke(stroke);
        g2.drawLine(150,300,750,300);
        g2.drawLine(150,550,150,50);
        int j = (int) Math.round(Main.sa/Circuit.dt);
        int a;
        int k = (int) Math.round(Main.ea/Circuit.dt);

        ArrayList<Double> initial = new ArrayList<Double>();
        for (a=j; a<k+1; a++)
            initial.add(Main.element.currents.get(a));
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        x.add(150);
        y.add(300);
        Double d2 = Double.valueOf(initial.size());
        for (a=0; a<initial.size(); a++) {
            try {
                Double d = Double.valueOf(a);
                x.add((int) Math.round((d + 1) / d2 * 580 + 150));
                y.add((int) Math.round(-initial.get(a)/max*220+300));
            } catch (Exception e) { y.add(300); }
        }
        g.setColor(Color.RED);
        Stroke s = new BasicStroke(2);
        ((Graphics2D) g).setStroke(s);
        for (a=1; a<x.size(); a++)
            g.drawLine(x.get(a-1),y.get(a-1),x.get(a),y.get(a));


    }

    public static void pass( ) {
        JFrame frame = new JFrame("CURRENT");
        frame.setSize(800,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("CURRENT OF " + Main.element.name);
        frame.add(label);
        label.setBounds(50,20,100,20);
        JLabel labelA = new JLabel(String.format("%.4f",Main.sa));
        JLabel labelB = new JLabel(String.format("%.4f",(Main.sa+Main.ea)/2));
        JLabel labelC = new JLabel(String.format("%.4f",Main.ea));
        frame.add(labelA);
        frame.add(labelB);
        frame.add(labelC);
        labelA.setBounds(155,305,100,20);
        labelB.setBounds(440,305,100,20);
        labelC.setBounds(730,305,100,20);

        int j = (int) Math.round(Main.sa/Circuit.dt);
        int a;
        int k = (int) Math.round(Main.ea/Circuit.dt);
        max = 0;
        for (a=j ; a<k+1; a++) {
            if (Math.abs(Main.element.currents.get(a)) > max)
                max = Math.abs(Main.element.currents.get(a));
        }
        //if (Main.element.currents.get(j) != 0 || Main.element.currents.get(k) != 0)
        //    max = Math.max(Math.abs(Main.element.currents.get(j))
        //            , Math.abs(Main.element.currents.get(k)));


        if (max != 0) {
            JLabel labelM1 = new JLabel(String.format("%.4f",max), SwingConstants.RIGHT);
            frame.add(labelM1);
            labelM1.setBounds(30, 70, 110, 20);
            JLabel labelM2 = new JLabel(String.format("%.4f",-max), SwingConstants.RIGHT);
            frame.add(labelM2);
            labelM2.setBounds(30, 510, 110, 20);
            JLabel labelM3 = new JLabel(String.format("%.4f",0.0000), SwingConstants.RIGHT);
            frame.add(labelM3, SwingConstants.RIGHT);
            labelM3.setBounds(30, 290, 110, 20);
        }
        else {
            JLabel labelM1 = new JLabel(String.format("%.4f",0.0000), SwingConstants.RIGHT);
            frame.add(labelM1, SwingConstants.RIGHT);
            labelM1.setBounds(30, 290, 110, 20);
        }

        JPanel current = new CurlCurrent();
        frame.add(current);
    }

}
