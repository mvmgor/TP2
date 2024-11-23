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
public class SommePonderationsInvalideException extends Exception {
    /**
     * Constructeur par défaut qui utilise un message prédéfini.
     */
    SommePonderationsInvalideException() {
        super(Utilitaire.MSG_SOMME_PONDERATIOND_DIFF_DE_100);
    }
}
