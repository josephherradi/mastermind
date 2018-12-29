package mastermind;

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


        System.out.print("Entrez les " + n + " chiffres de la combinaison ");

        AskComb askComb = new AskComb(n);
        int[] resultPropos = askComb.AskN();

        CompareVtwo compareVtwo= new CompareVtwo(n);

        int[] resultCompare = compareVtwo.compareVtwo(resultCombi,resultPropos);
        boolean resultTry = compareVtwo.resGame2(resultCompare);
        equalNtry=resultTry;

        compareVtwo.showResult(resultCompare);



        if (equalNtry) {
            System.out.print("Success ! Vous avez trouvé la combinaison");

        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFcombi);
        }

    }

    }
