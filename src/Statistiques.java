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
        // TODO : à implémenter
        return null;
    }

    /**
     * Calcule la moyenne générale à partir des moyennes individuelles.
     *
     * @param sommeMoyennes Tableau des moyennes individuelles.
     * @return La moyenne générale calculée.
     */
    public static float calculerMoyenne(float[] sommeMoyennes) {
        // TODO : à implémenter
        return 0;
    }

    /**
     * Trouve la valeur maximale dans un tableau de notes.
     *
     * @param notes Tableau contenant les notes.
     * @return La valeur maximale trouvée.
     */
    public static float trouverMax(float[] notes) {
        // TODO : à implémenter
        return 0;
    }

    /**
     * Trouve la valeur minimale dans un tableau de notes.
     *
     * @param notes Tableau contenant les notes.
     * @return La valeur minimale trouvée.
     */
    public static float trouverMin(float[] notes) {
        // TODO : à implémenter
        return 0;
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
        return null;
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
        return null;
    }

    /**
     * Calcule la somme des pondérations des évaluations.
     *
     * @param ponderations  Tableau contenant les pondérations des évaluations.
     * @return un nombre représentant la somme des pondérations des évaluations
     */
    public static int calculerSommePonderation(int[] ponderations){
        // TODO : à implémenter
        return 0;
    }

    /**
     * Calcule la somme des notes pour chaque étudiant.
     *
     * @param nbrEvals     Nombre total d'évaluations.
     * @param nbrEtudiants Nombre total d'étudiants.
     * @param notes        Tableau 2D contenant les notes des étudiants.
     * @return Tableau contenant les sommes des notes pour chaque étudiant.
     */
    private static float[] calculerSommeNotesEtudiants(int nbrEvals, int nbrEtudiants, float[][] notes) {
        // TODO : à implémenter
        return null;
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
     * @param nbrEvals     Nombre total d'évaluations.
     * @param nbrEtudiants Nombre total d'étudiants.
     * @param notes        Tableau 2D contenant les notes des étudiants.
     * @return Tableau des moyennes pour chaque étudiant.
     */
    static float[] calculerMoyenneEtudiants(int nbrEvals, int nbrEtudiants, float[][] notes) {
        float[] sommeNotes = calculerSommeNotesEtudiants(nbrEvals, nbrEtudiants, notes);

        return calculerMoyennes(sommeNotes, nbrEvals);
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
        return 0;
    }
}
