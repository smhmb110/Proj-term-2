import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphicsCircuit extends Application {


    static  final  int Width = 1500;
    static  final  int Height = 800;
    static  int k = 0;
    static  int k1 = 0;
    static  int k2 = 0;
    static  int k3 = 1;
    static int k4 = 1;
    static int k5 = 1;
    static int k6 = 1;
    static int k7 = 1;
    static int k8 = 1;
    static int k9 = 1;
    static int t = 0;
    static int x = 0;


    public static void pass(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        File file = new File(Main.fileChooser.getSelectedFile().getAbsolutePath());

        int[][] parallelElement = new int[100][100];
        int[][] mainBranch= new int[100][100];


////////////////////////////////////stage && scene////////////////////////////////////////////////////////////////
       /* Group g2 = new Group();
        Scene scene2 = new Scene(g2,Width,Height);
        stage.setScene(scene2);

        Button b1 = new Button("RUN");
        b1.setLayoutX(100);
        b1.setLayoutY(100);
        b1.setVisible(true);

        Button b2 = new Button("Draw");
        Button b3 = new Button("Output");
        g2.getChildren().addAll(b1,b2,b3);


        b1.setOnAction(e-> {
            stage.close();
                }*/

        Group g1 = new Group();
        Scene scene = new Scene(g1,Width,Height);
        stage.setTitle("Plotting Circuit");
        stage.setScene(scene);
        stage.show();

        Circle[][] circles = new Circle[6][6];

        circles[5][0] = new Circle(50,720,10);

        circles[5][1] = new Circle(300,720,10);

        circles[5][2] = new Circle(550,720,10);

        circles[5][3] = new Circle(800,720,10);

        circles[5][4] = new Circle(1050,720,10);

        circles[5][5] = new Circle(1300,720,10);


        circles[4][0] = new Circle(50,587,10);

        circles[4][1] = new Circle(300,587,10);

        circles[4][2] = new Circle(550,587,10);

        circles[4][3] = new Circle(800,587,10);

        circles[4][4] = new Circle(1050,587,10);
        ;
        circles[4][5] = new Circle(1300,587,10);


        circles[3][0] = new Circle(50,454,10);

        circles[3][1] = new Circle(300,454,10);

        circles[3][2] = new Circle(550,454,10);

        circles[3][3] = new Circle(800,454,10);

        circles[3][4] = new Circle(1050,454,10);

        circles[3][5] = new Circle(1300,454,10);


        circles[2][0] = new Circle(50,321,10);

        circles[2][1] = new Circle(300,321,10);

        circles[2][2] = new Circle(550,321,10);

        circles[2][3] = new Circle(800,321,10);

        circles[2][4] = new Circle(1050,321,10);

        circles[2][5] = new Circle(1300,321,10);


        circles[1][0] = new Circle(50,188,10);

        circles[1][1] = new Circle(300,188,10);

        circles[1][2] = new Circle(550,188,10);

        circles[1][3] = new Circle(800,188,10);

        circles[1][4] = new Circle(1050,188,10);

        circles[1][5] = new Circle(1300,188,10);


        circles[0][0] = new Circle(50,55,10);

        circles[0][1] = new Circle(300,55,10);

        circles[0][2] = new Circle(550,55,10);

        circles[0][3] = new Circle(800,55,10);

        circles[0][4] = new Circle(1050,55,10);

        circles[0][5] = new Circle(1300,55,10);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Scanner scr = new Scanner(file);
            do {
                String line = scr.nextLine();
                String[] result = line.split(" ");
                if(result.length > 3)
                {
                    t++;

                    result[1] = result[1].replaceAll("\\b1\\b","40");
                    result[2] = result[2].replaceAll("\\b1\\b","40");

                    result[1] = result[1].replaceAll("\\b2\\b","41");
                    result[2] = result[2].replaceAll("\\b2\\b","41");

                    result[1] = result[1].replaceAll("\\b3\\b","42");
                    result[2] = result[2].replaceAll("\\b3\\b","42");

                    result[1] = result[1].replaceAll("\\b4\\b","43");
                    result[2] = result[2].replaceAll("\\b4\\b","43");

                    result[1] = result[1].replaceAll("\\b5\\b","44");
                    result[2] = result[2].replaceAll("\\b5\\b","44");

                    result[1] = result[1].replaceAll("\\b6\\b","45");
                    result[2] = result[2].replaceAll("\\b6\\b","45");

                    result[1] = result[1].replaceAll("\\b7\\b","30");
                    result[2] = result[2].replaceAll("\\b7\\b","30");

                    result[1] = result[1].replaceAll("\\b8\\b","31");
                    result[2] = result[2].replaceAll("\\b8\\b","31");

                    result[1] = result[1].replaceAll("\\b9\\b","32");
                    result[2] = result[2].replaceAll("\\b9\\b","32");

                    result[1] = result[1].replaceAll("10","33");
                    result[2] = result[2].replaceAll("10","33");

                    result[1] = result[1].replaceAll("11","34");
                    result[2] = result[2].replaceAll("11","34");

                    result[1] = result[1].replaceAll("12","35");
                    result[2] = result[2].replaceAll("12","35");

                    result[1] = result[1].replaceAll("13","20");
                    result[2] = result[2].replaceAll("13","20");

                    result[1] = result[1].replaceAll("14","21");
                    result[2] = result[2].replaceAll("14","21");

                    result[1] = result[1].replaceAll("15","22");
                    result[2] = result[2].replaceAll("15","22");

                    result[1] = result[1].replaceAll("16","23");
                    result[2] = result[2].replaceAll("16","23");

                    result[1] = result[1].replaceAll("17","24");
                    result[2] = result[2].replaceAll("17","24");

                    result[1] = result[1].replaceAll("18","25");
                    result[2] = result[2].replaceAll("18","25");

                    result[1] = result[1].replaceAll("19","10");
                    result[2] = result[2].replaceAll("19","10");

                    result[1] = result[1].replaceAll("20","11");
                    result[2] = result[2].replaceAll("20","11");

                    result[1] = result[1].replaceAll("21","12");
                    result[2] = result[2].replaceAll("21","12");

                    result[1] = result[1].replaceAll("22","13");
                    result[2] = result[2].replaceAll("22","13");

                    result[1] = result[1].replaceAll("23","14");
                    result[2] = result[2].replaceAll("23","14");

                    result[1] = result[1].replaceAll("24","15");
                    result[2] = result[2].replaceAll("24","15");

                    result[1] = result[1].replaceAll("25","00");
                    result[2] = result[2].replaceAll("25","00");

                    result[1] = result[1].replaceAll("26","01");
                    result[2] = result[2].replaceAll("26","01");

                    result[1] = result[1].replaceAll("27","02");
                    result[2] = result[2].replaceAll("27","02");

                    result[1] = result[1].replaceAll("28","03");
                    result[2] = result[2].replaceAll("28","03");

                    result[1] = result[1].replaceAll("29","04");
                    result[2] = result[2].replaceAll("29","04");

                    result[1] = result[1].replaceAll("30","05");
                    result[2] = result[2].replaceAll("30","05");

                    if(result[1].equals("0"))
                    {
                        result[1] = "5" + result[2].substring(1,result[2].length());
                    }
                    if(result[2].equals("0"))
                    {
                        result[2] = "5" + result[1].substring(1,result[1].length());
                    }

                    Scanner scr2 = new Scanner(file);
                    do {
                        String line4 = scr2.nextLine();
                        String[] result2 = line4.split(" ");
                        if(result2.length > 3)
                        {
                            result2[1] = result2[1].replaceAll("\\b1\\b","40");
                            result2[2] = result2[2].replaceAll("\\b1\\b","40");

                            result2[1] = result2[1].replaceAll("\\b2\\b","41");
                            result2[2] = result2[2].replaceAll("\\b2\\b","41");

                            result2[1] = result2[1].replaceAll("\\b3\\b","42");
                            result2[2] = result2[2].replaceAll("\\b3\\b","42");

                            result2[1] = result2[1].replaceAll("\\b4\\b","43");
                            result2[2] = result2[2].replaceAll("\\b4\\b","43");

                            result2[1] = result2[1].replaceAll("\\b5\\b","44");
                            result2[2] = result2[2].replaceAll("\\b5\\b","44");

                            result2[1] = result2[1].replaceAll("\\b6\\b","45");
                            result2[2] = result2[2].replaceAll("\\b6\\b","45");

                            result2[1] = result2[1].replaceAll("\\b7\\b","30");
                            result2[2] = result2[2].replaceAll("\\b7\\b","30");

                            result2[1] = result2[1].replaceAll("\\b8\\b","31");
                            result2[2] = result2[2].replaceAll("\\b8\\b","31");

                            result2[1] = result2[1].replaceAll("\\b9\\b","32");
                            result2[2] = result2[2].replaceAll("\\b9\\b","32");

                            result2[1] = result2[1].replaceAll("10","33");
                            result2[2] = result2[2].replaceAll("10","33");

                            result2[1] = result2[1].replaceAll("11","34");
                            result2[2] = result2[2].replaceAll("11","34");

                            result2[1] = result2[1].replaceAll("12","35");
                            result2[2] = result2[2].replaceAll("12","35");

                            result2[1] = result2[1].replaceAll("13","20");
                            result2[2] = result2[2].replaceAll("13","20");

                            result2[1] = result2[1].replaceAll("14","21");
                            result2[2] = result2[2].replaceAll("14","21");

                            result2[1] = result2[1].replaceAll("15","22");
                            result2[2] = result2[2].replaceAll("15","22");

                            result2[1] = result2[1].replaceAll("16","23");
                            result2[2] = result2[2].replaceAll("16","23");

                            result2[1] = result2[1].replaceAll("17","24");
                            result2[2] = result2[2].replaceAll("17","24");

                            result2[1] = result2[1].replaceAll("18","25");
                            result2[2] = result2[2].replaceAll("18","25");

                            result2[1] = result2[1].replaceAll("19","10");
                            result2[2] = result2[2].replaceAll("19","10");

                            result2[1] = result2[1].replaceAll("20","11");
                            result2[2] = result2[2].replaceAll("20","11");

                            result2[1] = result2[1].replaceAll("21","12");
                            result2[2] = result2[2].replaceAll("21","12");

                            result2[1] = result2[1].replaceAll("22","13");
                            result2[2] = result2[2].replaceAll("22","13");

                            result2[1] = result2[1].replaceAll("23","14");
                            result2[2] = result2[2].replaceAll("23","14");

                            result2[1] = result2[1].replaceAll("24","15");
                            result2[2] = result2[2].replaceAll("24","15");

                            result2[1] = result2[1].replaceAll("25","00");
                            result2[2] = result2[2].replaceAll("25","00");

                            result2[1] = result2[1].replaceAll("26","01");
                            result2[2] = result2[2].replaceAll("26","01");

                            result2[1] = result2[1].replaceAll("27","02");
                            result2[2] = result2[2].replaceAll("27","02");

                            result2[1] = result2[1].replaceAll("28","03");
                            result2[2] = result2[2].replaceAll("28","03");

                            result2[1] = result2[1].replaceAll("29","04");
                            result2[2] = result2[2].replaceAll("29","04");

                            result2[1] = result2[1].replaceAll("30","05");
                            result2[2] = result2[2].replaceAll("30","05");

                            if(result2[1].equals("0"))
                            {
                                result2[1] = "5" + result2[2].substring(1,result2[2].length());
                            }
                            if(result2[2].equals("0"))
                            {
                                result2[2] = "5" + result2[1].substring(1,result2[1].length());
                            }



                            if(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX())
                            {
                                Line line5 = new Line(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY(),circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX(),circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY());
                                line5.setStroke(Color.LIGHTGRAY);
                                line5.setStrokeWidth(1);
                                g1.getChildren().add(line5);
                            }
                            if(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY())
                            {
                                Line line5 = new Line(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY(),circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX(),circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY());
                                line5.setStroke(Color.LIGHTGRAY);
                                line5.setStrokeWidth(1);
                                g1.getChildren().add(line5);
                            }
                            if(result[1].equals(result2[1])
                                    && result[2].equals(result2[2])
                                    && ! result[0].equals(result2[0]))
                            {

                                if(parallelElement[Integer.parseInt(result2[1])][Integer.parseInt(result2[2])] == 0)
                                    t=1;

                                if(t==1 ||  parallelElement[Integer.parseInt(result2[1])][Integer.parseInt(result2[2])] != 1 )
                                {
                                    if(result2[0].substring(0,1).equals("V")
                                            || result2[0].substring(0,1).equals("v"))
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\V4.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k3);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);
                                            Line line1 = new Line(imageView.getX()-62.5*k3, imageView.getY(), imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k3++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\V1.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k3);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k3,imageView.getY(), imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k3++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\V2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k3);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k3, imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k3++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\V3.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k3);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k3, imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k3++;
                                        }


                                        //////////////////////////////////////
                                        k4++;
                                        k5++;
                                        k6++;
                                        k7++;
                                        k8++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("L")
                                            || result2[0].substring(0,1).equals("l"))
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\L2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k4);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k4, imageView.getY(), imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+10);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k4++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\L2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k4);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k4, imageView.getY(), imageView.getX(),imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+10);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k4++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\L.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k4-10);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k4+10, imageView.getX(),imageView.getY()+10);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+10 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k4++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\L.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k4-10);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k4+10, imageView.getX(),imageView.getY()+10);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+10 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k4++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k5++;
                                        k6++;
                                        k7++;
                                        k8++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("C")
                                            || result2[0].substring(0,1).equals("c"))
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\C2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k5-7);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k5+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+50);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k5++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\C2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k5-7);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k5+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+50);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k5++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\C.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-7-44.4*k5);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k5+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+50 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k5++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\C.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-7-44.4*k5);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k5+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+50 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k5++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k4++;
                                        k6++;
                                        k7++;
                                        k8++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("D") == true)
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\D4.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k6-7);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k6+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+50);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k6++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\D3.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k6-7);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k6+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+50);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k6++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\D2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k6-7);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k6+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+50 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k6++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\D1.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k6-7);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k6+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+50 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k6++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k4++;
                                        k5++;
                                        k7++;
                                        k8++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("R")
                                            || result2[0].substring(0,1).equals("r"))
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\R2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k7-7);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k7+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k7++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\R2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k7-7);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k7+7, imageView.getY(), imageView.getX()+7,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k7++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\R.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k7-7);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k7+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k7++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\R.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k7-7);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k7+7, imageView.getX(),imageView.getY()+7);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k7++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k4++;
                                        k5++;
                                        k6++;
                                        k8++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("I")
                                            || result2[0].substring(0,1).equals("i"))
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\I2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k8-18);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k8+18, imageView.getY(), imageView.getX()+18,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k8++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\I1.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k8-18);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k8+18,imageView.getY(), imageView.getX()+18,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k8++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\I3.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k8-18);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k8+18, imageView.getX(),imageView.getY()+18);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k8++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\I4.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k8-18);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k8+18, imageView.getX(),imageView.getY()+18);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k8++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k4++;
                                        k5++;
                                        k6++;
                                        k7++;
                                        k9++;
                                    }
                                    else if(result2[0].substring(0,1).equals("F") == true || result2[0].substring(0,1).equals("G") == true || result2[0].substring(0,1).equals("H") == true || result2[0].substring(0,1).equals("E") == true
                                            ||result2[0].substring(0,1).equals("f") == true || result2[0].substring(0,1).equals("g") == true || result2[0].substring(0,1).equals("h") == true || result2[0].substring(0,1).equals("e") == true)
                                    {
                                        FileInputStream fileInputStream = null;

                                        if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\GEFH2.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+62.5*k9-18);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k9+18, imageView.getY(), imageView.getX()+18,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);

                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k9++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) )
                                        {
                                            fileInputStream = new FileInputStream("E:\\Elements\\GEFH1.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+62.5*k9-18);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()+45);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX()-62.5*k9+18,imageView.getY(), imageView.getX()+18,imageView.getY());
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(),line1.getEndX(), line1.getEndY() + image.getHeight()+25);
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getStartX(),line2.getEndY(),line1.getStartX(),line2.getEndY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k9++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() > circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\GEFH4.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()-44.4*k9-18);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k9+18, imageView.getX(),imageView.getY()+18);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k9++;
                                        }
                                        else if( (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY() == circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterY()) && (circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX() < circles[Integer.parseInt(result2[2].substring(0,result2[2].length()-1))][Integer.parseInt(result2[2].substring(1,result2[2].length()))].getCenterX()) )
                                        {

                                            fileInputStream = new FileInputStream("E:\\Elements\\GEFH3.PNG");
                                            Image image = new Image(fileInputStream);
                                            ImageView imageView = new ImageView(image);
                                            imageView.setX(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterX()+100);
                                            imageView.setY(circles[Integer.parseInt(result2[1].substring(0,result2[1].length()-1))][Integer.parseInt(result2[1].substring(1,result2[1].length()))].getCenterY()-44.4*k9-18);
                                            g1.getChildren().add(imageView);

                                            Line line1 = new Line(imageView.getX(),imageView.getY()+44.4*k9+18, imageView.getX(),imageView.getY()+18);
                                            line1.setStroke(Color.LIGHTGRAY);
                                            line1.setStrokeWidth(1);
                                            g1.getChildren().add(line1);


                                            Line line2 = new Line(line1.getEndX(), line1.getEndY(), line1.getEndX() + image.getWidth()+25 ,line1.getEndY());
                                            line2.setStroke(Color.LIGHTGRAY);
                                            line2.setStrokeWidth(1);
                                            g1.getChildren().add(line2);

                                            Line line3 = new Line(line2.getEndX(),line2.getEndY(),line2.getEndX(),line1.getStartY());
                                            line3.setStroke(Color.LIGHTGRAY);
                                            line3.setStrokeWidth(1);
                                            g1.getChildren().add(line3);
                                            k9++;
                                        }
                                        //////////////////////////////////////
                                        k3++;
                                        k4++;
                                        k5++;
                                        k6++;
                                        k7++;
                                        k8++;
                                    }
                                }
                                parallelElement[Integer.parseInt(result2[1])][Integer.parseInt(result2[2])] = 1;
                            }
                        }
                    }
                    while (scr2.hasNextLine());

                    k++;
                    k3=1;
                    k4=1;
                    k5=1;
                    k6=1;
                    k7=1;
                    k8=1;
                    k9=1;
                    if(mainBranch[Integer.parseInt(result[1])][Integer.parseInt(result[2])] != 1)
                    {
                        if(result[0].substring(0,1).equals("V") == true
                                || result[0].substring(0,1).equals("v") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\V4.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX() );
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+ 45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\V1.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() );
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+ 45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\V2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY());
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\V3.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY());
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("L") == true
                                || result[0].substring(0,1).equals("l") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\L2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX());
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\L2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX());
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\L.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-10);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\L.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-10);
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("C") == true
                                || result[0].substring(0,1).equals("c") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\C2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\C2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\C.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\C.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("D") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\D4.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\D3.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\D2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\D1.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("R") == true
                                || result[0].substring(0,1).equals("r") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\R2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\R2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()-7);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\R.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\R.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-7);
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("I") == true
                                || result[0].substring(0,1).equals("i") == true)
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\I2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()-18);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\I1.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()-18);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\I3.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-18);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\I4.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-18);
                                g1.getChildren().add(imageView);
                            }
                        }
                        else if(result[0].substring(0,1).equals("F") == true || result[0].substring(0,1).equals("G") == true || result[0].substring(0,1).equals("H") == true || result[0].substring(0,1).equals("E") == true
                                || result[0].substring(0,1).equals("f") == true || result[0].substring(0,1).equals("g") == true || result[0].substring(0,1).equals("h") == true || result[0].substring(0,1).equals("e") == true )
                        {
                            FileInputStream fileInputStream = null;

                            if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\GEFH2.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()-18);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\GEFH1.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()-18);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()+45);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() > circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {

                                fileInputStream = new FileInputStream("E:\\Elements\\GEFH4.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()-18);
                                g1.getChildren().add(imageView);
                            }
                            else if( (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()) && (circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() < circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX()) )
                            {
                                fileInputStream = new FileInputStream("E:\\Elements\\GEFH3.PNG");
                                Image image = new Image(fileInputStream);
                                ImageView imageView = new ImageView(image);
                                imageView.setX(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX()+100);
                                imageView.setY(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY()-18);
                                g1.getChildren().add(imageView);
                            }
                        }
                    }
                    mainBranch[Integer.parseInt(result[1])][Integer.parseInt(result[2])] = 1;

                    if( circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX() )
                    {
                        Line line2 = new Line(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY());
                        line2.setStroke(Color.LIGHTGRAY);
                        line2.setStrokeWidth(1);
                        g1.getChildren().add(line2);
                    }
                    else if( circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY() == circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY()  )
                    {
                        Line line2 = new Line(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY());
                        line2.setStroke(Color.LIGHTGRAY);
                        line2.setStrokeWidth(1);
                        g1.getChildren().add(line2);
                    }


                    Line line3 = new Line(circles[5][0].getCenterX(),circles[5][0].getCenterY(),circles[5][5].getCenterX()+60,circles[5][5].getCenterY());
                    line3.setStroke(Color.LIGHTGRAY);
                    line3.setStrokeWidth(1);
                    g1.getChildren().add(line3);

                    FileInputStream fileInputStream = null;
                    fileInputStream = new FileInputStream("E:\\Elements\\Ground.PNG");
                    Image image = new Image(fileInputStream);
                    ImageView imageView = new ImageView(image);
                    imageView.setX(circles[5][5].getCenterX()+50);
                    imageView.setY(circles[5][5].getCenterY()-25);
                    g1.getChildren().add(imageView);

                    for (int i=0; i<2;i++)
                    {
                        Line line12 = new Line(circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterY(),circles[Integer.parseInt(result[2].substring(0,result[2].length()-1))][Integer.parseInt(result[2].substring(1,result[2].length()))].getCenterX(),circles[5][0].getCenterY());
                        line12.setStroke(Color.LIGHTGRAY);
                        line12.setStrokeWidth(1);
                        g1.getChildren().add(line12);
                        Line line13 = new Line(circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterY(),circles[Integer.parseInt(result[1].substring(0,result[1].length()-1))][Integer.parseInt(result[1].substring(1,result[1].length()))].getCenterX(),circles[5][0].getCenterY());
                        line13.setStroke(Color.LIGHTGRAY);
                        line13.setStrokeWidth(1);
                        g1.getChildren().add(line13);
                    }
                }
            }
            while (scr.hasNextLine());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
