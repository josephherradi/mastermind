package fr.joseph.mastermind;

import java.util.Scanner;

/** Classe permettant la saisie d'une combinaison/proposition du joueur
 */

class AskComb{

    int n;
    String saisie;

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
             saisie = scanner.next();
             if(saisie.length()!=n){
              System.out.println("nombre de chiffres incorrects, saisissez "+n+" chiffres");
             }
        }while (saisie.length()!=n);

        int[] proposition= new int[saisie.length()];

        for (int i = 0; i < saisie.length(); i++) {
            proposition[i] = Integer.parseInt(saisie.charAt(i)+"");
        }
        return proposition;
    }
}

