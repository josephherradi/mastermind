package fr.joseph.mastermind;
import java.util.Arrays;

/**
 * Pour le jeu1 (rechercher +/-) classe qui compare la proposition avec la combinaison
 */
public class CompareGame1 {


    int n;

    public CompareGame1(int n) {
        this.n = n;
    }

    /**
     * pour la recherche +/-
     * compare tirage de l'ordinateur avec la proposition de l'utilisateur
     * @param combinaison
     * @param proposition
     * @return resCompare
     *         tableau de comparaison des combinaisons indiquant +/-/=
     */
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

    /**
     * Résultat du coup joué
     * @param resCompare
     * @return equaltst
     *         booléen si la combinaison correspond à la proposition
     */

    public boolean resGame(String[] resCompare) {

        String success[] = new String[n];
        for (int i=0;i<n;i++){success[i]="=";}
        boolean equaltst = Arrays.equals(resCompare, success);
        return equaltst;
    }
}

