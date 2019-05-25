import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *Creado por Elias Periañez
 *31 ene. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *31 ene. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public class Menu implements Serializable {

	private static final long serialVersionUID = -7924402451463615207L;

	private MenuLayer[] layers;
	private Turn caller;

	public Menu(MenuLayer[] layers, Turn caller) {
		this.setLayers(layers);
		this.setCaller(caller);
	}

	public Menu() {
	}

	public MenuLayer[] getLayers() {
		return layers;
	}

	public void setLayers(MenuLayer[] layers) {
		this.layers = layers;
	}

	public static MenuLayer layerFactory(MenuLayerType mlt, Action[] actions, HashMap<String, String> data) {
		MenuLayer result;

		if (actions == null) {
			result = new Menu().new MenuLayer().CreateMenuLayer(data);
		} else if (data == null) {
			result = new Menu().new MenuLayer().CreateMenuLayer(actions);
		} else {
			result = new Menu().new MenuLayer().CreateMenuLayer(mlt, actions, data);
		}
		return result;
	}

	public Turn getCaller() {
		return caller;
	}

	public void setCaller(Turn caller) {
		this.caller = caller;
	}

	/**
	 * Use this method to call the action choice menu, which let the player choose
	 * the action they want to perform in this turn
	 * 
	 * @param actions
	 *            an array of actions to be shown in the menu
	 * @return The chosen action by the user
	 */
	//

	class MenuLayer {

		MenuLayer CreateMenuLayer(Action[] actions) {
			return CreateMenuLayer(MenuLayerType.CHOICE, actions, null);
		}

		MenuLayer CreateMenuLayer(HashMap<String, String> data) {
			return CreateMenuLayer(MenuLayerType.PROMPT, null, data);
		}

		MenuLayer CreateMenuLayer(MenuLayerType mlt, Action[] actions, HashMap<String, String> data) {

			MenuLayer result = null;

			if (mlt == MenuLayerType.CHOICE) {
				result = new ChoiceLayer(actions);

			} else {
				result = new PromptLayer(data);
			}
			return result;
		}

		// TODO Javadoc
		class ChoiceLayer extends MenuLayer implements Serializable {

			private static final long serialVersionUID = -511268994651726131L;

			private Action[] actions;

			public ChoiceLayer(Action[] actions) {
				this.actions = actions;
			}

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
						result = actions[sc.nextInt()];
						check = true;
					} while (!check);
				} catch (IndexOutOfBoundsException | InputMismatchException e) {
					check = false;
				}
				sc.close();
				return result;
			}

			public Action[] getActions() {
				return actions;
			}

			public void setActions(Action[] actions) {
				this.actions = actions;
			}

			@Override
			public String toString() {
				return new StringBuffer(" Actions : ").append(this.actions).toString();
			}

		}

		// TODO Javadoc
		class PromptLayer extends MenuLayer implements Serializable {

			private static final long serialVersionUID = -7756136883211134387L;

			private HashMap<String, String> strings;

			public PromptLayer(HashMap<String, String> data) {
				this.strings = data;
			}

			public void printByKey(String key) {
				this.strings.get(key);
			}

			public String getByKey(String key) {
				return this.strings.get(key);
			}

			public HashMap<String, String> getStrings() {
				return strings;
			}

			public void setStrings(HashMap<String, String> strings) {
				this.strings = strings;
			}

			@Override
			public String toString() {
				return new StringBuffer(" Strings : ").append(this.strings).toString();
			}
		}

	}

	enum MenuLayerType {
		CHOICE, PROMPT
	}

	@Override
	public String toString() {
		return new StringBuffer(" Layers : ").append(this.layers).append(" Caller : ").append(this.layers).toString();
	}
}
