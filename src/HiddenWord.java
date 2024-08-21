public class HiddenWord {
    private int length;
    private String word;
    public HiddenWord(String word) {
        this.word = word.toUpperCase();
    }
    public String getHiddenWord() {
        return word;
    }
    public String getHint(String guess) {
        String hint = "";

        for (int i = 0; i < guess.length(); i++) {
            if (Character.isLowerCase(guess.charAt(i))) {    // if the character is lowercase
                throw new IllegalArgumentException("Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
            }
        }

        if (guess.length() != word.length()) {      // if guess length is not the same as the word length
            throw new IllegalArgumentException("Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + word.length() + " characters. Your guess must be a word with " + word.length() + " characters!");
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) hint += guess.charAt(i);      // corresponding matching letter
            else if (word.contains("" + guess.charAt(i))) hint += "+";         // hidden word in different position
            else hint += "*";        // letter does not appear at all in the word
        }

        return hint;
    }
}
