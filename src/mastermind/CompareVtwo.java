package mastermind;

import java.util.Arrays;

public class CompareVtwo {

    int n;

    public CompareVtwo(int n) {
        this.n = n;
    }

    public int[] compareVtwo(int[] combinaison, int[] proposition) {
        int nb1 = 0;
        int nb2 = 0;
        int[] result= new int[n];
        boolean[] marked = new boolean[n];

        // cette première boucle sert à trouver
        // les éléments bien devinés et correctement placés.
        // Le tableau marque permet de marquer de tels
        // éléments pour qu'ils ne soient pas considérés
        // plusieurs fois.

        for (int i = 0; i < n; i++) {
            if (combinaison [i] == proposition [i]) {
                nb1++;
                marked[i] = true;
            } else {
                marked[i] = false;
            }
        }
        // la deuxième boucle suivante sert à identifier les
        // éléments bien devinés mais mal placés.

        for (int i = 0; i < n; i++) {
            if (combinaison[i] != proposition[i]) {
                int j = 0;
                boolean trouveMalPlace = false;
                while ((j < n) && !trouveMalPlace) {
                    if (!marked[j] && (combinaison[i] == proposition[j])) {
                        nb2++;
                        marked[j] = true;
                        trouveMalPlace = true;
                    }
                    j++;
                }
            }
        }
        System.out.println(Arrays.toString(marked));
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
        for (int i = 0; i < result[0]; i++)
            System.out.print('#');
        for (int i = 0; i < result[1]; i++)
            System.out.print('O');
        System.out.println();
    }


}
