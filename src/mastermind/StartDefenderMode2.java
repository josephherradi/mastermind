package mastermind;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Defender mode du mastermind
 * L'IA devine la combinaison secrète du joueur en nMaxTry coups.
 * Si un chiffre tiré est présent et bien placé, il est gardé
 * sinon nouveau tirage
 */

public class StartDefenderMode2 {
    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;


    public StartDefenderMode2(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.equalNtry=equalNtry;
    }

    public boolean isEqualNtry() {
        return equalNtry;
    }

    public void defenderMode2(int n, int m, int nMaxTry) {
        int nTry = 0;
        System.out.print("Entrez les " + n + " chiffres de la combinaison ");

        AskComb askComb = new AskComb(n);
        int[] resultCombi = askComb.AskN();

        String resultFCombi = IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFCombi);

        boolean[] marked= new boolean[n];
        int[] resultPropos= new int[n];
        Arrays.fill(resultPropos,0);
        int[] result= new int[2];

        CompareVtwo compareVtwo = new CompareVtwo(n);


        do {
            nTry++;
            this.promptEnterKey();

            resultPropos = this.smartCombiGen2(marked,resultPropos);
            System.out.print("Proposition de l'ordinateur ");
            String resultFPropos = IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println(resultFPropos);

            result = compareVtwo.compareVtwo(resultCombi, resultPropos);

            // tableau de booleen marked indiquant les chiffres présents et bien placés
            marked=compareVtwo.getMarked1();

            compareVtwo.showResult(result);
            boolean resultTry = compareVtwo.resGame2(result);
            equalNtry = resultTry;


        } while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! L'ordinateur a trouvé la combinaison en ");
            System.out.print(nTry);
            System.out.println(" essais");
        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFCombi);
        }

    }

    /**
     * Tirage d'un chiffre aléatoire
     * @return
     *         chiffre aléatoire tiré entre 1 et m
     */


    private int PickN() {

        return 1 + (int) (Math.random() * m);
    }


    /**
     *
     * @param marked
     *          tableau de booleen marked indiquant les chiffres présents et bien placés
     * @param resultPropos
     *          proposition précédente de l'IA
     * @return
     *          tire une nouvelle proposition
     *          (si un chiffre est bien deviné, il est gardé
     *          sinon nouveau tirage)
     */

    public int[] smartCombiGen2(boolean[] marked,int[] resultPropos) {
        int[] smartPropos = new int[n];
        for (int i = 0; i < n; i++) {
            if (marked[i] == true) {
                smartPropos[i] = resultPropos[i];
            } else if (marked[i] == false) {
                smartPropos[i] = PickN();
        }

    }
        return smartPropos;
    }

    public void promptEnterKey(){
        System.out.println("Appuyez sur entrée pour continuer...");
        Scanner prompt = new Scanner(System.in);
        prompt.nextLine();
    }
}