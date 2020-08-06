import java.util.ArrayList;

public class Node {
    int number;
    int union;
    boolean added = false;
    boolean visited = false;
    boolean error5 = false;
    double voltagePast = 0;
    double voltagePresent = 0;

    ArrayList<Double> voltage = new ArrayList<Double>();
    ArrayList<Element> branches = new ArrayList<Element>();

}
