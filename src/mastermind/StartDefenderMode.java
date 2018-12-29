package mastermind;

import java.util.Arrays;
import java.util.Scanner;
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

    public void defenderMode(int n, int m, int nMaxTry) {
        int nTry = 0;
        boolean equalNtry = true;
        System.out.print("Entrez les " + n + " chiffres de la combinaison ");

        AskComb askComb = new AskComb(n);
        int[] resultCombi = askComb.AskN();

        String resultFCombi = IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(resultFCombi);

        String[] resultCompare= new String[n];
        Arrays.fill(resultCompare,"0");
        int[] resultPropos= new int[n];
        Arrays.fill(resultPropos,0);

        CompareInfSup compareInfSup = new CompareInfSup(n);



        do {
            nTry++;
            this.promptEnterKey();

            resultPropos = this.smartCombiGen(resultCompare,resultPropos);
            System.out.print("Proposition de l'ordinateur ");
            String resultFPropos = IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println(resultFPropos);

            resultCompare = compareInfSup.compare(resultCombi, resultPropos);
            boolean resultTry = compareInfSup.resGame(resultCompare);
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

    private int smartPickN(int p ,int m2) {

        return p + (int) (Math.random() * m2);
    }

    public int[] smartCombiGen(String[] resultCompare, int[] resultPropos) {
        int[] smartPropos = new int[n];
        for (int i = 0; i < n; i++) {
            if (resultCompare[i] == "=") {
                smartPropos[i] = resultPropos[i];
            } else if (resultCompare[i] == "+") {
                int m2 = 9-(resultPropos[i] + 1);
                int p= resultPropos[i] + 1;
                smartPropos[i] = smartPickN(p,m2);
            } else if (resultCompare[i] == "-") {
                int m2 = resultPropos[i] - 1;
                int p=1;
                smartPropos[i] = smartPickN(p,m2);
            }
            else if(resultCompare[i]=="0"){
                smartPropos[i]=smartPickN(1,9);
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








