package mastermind;

import java.util.Scanner;

/** permet la saisie d'une combinaison du joueur
 */

class AskComb{

    int n;

    public AskComb(int n) {
        this.n = n;
    }

    public int [] AskN() {

        Scanner scanner = new Scanner(System.in);

        String saisie = scanner.next();

        int[] proposition= new int[saisie.length()];

        for (int i = 0; i < saisie.length(); i++) {
            proposition[i] = Integer.parseInt(saisie.charAt(i)+"");
        }
        return proposition;
    }
}

