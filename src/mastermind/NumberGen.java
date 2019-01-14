package mastermind;

public class NumberGen {
    /**
     * Genere une combinaison aléatoire à n chiffres avec m chiffre max
     *
     */


    int n;
    int m;

    public NumberGen(int n, int m) {
        this.n = n;
        this.m = m;
    }

    /**
     * Tirage d'un chiffre max
     * @param m
     *          chiffre max
     * @return chiffre aléatoire tiré
     */
    private int pickN(int m) {
        return 1 + (int) (Math.random() * m);
    }

    /**
     * Génère une combinaison aléatoire à n chiffres
     * @return combinaison
     */

    public int[] combiGen() {
        int[] combinaison= new int[n];
        for (int i = 0; i < n; i++) {
            combinaison [i] = pickN(m);
        }
        return combinaison;
    }

}
