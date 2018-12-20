package gameone;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartChallengerMode {

    int n;
    int m;
    int nMaxTry;

    public StartChallengerMode(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }

    static void challengeMode(int n, int m, int nMaxTry) {
        int nTry = 0;
        int[] proposition = new int[n];
        int[] combinaison = new int[n];
        boolean equalNtry= true;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFcombi= IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFcombi);

        do {
            nTry++;
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");

            AskComb askComb = new AskComb(n);
            int[] resultPropos = askComb.AskN();

            CompareInfSup compareInfSup = new CompareInfSup(n);
            String[] resultCompare = compareInfSup.compare(resultCombi, resultPropos);
            boolean resultTry = compareInfSup.resGame(resultCompare);
            equalNtry=resultTry;
        } while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! Vous avez trouvé la combinaison en ");
            System.out.print(nTry);
            System.out.println(" essais");
        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(Arrays.toString(resultCombi));
        }

    }
}
