
/**
 * Write a description of class evacuatie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evacuatie extends Calimiteiten
{
    public Evacuatie(boolean fake) {
    	super();
        _IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Evacuatie[3];
        	_Fakes[0] = new Evacuatie(true);
        	_Fakes[1] = new Evacuatie(true);
        	_Fakes[2] = new Evacuatie(true);
        }
    }
    
    public void act() {
    	super.act();
    } 
}
