// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class Scenario {
	/*
	 * Hier worden de private variablen _C1, _C2, _C3 en _C4 aangemaakt. Hier
	 * worden de calimiteiten in opgeslagen. Ook wordt de boolean _Completed
	 * aangemaakt. deze zal kijken of het scenario is afgelopen
	 */
	private Calimiteit _C1, _C2, _C3, _C4;
	private boolean _Completed;

	/* De verschillende contructors op basis van de hoeveelheid calimiteiten */
	public Scenario(Calimiteit c1, Calimiteit c2) {
		_C1 = c1;
		_C2 = c2;
	}

	public Scenario(Calimiteit c1, Calimiteit c2, Calimiteit c3) {
		_C1 = c1;
		_C2 = c2;
		_C3 = c3;
	}

	public Scenario(Calimiteit c1, Calimiteit c2, Calimiteit c3, Calimiteit c4) {
		_C1 = c1;
		_C2 = c2;
		_C3 = c3;
		_C4 = c4;
	}

	/* De Getter voor een bepaalde calimiteit terug te geven. */
	public Calimiteit getCalimiteit(int calimiteit) {

		if (calimiteit == 1)
			return _C1;
		else if (calimiteit == 2)
			return _C2;
		else if (calimiteit == 3)
			return _C3;
		else if (calimiteit == 4)
			return _C4;
		else
			return null;
	}

	public void checkCompletion(int aantalCalimiteiten) {

		switch (aantalCalimiteiten) {
		case 2:
			if (_C1.isCompleted() && _C2.isCompleted())
				setCompleted(true);
			break;
		case 3:
			if (_C1.isCompleted() && _C2.isCompleted() && _C3.isCompleted())
				setCompleted(true);
			break;
		case 4:
			if (_C1.isCompleted() && _C2.isCompleted() && _C3.isCompleted()
					&& _C4.isCompleted())
				setCompleted(true);
			break;
		}
	}

	/* Een getter om te kijken of de scenario voltooid is */
	public boolean isCompleted() {
		return _Completed;
	}

	/* Setter om eventueel de scenario _Completed op true te zetten */
	public void setCompleted(boolean value) {
		_Completed = value;
	}
}
