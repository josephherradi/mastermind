package fr.joseph.mastermind;
/**
 * Genere une combinaison aléatoire à n chiffres avec m chiffre max
 *
 */
public class NumberGen {
    int n;
    int m;

    public NumberGen(int n, int m) {
        this.n = n;
        this.m = m;
    }

    /**
     * Tirage d'un chiffre max
     * @return chiffre aléatoire tiré
     */
    private int pickN() {
        return 1 + (int) (Math.random() * m);
    }

    /**
     * Génère une combinaison aléatoire à n chiffres
     * @return combinaison
     */

    public int[] combiGen() {
        int[] combinaison= new int[n];
        for (int i = 0; i < n; i++) {
            combinaison [i] = pickN();
        }
        return combinaison;
    }

}
