import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Elias
 *
 */
abstract public class Menu {

	/**
	 * Use this method to call the action choice menu, which let the player choose the action they want to perform in this turn
	 * @param actions an array of actions to be shown in the menu
	 * @return The chosen action by the user
	 */
	public Action choiceMenu(Action[] actions) {
		int i = 0;
		for (Action current : actions) {
			if (current.getActionInfo().getValue() != null) {
				System.out.println(
						i + "." + current.getActionInfo().getKey() + ": " + current.getActionInfo().getValue());
			} else {
				System.out.println(i + "." + current.getActionInfo().getKey());
			}
			i++;
		}
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		Action result = null;
		try {
			do {
				System.out.print("Please, input the number of the action you want to perform: ");
				int choice = sc.nextInt();
				result = actions[i];
				check = true;
			} while (!check);
		} catch (IndexOutOfBoundsException | InputMismatchException e) {
			check = false;
		}
		return result;
	}

}
