public class CCVSH extends VolSource {
    String depended;
    double gain;
    int line;

    public CCVSH(String name, String startNode, String endNode, String depended, String gain) {
        super(name, startNode, endNode);
        this.line = Circuit.counter;
        this.depended = naming(depended);
        this.gain = quantification(gain);
        //System.out.println(" "+this.depended+" "+this.gain);
    }

    public static double maxwellType2(CCVSH ccvsh) {
        if (Circuit.nameElementHM.get(ccvsh.depended) instanceof Resistor) {
            ccvsh.voltage = ccvsh.gain * (Circuit.nameElementHM.get(ccvsh.depended).startNode.voltagePresent
                    -Circuit.nameElementHM.get(ccvsh.depended).endNode.voltagePresent)
                    / ((Resistor) Circuit.nameElementHM.get(ccvsh.depended)).size;
        }
        else if (Circuit.nameElementHM.get(ccvsh.depended) instanceof Capacitor) {
            ccvsh.voltage = ccvsh.gain * ((Capacitor) Circuit.nameElementHM.get(ccvsh.depended)).size
                    * ((Circuit.nameElementHM.get(ccvsh.depended).startNode.voltagePresent
                    - Circuit.nameElementHM.get(ccvsh.depended).endNode.voltagePresent)
                    -(Circuit.nameElementHM.get(ccvsh.depended).startNode.voltagePast
                    -Circuit.nameElementHM.get(ccvsh.depended).endNode.voltagePast))/Circuit.dt;
        }
        else if (Circuit.nameElementHM.get(ccvsh.depended) instanceof Inductor) {
            ccvsh.voltage = ((Inductor) Circuit.nameElementHM.get(ccvsh.depended)).current;
        }
        else if (Circuit.nameElementHM.get(ccvsh.depended) instanceof CurrentSourceInd) {
            ccvsh.voltage = ((CurrentSourceInd) Circuit.nameElementHM.get(ccvsh.depended)).current;
        }
        return ccvsh.voltage;
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
