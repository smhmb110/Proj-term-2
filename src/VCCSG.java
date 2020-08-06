public class VCCSG extends CurSource {
    double gain;
    Node startNodeD;
    Node endNodeD;
    int startD;
    int endD;
    int line;

    public VCCSG(String name, String startNode, String endNode,
                 String startNodeD, String endNodeD, String gain) {
        super(name, startNode, endNode);
        this.line = Circuit.counter;
        this.startD = nodeNo(startNodeD);
        this.endD = nodeNo(endNodeD);
        this.gain = quantification(gain);
        //System.out.println(" "+this.startD+" "+this.endD+" "+this.gain);
    }

    public static double maxwell(VCCSG vccsg) {
        vccsg.current = vccsg.gain * (Circuit.noNodeHM.get(vccsg.startD).voltagePresent
                -Circuit.noNodeHM.get(vccsg.endD).voltagePresent);
        return vccsg.current;
    }

    protected static double quantification(String size) {
        double d;
        try {
            return Double.parseDouble(size);
        } catch (NumberFormatException e) {
            if (size.matches("-?[0-9]+(\\.[0-9]+)?[p]"))
                d = Double.parseDouble(size.replaceAll("p",""))*Math.pow(10,-12);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[n]"))
                d = Double.parseDouble(size.replaceAll("n",""))*Math.pow(10,-9);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[u]"))
                d = Double.parseDouble(size.replaceAll("u",""))*Math.pow(10,-6);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[m]"))
                d = Double.parseDouble(size.replaceAll("m",""))*Math.pow(10,-3);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[K]"))
                d = Double.parseDouble(size.replaceAll("K",""))*Math.pow(10,3);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[M]"))
                d = Double.parseDouble(size.replaceAll("M",""))*Math.pow(10,6);
            else if (size.matches("-?[0-9]+(\\.[0-9]+)?[G]"))
                d = Double.parseDouble(size.replaceAll("G",""))*Math.pow(10,9);
            else
                return -1;
        }
        return d;
    }
}
