package mastermind;
import java.util.Arrays;

public class CompareInfSup {
    /**
     * compare tirage de l'ordinateur avec la proposition de l'utilisateur
     * en indiquant  +/-/= en sortie
     */
    int n;

    public CompareInfSup(int n) {
        this.n = n;
    }

    public String[] compare(int[] combinaison, int[] proposition) {
        String[] resCompare = new String[n];
        try {
        for (int i = 0; i < n; i++) {

               if (combinaison[i] == proposition[i]) {
                   resCompare[i] = "=";
               } else if (combinaison[i] < proposition[i]) {
                   resCompare[i] = "-";
               } else {
                   resCompare[i] = "+";
               }

           }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Veuillez proposer une combinaison à "+n+" chiffres");
        }
        return resCompare;
    }

    public boolean resGame(String[] resCompare) {

        String success[] = new String[n];
        for (int i=0;i<n;i++){success[i]="=";}
        boolean equaltst = Arrays.equals(resCompare, success);
        return equaltst;
    }
}

