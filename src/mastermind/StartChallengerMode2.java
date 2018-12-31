package mastermind;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartChallengerMode2 {
    int n;
    int m;
    int nMaxTry;


    public StartChallengerMode2(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }



    public void challengeMode2(int n, int m, int nMaxTry) {
        int nTry = 0;
        boolean equalNtry = true;


        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFcombi= IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFcombi);



        AskComb askComb = new AskComb(n);

        CompareVtwo compareVtwo= new CompareVtwo(n);



        do {
            nTry++;
            System.out.println("");
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");
            int[] resultPropos = askComb.AskN();
            int[] resultCompare = compareVtwo.compareVtwo(resultCombi, resultPropos);
            boolean resultTry = compareVtwo.resGame2(resultCompare);
            System.out.println("");
            compareVtwo.showResult(resultCompare);

            equalNtry = resultTry;

        }while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! Vous avez trouvé la combinaison");

        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFcombi);
        }

    }

    }
