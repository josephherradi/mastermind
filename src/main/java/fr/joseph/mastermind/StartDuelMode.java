package fr.joseph.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Duel Mode: Le joueur et l'IA jouent tour à tour
 * et le premier qui a deviné la combinaison de l'autre a gagné
 */

public class StartDuelMode {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    int n;
    int m;
    int nMaxTry;
    boolean dev=false;


    public StartDuelMode(int n, int m, int nMaxTry,boolean dev) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.dev=dev;
    }

    /**
     * Duel Mode de la Recherche +/-
     * @param n
     *          n chiffres de la combinaisons
     * @param m
     *          chiffre max tiré
     */
    public void duelMode1(int n, int m, boolean dev) {

        NumberGen numberGen = new NumberGen(n, m);
        AskComb askComb = new AskComb(n);
        CompareInfSup compareInfSup = new CompareInfSup(n);

        int[] resultCombi1 = numberGen.combiGen();
        String resultFcombi1 = IntStream.of(resultCombi1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        if(dev){
            System.out.println("Combinaison de secrète l'IA " + resultFcombi1);
            logger.info("Combinaison de secrète l'IA " + resultFcombi1);
        }

        System.out.println("Entrez la combinaison secrète du joueur");
        logger.info("Entrez la combinaison secrète du joueur");
        int[] resultCombi2 = askComb.AskN();
        String resultFCombi2 = IntStream.of(resultCombi2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison secrète du joueur " + resultFCombi2);
        logger.info("Combinaison secrète du joueur " + resultFCombi2);

        // initialisation variables defender

        String[] resultCompare2 = new String[n];
        Arrays.fill(resultCompare2, "0");
        int[] resultPropos2 = new int[n];
        Arrays.fill(resultPropos2, 0);

        boolean resultTryGamer=false;
        boolean resultTryIA=false;
        do {
            System.out.println("Proposition du joueur");
            logger.info("Proposition du joueur");
            int[] resultPropos1 = askComb.AskN();
            String resultFpropos1= IntStream.of(resultPropos1).mapToObj(String::valueOf).collect(Collectors.joining(""));

            logger.info(resultFpropos1);

            String[] resultCompare1 = compareInfSup.compare(resultCombi1, resultPropos1);
            System.out.println(Arrays.toString(resultCompare1));
            logger.info(Arrays.toString(resultCompare1));

            resultTryGamer = compareInfSup.resGame(resultCompare1);

            if(!resultTryGamer){
                this.promptEnterKey();

            System.out.print("Proposition de l'ordinateur ");
            logger.info("Proposition de l'ordinateur ");
            resultPropos2 = this.smartCombiGen(resultCompare2, resultPropos2);
            String resultFPropos2 = IntStream.of(resultPropos2).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println(resultFPropos2);
            logger.info(resultFPropos2);

            resultCompare2 = compareInfSup.compare(resultCombi2, resultPropos2);
            System.out.println(Arrays.toString(resultCompare2));
            logger.info(Arrays.toString(resultCompare2));

            resultTryIA = compareInfSup.resGame(resultCompare2);}
            this.resultGame(resultTryGamer,resultTryIA);
        } while (!(resultTryGamer ^ resultTryIA));

    }

    /**
     * Duel Mode du Mastermind
     * @param n
     *          n chiffres de la combinaison
     * @param m
     *          chiffre max pour le tirage
     */
    public void duelMode2(int n, int m, boolean dev) {

        NumberGen numberGen = new NumberGen(n, m);
        AskComb askComb = new AskComb(n);
        CompareVtwo compareVtwoIA = new CompareVtwo(n);
        CompareVtwo compareVtwoGamer = new CompareVtwo(n);



        int[] resultCombi1 = numberGen.combiGen();
        String resultFcombi1 = IntStream.of(resultCombi1).mapToObj(String::valueOf).collect(Collectors.joining(""));
       if(dev){
        System.out.println("Combinaison secrète de l'IA " + resultFcombi1);
       logger.info("Combinaison secrète de l'IA " + resultFcombi1);
       }
        System.out.println("Entrez la combinaison secrète du joueur");
       logger.info("Entrez la combinaison secrète du joueur");
        int[] resultCombi2 = askComb.AskN();
        String resultFCombi2 = IntStream.of(resultCombi2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("Combinaison secrète du joueur " + resultFCombi2);
        logger.info("Combinaison secrète du joueur " + resultFCombi2);

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
            logger.info("Proposition du joueur");
            int[] resultPropos1 = askComb.AskN();
            String resultFpropos1= IntStream.of(resultPropos1).mapToObj(String::valueOf).collect(Collectors.joining(""));

            logger.info(resultFpropos1);

            result1 = compareVtwoGamer.compareVtwo(resultCombi1, resultPropos1);
            compareVtwoGamer.showResult(result1);

            resultTryGamer = compareVtwoGamer.resGame2(result1);

            if(!resultTryGamer){
                this.promptEnterKey();


                System.out.print("Proposition de l'ordinateur ");
                logger.info("Proposition de l'ordinateur ");

                resultPropos2 = this.smartCombiGen2(marked, resultPropos2);
                String resultFPropos2 = IntStream.of(resultPropos2).mapToObj(String::valueOf).collect(Collectors.joining(""));
                System.out.println(resultFPropos2);
                logger.info(resultFPropos2);

                result2 = compareVtwoIA.compareVtwo(resultCombi2, resultPropos2);
                marked=compareVtwoIA.getMarked1();
                compareVtwoIA.showResult(result2);


                resultTryIA = compareVtwoIA.resGame2(result2);}

            this.resultGame(resultTryGamer,resultTryIA);
        } while (!(resultTryGamer ^ resultTryIA));

    }

    /**
     * Donne le résultat du Duel Mode lorsque le premier a deviné
     * la combinaison de l'autre
     * @param resultTryGamer
     *          booleen résultat du coup du joueur
     * @param resultTryIA
     *          booleen résultat du coup de l'IA
     */
    public void resultGame(boolean resultTryGamer, boolean resultTryIA) {
        if (resultTryGamer && !resultTryIA) {
            System.out.println("Bravo le joueur a gagné!");
            logger.info("Bravo le joueur a gagné!");
        } else if (resultTryIA && !resultTryGamer) {
            System.out.println("L'IA a gagné :(");
            logger.info("L'IA a gagné :(");
        }
    }

    /** Dans le duel mode de la recherche +/-, pour la partie defender
     * Tirage "intelligent" en ajustant les bornes du tirage
     * @param p
     *          borne inférieure pour le tirage du chiffre
     * @param m2
     *          borne supérieure pour le tirage du chiffre
     * @return
     */

    private int smartPickN(int p, int m2) {

        return p + (int) (Math.random() * m2);
    }

    /** Dans le duel mode de la recherche +/-, pour la partie defender
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
    /**
     *Dans le duel mode mastermind, pour la partie defender
     * Tirage d'un chiffre aléatoire
     * @return
     *         chiffre aléatoire tiré entre 1 et m
     */

    private int PickN() {

        return 1 + (int) (Math.random() * m);
    }

    /**
     *Dans le duel mode mastermind, pour la partie defender
     * @param marked
     *          tableau de booleen marked indiquant les chiffres présents et bien placés
     * @param resultPropos
     *          proposition précédente de l'IA
     * @return
     *          tire une nouvelle proposition
     *          (si un chiffre est bien deviné, il est gardé
     *          sinon nouveau tirage)
     */


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
        logger.info("Appuyez sur entrée pour continuer...");
        Scanner prompt = new Scanner(System.in);
        prompt.nextLine();
    }


}