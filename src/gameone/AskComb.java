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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez les ");
        System.out.print(" chiffres de votre proposition ");


        String saisie = scanner.next();

        int[] proposition= new int[saisie.length()];

        for (int i = 0; i < saisie.length(); i++) {
            proposition[i] = Integer.parseInt(saisie.charAt(i)+"");
        }
        return proposition;
    }
}

