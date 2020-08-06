public class Capacitor extends Element {

    double size;

    public Capacitor(String name, String startNode, String endNode, String size) {
        super(name, startNode, endNode);
        this.size = quantification(size);
        //System.out.println(" "+this.size);
    }

    public static double maxwell(Capacitor capacitor, double vol, boolean startOrEnd) {
        if (vol != 0)
            return capacitor.size * vol / Circuit.dt;
        else if (startOrEnd == false)
            return capacitor.size * ((capacitor.startNode.voltagePresent+vol
                    -capacitor.endNode.voltagePresent)-(capacitor.startNode.voltagePast
                    -capacitor.endNode.voltagePast))/Circuit.dt;
        else
            return capacitor.size * ((capacitor.endNode.voltagePresent+vol
                    -capacitor.startNode.voltagePresent)-(capacitor.endNode.voltagePast
                    -capacitor.startNode.voltagePast))/Circuit.dt;
    }

}
