package mastermind;

import java.util.Arrays;

public class CompareVtwo {

    int n;
    boolean[] marked1;
    boolean[] marked2;




    public CompareVtwo(int n) {
        this.n = n;
        marked1 = new boolean[this.n];
        marked2 = new boolean[this.n];
    }

    public boolean[] getMarked1() {
        return marked1;
    }

    public boolean[] getMarked2() {
        return marked2;
    }


    public int[] compareVtwo(int[] combinaison, int[] proposition) {
        int nb1 = 0;
        int nb2 = 0;
        int[] result= new int[n];
        boolean[] marked1=new boolean[n];
        boolean[] marked2=new boolean[n];



        // présents et bien placés


        for (int i = 0; i < n; i++) {
            if (combinaison [i] == proposition [i]) {
                nb1++;
                marked1[i] = true;
            } else {
                marked1[i] = false;
            }
        }
        // présents et mal placés

        for (int i = 0; i < n; i++) {
            if (combinaison[i] != proposition[i]) {
                int j = 0;
                boolean trouveMalPlace = false;
                while ((j < n) && !trouveMalPlace) {
                    if (!marked1[j] && (combinaison[i] == proposition[j])) {
                        nb2++;
                        marked2[j] = true;
                        trouveMalPlace = true;
                    }
                    j++;
                }
            }
        }
        System.out.println("Position des chiffres présents et bien placés "+Arrays.toString(marked1));
        System.out.println("Position des chiffres présents et mal placés "+Arrays.toString(marked2));

        result[0] = nb1;
        result[1] = nb2;
        return result;
    }


    public boolean resGame2(int[] result){
        boolean success=false;
        if (result[0]==n && result[1]==0){
            success=true;
        }
        return  success;
    }

    public void showResult(int[] result) {
        System.out.println(result[0]+" chiffres bien présents et bien placés");
        System.out.println(result[1]+" chiffres bien présents et mal placés");

    }




}
