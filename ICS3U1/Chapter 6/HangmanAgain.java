import becker.xtras.hangman.*;
import becker.util.*;
public class HangmanAgain implements IHangman{
  
  private ViewList views = new Viewlist();
  private String phrase;
  private String guessedLetters;
  private String guessedPhrase;
  private int numWrongGuesses;
  
  public Hangman {
    phrase = "";
    guessedPhrase = "";
    guessedLetters = "";
    numWrongGuesses = 0;
  }
  
  public void addView(IView aView) {
    this.views.addView(aView);
  }
  
  public void stateChangingMethod(){
    this.views.updateAllViews();
  }
  
  public void newGame() {
    this.phrase = phrase;
  }
  
}