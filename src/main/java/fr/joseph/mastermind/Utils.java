package fr.joseph.mastermind;

/**
 * Transforme un tableau d'entiers en chaine de caractères
 * utilité pour le logging
 */
public class Utils {
    /**
     * Convertit un tableau d'int en String
     * @param tab tableau d'entiers
     * @return chaine de caractères
     */
    public static String arrayToString(int[] tab){
        String result="";
        for (int i = 0; i <tab.length ; i++) {
            result=result+tab[i];

        }
        return result;
    }
}
