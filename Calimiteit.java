import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class Calimiteit here.
 * 
 * @author TechSetters
 */
public class Calimiteit {
	/* Private variablen die horen bij het object Calimiteit */
	private Actor _Actor; // De Actor
	private int _Xcoord, _Ycoord; // De X en Y coordinaat van de calimiteit
	private int _Health = Greenfoot.getRandomNumber(100); // De random Health
															// die wordt
															// toegekend
	private Actor _Intervention;

	private String _Information;

	/*
	 * Private variablen die bijhouden of de calimiteit is verholpen of
	 * geplaatst is op de kaart
	 */
	private boolean _Completed;
	private boolean _Placed;

	/**
	 * Constructor for objects of class Calimiteit
	 */
	public Calimiteit(Actor type, int x, int y, Actor intervention) {
		_Actor = type;
		_Xcoord = x;
		_Ycoord = y;
		_Intervention = intervention;

		/*
		 * Maakt het type Actor een string en verwijdert daarna de Hex van de
		 * String (e.g. Evacuatie@1234AB)
		 */
		String actorStr = getActor().toString();
		int actIndex = actorStr.indexOf("@");
		if (actIndex != -1) {
			actorStr = actorStr.substring(0, actIndex);
		}

		_Information = String.format(
				"Er is een %s ontstaan op de positie X: %d Y: %d ", actorStr,
				_Xcoord, _Ycoord);

		/* Vult de Health aan met de minimale health van de Calimiteit */
		_Health += 1000;
	}

	/* Getters */

	public Actor getActor() {
		return _Actor;
	}

	public int getXcoord() {
		return _Xcoord;
	}

	public int getYcoord() {
		return _Ycoord;
	}

	public int getHealth() {
		return _Health;
	}

	public Actor getIntervention() {
		return _Intervention;
	}

	public boolean isCompleted() {
		return _Completed;
	}

	public boolean isPlaced() {
		return _Placed;
	}

	public String getInformation() {
		return _Information;
	}

	/* Setters */

	public void setCompleted(boolean value) {
		_Completed = value;
	}

	public void setPlaced(boolean value) {
		_Placed = value;
	}

	public void setHealth(int value) {
		_Health = value;
	}

	public void setIntervention(Actor intervention) {
		_Intervention = intervention;
	}
}
