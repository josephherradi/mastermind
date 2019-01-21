package fr.joseph.mastermind;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Pour le jeu 2 (mastermind), classe comparant la proposition et la combinaison
 */

public class CompareGame2 {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());


    int n;
    boolean[] marked1;
    boolean[] marked2;


    public CompareGame2(int n) {
        this.n = n;
        marked1 = new boolean[this.n];
        marked2 = new boolean[this.n];
    }

    public boolean[] getMarked1() {
        return marked1;
    }


    /**Pour le jeu mastermind
     * Compare la combinaison avec la proposition
     * @param combinaison
     * @param proposition
     * @return result
     *          result[0]:le nombre de chiffres présents et bien placés
     *          result[1]: le nombre de chiffres présents et mal placés
     */



    public int[] compareComb(int[] combinaison, int[] proposition) {
        int nb1 = 0;
        int nb2 = 0;
        int[] result= new int[2];


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

        result[0] = nb1;
        result[1] = nb2;
        return result;
    }

    /**
     * Résulat du coup joué
     * @param result
     * @return success
     *         booléen qui donne le résultat du coup  true si n chiffres de la combinaison secrete
     *         sont présents et bien devinés
     */

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
        logger.info(result[0]+" chiffres bien présents et bien placés");
        logger.info(result[1]+" chiffres bien présents et mal placés");

    }




}
