package src;

public class Utilitaire {
    public static final int PERMIERE_OPTION = 1;
    public static final int DERNIERE_OPTION = 11;
    public static final int CAPACITE_MIN_CLASSE = 1;
    public static final int CAPACITE_MAX_CLASSE = 30;
    public static final int MIN_NBR_EVALS = 1;
    public static final int MAX_NBR_EVALS = 10;
    public static final int MIN_TAILLE_NOM_EVAL = 2;
    public static final int MAX_TAILLE_NOM_EVAL = 15;
    public static final int MIN_PONDERATION_EVAL = 0;
    public static final int MAX_PONDERATION_EVAL = 100;
    public static final float NOTE_PASSAGE = 60.0F;
    public static final String MSG_QUITTER_PROGRAMME = "Au revoir!";
    public static final String OPTIONS_ENTREE_NOTES = "vaner";
    public static final String OPTIONS_ENTREE_NOTES_TOUS_ETUDIANTS = "ver";
    public static final String ETUDIANT = "étudiant";
    public static final String EVALUATION = "évaluation";
    public static final String SUCCES = "succès";
    public static final String ECHEC = "échec";
    public static final String SEPARATEUR_NOM = "_";
    public static final String NOM_COURS_CLASSE = "420-111";
    public static final String DESCRIPTION_PROGRAMME = "Système de gestion de scolarité et résultats du cours 420-111\n";
    public static final String MENU_PRINCIPAL = "\n=========================================\n\t\t\tMenu principal\n=========================================\nVeuillez choisir une des options suivantes : \n\t1. Créer une classe d’étudiants\n\t2. Créer une grille d’évaluation\n\t3. Affiche la liste des étudiants\n\t4. Afficher la liste des évaluations\n\t5. Entrer / modifier des résultats\n\t6. Calculer les résultats\n\t7. Afficher les résultats\n\t8. Afficher les statistiques\n\t9. Trier les résultats\n\t10. Créer les rapports des résultats et statistiques\n\t11. Quitter\n";
    public static final String MSG_ERR_CLASSE_INEXISTANTE = "Aucun etudiant! Pour créer une classe et lui ajouter des étudiants, il faut d'abord choisir l'option 1.";
    public static final String MSG_ERR_GRILLE_EVAL_INEXISTANTE = "Aucune grille d'évaluation! Pour créer une grille d'évaluation pour la classe, il faut d'abord choisir l'option 2.";
    public static final String MSG_ERR_NOTES_INEXISTANTE = "Assurer vous que vous avez créé une classe (option 1) et sa grille d'évaluation (option 2) avant. \nL'option 3 vous permet de vérifier si une classe a été déjà créée.\nL'option 4 vous permet de vérifier si une grille d'évaluation a été déjà créée pour cette classe.";
    public static final String MSG_SAISIE_NBR_ETUDIANTS = String.format("Entrez le nombre d’étudiants (entre %d et %d) : ", 1, 30);
    public static final String MSG_ERR_SAISIE_NUMERIQUE = "Erreur de saisie! ";
    public static final String MSG_SAISIE_NOM_ETUDIANT = "Veuillez saisir le nom et le prénom de l'étudiant %d séparés par _ : ";
    public static final String MSG_NBR_DEPASSE_CAPACITE_EXCEPTION = "Le nombre des étudiants dépasse la capacité de la classe.";
    public static final String MSG_ERR_NBR_INF_CAPACITE_MIN_CLASSE = "Le nombre des étudiants ne peut pas être inférieur ou égal à 0.";
    public static final String MSG_SAISI_NBR_EVALS = "Entrez le nombre d’évaluations : ";
    public static final String MSG_SAISI_NOM_EVAL = "Nom de l’évaluation %d (de 2 à 15 caractères) : ";
    public static final String MSG_SAISI_PONDERATION = String.format("Pondération de l’évaluation (%d-%d) : ", 0, 100);
    public static final String MSG_ERR_SAISI_NOM_EVAL = "Erreur! Le nom de l'évaluation devrait contenir 2 à 15 caractères.";
    public static final String MSG_SOMME_PONDERATIOND_DIFF_DE_100 = "la somme des pondérations est différente de 100%.";
    public static final String MENU_ENTRER_NOTES = "Voulez-vous entrer / modifier les résultats de : \n\ta. tous les étudiants\n\te. un étudiant\n\tv. une évaluation\n\tn. une évaluation d'un étudiant\n\tr. retour au menu principal\n";
    public static final String MENU_ENTRER_NOTES_ETUDIANTS = "Voulez-vous entrer / modifier les résultats des étudiants par : \n\te. étudiant\n\tv. évaluation\n\tr. retour au menu principal\n";
    public static final String MSG_ERR_OPTION_INVALIDE = "Option invalide!";
    public static final String MSG_ERR_FORMAT_NOTES = "Une entrée n'est pas valide. Assurer vous que les fractions sont séparées par ',' ou non '.'";
    public static final String MSG_ENTRER_NOTES_ETUDIANTS = "Veuillez entrer les notes des %ss de chaque %s selon leur ordre, séparées par des espaces.\n";
    public static final String MSG_ENTRER_NOTE = "Veuillez entrer la note de l'évaluation : ";
    public static final String MSG_ENTRER_NOTES = "Les notes de l'%s %s (séparées par des espaces) sont : \n";
    public static final String MSG_ERR_ENTRER_NOTES = "Le nombre de notes saisies ne correspond pas au nombre des évaluations.";
    public static final String MSG_AFFICHAGE_EVALS = "Les évaluations sont : %s\n";
    public static final String MSG_ENTRER_CODE_ETUDIANT = "Veuillez entrer le code de l'étudiant : ";
    public static final String MSG_ERR_CODE_ETUDIANT_INEXISTANT = "Le code étudiant \"%s\" n'existe pas!\n";
    public static final String MSG_FORMAT_CODE_ETUDIANT_INVALIDE = "Erreur! Le code de l'étudiant se compose de 4 lettres suivies de 5 chiffres";
    public static final String MSG_ENTRER_NUM_EVAL = "Veuillez saisir le numéro de évaluation de %d à %d : ";
    public static final String MSG_ERR_ENTRER_NUM_EVAL = "Le numéro de l'éval est incorrect! ";
    public static final String RAPPORT_STATS = "============================\n\t\tStatistiques\n============================\n\nLes stats des étudiants sont : \n%s\nLes stats des évaluations sont : \n%s\nLa moyenne de la classe est : %.2f\n\nLe nombre d'étudiants à succès : %d / %d\n\nLe nombre d'étudiants à échec : %d / %d\n";
    public static final String AUCUNE_STATISTIQUE_CALCULEE = "Aucune statistique n'a été claculée. Veuillez choisir l'option 6 avant.";
    public static final String MSG_STATS_CALCULEES = "Les statistiques de la classe ont été calculées avec succès. Pour les consulter, veuillez choisir l'option 8 du menu.";
    public static final String ENTETE_STATS_EVALS = "\n|    Nom de l'évaluation    | Meilleure note |    Pire note   | Moyenne |";
    public static final String FORMAT_COLLONNES_STATS_EVALS = "\n| %-25s | %14.2f | %14.2f | %7.2f |";
    public static final String ENTETE_STATS_ETUDIANTS = "\n|          Nom et prénom         | Meilleure note |    Pire note   | Moyenne | Résultat |";
    public static final String ENTETE_LISTE_EVALS = "\n| # éval |  Nom évaluation   | Pondération |";
    public static final String FORMAT_COLLONNES_LISTE_EVALS = "\n| %-6d | %-17s | %10d%% |";
    public static final String ENTETE_LISTE_ETUDIANTS = "\n| Code étudiant |        Nom        |       Prénom      |";
    public static final String FORMAT_COLLONNES_LISTE_ETUDIANTS = "\n| %-13s | %-17s | %-17s |";
    public static final String FORMAT_COLLONNES_STATS_ETUDIANTS = "\n| %-30s | %14.2f | %14.2f | %7.2f | %8s |";
    public static final String MSG_AFFICHER_STATS = "Les résultats de la classe sont : \n";
    public static final String MSG_AFFICHER_LISTE_ETUDIANTS = "Les étudiants de la classe pour le cours 420-111 sont : \n";
    public static final String MSG_AFFICHER_LISTE_EVALS = "Les résultats de la classe pour le cours 420-111 sont : \n";
    public static final String NOM_FICHIER_RAPPORT_STATS = "stats.txt";
    public static final String NOM_FICHIER_RAPPORT_RESULTATS = "resultats.txt";
    public static final String NOM_FICHIER_RAPPORT_LISTE_ETUDIANTS = "liste_etudiants.txt";
    public static final String NOM_FICHIER_RAPPORT_LISTE_EVALS = "liste_evaluations.txt";

    public Utilitaire() {
    }

    public static String genererCodeEtudiant(String nom, String prenom) {
        String partie1 = nom.substring(0,3).toUpperCase();
        String partie2 = prenom.substring(0,1).toUpperCase();

        int random = (int) (Math.random() * 10000);
        String partie3 = Integer.toString(random);

        while(partie3.length() < 5){ // ajout des 0 si le nombre est < 5
            partie3 += "0";
        }

        String code = partie1 + partie2 + partie3;

        return code;
    }

    public static float[] extraireColonne(float[][] notes, int colonne) {
        return null;
    }

    public static String afficherElementsListeSurUneLigne(String[] liste) {
        String elements = "";
        for (String element : liste){
            elements += element + " ";
        }
        return elements.trim();
    }

    public static float[] parseStringListToFloatList(String[] liste) throws NumberFormatException {
        float[] listeEnFloat = new float[liste.length];
        try{
           for(int i = 0; i < liste.length; i++){
               listeEnFloat[i] = Float.parseFloat(liste[i]);
           }
       }catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        return listeEnFloat;
    }

    public static String recupererNomComplet(String[][] etudiants, int posEtudiant) {

        String nom = etudiants[posEtudiant][0];
        String prenom = etudiants[posEtudiant][1];
        String code = etudiants[posEtudiant][2];

        String info = String.format("%s %s %s",nom, prenom,code);

        return info;
    }

    public static String assemblerTableau(String entete, String donnees) {
        String structTableau = "";
        String separateur = "\n";

        for(int i = 0; i < entete.length() - 1; ++i) {
            separateur = separateur + "-";
        }

        structTableau = structTableau + separateur + entete + separateur + donnees + separateur;
        return structTableau;
    }

    public static void ecrireDansFichier(String nomFichier, String contenu) {
    }
}
