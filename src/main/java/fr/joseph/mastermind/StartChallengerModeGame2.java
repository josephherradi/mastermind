package fr.joseph.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Challenger mode du mastermind
 * Le joueur devine la combinaison de l'IA en nMaxTry coups
 * L'IA indique le nombre de chiffres présents et bien placés
 * et le nombre de chiffres présents et pas bien placés
 */

public class StartChallengerModeGame2 {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;
    boolean dev=true;



    public StartChallengerModeGame2(int n, int m, int nMaxTry, boolean dev) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.dev=dev;

    }

    /**
     * Challenger mode pour le mastermind
     */

    public void challengeMode2() {
        int nTry = 0;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFCombi = Utils.arrayToString(resultCombi);

        if(dev){
        System.out.println("Combinaison de l'IA "+resultFCombi);
        logger.info("Combinaison de l'IA "+resultFCombi);
        }



        AskComb askComb = new AskComb(n);

        CompareGame2 compareGame2 = new CompareGame2(n);



        do {
            nTry++;
            System.out.println("");
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");
            logger.info("Entrez les "+n);
            logger.info("chiffres de votre proposition ");
            int[] resultPropos = askComb.AskN();
            String resultFpropos = Utils.arrayToString(resultPropos);

            logger.info("Proposition "+nTry+": "+resultFpropos);
            int[] resultCompare = compareGame2.compareComb(resultCombi, resultPropos);
            boolean resultTry = compareGame2.resGame2(resultCompare);
            System.out.println("");
            compareGame2.showResult(resultCompare);

            equalNtry = resultTry;

        }while (!equalNtry && (nTry < nMaxTry));

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
