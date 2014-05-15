import greenfoot.*;

public class cParticleSystem extends Actor
{
	public void act()
	{
		/*
		 * Weergeeft i(=15) particles wanneer calimiteit opgelost wordt
		 * cParticle neemt 4 parameters aan: X, Y, power, life
		 * X en Y wordt berekent met random nummers (getal tussen 3 en -3)
		 * Power hoe snel particle beweegt
		 * Life hoe lang de particle in beeld is
		 */
		for (int i = 0; i < 15; i++) {
			getWorld().addObject(
					new cParticle(Greenfoot.getRandomNumber(4) - 2,
							Greenfoot.getRandomNumber(4) - 2,
							Greenfoot.getRandomNumber(20),
							Greenfoot.getRandomNumber(80) + 100),
							getX(), getY());
			if (i == 15 - 1) {
				getWorld().removeObject(this);
			}
		}
	}
}
