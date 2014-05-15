import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Interventions extends Actor
{
	protected boolean _isFake;
	protected int _Type;

	private int _Health = 400;
	private int _RealX;
	private int _RealY;
	private boolean _isSelected = false;
	private Actor _DraggableFake;

	public void act()
	{
		if (!_isFake) {
			if (_Health <= 0) {
				getWorld().removeObject(this);
			}
			_Health -= 1;
		}

		if (_isFake) {
			if (!_isSelected && Greenfoot.mousePressed(this)) {
				_isSelected = true;

				_RealX = getX();
				_RealY = getY();

				_DraggableFake = getIntervention();
				getWorld().addObject(_DraggableFake, _RealX, _RealY);

				return;
			}

			if (_isSelected && Greenfoot.mouseDragged(this)) {
				// mi Ontvangt gegevens van gebruik muis
				MouseInfo mi = Greenfoot.getMouseInfo();
				// Plaatst locatie op de coordinaten van muis 
				setLocation(mi.getX(), mi.getY());
				
				return;
			}

			if (_isSelected && Greenfoot.mouseDragEnded(this)) {
				_isSelected = false;

				getWorld().removeObject(_DraggableFake);

				MouseInfo info = Greenfoot.getMouseInfo();
				if (info.getX() > 20 && info.getY() > 10 && info.getX() < 590
						&& info.getY() < 690) {
					getWorld().addObject(getIntervention(), info.getX(),
							info.getY());
				}

				setLocation(_RealX, _RealY);
			}
		}
	}

	private Actor getIntervention()
	{
		Actor intervention = new Interventions();
		switch (_Type) {
		case 1:
			intervention = new actArrest(false);
			break;
		case 2:
			intervention = new actBlussen(false);
			break;
		case 3:
			intervention = new actZorg(false);
			break;
		case 4:
			intervention = new actWaterpomp(false);
			break;
		case 5:
			intervention = new actElectraBrand(false);
			break;
		case 6:
			intervention = new actStuurME(false);
			break;
		case 7:
			intervention = new actEhbo(false);
			break;
		}

		return intervention;
	}
}
