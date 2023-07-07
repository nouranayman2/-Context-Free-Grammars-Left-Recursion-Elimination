package csen1002.main.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CfgLeftRecElim {

    String variables;
    String characters;

    String Sequences;

    ArrayList<String> sequence = new ArrayList<>();

    ArrayList<String> Prods = new ArrayList<>();

    /**
     * Constructs a Context Free Grammar
     *
     * @param cfg A formatted string representation of the CFG. The string
     *            representation follows the one in the task description
     */
    public CfgLeftRecElim(String cfg) {

        String[] x = cfg.split("#");
        variables = x[0];
        characters = x[1];
        Sequences = x[2];
        String[] x2 = Sequences.split(";");
        // ArrayList<String> Prods= new ArrayList<>();
        for (int i = 0; i < x2.length; i++) {
            Prods.add(x2[i]);
        }


        // TODO Auto-generated constructor stub
    }

    /**
     * @return Returns a formatted string representation of the CFG. The string
     * representation follows the one in the task description
     */
    @Override
    public String toString() {
        Sequences = "";
        for (String s : Prods) {
            Sequences += s + ";";
        }
        Sequences = Sequences.substring(0, Sequences.length() - 1);
        String l = variables + "#" + characters + "#" + Sequences;
        // TODO Auto-generated method stub
        return l;
    }
        // TODO Auto-generated method stub


    /**
     * Eliminates Left Recursion from the grammar
     */
    public void eliminateLeftRecursion() {
        String variable = "";
        String rules = "";
        //ArrayList<String> arrayvar = new ArrayList<String>(List.of(variables));
        String[] arrvar = variables.split(";");
        //System.out.println("arrvar" + Arrays.toString(arrvar));

        for (int i = 0; i < arrvar.length; i++) {
            String s = Prods.get(i);
            String[] arr = s.split("/");
           // System.out.println(Arrays.toString(arr));
            //System.out.println("arrvar"+arrvar[i]);
            variable = arr[0];
            rules = arr[1];
            String[] arr2 = rules.split(",");
            ArrayList<String> arrayrules = new ArrayList<String>(List.of(arr2));
            //System.out.println("hii"+arrayrules);
            String rules2;
          //  System.out.println("arrayrule2"+arrayrules);
            for (int j = 0; j <= i - 1; j++) {
                ArrayList<String> arraynew = new ArrayList<String>();
                for (int l = 0; l < arrayrules.size(); l++) {
                    String ax = arrayrules.get(l);
                    if (arrayrules.get(l).charAt(0) == (arrvar[j].charAt(0))) {
                        String ax2 = String.valueOf(arrayrules.get(l).charAt(0));
                        String m = Prods.get(j);
                        String[] ar = m.split("/");
                        rules2 = ar[1];
                        String[] arr3 = rules2.split(",");
                        ArrayList<String> a2 = new ArrayList<String>(List.of(arr3));
                     //   System.out.println("a2"+a2);
                        for (int r = 0; r < a2.size() ; r++) {
                            //ax.replaceFirst(ax2, a2.get(r));
                            arraynew.add(ax.replaceFirst(ax2, a2.get(r)));

                        }


                    } else if(!arraynew.contains(ax))
                        arraynew.add(ax);
                 //   System.out.println("arrayneww"+arraynew);


                }

                arrayrules = (arraynew);

            }
            boolean q= false;
            System.out.println("arrayrule"+arrayrules);
            ArrayList<String> betaarr = new ArrayList<String>();
            ArrayList<String> alphaarr = new ArrayList<String>();
            for (int k = 0; k < arrayrules.size(); k++) {
                if (arrvar[i].charAt(0) == (arrayrules.get(k).charAt(0))) {
                    q=true;
                    String x = arrayrules.get(k);
                    String alpha = x.substring(1, x.length()) + arrvar[i].charAt(0) + "'";
                    alphaarr.add(alpha);
                } else {
                    String beta = arrayrules.get(k) + arrvar[i].charAt(0) + "'";
                    betaarr.add(beta);
                }
            }
            if (q==true) {
                arrayrules = betaarr;
                alphaarr.add("e");
                String lr = alphaarr.toString().replace("[", "").replace("]", "").replace(" ", "");
                lr = variable + "'" + "/" + lr;
                variables+=";"+variable+"'";
                Prods.add(lr);
            }
                String t = arrayrules.toString().replace("[", "").replace("]", "").replace(" ", "");
                t = variable + "/" + t;
                Prods.set(i, t);
        //    System.out.println("prodss"+Prods);
        }





    }


    public static void main(String[] args) {
        String cfg = ("S;T;L#a;b;c;d;i#S/ScT,La,Ti,b;T/aSb,LabS,i;L/SdL,Si");

        CfgLeftRecElim mycfg = new CfgLeftRecElim(cfg);


        System.out.println("Variables: " + mycfg.variables);
        System.out.println("Characters: " + mycfg.characters);
        System.out.println("Prodsss " + mycfg.Prods);

        // mycfg.eliminateUnitRules();

        //  mycfg.eliminateEpsilonRules();
   //     System.out.println("my cfg" + mycfg);

        mycfg.eliminateLeftRecursion();
     //   System.out.println("Final " + mycfg.toString());


        // TODO Auto-generated method stub
    }

}


