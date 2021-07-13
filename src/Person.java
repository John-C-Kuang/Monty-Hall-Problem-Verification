/**
 * Represents a person experimenting the Monty Hall Problem.
 */
public interface Person {

  /**
   * Runs the Monty Hall Problem experiment.
   * @param roundsCount rounds to run the experiment
   * @param switchDoor  whether the person chooses to switch doors
   * @return  the number of times a person wins a car.
   * @throws IllegalArgumentException       if roundsCount is negative.
   */
  int runMontyHall(int roundsCount, boolean switchDoor) throws IllegalArgumentException;

}
