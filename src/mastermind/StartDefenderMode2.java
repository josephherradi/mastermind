package mastermind;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartDefenderMode2 {
    int n;
    int m;
    int nMaxTry;

    public StartDefenderMode2(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }

    public void defenderMode2(int n, int m, int nMaxTry) {
        int nTry = 0;
        boolean equalNtry = true;
        System.out.print("Entrez les " + n + " chiffres de la combinaison ");

        AskComb askComb = new AskComb(n);
        int[] resultCombi = askComb.AskN();

        String resultFCombi = IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFCombi);

        boolean[] resultMarked = new boolean[n];
        int[] resultPropos = new int[n];
        Arrays.fill(resultPropos, 0);

        CompareVtwo compareVtwo = new CompareVtwo(n);

//        resultPropos = this.smartCombiGen2(resultMarked,resultPropos);

        System.out.print("Proposition de l'ordinateur ");
        String resultFPropos = IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFPropos);

/*        resultMarked = compareVtwo.compareVtwo(resultCombi, resultPropos);
        boolean resultTry = compareInfSup.resGame(resultCompare);
        equalNtry = resultTry;


    }

    private int[] smartCombiGen2(boolean[] resultMarked, int[] resultPropos) {
    }*/
        System.out.println("h");

    }
}