public class VoltageSourceInd extends VolSource {
    double dc;
    double amplitude;
    double frequency;
    double phase;

    public VoltageSourceInd(String name, String startNode, String endNode, String dc,
                            String amplitude, String frequency, String phase) {
        super(name, startNode, endNode);
        this.dc = quantification(dc);
        this.amplitude = quantification(amplitude);
        this.frequency = Resistor.quantification(frequency);
        if (frequency.matches("0+(\\.0+)?[p|n|u|m|K|M|G]?"))
            this.frequency = 0;
        this.phase = quantification(phase);
        //System.out.println(" "+this.dc+" "+this.amplitude+" "+ this.frequency+" "+ this.phase);
    }
    public VoltageSourceInd(String name, String startNode, String endNode, String dc) {
        super(name, startNode, endNode);
        this.dc = quantification(dc);
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
