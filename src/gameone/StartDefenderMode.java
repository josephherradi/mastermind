package gameone;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StartDefenderMode {
    int n;
    int m;
    int nMaxTry;

    public StartDefenderMode(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }

    static void defenderMode(int n, int m, int nMaxTry) {
        int nTry = 0;
        int[] proposition = new int[n];
        int[] combinaison = new int[n];
        boolean equalNtry = true;
        System.out.print("Entrez les " + n + " chiffres de la combinaison ");

        AskComb askComb = new AskComb(n);
        int[] resultCombi = askComb.AskN();

        String resultFCombi = IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFCombi);

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultPropos = numberGen.combiGen();
        System.out.print("Proposition de l'ordinateur ");
        String resultFPropos = IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFPropos);


        CompareInfSup compareInfSup = new CompareInfSup(n);
        String[] resultCompare = compareInfSup.compare(resultCombi, resultPropos);
        boolean resultTry = compareInfSup.resGame(resultCompare);
        equalNtry = resultTry;


        do {
            nTry++;
            NumberGen numberGen2 = new NumberGen(n, m);
            int[] resultPropos2 = numberGen2.combiGen();
            System.out.print("Proposition de l'ordinateur ");
            String result2FPropos = IntStream.of(resultPropos2).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println(result2FPropos);

            CompareInfSup compareInfSup2 = new CompareInfSup(n);
            String[] resultCompare2 = compareInfSup2.compare(resultCombi, resultPropos2);
            boolean resultTry2 = compareInfSup.resGame(resultCompare2);
            equalNtry = resultTry2;
        } while (!equalNtry && (nTry < nMaxTry-1));

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
}







