import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.List;

public class Calimiteiten extends Actor
{
	private Calimiteit _Calimiteit;
	private int _Health;
	private int _MaxHealth;
	private boolean _isPlaced;
	private Map _World;

	protected boolean _IsFake = false;
	protected Calimiteiten[] _Fakes;

	public void act()
	{
		_World = (Map) getWorld();
		if (!_World.isPaused()) {
			if (!_IsFake) {
				List objects = getObjectsInRange(40, _Calimiteit.getIntervention().getClass());
				if (!objects.isEmpty()) {
					_Health += 1;
				} else {
					_Health -= 1;
				}

				// Verwijdert Health per tick
				_Calimiteit.setHealth(_Health);

				switch (_Health) {
				case 750:
					if (_Fakes[0].isPlaced()) {
						getWorld().removeObject(_Fakes[0]);
						_Fakes[0].setPlaced(false);
					} else {
						getWorld().addObject(_Fakes[0],
								getRandomNumber("x"),
								getRandomNumber("y"));
						_Fakes[0].setPlaced(true);
					}
					break;
				case 500:
					if (_Fakes[1].isPlaced()) {
						getWorld().removeObject(_Fakes[1]);
						_Fakes[1].setPlaced(false);
					} else {
						getWorld().addObject(_Fakes[1],
								getRandomNumber("x"),
								getRandomNumber("y"));
						_Fakes[1].setPlaced(true);
					}
					break;
				case 250:
					if (_Fakes[2].isPlaced()) {
						getWorld().removeObject(_Fakes[2]);
						_Fakes[2].setPlaced(false);
					} else {
						getWorld().addObject(_Fakes[2],
								getRandomNumber("x"),
								getRandomNumber("y"));
						_Fakes[2].setPlaced(true);
					}
					break;
				case 0:
					_World.setPaused(true);
					_World.createGameOverMenu();
					break;
				default:
					if (_Health >= _MaxHealth && !_Fakes[0].isPlaced()
							&& !_Fakes[1].isPlaced() && !_Fakes[2].isPlaced()) {
						_Calimiteit.setCompleted(true);
						getWorld().addObject(new cParticleSystem(),
								getX(),
								getY());
						_World.addScore(25);
						getWorld().removeObject(_Fakes[0]);
						getWorld().removeObject(_Fakes[1]);
						getWorld().removeObject(_Fakes[2]);
						getWorld().removeObject((Actor) objects.get(0));
						getWorld().removeObject(this);
					}
					break;
				}
			}
		}
	}

	private int getRandomNumber(String coord)
	{
		int result = 0;

		if (coord.equals("x")) {
			int random = 0;

			while (random <= 15)
				random = Greenfoot.getRandomNumber(30);

			int rand = Greenfoot.getRandomNumber(2);

			if (rand == 1)
				result = this.getX() + random;
			else
				result = this.getX() - random;
		} else if (coord.equals("y")) {
			int random = Greenfoot.getRandomNumber(30);

			int rand = Greenfoot.getRandomNumber(2);

			if (rand == 1)
				result = this.getY() + random;
			else
				result = this.getY() - random;
		}

		return result;
	}

	/*
	 * Hier wordt de calimiteit geplaats in de actor en de Health van de
	 * calimiteit gehaald naar de Actor
	 */
	public void setCalimiteit(Calimiteit value)
	{
		_Calimiteit = value;
		setHealth(value.getHealth());
		setMaxHealth(value.getHealth());
	}

	// Setter voor de Health
	public void setHealth(int value)
	{
		_Health = value;
	}

	public void setMaxHealth(int value)
	{
		_MaxHealth = value;
	}

	public boolean isPlaced()
	{
		return _isPlaced;
	}

	public void setPlaced(boolean value)
	{
		_isPlaced = value;
	}
}
