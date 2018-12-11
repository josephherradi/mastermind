package gameone;

import java.util.Scanner;

class AskComb{
    /**
     * demande une combinaison à n chiffres
     */

    int n;

    public AskComb(int n) {
        this.n = n;
    }

    public int [] AskN() {
        int[] proposition= new int[n];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez les ");
        System.out.print(n);
        System.out.print(" chiffres de votre proposition ");
        for (int i = 0; i < n; i++) {
            proposition[i] = scanner.nextInt();
        }
        return proposition;
    }
}

