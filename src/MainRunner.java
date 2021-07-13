/**
 * Runs the program.
 */
public class MainRunner {

  /**
   * Processes command-line argument.
   *
   * @param args the command-line argument
   */
  public static void main(String[] args) {
    Person person1 = new PersonA();

    int rounds;
    try {
      rounds = Integer.parseInt(args[0]);
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException(e.getMessage());
    }

    // Run experiment
    int withSwitchWinCount = person1.runMontyHall(rounds, true);
    int withoutSwitchWinCount = person1.runMontyHall(rounds, false);

    // Display the result
    MainRunner.displayResult(withSwitchWinCount, withoutSwitchWinCount, rounds);
  }

  /**
   * Display the result on the console.
   * @param withSwitchWinCount
   * the victory count for a player who always chooses to switch
   * @param withoutSwitchWinCount
   * the victory count for a player who always chooses not to switch
   * @param rounds     number of rounds player
   */
  private static void displayResult(int withSwitchWinCount, int withoutSwitchWinCount, int rounds) {
    System.out.println("Total Rounds: " + rounds);
    System.out.println("Switch Door(True):" + " Wins:" + withSwitchWinCount + ", Success Rate: "
        + (double) withSwitchWinCount * 100 / (double) rounds + "%");
    System.out.println("Switch Door(False):" + " Wins:" + withoutSwitchWinCount+ ", Success Rate: "
        + (double) withoutSwitchWinCount * 100 / (double) rounds + "%");
  }
}
