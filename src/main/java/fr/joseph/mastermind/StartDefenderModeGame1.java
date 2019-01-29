package fr.joseph.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Defender mode de la recherche +/-
 * L'IA devine la combinaison secrète du joueur en
 * nMaxTry coups
 * L'IA utilise les indications +/-/= pour tirer des nouvelles propositions
 */

public class StartDefenderModeGame1 {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;


    public StartDefenderModeGame1(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;

    }

    /**
     * Defender mode de la recherche +/-
     */

    public void defenderMode() {
        int nTry = 0;
        System.out.print("Entrez les " + n + " chiffres de la combinaison du joueur ");
        logger.info("Entrez les " + n + " chiffres de la combinaison du joueur ");

        AskComb askComb = new AskComb(n);
        int[] resultCombi = askComb.AskN();

        String resultFCombi = Utils.arrayToString(resultCombi);
        logger.info(resultFCombi);
//        System.out.println(resultFCombi);

        String[] resultCompare= new String[n];
        Arrays.fill(resultCompare,"0");
        int[] resultPropos= new int[n];
        Arrays.fill(resultPropos,0);

        CompareGame1 compareGame1 = new CompareGame1(n);



        do {
            nTry++;
            this.promptEnterKey();

            resultPropos = this.smartCombiGen(resultCompare,resultPropos);
            System.out.print("Proposition de l'ordinateur ");
            logger.info("Proposition de l'ordinateur ");
            String resultFPropos = Utils.arrayToString(resultPropos);
            System.out.println(resultFPropos);
            logger.info(resultFPropos);

            resultCompare = compareGame1.compare(resultCombi, resultPropos);
            System.out.println(Arrays.toString(resultCompare));
            logger.info(Arrays.toString(resultCompare));
            boolean resultTry = compareGame1.resGame(resultCompare);
            equalNtry = resultTry;


        } while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! L'ordinateur a trouvé la combinaison en ");
            System.out.print(nTry);
            System.out.println("essais");
            logger.info("Success ! L'ordinateur a trouvé la combinaison en ");
            logger.info(nTry+" essais");
        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFCombi);
            logger.info("Fail :( ");
            logger.info("La combinaison était "+resultFCombi);
        }

    }

    /**
     * Tirage "intelligent" en ajustant les bornes du tirage
     * @param p
     *          borne inférieure pour le tirage du chiffre
     * @param m2
     *          borne supérieure pour le tirage du chiffre
     * @return
     */

    private int smartPickN(int p ,int m2) {

        return p + (int) (Math.random() * m2);
    }

    /**
     * Génère une combinaison intelligente en utilisant le tableau de comparaison
     * entre la combinaison secrète et la proposition
     * @param resultCompare
     * @param resultPropos
     * @return smartPropos
     *          si le chiffre est bien deviné, il est gardé
     *          sinon on "smartPick" en ajustant les bornes du tirage
     */

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
        logger.info("Appuyez sur entrée pour continuer...");
        Scanner prompt = new Scanner(System.in);
        prompt.nextLine();
    }
}








