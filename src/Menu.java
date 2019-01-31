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
	 * TODO: Complete Javadoc
	 * @param actions
	 * @return
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
