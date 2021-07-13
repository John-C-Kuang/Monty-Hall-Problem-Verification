import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents a player of the Monty Hall Problem who may or may not choose to switch to another
 * door.
 */
public class PersonA implements Person {

  List<String> selectionList;

  /**
   * Creates an PersonA object.
   */
  public PersonA() {
    // Default list
    this.selectionList = new ArrayList<>(Arrays.asList("Goat", "Goat", "Car"));
  }

  /**
   * Runs the Monty Hall Problem experiment.
   *
   * @param roundsCount rounds to run the experiment
   * @param switchDoor  whether the person chooses to switch doors
   * @return the number of times a person wins a car.
   * @throws IllegalArgumentException if roundsCount is negative.
   */
  public int runMontyHall(int roundsCount, boolean switchDoor) throws IllegalArgumentException {

    if (roundsCount < 0) {
      throw new IllegalArgumentException("roundsCount cannot be negative.");
    }

    // Initiates local variables
    int winCount = 0;
    for (int i = 0; i < roundsCount; i++) {

      // Shuffle the default list
      Collections.shuffle(this.selectionList);

      // Make a selection
      int playerChoice = new Random().nextInt(2);

      /*
      Technically, if the user chooses not to switch, we can ignore the Host selection
      process for efficiency. However, to fully replicate the experiment, the Host will
      always make a selection, regardless if the user chooses to switch or not
       */

      // Always a goat
      int hostChoice = this.hostSelect(playerChoice);

      // Switch door
      if (switchDoor) {
        playerChoice = 3 - playerChoice - hostChoice;
      }

      // Check if the player wins
      if (this.selectionList.get(playerChoice).equals("Car")) {
        winCount++;
      }

    }
    // Return the result
    return winCount;
  }

  /**
   * Simulate the process of a host choosing a goat that the player doesn't choose.
   * @param playerFirstChoice         a player's first choice index
   * @return  the index of the goat host chose
   * @throws IllegalStateException  if no available goat is found
   */
  private int hostSelect(int playerFirstChoice) throws IllegalStateException {
    for (int i = 0; i < 3; i++) {
      if (i == playerFirstChoice) {
        continue;
      } else if (this.selectionList.get(i).equals("Goat")) {
        return i;
      }
    }
    throw new IllegalStateException("No available goat found.");
  }

}
