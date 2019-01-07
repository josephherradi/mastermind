package mastermind;

import java.util.Arrays;
import java.util.Scanner;
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

            marked=compareVtwo.getMarked1();
            System.out.println(Arrays.toString(marked));

            compareVtwo.showResult(result);
            boolean resultTry = compareVtwo.resGame2(result);
            equalNtry = resultTry;


        } while (!equalNtry && (nTry < nMaxTry - 1));

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

        /*NumberGen numberGen=new NumberGen(n,m);

        int[] resultPropos= numberGen.combiGen();

        System.out.print("Proposition de l'ordinateur ");
        String resultFPropos = IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFPropos);

        CompareVtwo compareVtwo=new CompareVtwo(n);
        int[] resultCompare=compareVtwo.compareVtwo(resultCombi,resultPropos);
        boolean resultTry=compareVtwo.resGame2(resultCompare);

        if(resultTry){
            System.out.println("sucess");
        }
        else
        { System.out.println("fail");}

        compareVtwo.showResult(resultCompare);*/




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

    public void promptEnterKey(){
        System.out.println("Appuyez sur entrée pour continuer...");
        Scanner prompt = new Scanner(System.in);
        prompt.nextLine();
    }
}