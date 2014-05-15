import greenfoot.*;

public class cParticle extends cParticleSystem
{
	int dirX;
	int dirY;
	int Power;
	int Life;

	public cParticle(int X, int Y, int power, int life)
	{
		// Pakt een willekeurige afbeelding van 1 t/m 8
		int imgNum = (Greenfoot.getRandomNumber(8) + 1);
		GreenfootImage display = new GreenfootImage("particle_" + imgNum + ".png");
		setImage(display);
		
		dirX = X;
		dirY = Y;
		Power = power;
		Life = life;
	}

	public void act()
	{
		// Verplaatst particle met een steeds langzamere snelheid
		setLocation(getX() + dirX * (Power), getY() + dirY * (Power));
		update();
	}

	public void update()
	{
		/*
		 * Als particle zichtbaar is, wordt deze per tick minder zichbaar
		 * Wanneer de kracht van de particle nog van toepassing is,
		 * neemt deze langzaam af
		 */
		if (Life > 5) {
			Life -= 5;
			if (Power > 1) {
				Power--;
			}
			getImage().setTransparency(Life);
		}
	}
}
