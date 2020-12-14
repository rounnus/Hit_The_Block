package hittheblock.constants;

public enum Messages {
    // Εδω καθοριζουμε καποια μυνηματα τα οποια θα εμφανιζονται.
    COMPLETE_MESSAGE("Game Over!"),
    ERROR_MESSAGE("An error has occurred"),
    LOOSE_MESSAGE("You lose."),
    WIN_MESSAGE("You win!.");

    public final String message;
    Messages(String message) {
        this.message = message;
    }
}
