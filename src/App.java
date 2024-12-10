package src;

/**
 * TP2 - 420-111 (A24)
 * Classe principale qui gère le flux du programme de gestion de scolarité, incluant la navigation dans le menu
 * et l'exécution des différentes fonctionnalités.
 *
 * @author Sara Boumehraz
 * @version 18/11/2024
 * <p>
 * [Votre nom et prénom]
 * [Votre numDA]
 */
public class App {
    // Les variables de classe (statiques)
    private static int nbrEtudiants;
    private static float[][] notes;
    private static int nbrEvals;
    private static String[][] etudiants; //[0.nom 1.prenom 2.codePermanant] [nbrEtudiant]
    private static String[] evals; // nom des evaluation selon le nb d'evaluation entrer
    private static int[] ponderations;
    private static float[] moyenneEvals;
    private static float[] moyenneEtudiants;
    private static float moyenneClasse;
    private static float[] notesPlusFortesEtudiants; // par etudiants
    private static float[] notesPlusFaiblesEtudiants;// par etudiant
    private static float[] notesPlusFortesEvals; // par evaluation
    private static float[] notesPlusFaiblesEvals; // par evalutation
    private static String stats;
    private static int nbrEtudiantsSucces;

    // Les méthodes de classe (statiques)
    public static void main(String[] args) {
        try {
            demarrerProgramme();
        } catch (NombreEtudiantsDepasseCapaciteException e) {
            System.out.println(e.getMessage());
        } catch (SommePonderationsInvalideException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(Utilitaire.MSG_QUITTER_PROGRAMME);
        }
    }

    /**
     * Démarre le programme et gère le menu principal.
     *
     * @throws NombreEtudiantsDepasseCapaciteException Si le nombre d'étudiants dépasse la capacité.
     * @throws SommePonderationsInvalideException      Si une exception liée à la somme des évaluations est levée.
     */
    public static void demarrerProgramme() throws NombreEtudiantsDepasseCapaciteException, SommePonderationsInvalideException {
        int option;

        System.out.println(Utilitaire.DESCRIPTION_PROGRAMME);
        do {
            option = Validations.validerNombre(Utilitaire.MENU_PRINCIPAL, Utilitaire.PERMIERE_OPTION, 
            Utilitaire.DERNIERE_OPTION);
            appliquerOption(option);
        } while (option != Utilitaire.DERNIERE_OPTION);


    }

    /**
     * Applique l'option sélectionnée par l'utilisateur dans le menu.
     *
     * @param option Numéro de l'option choisie.
     * @throws NombreEtudiantsDepasseCapaciteException Si une exception liée au nombre d'étudiants est levée.
     * @throws SommePonderationsInvalideException      Si une exception liée à la somme des évaluations est levée.
     * @Implementation d'un switch case qui redirige vers les methodes designe selon l'option choisie.
     */
    public static void appliquerOption(int option) throws NombreEtudiantsDepasseCapaciteException, SommePonderationsInvalideException {
        // TODO : à implémenter
        switch (option){
            case 1:
                creerClasseEtudiants();
                break;
            case 2:
                creerGrilleEvaluation();
                break;
            case 3:
                afficherListeEtudiants();
                break;
            case 4:
                afficherListeEvals();
                break;
            case 5:
                entrerResultats();
                break;
            case 6:
                calculerResultats();
                break;
            case 7:
                afficherResultats();
                break;
            case 8:
                afficherStatistiques();
                break;
            case 9:
                trierResultats();
                break;
            case 10:
                creerRapportResultats();
                break;
            case 11:
                quitterProgramme();
                break;
            default:
        }
    }

    /////////////////////////////////////////////////////////////
    //   Méthodes pour appliquer les options du menu pricipal //
    /////////////////////////////////////////////////////////////

    /**
     * Crée une classe d'étudiants et initialise leurs données.
     * (Option 1)
     *
     * @throws NombreEtudiantsDepasseCapaciteException Si le nombre d'étudiants dépasse la capacité.
     */
    public static void creerClasseEtudiants() throws NombreEtudiantsDepasseCapaciteException {
        nbrEtudiants = Validations.validerNbrEtudiants();
        etudiants = new String[nbrEtudiants][3];
        notes = new float[nbrEtudiants][];
        entrerNomsEtudiants();
    }

    /**
     * Crée une grille d'évaluations pour les étudiants.
     * (Option 2)
     *
     * @throws SommePonderationsInvalideException Si une exception liée à la somme des évaluations est levée.
     */
    private static void creerGrilleEvaluation() throws SommePonderationsInvalideException {
        // TODO : à implémenter
        // utiliser validerNombre() pour initialiser nbrEvals
        // initialiser le tableau evals et le tableau ponderations avec la taille nbrEvals
        // boucle avec nbrEval itérations qui appelle validerNomEval() pour insérer les noms des evals
        // et validerNombre() la ponderation
        nbrEvals = Validations.validerNombre(Utilitaire.MSG_SAISI_NBR_EVALS,Utilitaire.MIN_NBR_EVALS, Utilitaire.MAX_NBR_EVALS);
        evals = new String[nbrEvals];
        ponderations = new int[nbrEvals];
        int sommePonderation = 0;
        do{
            for(int i = 0 ; i < evals.length;i++){
                //String nomEval =
                evals[i] = Validations.validerNomEval(i);
                ponderations[i] = Validations.validerNombre(Utilitaire.MSG_SAISI_PONDERATION,Utilitaire.MIN_PONDERATION_EVAL,Utilitaire.MAX_PONDERATION_EVAL);
            }
            sommePonderation = Statistiques.calculerSommePonderation(ponderations);
            if(sommePonderation > Utilitaire.MAX_PONDERATION_EVAL || sommePonderation < Utilitaire.MAX_PONDERATION_EVAL  ){
                throw new SommePonderationsInvalideException();
            }

        }while (sommePonderation != Utilitaire.MAX_PONDERATION_EVAL);

        // validation nom d'eval et entrer des noms dans le tableaux

    }

    /**
     * Affiche la liste des étudiants dans un tableau formaté.
     * (Option 3)
     */
    private static void afficherListeEtudiants() {
        if (etudiants != null) {
            System.out.println(Utilitaire.MSG_AFFICHER_LISTE_ETUDIANTS + obtenirListeEtudiants());
        } else {
            System.out.println(Utilitaire.MSG_ERR_CLASSE_INEXISTANTE);
        }
    }

    /**
     * Affiche la liste des évaluations et leurs pondérations.
     * (Option 4)
     */
    private static void afficherListeEvals() {
        if (evals != null) {
            System.out.println(Utilitaire.MSG_AFFICHER_LISTE_EVALS + obtenirListeEvals());
        } else {
            System.out.println(Utilitaire.MSG_ERR_GRILLE_EVAL_INEXISTANTE);
        }
    }

    /**
     * Gère l'entrée ou la modification des résultats selon les options disponibles.
     * (Option 5)
     */
    private static void entrerResultats() {
        // TODO : à implémenter
        if(etudiants == null || evals == null ){
            System.out.println(Utilitaire.MSG_ERR_NOTES_INEXISTANTE);
        }
        char option ;
        option = Validations.validerLettre(Utilitaire.MENU_ENTRER_NOTES,Utilitaire.MSG_ERR_OPTION_INVALIDE,Utilitaire.OPTIONS_ENTREE_NOTES);
        switch (option){
            case 'a':
                saisirNotesEtudiants();
            break;
            case 'e':
                saisirNotesDunEtudiant();
            break;
            case 'v':
                saisirNotesDuneEvaluation();
            break;
            case 'n':
                saisirNotesDuneEvaluationDunEtudiant();
            break;
            default:
               break;
        }
    }

    /**
     * Calcule les résultats des étudiants et des évaluations puis les sauvegarder.
     * (Option 6)
     */
    private static void calculerResultats() {
        // TODO : à implémenter
        //Moyenne etudiant
        moyenneEtudiants = Statistiques.calculerMoyenneEtudiants(nbrEvals,nbrEtudiants,notes,ponderations,Utilitaire.MAX_PONDERATION_EVAL);
//        float[] sommePondereeEtudiants = new float[nbrEtudiants];
//
//        for (int i = 0; i < nbrEtudiants; i++) {
//            float sommePonderee = 0;
//            for (int j = 0; j < nbrEvals; j++) {
//                sommePonderee += notes[i][j] * ponderations[j];
//            }
//            sommePondereeEtudiants[i] = sommePonderee;
//        }
//        moyenneEtudiants = Statistiques.calculerMoyennes(sommePondereeEtudiants,Utilitaire.MAX_PONDERATION_EVAL);

        //Moyenne de chaque evals
        moyenneEvals = Statistiques.calculerMoyenneEvals(nbrEvals,nbrEtudiants,notes);

//        moyenneEvals = new float[nbrEvals];
//        float[] sommeEvals = new float[nbrEvals];
//
//        for(int i = 0; i < nbrEvals;i++){
//            float sommeEval = 0;
//            for(int j = 0; j < nbrEtudiants;j++){
//                sommeEval += notes[j][i];
//            }
//            sommeEvals[i] = sommeEval;
//        }
//        moyenneEvals = Statistiques.calculerMoyennes(sommeEvals,nbrEtudiants);

        //Moyenne general
        moyenneClasse = Statistiques.calculerMoyenne(moyenneEvals);

        //trouver min/max etudiant
        notesPlusFortesEtudiants = Statistiques.calculerMinMaxNotesEtudiants(notes,true);
        notesPlusFaiblesEtudiants = Statistiques.calculerMinMaxNotesEtudiants(notes,false);

        //trouver min/max etudiant
        notesPlusFortesEvals = Statistiques.calculerMinMaxNotesEval(notes,true);
        notesPlusFaiblesEvals = Statistiques.calculerMinMaxNotesEval(notes,false);

        //etudiant succes
        nbrEtudiantsSucces = Statistiques.calculerNombreEtudiantsSucces(moyenneEtudiants);

        //sauvegarde des statistiques
        sauvegarderStats(moyenneEvals,moyenneEtudiants,moyenneClasse,notesPlusFortesEtudiants,notesPlusFaiblesEtudiants,notesPlusFortesEvals,notesPlusFaiblesEvals,nbrEtudiantsSucces);



    }

    /**
     * Affiche les résultats des étudiants sous forme de tableau.
     * (Option 7)
     */
    private static void afficherResultats() {
        if (etudiants != null) {
            System.out.println(Utilitaire.MSG_AFFICHER_STATS + obtenirResultats());
        } else {
            System.out.println(Utilitaire.MSG_ERR_CLASSE_INEXISTANTE);
        }
    }

    /**
     * Affiche les statistiques calculées sous forme de tableau ou de résumé.
     * (Option 8)
     */
    private static void afficherStatistiques() {
        if (etudiants != null) {
            System.out.println(stats != null ? stats : Utilitaire.AUCUNE_STATISTIQUE_CALCULEE);
        } else {
            System.out.println(Utilitaire.MSG_ERR_CLASSE_INEXISTANTE);
        }
    }

    /**
     * Trie les résultats selon des critères définis ('c' : croissant, 'd' : décroissant).
     * (Option 9 : bonus)
     */
    private static void trierResultats() {
        // TODO: trier les tableau selon la moyenne des étudiants ('c' : croissant, 'd' : décroissant)
        char option = Validations.validerLettre(Utilitaire.MSG_TRIAGE,Utilitaire.MSG_ERR_OPTION_INVALIDE,Utilitaire.OPTION_TRIAGE);
        switch (option){
            case 'c':

            break;
            case 'd':

            break;
        }
    }

    /**
     * Crée les rapports des : liste des étudiants, liste des évaluations, des résultats et les statistiques,
     * puis l'enregistre dans des fichiers.
     * (Option 10)
     */
    private static void creerRapportResultats() {
        // TODO : à implémenter ** Sur Github copy/paste
        if(moyenneEtudiants == null){
            System.out.println("Veuillez calculer les résultats avec l'option 6!");
        }else{
            Utilitaire.ecrireDansFichier(Utilitaire.NOM_FICHIER_RAPPORT_LISTE_ETUDIANTS,obtenirListeEtudiants());
            Utilitaire.ecrireDansFichier(Utilitaire.NOM_FICHIER_RAPPORT_LISTE_EVALS,obtenirListeEvals());
            Utilitaire.ecrireDansFichier(Utilitaire.NOM_FICHIER_RAPPORT_RESULTATS,obtenirResultats());
            Utilitaire.ecrireDansFichier(Utilitaire.NOM_FICHIER_RAPPORT_STATS,stats);

        }
    }

    /**
     * Ferme le scanner et affiche un message de sortie avant de quitter le programme.
     * (Option 11)
     */
    private static void quitterProgramme() {
        // TODO : à implémenter
        System.out.println(Utilitaire.MSG_QUITTER_PROGRAMME);

    }

    ////////////////////////////////////////////////////////////////////////////
    //   Sous-méthodes appelées par les méthodes des options du menu pricipal //
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Permet de formater et retourner les informations des étudiants de la classe dans un tableau
     *
     * @return la liste des étudiants (leur code étudiant, nom et prénom)
     */
    private static String obtenirListeEtudiants() {
        // TODO : à implémenter
        String etudiant = "";
        String listeEtudiant = "";
        String entete = Utilitaire.ENTETE_LISTE_ETUDIANTS;


        for(int i = 0; i < etudiants.length;i++){//check genererStatsEtudiants()
            String nomComplet = Utilitaire.recupererNomComplet(etudiants,i); //Recupere les infos de l'etudiant sur une seul ligne de String
            String[] nomEnPartie = nomComplet.split(" ");// fait un tableau et separe nomComplet avec .split
            String nom = nomEnPartie[0]; // Recupere leurs valeurs
            String prenom = nomEnPartie[1];
            String code = nomEnPartie[2];
            etudiant += String.format(Utilitaire.FORMAT_COLLONNES_LISTE_ETUDIANTS,code,nom,prenom);
        }
        listeEtudiant = Utilitaire.assemblerTableau(entete,etudiant);



        return listeEtudiant;
    }

    /**
     * Permet de formater et retourner les informations des évaluations du cours dans un tableau
     *
     * @return la liste des évaluations (leur numéro, nom et pondération)
     */
    private static String obtenirListeEvals() {
        // TODO : à implémenter
        String evaluation = "";
        String listeEvaluation = "";
        final String entete = Utilitaire.ENTETE_LISTE_EVALS;

        for(int i = 0; i < evals.length;i++){
            evaluation += String.format(Utilitaire.FORMAT_COLLONNES_LISTE_EVALS,i+1,evals[i],ponderations[i]);
        }
        listeEvaluation = Utilitaire.assemblerTableau(entete,evaluation);

        return listeEvaluation;
    }

    /**
     * Permet de formater et retourner les résultats de la classe dans un tableau
     *
     * @return les résultats de la classe
     */
    private static String obtenirResultats() {
        String entete = "\n|          Nom et prenom         |";

        for (String eval : evals) {
            entete += String.format(" %15s |", eval);
        }

        return Utilitaire.assemblerTableau(entete, construireContenuResultat());
    }

    /**
     * Demande à l'utilisateur de saisir les noms des étudiants et génère leurs codes uniques.
     */
    private static void entrerNomsEtudiants() {
        // TODO : à implémenter

        int i ;
        for(i = 0; i < nbrEtudiants; i++){
            String [] prenomsNoms = Validations.validerNomEtudiant(Utilitaire.MSG_SAISIE_NOM_ETUDIANT,i);
            etudiants[i][0] = prenomsNoms[0];
            etudiants[i][1] = prenomsNoms[1];
            etudiants[i][2] = Utilitaire.genererCodeEtudiant(prenomsNoms[0],prenomsNoms[1]);
        }
    }

    /**
     * Gère l'entrée des notes pour tous les étudiants ou toutes les évaluations.
     */
    private static void saisirNotesEtudiants() {
        char choix = Validations.validerLettre(Utilitaire.MENU_ENTRER_NOTES_ETUDIANTS, 
                    Utilitaire.MSG_ERR_OPTION_INVALIDE, Utilitaire.OPTIONS_ENTREE_NOTES_TOUS_ETUDIANTS);
        // TODO : à implémenter
        switch (choix) {
            case 'e':
                entrerNotesParEtudiant();
               // System.out.printf(Utilitaire.MSG_AFFICHAGE_EVALS, Utilitaire.afficherElementsListeSurUneLigne(evals));
                //int notes = Validations.validerNotes(Utilitaire.MSG_ENTRER_NOTES_ETUDIANTS,Utilitaire.ETUDIANT, Utilitaire.EVALUATION,);
                break;
            case 'v':
                entrerNotesParEvaluation();
                break;
            case 'r':
                break;
            default:


        }
    }

    /**
     * Construit un tableau formaté contenant les résultats des étudiants.
     *
     * @return Une chaîne représentant le tableau des résultats.
     */
    private static String construireContenuResultat() {
        String resultats = "";

        for (int i = 0; i < nbrEtudiants; i++) {
            String[] nomComplet = Utilitaire.recupererNomComplet(etudiants, i).split(" ");
            String nomPrenom = String.format("%s %s",nomComplet[0],nomComplet[1]);
            resultats += String.format("\n| %-30s |", nomPrenom);
            for (int j = 0; j < nbrEvals; j++) {
                resultats += String.format(" %15.2f |", notes[i][j]);
            }
        }

        return resultats;
    }
    /**
     * Sauvegarde les statistiques calculées des résultats puis les afficher.
     *
     * @param moyenneEvals              Les moyennes des évaluations.
     * @param moyenneEtudiants          Les moyennes des étudiants.
     * @param moyenneClasse             La moyenne générale de la classe.
     * @param notesPlusFortesEtudiants  Les meilleures notes des étudiants.
     * @param notesPlusFaiblesEtudiants Les pires notes des étudiants.
     * @param notesPlusFortesEvals      Les meilleures notes des évaluations.
     * @param notesPlusFaiblesEvals     Les pires notes des évaluations.
     * @param nbrEtudiantsSucces
     */
    private static void sauvegarderStats(float[] moyenneEvals, float[] moyenneEtudiants, float moyenneClasse,
                                         float[] notesPlusFortesEtudiants, float[] notesPlusFaiblesEtudiants,
                                         float[] notesPlusFortesEvals, float[] notesPlusFaiblesEvals, int nbrEtudiantsSucces) {
        stats = String.format(Utilitaire.RAPPORT_STATS,
                genererStatsEtudiants(notesPlusFortesEtudiants, notesPlusFaiblesEtudiants, moyenneEtudiants),
                genererStatsEvals(notesPlusFortesEvals, notesPlusFaiblesEvals, moyenneEvals),
                moyenneClasse, nbrEtudiantsSucces, nbrEtudiants, (nbrEtudiants - nbrEtudiantsSucces), nbrEtudiants);
        System.out.println(Utilitaire.MSG_STATS_CALCULEES);
    }

    /**
     * Construit un tableau contenant les statistiques par étudiant.
     *
     * @param meilleuresNotes Les meilleures notes des étudiants.
     * @param pireNotes       Les pires notes des étudiants.
     * @param moyennes        Les moyennes des étudiants.
     * @return Une chaîne contenant les statistiques par étudiant.
     */
    private static String genererStatsEtudiants(float[] meilleuresNotes, float[] pireNotes, float[] moyennes) {
        String donnees = "";

        for (int i = 0; i < nbrEtudiants; i++) {
            donnees += String.format(Utilitaire.FORMAT_COLLONNES_STATS_ETUDIANTS,
                    Utilitaire.recupererNomComplet(etudiants, i), meilleuresNotes[i], pireNotes[i],
                    moyennes[i], (moyennes[i] >= Utilitaire.NOTE_PASSAGE ? Utilitaire.SUCCES : Utilitaire.ECHEC));
        }

        return Utilitaire.assemblerTableau(Utilitaire.ENTETE_STATS_ETUDIANTS, donnees);
    }

    /**
     * Construit un tableau contenant les statistiques par évaluation.
     *
     * @param meilleuresNotes Les meilleures notes des évaluations.
     * @param pireNotes       Les pires notes des évaluations.
     * @param moyennes        Les moyennes des évaluations.
     * @return Une chaîne contenant les statistiques par évaluation.
     */
    private static String genererStatsEvals(float[] meilleuresNotes, float[] pireNotes, float[] moyennes) {
        // TODO : à implémenter
        String donnees ="";
        for (int i = 0; i < nbrEvals; i++) {
            donnees += String.format(Utilitaire.FORMAT_COLLONNES_STATS_EVALS, evals[i], meilleuresNotes[i], pireNotes[i],
                    moyennes[i]);
        }
        return Utilitaire.assemblerTableau(Utilitaire.ENTETE_STATS_EVALS, donnees);
    }

    /**
     * Permet de saisir les notes pour une évaluation spécifique.
     */
    private static void saisirNotesDuneEvaluation() {
        // TODO : à implémenter
        String MSG_ERR_NB_ETUDIANT = "Le nombre de notes saisies ne correspond pas au nombre d'étudiant..";
        int posEval = Validations.validerNumEval(nbrEvals);
        float[] listeNoteDuneEvaluation = Validations.validerNotes(Utilitaire.MSG_ENTRER_NOTES,Utilitaire.EVALUATION,evals[posEval-1],MSG_ERR_NB_ETUDIANT,nbrEtudiants);
        for(int i = 0; i < nbrEtudiants; i++){
            notes[i][posEval-1]= listeNoteDuneEvaluation[i];
        }

    }

    /**
     * Permet de saisir les notes pour un étudiant spécifique.
     */
    private static void saisirNotesDunEtudiant() {
        int posEtudiant = Validations.validerCodeEtudiant(etudiants);
        notes[posEtudiant] = Validations.validerNotes(Utilitaire.MSG_ENTRER_NOTES, Utilitaire.ETUDIANT,
                Utilitaire.recupererNomComplet(etudiants, posEtudiant), Utilitaire.MSG_ERR_ENTRER_NOTES, nbrEvals);

    }

    /**
     * Permet de saisir les notes pour une évaluation donnée en parcourant les étudiants.
     */
    private static void entrerNotesParEvaluation() {
        // TODO : à implémenter
        float[] listeNotesEvaluation = new float[nbrEtudiants];
        System.out.printf(Utilitaire.MSG_ENTRER_NOTES_ETUDIANTS,Utilitaire.ETUDIANT,Utilitaire.EVALUATION);
        System.out.printf(Utilitaire.MSG_AFFICHAGE_EVALS, Utilitaire.afficherElementsListeSurUneLigne(evals));
        int i;
        String MSG_ERR_ENTRER_NOTE_PAR_EVALUATION = "Le nombre de notes saisies ne correspond pas au nombre d'étudiants";
        for(i = 0;  i < nbrEvals; i++){
            listeNotesEvaluation = Validations.validerNotes(Utilitaire.MSG_ENTRER_NOTES,Utilitaire.EVALUATION,evals[i],MSG_ERR_ENTRER_NOTE_PAR_EVALUATION,nbrEtudiants);
            for(int j = 0; j < listeNotesEvaluation.length; j++){
                notes[j][i] = listeNotesEvaluation[j];
            }
        }
    }

    /**
     * Permet de saisir les notes pour chaque étudiant en parcourant toutes les évaluations.
     */
    private static void entrerNotesParEtudiant() {
        // TODO : à implémenter
        float[] listeNotesParEtudiants = new float [nbrEvals];
        System.out.printf(Utilitaire.MSG_ENTRER_NOTES_ETUDIANTS, Utilitaire.EVALUATION, Utilitaire.ETUDIANT);
        System.out.printf(Utilitaire.MSG_AFFICHAGE_EVALS, Utilitaire.afficherElementsListeSurUneLigne(evals));

        int i;
        for (i = 0; i < nbrEtudiants; i++) {
            listeNotesParEtudiants = Validations.validerNotes(Utilitaire.MSG_ENTRER_NOTES, Utilitaire.ETUDIANT,
                    Utilitaire.recupererNomComplet(etudiants, i), Utilitaire.MSG_ERR_ENTRER_NOTES, nbrEvals);
            notes[i] = listeNotesParEtudiants;
        }
    }

    /**
     * Permet de saisir la note pour une évaluation spécifique d'un étudiant.
     */
    private static void saisirNotesDuneEvaluationDunEtudiant() {
        // TODO : à implémenter le code est complete, donnee par l'enseignante
        int posEtudiant = Validations.validerCodeEtudiant(etudiants);
        int posEval = Validations.validerNumEval(nbrEvals);
        float noteEtudiant = Validations.validerNote(evals[posEval-1]);

        notes[posEtudiant][posEval] = noteEtudiant;
    }

}
