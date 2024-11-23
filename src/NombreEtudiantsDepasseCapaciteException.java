package src;

/**
 * TP2 - 420-111 (A24)
 * Exception personnalisée levée lorsque le nombre d'étudiants dépasse la capacité maximale.
 *
 *
 * @author Sara Boumehraz
 * @version 18/11/2024
 *
 * [Votre nom et prénom]
 * [Votre numDA]
 */
public class NombreEtudiantsDepasseCapaciteException extends Exception {

    /**
     * Constructeur par défaut qui utilise un message prédéfini.
     */
    NombreEtudiantsDepasseCapaciteException() {
        super(Utilitaire.MSG_NBR_DEPASSE_CAPACITE_EXCEPTION);
    }
}
