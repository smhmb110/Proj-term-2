public class Inductor extends Element {

    double size;
    double current = 0;

    public Inductor(String name, String startNode, String endNode, String size) {
        super(name, startNode, endNode);
        this.size = quantification(size);
        //System.out.println(" "+this.size);
    }

    public static double maxwell(Inductor inductor, double vol, boolean startOrEnd) {
        int j;
        inductor.current = 0;
        for (j=0; j<inductor.voltages.size(); j++)
            inductor.current += inductor.voltages.get(j);
        inductor.current = inductor.current * Circuit.dt / inductor.size;
        if (vol == 0)
            return inductor.current;
        else if (! startOrEnd)
            return inductor.current + (vol + inductor.startNode.voltagePresent
                    - inductor.endNode.voltagePresent) * Circuit.dt / inductor.size;
        return inductor.current + (vol + inductor.endNode.voltagePresent
                - inductor.startNode.voltagePresent) * Circuit.dt / inductor.size;
    }

    public static  void inductorCurrent( ) {
        int j, k;
        for (j=0; j<Circuit.l.size(); j++) {
            Circuit.l.get(j).current = 0;
            for (k=0; k< Circuit.l.get(j).voltages.size(); k++)
                Circuit.l.get(j).current += Circuit.l.get(j).voltages.get(k);
            Circuit.l.get(j).current = Circuit.l.get(j).current * Circuit.dt / Circuit.l.get(j).size;
        }
    }

}
