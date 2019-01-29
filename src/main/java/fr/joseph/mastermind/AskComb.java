package fr.joseph.mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Classe permettant la saisie d'une combinaison/proposition du joueur
 */

class AskComb{

    int n;
    String saisieStr;

    public AskComb(int n) {
        this.n = n;
    }

    /**
     *Demande la saisie d'une combinaison/proposition joueur
     * @return un tableau d'entiers à n chiffres
     */

    public int [] AskN() {

        Scanner scanner = new Scanner(System.in);

        do {
            while (true) {
                saisieStr = scanner.next();
                int saisieInt = 0;
                    try {
                        saisieInt = Integer.parseInt(saisieStr);
                    break;
                    } catch (NumberFormatException e) {
            System.out.println("Erreur de format, saisissez une combinaison à "+n+" chiffres");
        }
         }
            if(saisieStr.length()!=n){System.out.println("Saisissez une combinaison à "+n+" chiffres");}

        }while (saisieStr.length()!=n);


        int[] proposition= new int[saisieStr.length()];

        for (int i = 0; i <saisieStr.length(); i++) {
            proposition[i] = Integer.parseInt(saisieStr.charAt(i)+"");
        }
        return proposition;
    }
}

