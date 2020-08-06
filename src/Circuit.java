import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Circuit {

    public static double dt = 0;
    public static double di = 0;
    public static double dv = 0;
    public static double tran = 0;

    public static int node1 = Integer.MIN_VALUE;
    public static int node2 = Integer.MIN_VALUE;
    public static double specifiedTime = Double.MIN_EXPONENT;
    public static double time = 0;

    public static int counter = 1;

    public static HashMap<Integer, Node> noNodeHM = new HashMap<Integer, Node>();
    public static HashMap<String, Element> nameElementHM = new HashMap<String, Element>();

    public static ArrayList<Resistor> r = new ArrayList<Resistor>();
    public static ArrayList<Capacitor> c = new ArrayList<Capacitor>();
    public static ArrayList<Inductor> l = new ArrayList<Inductor>();
    public static ArrayList<CCCSF> f = new ArrayList<CCCSF>();
    public static ArrayList<VCCSG> g = new ArrayList<VCCSG>();
    public static ArrayList<CCVSH> h = new ArrayList<CCVSH>();
    public static ArrayList<VCVSE> e = new ArrayList<VCVSE>();
    public static ArrayList<Diode> d = new ArrayList<Diode>();
    public static ArrayList<VoltageSourceInd> v = new ArrayList<VoltageSourceInd>();
    public static ArrayList<CurrentSourceInd> i = new ArrayList<CurrentSourceInd>();

    public static ArrayList<VolSource> volSources = new ArrayList<VolSource>();
    public static ArrayList<CurSource> curSources = new ArrayList<CurSource>();

    public static ArrayList<Integer> nodeNo = new ArrayList<Integer>();
    public static ArrayList<Element> elements = new ArrayList<Element>();
    public static ArrayList<Node> nodes = new ArrayList<Node>();
    public static ArrayList<Union> unions = new ArrayList<Union>();

    public static int initial(String code) throws IOException {
        reset();
        Scanner sc = new Scanner(code);
        String s;
        String[] tokens;
        if (sc.hasNextLine())
            sc.nextLine();

        while (sc.hasNextLine()) {
            counter ++;
            s = sc.nextLine().trim();
            tokens = s.split("\\s+");
            //System.out.println(counter +": "+ tokens.length);
            if (tokens[0].length() == 0)
                continue;
            if (s.charAt(0) == '$')
                continue;
            if (s.charAt(0) == 'r' || s.charAt(0) == 'R') {
                if (tokens.length != 4)
                    return counter;
                Resistor resistor = new Resistor(tokens[0], tokens[1], tokens[2], tokens[3]);
                if (resistor.name.equals("-1") || resistor.start == -1 ||
                        resistor.end == -1 || resistor.size == -1)
                    return counter;
                elements.add(resistor);
                r.add(resistor);
            } else if (s.charAt(0) == 'c' || s.charAt(0) == 'C') {
                if (tokens.length != 4)
                    return counter;
                Capacitor capacitor = new Capacitor(tokens[0], tokens[1], tokens[2], tokens[3]);
                if (capacitor.name.equals("-1") || capacitor.start == -1 ||
                        capacitor.end == -1 || capacitor.size == -1)
                    return counter;
                elements.add(capacitor);
                c.add(capacitor);
            } else if (s.charAt(0) == 'l' || s.charAt(0) == 'L') {
                if (tokens.length != 4)
                    return counter;
                Inductor inductor = new Inductor(tokens[0], tokens[1], tokens[2], tokens[3]);
                if (inductor.name.equals("-1") || inductor.start == -1 ||
                        inductor.end == -1 || inductor.size == -1)
                    return counter;
                elements.add(inductor);
                l.add(inductor);
            } else if (s.charAt(0) == 'i' || s.charAt(0) == 'I') {
                if (tokens.length != 7 && tokens.length != 4)
                    return counter;
                CurrentSourceInd currentSourceInd = null;
                if (tokens.length == 7) {
                    currentSourceInd = new CurrentSourceInd(tokens[0], tokens[1], tokens[2], tokens[3],
                            tokens[4], tokens[5], tokens[6]);
                    if (currentSourceInd.name.equals("-1") || currentSourceInd.start == -1 ||
                            currentSourceInd.end == -1 || currentSourceInd.dc == -1 ||
                            currentSourceInd.amplitude == -1 || currentSourceInd.frequency == -1
                            || currentSourceInd.phase == -1)
                        return counter;
                } else if (tokens.length == 4) {
                    currentSourceInd = new CurrentSourceInd(tokens[0], tokens[1], tokens[2], tokens[3]);
                    if (currentSourceInd.name.equals("-1") || currentSourceInd.start == -1 ||
                            currentSourceInd.end == -1 || currentSourceInd.dc == -1)
                        return counter;
                }
                elements.add(currentSourceInd);
                i.add(currentSourceInd);
                curSources.add(currentSourceInd);
            } else if (s.charAt(0) == 'v' || s.charAt(0) == 'V') {
                if (tokens.length != 7 && tokens.length != 4)
                    return counter;
                VoltageSourceInd voltageSourceInd = null;
                if (tokens.length == 7) {
                    voltageSourceInd = new VoltageSourceInd(tokens[0], tokens[1], tokens[2], tokens[3],
                            tokens[4], tokens[5], tokens[6]);
                    if (voltageSourceInd.name.equals("-1") || voltageSourceInd.start == -1 ||
                            voltageSourceInd.end == -1 || voltageSourceInd.dc == -1 ||
                            voltageSourceInd.amplitude == -1 || voltageSourceInd.frequency == -1
                            || voltageSourceInd.phase == -1)
                        return counter;
                } else if (tokens.length == 4) {
                    voltageSourceInd = new VoltageSourceInd(tokens[0], tokens[1], tokens[2], tokens[3]);
                    if (voltageSourceInd.name.equals("-1") || voltageSourceInd.start == -1 ||
                            voltageSourceInd.end == -1 || voltageSourceInd.dc == -1)
                        return counter;
                }
                if ((voltageSourceInd.amplitude != 0 || voltageSourceInd.dc != 0)
                        && voltageSourceInd.start == voltageSourceInd.end)
                    return -4;
                elements.add(voltageSourceInd);
                v.add(voltageSourceInd);
                volSources.add(voltageSourceInd);
            } /*else if ((s.charAt(0) == 'd' || s.charAt(0) == 'D') && tokens.length == 3) {
                Diode diode = new Diode(tokens[0], tokens[1], tokens[2]);
                if (diode.name.equals("-1") || diode.start == -1 || diode.end == -1)
                    return counter;
                elements.add(diode);
                d.add(diode);
            }*/ else if (tokens[0].equals("dt") && tokens.length == 2) {
                dt = quantification(tokens[1]);
                if (dt == -1)
                    return  counter;
            } else if (tokens[0].equals("di") && tokens.length == 2) {
                di = quantification(tokens[1]);
                if (di == -1)
                    return counter;
            } else if (tokens[0].equals("dv") && tokens.length == 2) {
                dv = quantification(tokens[1]);
                if (dv == -1)
                    return counter;
            } else if (tokens[0].equals(".tran") && tokens.length == 2) {
                tran = quantification(tokens[1]);
                if (tran == -1)
                    return counter;
            } else if ((s.charAt(0) == 'e' || s.charAt(0) == 'E')
                    && !(tokens.length == 1 && (tokens[0].equals("END") || tokens[0].equals(".END")))) {
                if (tokens.length != 6)
                    return counter;
                VCVSE vcvse = new VCVSE(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                if (vcvse.name.equals("-1") || vcvse.start == -1 || vcvse.end == -1
                        || vcvse.startD == -1 || vcvse.endD == -1)
                    return counter;

                elements.add(vcvse);
                e.add(vcvse);
                volSources.add(vcvse);
            } else if (s.charAt(0) == 'f' || s.charAt(0) == 'F') {
                if (tokens.length != 5)
                    return counter;
                CCCSF cccsf = new CCCSF(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                if (cccsf.name.equals("-1") || cccsf.start == -1 || cccsf.end == -1
                        || cccsf.depended.equals("-1"))
                    return counter;
                elements.add(cccsf);
                f.add(cccsf);
                curSources.add(cccsf);
            } else if (s.charAt(0) == 'g' || s.charAt(0) == 'G') {
                if (tokens.length != 6)
                    return counter;
                VCCSG vccsg = new VCCSG(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                if (vccsg.name.equals("-1") || vccsg.start == -1 || vccsg.end == -1
                        || vccsg.startD == -1 || vccsg.endD == -1)
                    return counter;
                elements.add(vccsg);
                g.add(vccsg);
                curSources.add(vccsg);
            } else if (s.charAt(0) == 'h' || s.charAt(0) == 'H') {
                if (tokens.length != 5)
                    return counter;
                CCVSH ccvsh = new CCVSH(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                if (ccvsh.name.equals("-1") || ccvsh.start == -1 || ccvsh.end == -1
                        || ccvsh.depended.equals("-1"))
                    return counter;

                elements.add(ccvsh);
                h.add(ccvsh);
                volSources.add(ccvsh);
            } else {
                return counter;
            }
        }
        if (dt == 0 || di == 0 || dv == 0 || tran == 0)
            return -1;
        counter = dependedSources();
        if (counter != 1)
            return counter;
        int flag;   boolean flag2 = false;
        int x;
        for (x=0; x<nodeNo.size(); x++) {
            flag = 0;
            if (nodeNo.get(x) != 0)
                for (int y=0; y<elements.size(); y++) {
                    if (nodeNo.get(x) == elements.get(y).start)
                        flag++;
                    if (nodeNo.get(x) == elements.get(y).end)
                        flag++;
                }
            else
                flag2 = true;
            if (flag == 1)
                return -5;
        }
        if (!flag2 && nodeNo.size() > 0)
            return -4;
        //if (!searchNodeNo(node1) || !searchNodeNo(node2))
        //    return 0;
        //if (specifiedTime != Double.MIN_EXPONENT
        //       && (specifiedTime <= 0 || specifiedTime > tran
        //        || Math.floor(specifiedTime /dt) != specifiedTime /dt))
        //    return 0;

        createNode();
        createUnion();
        //printData();

        //ERROR -5
        if (nodes.size() > 0) {
            noNodeHM.get(0).error5 = true;
            error5(noNodeHM.get(0));
        }
        //System.out.println("StepCircuit8");
        for (x=0; x<nodes.size(); x++) {
            if (! nodes.get(x).error5)
                return -5;
        }


        counter = solver();
        if (counter <= -2 && counter >= -4)
            return counter;
        //System.out.println("StepCircuit9");

        output();







        return 1;
    }
    public static void reset( ) {
        counter = 1;
        time =0;
        r.clear();
        c.clear();
        l.clear();
        d.clear();
        v.clear();
        i.clear();
        f.clear();
        g.clear();
        h.clear();
        e.clear();
        nodeNo.clear();
        elements.clear();
        nodes.clear();
        unions.clear();
        volSources.clear();
        curSources.clear();

        noNodeHM.clear();
        nameElementHM.clear();

        dt = 0;
        di = 0;
        dv = 0;
        tran = 0;
        node1 = Integer.MIN_VALUE;
        node2 = Integer.MIN_VALUE;
        specifiedTime = Double.MIN_EXPONENT;
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
    public static int dependedSources( ) {
        boolean a, b;
        int i,j;
        for (i=0; i<e.size(); i++) {
            a = false;
            b = false;
            for (j=0; j<elements.size(); j++) {
                if (e.get(i).startD == elements.get(j).start || e.get(i).startD == elements.get(j).end)
                    a = true;
                if (e.get(i).endD == elements.get(j).start || e.get(i).endD == elements.get(j).end)
                    b = true;
            }
            if (!a || !b)
                return e.get(i).line;
        }
        for (i=0; i<g.size(); i++) {
            a = false;
            b = false;
            for (j=0; j<elements.size(); j++) {
                if (g.get(i).startD == elements.get(j).start || g.get(i).startD == elements.get(j).end)
                    a = true;
                if (g.get(i).endD == elements.get(j).start || g.get(i).endD == elements.get(j).end)
                    b = true;
            }
            if (!a || !b)
                return g.get(i).line;
        }
        for (i=0; i<f.size(); i++) {
            a = false;
            for (j=0; j<elements.size(); j++) {
                if (f.get(i).depended.equals(elements.get(j).name))
                    a = true;
            }
            if (!a)
                return f.get(i).line;
        }
        for (i=0; i<h.size(); i++) {
            a = false;
            for (j=0; j<elements.size(); j++) {
                if (h.get(i).depended.equals(elements.get(j).name))
                    a = true;
            }
            if (!a)
                return h.get(i).line;
        }
        return 1;
    }
    public static void createNode( ) {
        int i;
        for (i=0; i<nodeNo.size(); i++) {
            Node n = new Node();
            n.number = nodeNo.get(i);
            nodes.add(n);
            noNodeHM.put(n.number,n);
        }

        for (i=0; i<elements.size(); i++) {
            elements.get(i).startNode = noNodeHM.get(elements.get(i).start);
            elements.get(i).endNode = noNodeHM.get(elements.get(i).end);
            noNodeHM.get(elements.get(i).start).branches.add(elements.get(i));
            noNodeHM.get(elements.get(i).end).branches.add(elements.get(i));
        }
        for (i=0; i<nodes.size(); i++)
            nodes.get(i).union = nodes.get(i).number;
        noNodeHM.get(0).added = true;
        noNodeHM.get(0).voltagePast = 0;
        noNodeHM.get(0).voltagePresent = 0;
        noNodeHM.get(0).union = 0;
        generateHashMapForCCCSF();
    }
    public static void generateHashMapForCCCSF( ) {
        int k;
        for (k=0; k<elements.size(); k++)
            nameElementHM.put(elements.get(k).name, elements.get(k));
    }
    public static void createUnion( ) {
        int j;
        for (j=0; j< noNodeHM.get(0).branches.size(); j++) {
            if (noNodeHM.get(0).branches.get(j) instanceof VoltageSourceInd
                    || noNodeHM.get(0).branches.get(j) instanceof VCVSE
                    || noNodeHM.get(0).branches.get(j) instanceof CCVSH) {
                Union u = new Union();
                unions.add(u);
                u.number = 0;
                u.nodeOfBranch.add(noNodeHM.get(0));
                if (noNodeHM.get(0).branches.get(j).start == 0) {
                    unionAnalyse(noNodeHM.get(0).branches.get(j).endNode, u, noNodeHM.get(0).branches.get(j),0);
                }
                else {
                    unionAnalyse(noNodeHM.get(0).branches.get(j).startNode, u, noNodeHM.get(0).branches.get(j),0);
                }
            }
        }
        int k;
        for (j=0; j<nodes.size(); j++) {
            if (nodes.get(j).added == false) {
                nodes.get(j).added = true;
                Union u = new Union();
                unions.add(u);
                u.nodeOfBranch.add(nodes.get(j));
                u.number = nodes.get(j).number;
                for (k=0; k<nodes.get(j).branches.size(); k++) {
                    if (nodes.get(j).branches.get(k) instanceof VoltageSourceInd
                            || nodes.get(j).branches.get(k) instanceof VCVSE
                            || nodes.get(j).branches.get(k) instanceof CCVSH) {
                        if (nodes.get(j).branches.get(k).start == nodes.get(j).number) {
                            unionAnalyse(nodes.get(j).branches.get(k).endNode, u,
                                    nodes.get(j).branches.get(k), nodes.get(j).number);
                        } else {
                            unionAnalyse(nodes.get(j).branches.get(k).startNode, u,
                                    nodes.get(j).branches.get(k), nodes.get(j).number);
                        }
                    }
                }
            }
        }
        
        for (j=0; j<unions.size(); j++) {
            for (k=0; k<unions.get(j).nodeOfBranch.size(); k++) {
                for (int aa=0; aa<unions.get(j).nodeOfBranch.get(k).branches.size(); aa++) {
                    if (! unions.get(j).branches.contains(
                            unions.get(j).nodeOfBranch.get(k).branches.get(aa)))
                        unions.get(j).branches.add(unions.get(j).nodeOfBranch.get(k).branches.get(aa));
                }
            }
        }
        
        boolean fff = false;
        for (j=0; j<unions.size(); j++) {
            if (unions.get(j).number == 0)
                fff = true;
        }
        if (! fff) {
            Union union = new Union();
            union.number = 0;
            union.nodeOfBranch.add(noNodeHM.get(0));
            unions.add(union);
        }
    }
    public static void unionAnalyse(Node node, Union union, Element element, int n) {
        node.added = true;
        union.nodeOfBranch.add(node);
        union.branches.add(element);
        union.number = n;
        node.union = n;
        int j;
        for (j=0; j<node.branches.size(); j++) {
            if (node.branches.get(j) instanceof VoltageSourceInd
                    || node.branches.get(j) instanceof VCVSE
                    || node.branches.get(j) instanceof CCVSH) {
                if (node.branches.get(j).start == node.number && node.branches.get(j).endNode.added == false) {
                    unionAnalyse(node.branches.get(j).endNode, union, node.branches.get(j), n);
                } else if (node.branches.get(j).end == node.number && node.branches.get(j).startNode.added == false) {
                    unionAnalyse(node.branches.get(j).startNode, union, node.branches.get(j), n);
                }
            }
        }
    }
    public static boolean searchNodeNo(int number) {
        for (int i=0; i<nodeNo.size(); i++) {
            if (nodeNo.get(i) == number)
                return true;
        }
        return false;
    }
    public static int solver( ) {
        int j, k;
        double x = 0;
        while (time <= tran) {
            sourcesQuantification();
            //System.out.println("Step Time "+time);
            for (j = 0; j < unions.size(); j++) {
                unions.get(j).it1 = 0;
                unions.get(j).it2 = 0;
                unions.get(j).it3 = 0;
                if (unions.get(j).number != 0) {
                    unions.get(j).it1 = currentTotal(0, unions.get(j));
                    //System.out.println("Step i1: j = "+j+" , i1 = "+unions.get(j).it1);
                    unions.get(j).it2 = currentTotal(dv, unions.get(j));
                    //System.out.println("Step i1: j = "+j+" , i2 = "+unions.get(j).it2);
                    unions.get(j).it3 = currentTotal(-dv, unions.get(j));
                    //System.out.println("Step i1: j = "+j+" , i3 = "+unions.get(j).it3);
                    if (Math.abs(unions.get(j).it2) > Math.abs(unions.get(j).it3)) {
                        x = (Math.abs(unions.get(j).it1) - Math.abs(unions.get(j).it3)) / di * (-dv);
                        //System.out.println("3j = "+j);
                    }
                    else {
                        x = (Math.abs(unions.get(j).it1) - Math.abs(unions.get(j).it2)) / di * dv;
                        //System.out.println("2j = "+j);
                    }
                    unions.get(j).nodeOfBranch.get(0).voltage.add(
                            unions.get(j).nodeOfBranch.get(0).voltagePresent + x);
                    //System.out.println(unions.get(j).nodeOfBranch.get(0).voltage);
                    //System.out.println(unions.get(j).nodeOfBranch.get(0).voltage.size());
                } else
                    unions.get(j).nodeOfBranch.get(0).voltage.add(0d);
                unions.get(j).nodeOfBranch.get(0).visited = true;
                //... sources voltage
                nodesVoltageONUnion(unions.get(j).nodeOfBranch.get(0), unions.get(j));
            }
            for (j = 0; j < nodes.size(); j++) {
                nodes.get(j).voltagePast = nodes.get(j).voltagePresent;
                if (nodes.get(j).voltage.size() == 0)
                    continue;
                nodes.get(j).voltagePresent = nodes.get(j).voltage.get(nodes.get(j).voltage.size() - 1);
            }
            //System.out.println("Step end for2  "+time);
            Inductor.inductorCurrent();
            //System.out.println("Step Inductor.inductorCurrent  "+time);
            for (j = 0; j < nodes.size(); j++)
                nodes.get(j).visited = false;

            //ERROR -2
            for (k=0; k<nodes.size(); k++) {
                if (nodes.get(k).branches.size() == 2) {
                    if ((nodes.get(k).branches.get(0) instanceof CurrentSourceInd
                            || nodes.get(k).branches.get(0) instanceof CCCSF
                            || nodes.get(k).branches.get(0) instanceof VCCSG) &&
                            (nodes.get(k).branches.get(1) instanceof CurrentSourceInd
                            || nodes.get(k).branches.get(1) instanceof CCCSF
                            || nodes.get(k).branches.get(1) instanceof VCCSG)) {
                        if (((CurSource) nodes.get(k).branches.get(0)).current
                                != ((CurSource) nodes.get(k).branches.get(1)).current)
                            return -2;
                    }
                }
            }
            //ERROR -3
            for (j=0; j<volSources.size(); j++) {
                for (k=0; k<volSources.size(); k++) {
                    if (k != j) {
                        if (volSources.get(j).start == volSources.get(k).start
                                && volSources.get(j).end == volSources.get(k).end
                                && volSources.get(j).voltage != volSources.get(k).voltage)
                            return -3;
                        else if (volSources.get(j).end == volSources.get(k).start
                                && volSources.get(j).start == volSources.get(k).end
                                && volSources.get(j).voltage != - volSources.get(k).voltage)
                            return -3;
                    }
                }
            }
            //ERROR -4
            for (j=0; j<volSources.size(); j++) {
                if (volSources.get(j).voltage != 0 && volSources.get(j).start == volSources.get(j).end)
                    return -4;
            }

            //Store  elements  voltage  &  current  &  power
            for (j=0; j<elements.size(); j++) {
                //Store elements voltage
                elements.get(j).voltages.add(elements.get(j).startNode.voltagePresent
                        -elements.get(j).endNode.voltagePresent);
                if (! (elements.get(j) instanceof VolSource) && ! (elements.get(j) instanceof CCCSF)
                        && ! (elements.get(j) instanceof VCCSG)) {
                    //Store elements current
                    if (elements.get(j) instanceof Resistor)
                        elements.get(j).currents.add((elements.get(j).startNode.voltagePresent
                                - elements.get(j).endNode.voltagePresent)
                                / ((Resistor) elements.get(j)).size);
                    else if (elements.get(j) instanceof Capacitor)
                        elements.get(j).currents.add(((Capacitor) elements.get(j)).size
                                * ((elements.get(j).startNode.voltagePresent
                                - elements.get(j).endNode.voltagePresent)
                                - (elements.get(j).startNode.voltagePast
                                - elements.get(j).endNode.voltagePast)) / dt);
                    else if (elements.get(j) instanceof Inductor)
                        elements.get(j).currents.add(((Inductor) elements.get(j)).current
                                + (elements.get(j).startNode.voltagePresent
                                - elements.get(j).endNode.voltagePresent)
                                * dt / ((Inductor) elements.get(j)).size);
                    else if (elements.get(j) instanceof CurrentSourceInd)
                        elements.get(j).currents.add(((CurrentSourceInd) elements.get(j)).current);

                    //Store elements power
                    elements.get(j).powers.add(elements.get(j).voltages.get(elements.get(j).voltages.size()-1)
                            * elements.get(j).currents.get(elements.get(j).currents.size() - 1));
                }
            }
            for (j=0; j<curSources.size(); j++) {
                if (! (curSources.get(j) instanceof CurrentSourceInd)) {
                    //Store elements current
                    if (curSources.get(j) instanceof CCCSF)
                        curSources.get(j).currents.add(nameElementHM
                                .get(((CCCSF) curSources.get(j)).depended).currents.get(
                                nameElementHM.get(((CCCSF) curSources.get(j)).depended).currents.size()-1)
                                * ((CCCSF) curSources.get(j)).gain);
                    else if (curSources.get(j) instanceof VCCSG)
                        curSources.get(j).currents.add(
                                (noNodeHM.get(((VCCSG) curSources.get(j)).startD).voltagePresent
                                        -noNodeHM.get(((VCCSG) curSources.get(j)).endD).voltagePresent)
                                        * ((VCCSG) curSources.get(j)).gain);

                    //Store elements power
                    elements.get(j).powers.add(elements.get(j).voltages.get(elements.get(j).voltages.size()-1)
                            * elements.get(j).currents.get(elements.get(j).currents.size() - 1));
                }
            }
            int a;  boolean bool = false;   double sum;
            for (j=0; j<nodes.size(); j++) {
                if (nodes.get(j).number == 0)
                    continue;
                a = -1;
                for (k=0; k<nodes.get(j).branches.size(); k++) {
                    if (nodes.get(j).branches.get(k) instanceof VolSource) {
                        a = k;
                        if (nodes.get(j).branches.get(k).startNode.equals(nodes.get(j)))
                            bool = false;
                        else
                            bool = true;
                        break;
                    }
                }
                if (a == -1)
                    continue;
                x = 0;
                for (k=0; k<nodes.get(j).branches.size(); k++) {
                    if (k == a)
                        continue;
                    if (nodes.get(j).branches.get(k).startNode.equals(nodes.get(j)))
                        x -= nodes.get(j).branches.get(k).currents.get(
                                nodes.get(j).branches.get(k).currents.size()-1);
                    else
                        x += nodes.get(j).branches.get(k).currents.get(
                                nodes.get(j).branches.get(k).currents.size()-1);
                } if (bool)
                    x = - x;
                nodes.get(j).branches.get(a).currents.add(x);
                //Store element power
                nodes.get(j).branches.get(a).powers.add(nodes.get(j).branches.get(a).currents.get(
                        nodes.get(j).branches.get(a).currents.size()-1)
                        * nodes.get(j).branches.get(a).voltages.get(
                                nodes.get(j).branches.get(a).voltages.size()-1));
            }

            time += dt;

        }
        //System.out.println(111);
        for (j=0; j<curSources.size(); j++) {
            for (k=0; k<curSources.get(j).currents.size(); k++)
                curSources.get(j).currents.set(k, - curSources.get(j).currents.get(k));
        }
        //System.out.println(111);
        for (j=0; j<elements.size(); j++) {
            for (k=0; k<elements.get(j).powers.size(); k++)
                elements.get(j).powers.set(k, - elements.get(j).powers.get(k));
            if (! (elements.get(j) instanceof CurrentSourceInd)
                    && ! (elements.get(j) instanceof CCCSF)
                    && ! (elements.get(j) instanceof VCCSG))
                for (k=0; k<elements.get(j).currents.size(); k++)
                    elements.get(j).currents.set(k, - elements.get(j).currents.get(k));
        }
        //System.out.println(111);

        return 1;
    }

    public static void nodesVoltageONUnion(Node node, Union union) {
        int j, x;
        for (j=0; j<node.branches.size(); j++) {
            x = 0;
            if (node.branches.get(j) instanceof VoltageSourceInd) {
                if (node.equals(node.branches.get(j).startNode)) {
                    node.branches.get(j).endNode.voltage.add(
                            node.voltage.get(node.voltage.size()-1)
                                    -((VoltageSourceInd) node.branches.get(j)).voltage);
                    x = 1;
                    node.branches.get(j).endNode.visited = true;
                } else {
                    node.branches.get(j).startNode.voltage.add(
                            node.voltagePresent
                                    +((VoltageSourceInd) node.branches.get(j)).voltage);
                    x = 2;
                    node.branches.get(j).startNode.visited = true;
                }
            } else if (node.branches.get(j) instanceof VCVSE) {
                if (node.equals(node.branches.get(j).startNode)) {
                    node.branches.get(j).endNode.voltage.add(node.voltagePresent
                            -VCVSE.maxwellType2((VCVSE) node.branches.get(j)));
                    x = 1;
                    node.branches.get(j).endNode.visited = true;
                } else {
                    node.branches.get(j).startNode.voltage.add(node.voltagePresent
                            +VCVSE.maxwellType2((VCVSE) node.branches.get(j)));
                    x = 2;
                    node.branches.get(j).startNode.visited = true;
                }
            } else if (node.branches.get(j) instanceof CCVSH) {
                if (node.equals(node.branches.get(j).startNode)) {
                    node.branches.get(j).endNode.voltage.add(node.voltagePresent
                            -CCVSH.maxwellType2((CCVSH) node.branches.get(j)));
                    x = 1;
                    node.branches.get(j).endNode.visited = true;
                } else {
                    node.branches.get(j).startNode.voltage.add(node.voltagePresent
                            +CCVSH.maxwellType2((CCVSH) node.branches.get(j)));
                    x = 2;
                    node.branches.get(j).startNode.visited = true;
                }
            }
            if (! isUnion(union) && x == 1)
                nodesVoltageONUnion(node.branches.get(j).endNode, union);
            else if (! isUnion(union) && x == 2)
                nodesVoltageONUnion(node.branches.get(j).startNode, union);
        }
    }
    public static boolean isUnion(Union union) {
        int j;
        for (j=0; j<union.nodeOfBranch.size(); j++) {
            if (! union.nodeOfBranch.get(j).visited)
                return false;
        }
        return true;
    }

    public static double currentTotal(double vol, Union u) {
        int k;
        double x = 0;
        for (k=0; k<u.branches.size(); k++) {
            if (!(u.branches.get(k) instanceof VoltageSourceInd)
                    && !(u.branches.get(k) instanceof VCVSE)
                    && !(u.branches.get(k) instanceof CCVSH)) {
                if (u.nodeOfBranch.contains(u.branches.get(k).startNode)) {
                    if (u.branches.get(k) instanceof Resistor) {
                        x -= Resistor.maxwell((Resistor) u.branches.get(k), vol,false);
                    }
                    else if (u.branches.get(k) instanceof Capacitor) {
                        x -= Capacitor.maxwell((Capacitor) u.branches.get(k), vol,false);
                    }
                    else if (u.branches.get(k) instanceof Inductor) {
                        x -= Inductor.maxwell((Inductor) u.branches.get(k), vol,false);
                    }
                    else if (u.branches.get(k) instanceof CurrentSourceInd) {
                        x -= ((CurrentSourceInd) u.branches.get(k)).current;
                    }
                    else if (u.branches.get(k) instanceof CCCSF) {
                        x -= CCCSF.maxwell((CCCSF) u.branches.get(k));
                    }
                    else if (u.branches.get(k) instanceof VCCSG) {
                        x -= VCCSG.maxwell((VCCSG) u.branches.get(k));
                    }
                }
                else {
                    if (u.branches.get(k) instanceof Resistor) {
                        x -= Resistor.maxwell((Resistor) u.branches.get(k), vol,true);
                    }
                    else if (u.branches.get(k) instanceof Capacitor) {
                        x -= Capacitor.maxwell((Capacitor) u.branches.get(k), vol,true);
                    }
                    else if (u.branches.get(k) instanceof Inductor) {
                        x -= Inductor.maxwell((Inductor) u.branches.get(k), vol,true);
                    }
                    else if (u.branches.get(k) instanceof CurrentSourceInd) {
                        x += ((CurrentSourceInd) u.branches.get(k)).current;
                    }
                    else if (u.branches.get(k) instanceof CCCSF) {
                        x += CCCSF.maxwell((CCCSF) u.branches.get(k));
                    }
                    else if (u.branches.get(k) instanceof VCCSG) {
                        x += VCCSG.maxwell((VCCSG) u.branches.get(k));
                    }
                }
            }
        }
        return x;
    }

    public static void sourcesQuantification( ) {
        int j;
        for (j=0; j<v.size(); j++)
            v.get(j).voltage = v.get(j).dc
                    + v.get(j).amplitude*Math.sin(2*Math.PI*v.get(j).frequency*time + v.get(j).phase*Math.PI/180);
        for (j=0; j<i.size(); j++)
            i.get(j).current = i.get(j).dc
                    + i.get(j).amplitude*Math.sin(2*Math.PI*i.get(j).frequency*time + i.get(j).phase*Math.PI/180);
    }

    public static void error5(Node node) {
        int j;
        for (j=0; j<node.branches.size(); j++) {
            if (node.branches.get(j).startNode.equals(node) && ! node.branches.get(j).endNode.error5) {
                node.branches.get(j).endNode.error5 = true;
                error5(node.branches.get(j).endNode);
            } else if (node.branches.get(j).endNode.equals(node) && ! node.branches.get(j).startNode.error5) {
                node.branches.get(j).startNode.error5 = true;
                error5(node.branches.get(j).startNode);
            }
        }
    }

    public static void output( ) throws IOException {
        //System.out.println(Main.fileChooser.getSelectedFile().getAbsolutePath()
        //        .replaceAll("(\\)(\\.txt)","//Output.txt"));
        File file = new File("C:\\Users\\Owner\\Desktop\\Output.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        Collections.sort(nodeNo);
        int j, k;
        for (j=0; j<nodeNo.size(); j++) {
            if (nodeNo.get(j) == 0)
                continue;
            bw.write("Node " + nodeNo.get(j) + ":  ");
            for (k=0; k<noNodeHM.get(nodeNo.get(j)).voltage.size(); k++)
                bw.write("  " + noNodeHM.get(nodeNo.get(j)).voltage.get(k));
            bw.newLine();
        }
        for (j=0; j<elements.size(); j++) {
            bw.write(elements.get(j).name + ":");
            bw.newLine();
            bw.write("    Voltages:");
            for (k=0; k<elements.get(j).voltages.size(); k++) {
                bw.write("  " + elements.get(j).voltages.get(k));
            }
            bw.newLine();
            bw.write("    Currents:");
            for (k=0; k<elements.get(j).currents.size(); k++) {
                bw.write("  " + elements.get(j).currents.get(k));
            }
            bw.newLine();
            bw.write("    Powers:");
            for (k=0; k<elements.get(j).powers.size(); k++) {
                bw.write("  " + elements.get(j).powers.get(k));
            }
            bw.newLine();
        }
        //bw.write("V(" + node1 + ") - V(" + node2 + ") in " + specifiedTime + "s:    ");
        //bw.write(String.valueOf(noNodeHM.get(node1).voltage.get((int) Math.round(specifiedTime/dt))
        //        -noNodeHM.get(node2).voltage.get((int) Math.round(specifiedTime/dt))));
        //bw.newLine();
        bw.close();
        fileWriter.close();
    }
    public static void printData( ) {
        int j;
        //elements
        System.out.println("Elements:");
        for (j=0; j<elements.size(); j++)
            System.out.println("    "+elements.get(j).name+" "+elements.get(j).start+" "+elements.get(j).end);
        //r
        System.out.println("Resistors:");
        for (j=0; j<r.size(); j++)
            System.out.println("    "+r.get(j).name+" "+r.get(j).start+" "+r.get(j).end+" "+r.get(j).size);
        //c
        System.out.println("Capacitors:");
        for (j=0; j<c.size(); j++)
            System.out.println("    "+c.get(j).name+" "+c.get(j).start+" "+c.get(j).end+" "+c.get(j).size);
        //l
        System.out.println("Inductors:");
        for (j=0; j<l.size(); j++)
            System.out.println("    "+l.get(j).name+" "+l.get(j).start+" "+l.get(j).end+" "+l.get(j).size);
        //i
        System.out.println("I:");
        for (j=0; j<i.size(); j++)
            System.out.println("    "+i.get(j).name+" "+i.get(j).start+" "+i.get(j).end+" "+i.get(j).dc+" "
                    +i.get(j).amplitude+" "+i.get(j).frequency+" "+i.get(j).phase);
        //v
        System.out.println("V:");
        for (j=0; j<v.size(); j++)
            System.out.println("    "+v.get(j).name+" "+v.get(j).start+" "+v.get(j).end+" "+v.get(j).dc+" "
                    +v.get(j).amplitude+" "+v.get(j).frequency+" "+v.get(j).phase);
        //e
        System.out.println("E:");
        for (j=0; j<e.size(); j++)
            System.out.println("    "+e.get(j).name+" "+e.get(j).start+" "+e.get(j).end+" "+e.get(j).startD+" "
                    +e.get(j).endD+" "+e.get(j).gain);
        //f
        System.out.println("F:");
        for (j=0; j<f.size(); j++)
            System.out.println("    "+f.get(j).name+" "+f.get(j).start+" "+f.get(j).end+" "+f.get(j).depended+" "
                    +f.get(j).gain);
        //g
        System.out.println("G:");
        for (j=0; j<g.size(); j++)
            System.out.println("    "+g.get(j).name+" "+g.get(j).start+" "+g.get(j).end+" "+g.get(j).startD+" "
                    +g.get(j).endD+" "+g.get(j).gain);
        //h
        System.out.println("H:");
        for (j=0; j<h.size(); j++)
            System.out.println("    "+h.get(j).name+" "+h.get(j).start+" "+h.get(j).end+" "+h.get(j).depended+" "
                    +h.get(j).gain);
        //node
        System.out.println("Nodes:");
        System.out.println(nodeNo.size());
        System.out.println(nodes.size());
        System.out.println(noNodeHM.size());
        for (j=0; j<nodes.size(); j++) {
            System.out.print("    "+nodes.get(j).number+":    ");
            for (int x=0; x<nodes.get(j).branches.size(); x++)
                System.out.print(nodes.get(j).branches.get(x).name+" ");
            System.out.println();
        }
        //union
        System.out.println("Unions:");
        System.out.println(unions.size());
        for (j=0; j<unions.size(); j++) {
            System.out.print("    "+unions.get(j).number+": Branches:    ");
            int x;
            for (x=0; x<unions.get(j).branches.size(); x++)
                System.out.print(unions.get(j).branches.get(x).name+" ");
            System.out.println();
            System.out.print("      >>>   Nodes:");
            for (x=0; x<unions.get(j).nodeOfBranch.size(); x++)
                System.out.print(unions.get(j).nodeOfBranch.get(x).number+" ");
            System.out.println();
        }
        //more...
        System.out.println("More...");
        System.out.println("    di = " + di);
        System.out.println("    dv = " + dv);
        System.out.println("    dt = " + dt);
        System.out.println("    tran = " + tran);
        //System.out.println("    node1 = " + node1);
        //System.out.println("    node2 = " + node2);
        //System.out.println("    specifiedTime = " + specifiedTime);
    }
}