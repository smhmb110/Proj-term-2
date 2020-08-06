public class Resistor extends Element {

    double size;

    public Resistor(String name, String startNode, String endNode, String size) {
        super(name, startNode, endNode);
        this.size = quantification(size);
        //System.out.println(" "+this.size);
    }

    public static double maxwell(Resistor resistor, double vol, boolean startOrEnd) {
        if (startOrEnd == false)
            return ((resistor.startNode.voltagePresent + vol) - resistor.endNode.voltagePresent)
                    / resistor.size;
        else
            return ((resistor.endNode.voltagePresent + vol) - resistor.startNode.voltagePresent)
                    / resistor.size;
    }

}
