package fr.joseph.mastermind;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartChallengerMode {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());


    /**
     * Challenger mode de la recherche +/-
     * Le joueur devine la combinaison secrète de l'IA
     * en nMaxTry coups
     * L'IA donne les indiquations +/-/= au joueur
     */
    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;
    boolean dev=true;

    public StartChallengerMode(int n, int m, int nMaxTry, boolean dev) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.dev=dev;
    }







    public void challengeMode(int n, int m, int nMaxTry, boolean dev) {
        int nTry = 0;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFcombi= IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));
        if(dev){
        System.out.println("Combinaison de l'IA "+resultFcombi);}

        AskComb askComb = new AskComb(n);
        CompareInfSup compareInfSup = new CompareInfSup(n);



        do {
            nTry++;
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");

            int[] resultPropos = askComb.AskN();

            String[] resultCompare = compareInfSup.compare(resultCombi, resultPropos);
            System.out.println(Arrays.toString(resultCompare));

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
        logger.info("Start of setUp");


    }

}
