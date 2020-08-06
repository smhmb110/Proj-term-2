import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {

    public static JFrame frame1;
    public static JFileChooser fileChooser;
    public static int fileChooserAct = Integer.MIN_VALUE;
    public static int runAct;
    public static String codes = "";
    public static String address;
    public static JTextArea codeArea;
    public static File file1;
    public static JComboBox comboBox;
    public static JTextField startText;
    public static JTextField endText;
    public static double sa;
    public static double ea;
    public static Element element;

    public static void main(String args[]) {
        playFrame(args);
    }

    public static void playFrame(String[] args) {
        frame1 = new JFrame("Electrical Circuit:)))");
        frame1.setVisible(false);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setBounds(0,0,600,700);
        Container container = frame1.getContentPane();
        container.setBackground(Color.GRAY);
        LayoutManager mgr = new GroupLayout(container);
        frame1.setLayout(mgr);
        //ImageIcon iconRun = new ImageIcon("C:\\Users\\Owner\\Desktop" +
        //        "\\Sharif University\\OOP- term 2\\Proj-term-2\\src\\run.png");
        //ImageIcon iconLoad = new ImageIcon("C:\\Users\\Owner\\Desktop" +
        //        "\\Sharif University\\OOP- term 2\\Proj-term-2\\src\\load.png");
        //ImageIcon iconDraw = new ImageIcon("C:\\Users\\Owner\\Desktop" +
        //        "\\Sharif University\\OOP- term 2\\Proj-term-2\\src\\draw.png");
        JButton run = new JButton("RUN");
        JButton load = new JButton("LOAD");
        JButton draw = new JButton("DRAW");
        load.setBounds(185,5,70,40);
        run.setBounds(265,5,70,40);
        draw.setBounds(345,5,70,40);
        frame1.add(run);
        frame1.add(load);
        frame1.add(draw);

        comboBox = new JComboBox();
        comboBox.setBounds(425,15,100,20);
        frame1.add(comboBox);
        JLabel labelStart = new JLabel("Start:");
        JLabel labelEnd = new JLabel("End:");
        JPanel startP = new JPanel();
        JPanel endP = new JPanel();
        startText = new JTextField();
        endText = new JTextField();
        startText.setBounds(65,5,100,15);
        endText.setBounds(65,30,100,15);
        frame1.add(startText);
        frame1.add(endText);
        frame1.add(labelStart);
        frame1.add(labelEnd);
        /*startP.add(labelStart);
        startP.add(startText);
        frame1.add(startP);
        endP.add(labelEnd);
        endP.add(endText);
        frame1.add(endP);*/
        labelStart.setBounds(15,5,40,15);
        labelEnd.setBounds(15,30,40,15);




        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FileWriter fileWriter = new FileWriter(file1);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(codeArea.getText());
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {

                } catch (NullPointerException e) {

                }
                try {
                    runAct = Circuit.initial(codeArea.getText());
                } catch (IOException e) {

                }
                if (runAct == 0)
                    JOptionPane.showMessageDialog(frame1,"ERROR: LINE OF 1","پیغام خطا",JOptionPane.ERROR_MESSAGE);
                else if (runAct < 0)
                    JOptionPane.showMessageDialog(frame1,"ERROR " + runAct
                            ,"پیغام خطا",JOptionPane.ERROR_MESSAGE);
                else if (runAct > 1)
                    JOptionPane.showMessageDialog(frame1,"ERROR: LINE OF " + runAct
                            ,"پیغام خطا",JOptionPane.ERROR_MESSAGE);
                else if (runAct == 1) {
                    //System.out.println("END...");
                    comboBox.removeAllItems();
                    int j;
                    for (j=0; j<Circuit.elements.size(); j++)
                        comboBox.addItem(Circuit.elements.get(j).name);
                    startText.setText("0");
                    endText.setText(String.valueOf(Circuit.tran));
                    GraphicsCircuit.pass(args);
                }
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File file = new File("c:\\");
                fileChooser = new JFileChooser(file,fsv);
                fileChooserAct = fileChooser.showSaveDialog(frame1);
                if (fileChooserAct == JFileChooser.APPROVE_OPTION) {
                    file1 = fileChooser.getSelectedFile();
                    try {
                        FileReader fileReader = new FileReader(file1);
                        BufferedReader br = new BufferedReader(fileReader);
                        String s = br.readLine();
                        codes = s;
                        while (s != null) {
                            s = br.readLine();
                            if (s != null)
                                codes = codes + "\n" + s;
                        }
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    } finally {
                        codeArea.setText(codes);
                    }
                }
            }
        });

        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBox.getItemCount() == 0)
                    JOptionPane.showMessageDialog(frame1,
                            "عنصری برای انتخاب وجود ندارد." + runAct
                            ,"پیغام خطا",JOptionPane.ERROR_MESSAGE);
                else {
                    element = Circuit.nameElementHM.get(comboBox.getSelectedItem());
                    sa = Circuit.quantification(startText.getText());
                    ea = Circuit.quantification(endText.getText());
                    if (Double.parseDouble(startText.getText()) == 0)
                        sa = 0;
                    if (Double.parseDouble(endText.getText()) == 0)
                        ea = 0;
                    CurlVoltage.pass();
                    CurlCurrent.pass();
                    CurlPower.pass();
                }

            }
        });

        codeArea = new JTextArea();
        JScrollPane codeScroll = new JScrollPane(codeArea);
        codeScroll.setBounds(10,50,565,600);
        container.add(codeScroll);
        frame1.setVisible(true);
    }
}