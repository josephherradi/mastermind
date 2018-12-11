package gameone;

public class NumberGen {
    /**
     * Genere une combinaison aléatoire à n chiffres avec m chiffre max
     */


    int n;
    int m;

    public NumberGen(int n, int m) {
        this.n = n;
        this.m = m;
    }

    private int pickN(int m) {
        return 1 + (int) (Math.random() * m);
    }

    public int[] combiGen() {
        int[] combinaison= new int[n];
        for (int i = 0; i < n; i++) {
            combinaison [i] = pickN(m);
        }
        return combinaison;
    }

}
