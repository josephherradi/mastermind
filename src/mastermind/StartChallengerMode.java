package mastermind;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartChallengerMode {

    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;

    public StartChallengerMode(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.equalNtry=equalNtry;
    }

    public boolean isEqualNtry() {
        return equalNtry;
    }

    public void challengeMode(int n, int m, int nMaxTry) {
        int nTry = 0;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFcombi= IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFcombi);

        AskComb askComb = new AskComb(n);
        CompareInfSup compareInfSup = new CompareInfSup(n);



        do {
            nTry++;
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");

            int[] resultPropos = askComb.AskN();
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
            System.out.println(resultFcombi);
        }

    }
}
