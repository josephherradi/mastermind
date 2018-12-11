package gameone;

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
        String[] ResCompare = new String[n];

        for (int i = 0; i < n; i++) {
            if (combinaison[i] == proposition[i]) {
                ResCompare[i] = "=";
            } else if (combinaison[i] < proposition[i]) {
                ResCompare[i] = "-";
            }
            else {
                ResCompare[i] = "+";
            }

        }
        return ResCompare;
    }
}
