package fr.joseph.mastermind;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Challenger mode de la recherche +/-
 * Le joueur devine la combinaison secrète de l'IA
 * en nMaxTry coups
 * L'IA donne les indiquations +/-/= au joueur
 */


public class StartChallengerModeGame1 {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;
    boolean dev=true;

    public StartChallengerModeGame1(int n, int m, int nMaxTry, boolean dev) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.dev=dev;
    }

    /**
     * Challenger mode de la recherche +/-
     */

    public void challengeMode() {
        int nTry = 0;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFCombi = Utils.arrayToString(resultCombi);
        if(dev){
        System.out.println("Combinaison de l'IA "+resultFCombi);
            logger.info("Combinaison de l'IA "+resultFCombi);
        }

        AskComb askComb = new AskComb(n);
        CompareGame1 compareGame1 = new CompareGame1(n);



        do {
            nTry++;
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");
            logger.info("Entrez les "+n);
            logger.info("chiffres de votre proposition ");

            int[] resultPropos = askComb.AskN();
            String resultFpropos = Utils.arrayToString(resultPropos);

            logger.info("Proposition "+nTry+": "+resultFpropos);
            String[] resultCompare = compareGame1.compare(resultCombi, resultPropos);
            System.out.println(Arrays.toString(resultCompare));
            logger.info(Arrays.toString(resultCompare));

            boolean resultTry = compareGame1.resGame(resultCompare);
            equalNtry=resultTry;
        } while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! Vous avez trouvé la combinaison en ");
            System.out.print(nTry);
            System.out.println(" essais");
            logger.info("Success ! Vous avez trouvé la combinaison en ");
            logger.info(nTry+" essais");
        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFCombi);
            logger.info("Fail :(");
            logger.info("La combinaison était "+resultFCombi);
        }


    }

}
