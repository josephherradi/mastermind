package mastermind;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartDuelMode {
    int n;
    int m;
    int nMaxTry;

    public StartDuelMode(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }


    public void duelMode1(int n, int m, int nMaxTry) {

        NumberGen numberGen = new NumberGen(n, m);
        AskComb askComb = new AskComb(n);
        CompareInfSup compareInfSup = new CompareInfSup(n);


        int[] resultCombi1 = numberGen.combiGen();
        String resultFcombi1 = IntStream.of(resultCombi1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison de l'IA " + resultFcombi1);
        System.out.println("Entrez la combinaison du joueur");
        int[] resultCombi2 = askComb.AskN();
        String resultFCombi2 = IntStream.of(resultCombi2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison du joueur " + resultFCombi2);

        // initialisation variables defender

        String[] resultCompare2 = new String[n];
        Arrays.fill(resultCompare2, "0");
        int[] resultPropos2 = new int[n];
        Arrays.fill(resultPropos2, 0);

        boolean resultTryGamer=false;
        boolean resultTryIA=false;
        do {
            System.out.println("Proposition du joueur");
            int[] resultPropos1 = askComb.AskN();

            String[] resultCompare1 = compareInfSup.compare(resultCombi1, resultPropos1);
            resultTryGamer = compareInfSup.resGame(resultCompare1);

            if(!resultTryGamer){

            System.out.print("Proposition de l'ordinateur ");
            resultPropos2 = this.smartCombiGen(resultCompare2, resultPropos2);
            String resultFPropos2 = IntStream.of(resultPropos2).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println(resultFPropos2);

            resultCompare2 = compareInfSup.compare(resultCombi2, resultPropos2);
            resultTryIA = compareInfSup.resGame(resultCompare2);}
            this.resultGame(resultTryGamer,resultTryIA);
        } while (!(resultTryGamer ^ resultTryIA));

    }


    public void duelMode2(int n, int m, int nMaxTry) {

        NumberGen numberGen = new NumberGen(n, m);
        AskComb askComb = new AskComb(n);
        CompareVtwo compareVtwoIA = new CompareVtwo(n);
        CompareVtwo compareVtwoGamer = new CompareVtwo(n);



        int[] resultCombi1 = numberGen.combiGen();
        String resultFcombi1 = IntStream.of(resultCombi1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison de l'IA " + resultFcombi1);
        System.out.println("Entrez la combinaison du joueur");
        int[] resultCombi2 = askComb.AskN();
        String resultFCombi2 = IntStream.of(resultCombi2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison du joueur " + resultFCombi2);

        // initialisation variables defender

        boolean[] marked= new boolean[n];
        int[] resultPropos2= new int[n];
        Arrays.fill(resultPropos2,0);
        int[] result1= new int[2];
        int[] result2= new int[2];


        boolean resultTryGamer=false;
        boolean resultTryIA=false;
        do {
            System.out.println("Proposition du joueur");
            int[] resultPropos1 = askComb.AskN();

            result1 = compareVtwoGamer.compareVtwo(resultCombi1, resultPropos1);
            resultTryGamer = compareVtwoGamer.resGame2(result1);

            if(!resultTryGamer){

                System.out.print("Proposition de l'ordinateur ");

                resultPropos2 = this.smartCombiGen2(marked, resultPropos2);
                String resultFPropos2 = IntStream.of(resultPropos2).mapToObj(String::valueOf).collect(Collectors.joining(""));
                System.out.println(resultFPropos2);

                result2 = compareVtwoIA.compareVtwo(resultCombi2, resultPropos2);
                marked=compareVtwoIA.getMarked1();

                resultTryIA = compareVtwoIA.resGame2(result2);}

            this.resultGame(resultTryGamer,resultTryIA);
        } while (!(resultTryGamer ^ resultTryIA));

    }


    public void resultGame(boolean resultTryGamer, boolean resultTryIA) {
        if (resultTryGamer && !resultTryIA) {
            System.out.println("Bravo le joueur a gagné!");
        } else if (resultTryIA && !resultTryGamer) {
            System.out.println("L'IA a gagné :(");
        }
    }


    private int smartPickN(int p, int m2) {

        return p + (int) (Math.random() * m2);
    }

    public int[] smartCombiGen(String[] resultCompare, int[] resultPropos) {
        int[] smartPropos = new int[n];
        for (int i = 0; i < n; i++) {
            if (resultCompare[i] == "=") {
                smartPropos[i] = resultPropos[i];
            } else if (resultCompare[i] == "+") {
                int m2 = 9 - (resultPropos[i] + 1);
                int p = resultPropos[i] + 1;
                smartPropos[i] = smartPickN(p, m2);
            } else if (resultCompare[i] == "-") {
                int m2 = resultPropos[i] - 1;
                int p = 1;
                smartPropos[i] = smartPickN(p, m2);
            } else if (resultCompare[i] == "0") {
                smartPropos[i] = smartPickN(1, 9);
            }
        }
        return smartPropos;

    }


    private int PickN() {

        return 1 + (int) (Math.random() * m);
    }
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


}