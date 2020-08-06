import java.util.ArrayList;

public class Element {
    String name = "-1";
    Node startNode;
    Node endNode;
    int start = -1;
    int end = -1;

    ArrayList<Double> currents = new ArrayList<Double>();
    ArrayList<Double> voltages = new ArrayList<Double>();
    ArrayList<Double> powers = new ArrayList<Double>();

    public Element( ) { }
    public Element(String name, String startNode, String endNode) {
        this.name = naming(name);
        this.start = nodeNo(startNode);
        this.end = nodeNo(endNode);
        boolean f1 = false, f2 = false;
        for (int i=0; i<Circuit.nodeNo.size(); i++) {
            if (start == Circuit.nodeNo.get(i))
                f1 = true;
            if (end == Circuit.nodeNo.get(i))
                f2 = true;
        }
        if (!f1 && start != -1)
            Circuit.nodeNo.add(start);
        if (!f2 && end != -1)
            Circuit.nodeNo.add(end);
        //System.out.print(this.name +" "+this.start+" "+ this.end);
    }

    protected static String naming(String name) {
        if (name.matches("[a-zA-Z0-9]*[$|_]*[a-zA-Z0-9]*"))
            return name;
        else
            return "-1";
    }
    protected static int nodeNo(String number) {
        if (number.matches("[0-9]+"))
            return Integer.parseInt(number);
        else
            return -1;
    }
    protected static double quantification(String size) {
        double d;
        try {
            if (Double.parseDouble(size) > 0)
                return Double.parseDouble(size);
            else
                return -1;
        } catch (NumberFormatException e) {
            if (size.matches("[0-9]+(\\.[0-9]+)?[p]"))
                d = Double.parseDouble(size.replaceAll("p",""))*Math.pow(10,-12);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[n]"))
                d = Double.parseDouble(size.replaceAll("n",""))*Math.pow(10,-9);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[u]"))
                d = Double.parseDouble(size.replaceAll("u",""))*Math.pow(10,-6);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[m]"))
                d = Double.parseDouble(size.replaceAll("m",""))*Math.pow(10,-3);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[K]"))
                d = Double.parseDouble(size.replaceAll("K",""))*Math.pow(10,3);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[M]"))
                d = Double.parseDouble(size.replaceAll("M",""))*Math.pow(10,6);
            else if (size.matches("[0-9]+(\\.[0-9]+)?[G]"))
                d = Double.parseDouble(size.replaceAll("G",""))*Math.pow(10,9);
            else
                return -1;
        }
        return d;
    }
}
