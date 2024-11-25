package src;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TP2 - 420-111 (A24)
 * Classe regroupant les méthodes de validation pour les entrées utilisateur,
 * incluant la validation des nombres, des chaînes et des notes.
 *
 * @author Sara Boumehraz
 * @version 18/11/2024
 *
 * [Votre nom et prénom]
 * [Votre numDA]
 */
public class Validations {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Valide un nombre dans une plage donnée en affichant un message.
     * exemple : pour valider si un nombre et entre 1 et 3 : borneInf est 1 et borneSup est 3 lors de l'appel de la méthode
     *
     * @param message  Message affiché pour demander l'entrée.
     * @param borneInf Borne inférieure de la plage.
     * @param borneSup Borne supérieure de la plage.
     * @return Le nombre valide saisi par l'utilisateur.
     *
     *@Implementation d'un try catch due la possibilite d'une entrer autre qu'un entier.
     * Verifie si option se trouve a l'exterieur du ranger permis.Si oui return option
     * Sinon affiche un message d'erreur et retourne 0 comme valeur par defaut
     *
     */


    public static int validerNombre(String message, int borneInf, int borneSup) {
        // TODO : à implémenter
        try {
            System.out.println(message);
            int nombre = sc.nextInt();
            if( nombre < borneInf || nombre > borneSup) {
                System.out.println(Utilitaire.MSG_ERR_OPTION_INVALIDE);
                return 0;
            }
            else{
                return nombre;
            }
        } catch(InputMismatchException e){
            System.out.println(Utilitaire.MSG_ERR_SAISIE_NUMERIQUE);
            sc.next();
            return 0;
        }
    }

    /**
     * Valide le nombre d'étudiants et vérifie qu'il ne dépasse pas la capacité autorisée.
     *
     * @return Le nombre d'étudiants valide saisi par l'utilisateur.
     * @throws NombreEtudiantsDepasseCapaciteException Si le nombre dépasse la capacité.
     */
    public static int validerNbrEtudiants() throws NombreEtudiantsDepasseCapaciteException {
        // TODO : à implémenter
        int nbEtudiant = 0;
        do {
            try {
                System.out.println(Utilitaire.MSG_SAISIE_NBR_ETUDIANTS);
                nbEtudiant = sc.nextInt();
                if(nbEtudiant > Utilitaire.CAPACITE_MAX_CLASSE) {
                    throw new NombreEtudiantsDepasseCapaciteException(); // **Needs to end program**
                } else if (nbEtudiant < Utilitaire.CAPACITE_MIN_CLASSE ) {
                    System.out.println(Utilitaire.MSG_ERR_NBR_INF_CAPACITE_MIN_CLASSE);
                    nbEtudiant = 0;
                }
            } catch (InputMismatchException e){
                System.out.println(Utilitaire.MSG_ERR_SAISIE_NUMERIQUE);
                sc.next();
            }

        } while(nbEtudiant == 0);

        return nbEtudiant;
    }

    /**
     * Valide le nom d'une évaluation en respectant les limites de taille.
     *
     * @param numEval Le numéro de l'évaluation.
     * @return Le nom valide de l'évaluation.
     */
    public static String validerNomEval(int numEval) {
        // TODO : à implémenter

        return null;
    }

    /**
     * Valide qu'une lettre saisie appartient à une liste donnée.
     *
     * @param message            Message affiché pour demander l'entrée.
     * @param msgErreur          Message affiché en cas d'erreur.
     * @param caracteresAcceptes Liste des caractères valides.
     * @return Le caractère validé.
     */
    public static char validerLettre(String message, String msgErreur, String caracteresAcceptes) {
        String entree = "";
        boolean estValide = false;

        do {
            System.out.println(message);
            entree = sc.nextLine();
            estValide = entree.length() == 1 && caracteresAcceptes.contains(entree.toLowerCase());
            if (!estValide) {
                System.out.println(msgErreur);
            }
        } while (!estValide);

        return entree.toLowerCase().charAt(0);
    }

    /**
     * Valide une liste de notes saisie par l'utilisateur.
     *
     * @param message Message affiché pour demander l'entrée.
     * @param type    Type de l'élément pour lequel les notes sont saisies.
     * @param element Nom de l'élément.
     * @param msgErreur Message affiché si le nombre de notes saisi est différent du nombre des évaluations
     * @param nbrEvals Le nombre des évaluations (correspond au nombre de notes par étudiant)
     * @return Un tableau de notes validées.
     */
    public static float[] validerNotes(String message, String type, String element, String msgErreur, int nbrEvals) {
        String entree = "";
        boolean estValide = false;
        String[] entreeSplitee;
        float[] notes = null;

        do {
            // TODO : à implémenter
            try {
                // TODO : à implémenter
            } catch (NumberFormatException e) {
                System.out.println(Utilitaire.MSG_ERR_FORMAT_NOTES);
            }
        } while (!estValide);

        return notes;
    }

    /**
     * Valide et sépare le nom et le prénom d'un étudiant.
     *
     * @param message     Message affiché pour demander l'entrée.
     * @param numEtudiant Numéro de l'étudiant.
     * @return Un tableau contenant le nom et le prénom validés.
     */
    public static String[] validerNomEtudiant(String message, int numEtudiant) {
        String entree;
        String[] nomEtudiant = null;
        do {
            // TODO : à implémenter
        } while (nomEtudiant.length != 2);

        return nomEtudiant;
    }

    /**
     * Valide un code étudiant et retourne sa position dans le tableau des étudiants.
     * @param etudiants Tableau contenant les données des étudiants.
     * @return La position de l'étudiant dans le tableau, ou -1 si le code est invalide ou non trouvé.
     */
    public static int validerCodeEtudiant(String[][] etudiants) {
        int posEtudiant = -1;
        boolean estValide = false;

        do {
            // TODO : à implémenter
            if (estValide) {
                // TODO : à décommenter après l'implémentation du TODO précédent
                // posEtudiant = rechercherCodeEtudiant(etudiants, code);
            } else {
                System.out.println(Utilitaire.MSG_FORMAT_CODE_ETUDIANT_INVALIDE);
            }
        } while (!estValide || posEtudiant == -1);

        return posEtudiant;
    }

    /**
     * Vérifie si un code étudiant respecte le format requis (9 caractères : 4 lettres puis 5 chiffres).
     *
     * @param code Le code étudiant à valider.
     * @return Vrai si le code respecte le format, faux sinon.
     */
    private static boolean estFormatCodeValide(String code) {
        // TODO : à implémenter

        return false;
    }

    /**
     * Vérifie si une chaîne contient uniquement des lettres.
     *
     * @param lettres La chaîne à vérifier.
     * @return Vrai si la chaîne contient uniquement des lettres, faux sinon.
     */
    public static boolean estChaineContientLettres(String lettres) {
        // TODO : à implémenter
        return false;
    }

    /**
     * Vérifie si une chaîne contient uniquement des chiffres.
     *
     * @param chiffres La chaîne à vérifier.
     * @return Vrai si la chaîne contient uniquement des chiffres, faux sinon.
     */
    public static boolean estChaineContientChiffres(String chiffres) {
        // TODO : à implémenter
        return false;
    }

    /**
     * Recherche un code étudiant dans un tableau.
     *
     * @param etudiants Tableau contenant les données des étudiants.
     * @param code      Le code de l'étudiant à rechercher.
     * @return L'indice de l'étudiant dans le tableau, ou -1 si non trouvé.
     */
    public static int rechercherCodeEtudiant(String[][] etudiants, String code) {
        // TODO : à implémenter

        return -1;
    }

    /**
     * Valide le numéro d'une évaluation dans une plage donnée.
     * @param nbrEvals Le nombre total d'évaluations.
     * @return Le numéro valide de l'évaluation.
     */
    public static int validerNumEval(int nbrEvals) {
        int numEval = -1;

        // TODO : à implémenter

        return numEval;
    }

    /**
     * Valide une note saisie pour une évaluation donnée.
     * @param nomEval Nom de l'évaluation associée à la note.
     * @return La note validée.
     */
    public static float validerNote(String nomEval) {
        float note = -1;

        // TODO : à implémenter

        return note;
    }
}
