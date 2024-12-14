package src;

/**
 * TP2 - 420-111 (A24)
 *
 * Classe fournissant des méthodes pour le calcul des statistiques, comme
 * les moyennes, les maxima et minima des notes.
 *
 * @author Sara Boumehraz
 * @version 18/11/2024
 *
 * [Votre nom et prénom]
 * [Votre numDA]
 */
public class Statistiques {

    /**
     * Calcule les moyennes à partir des sommes des notes et du nombre total.
     *
     * @param sommeNotes Tableau contenant les sommes des notes.
     * @param nombre     Nombre total d'éléments pour le calcul.
     * @return Tableau des moyennes calculées.
     */
    public static float[] calculerMoyennes(float[] sommeNotes, int nombre) {
        // TODO : à implémente
        float[] moyennes = new float[sommeNotes.length];
        for (int i = 0; i < sommeNotes.length; i++) {
            moyennes[i] = sommeNotes[i] / nombre; // divise la note par 100 pour obtenir une moyenne pondere
        }
        return moyennes;
    }

    /**
     * Calcule la moyenne générale à partir des moyennes individuelles.
     *
     * @param sommeMoyennes Tableau des moyennes individuelles.
     * @return La moyenne générale calculée.
     */
    public static float calculerMoyenne(float[] sommeMoyennes) {
        // TODO : à implémenter
        float somme = 0;
        for (float note : sommeMoyennes) {
            somme += note;
        }
        somme = somme/ sommeMoyennes.length;
        return somme;
    }

    /**
     * Trouve la valeur maximale dans un tableau de notes.
     *
     * @param notes Tableau contenant les notes.
     * @return La valeur maximale trouvée.
     */
    public static float trouverMax(float[] notes) {
        // TODO : à implémenter
        float max = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] > max) {
                max = notes[i];
            }
        }
        return max;
    }

    /**
     * Trouve la valeur minimale dans un tableau de notes.
     *
     * @param notes Tableau contenant les notes.
     * @return La valeur minimale trouvée.
     */
    public static float trouverMin(float[] notes) {
        // TODO : à implémenter
        float min = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] < min) {
                min = notes[i];
            }
        }
        return min;
    }

    /**
     * Calcule les maxima ou minima des notes pour chaque étudiant.
     *
     * @param notes      Tableau 2D contenant les notes des étudiants.
     * @param plusGrande Vrai pour calculer les maxima, faux pour les minima.
     * @return Tableau contenant les maxima ou minima pour chaque étudiant.
     */
    public static float[] calculerMinMaxNotesEtudiants(float[][] notes, boolean plusGrande) {
        float[] resultats = new float[notes.length];

        for (int i = 0; i < notes.length; i++) {
            float[] ligne = notes[i];
            resultats[i] = plusGrande ? trouverMax(ligne) : trouverMin(ligne);
        }

        return resultats;
    }

    /**
     * Calcule les maxima ou minima des notes pour chaque évaluation.
     *
     * @param notes      Tableau 2D contenant les notes des étudiants.
     * @param plusGrande Vrai pour calculer les maxima, faux pour les minima.
     * @return Tableau contenant les maxima ou minima pour chaque évaluation.
     */
    public static float[] calculerMinMaxNotesEval(float[][] notes, boolean plusGrande) {
        // TODO : à implémenter
        float[] resultats = new float[notes[0].length];

        for (int i = 0; i < notes[0].length; i++) {
            float[] colonne = Utilitaire.extraireColonne(notes,i);
            resultats[i] = plusGrande ? trouverMax(colonne) : trouverMin(colonne);
        }

        return resultats;
    }

    /**
     * Calcule la somme des notes pour chaque évaluation.
     *
     * @param nbrEvals     Nombre total d'évaluations.
     * @param nbrEtudiants Nombre total d'étudiants.
     * @param notes        Tableau 2D contenant les notes des étudiants.
     * @return Tableau contenant les sommes des notes pour chaque évaluation.
     */
    private static float[] calculerSommeNotesEvals(int nbrEvals, int nbrEtudiants, float[][] notes) {
        // TODO : à implémenter
        float[] sommeEvals = new float[nbrEvals];

        for(int i = 0; i < nbrEvals;i++){//loop externe # eval
            float sommeEval = 0;
            for(int j = 0; j < nbrEtudiants;j++){//loop interne le nombre d'etudiant == nbDeNote par eval
                sommeEval += notes[j][i];
            }
            sommeEvals[i] = sommeEval;
        }
        return sommeEvals;
    }

    /**
     * Calcule la somme des pondérations des évaluations.
     *
     * @param ponderations  Tableau contenant les pondérations des évaluations.
     * @return un nombre représentant la somme des pondérations des évaluations
     */
    public static int calculerSommePonderation(int[] ponderations){
        // TODO : à implémenter
        int sommePonderation = 0;
        for(int i = 0; i < ponderations.length; i++){
            sommePonderation += ponderations[i];
        }

        return sommePonderation;
    }

    /**
     * Calcule la somme des notes pour chaque étudiant.
     *
     * @param nbrEvals     Nombre total d'évaluations.
     * @param nbrEtudiants Nombre total d'étudiants.
     * @param notes        Tableau 2D contenant les notes des étudiants.
     * @param ponderations
     * @return Tableau contenant les sommes des notes pour chaque étudiant.
     */
    private static float[] calculerSommeNotesEtudiants(int nbrEvals, int nbrEtudiants, float[][] notes, int[] ponderations) {
        // TODO : à implémenter
        float[] notesPonderee = new float[nbrEtudiants];
        for (int i = 0; i < nbrEtudiants; i++) {
            float somme = 0;
            for (int j = 0; j < nbrEvals; j++) {
                somme += notes[i][j] * ponderations[j];//multiplie chaque note par la ponderation en position j
            }
            notesPonderee[i] = somme;//retourne au tableau la note multiplier par la ponderation, elle est diviser dans une autre methode
        }
        return notesPonderee;
    }

    /**
     * Calcule les moyennes des évaluations à partir des notes des étudiants.
     *
     * @param nbrEvals     Nombre total d'évaluations.
     * @param nbrEtudiants Nombre total d'étudiants.
     * @param notes        Tableau 2D contenant les notes des étudiants.
     * @return Tableau des moyennes pour chaque évaluation.
     */
    static float[] calculerMoyenneEvals(int nbrEvals, int nbrEtudiants, float[][] notes) {
        float[] sommeNotes = calculerSommeNotesEvals(nbrEvals, nbrEtudiants, notes);

        return calculerMoyennes(sommeNotes, nbrEtudiants);
    }

    /**
     * Calcule les moyennes des étudiants à partir de leurs notes.
     *
     * @param nbrEvals           Nombre total d'évaluations.
     * @param nbrEtudiants       Nombre total d'étudiants.
     * @param notes              Tableau 2D contenant les notes des étudiants.
     * @param maxPonderationEval
     * @return Tableau des moyennes pour chaque étudiant.
     */
    static float[] calculerMoyenneEtudiants(int nbrEvals, int nbrEtudiants, float[][] notes, int[] ponderations, int maxPonderationEval) {
        float[] sommeNotes = calculerSommeNotesEtudiants(nbrEvals, nbrEtudiants, notes,ponderations);//ajout de la ponderation en parametre pour calculer reelememt la moyenne pondere

        return calculerMoyennes(sommeNotes, maxPonderationEval);
    }

    /**
     * Clacule le nombre des étudiants qui ont obtenu une moyenne de 60 et plus dans le cours
     *
     * @param moyenneEtudiants un tableau contenant les moyennes des étudiants
     *
     * @return le nombre des étudiants qui ont réussi le cours (ont obtenus une moyenne de 60 et plus dans le cours)
     */
    static int calculerNombreEtudiantsSucces(float[] moyenneEtudiants){
        // TODO : à implémenter
        int nbSuccer =0;
        for(float notePassage : moyenneEtudiants){
            if(notePassage >= 50.0){
                nbSuccer++;
            }
        }
        return nbSuccer;
    }
}
