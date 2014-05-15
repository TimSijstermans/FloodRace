
/**
 * Write a description of class brand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elek_Brand extends Calimiteiten
{ 
    public Elek_Brand(boolean fake) {
        super();
    	_IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Elek_Brand[3];
        	_Fakes[0] = new Elek_Brand(true);
        	_Fakes[1] = new Elek_Brand(true);
        	_Fakes[2] = new Elek_Brand(true);
        }
    }
    
    public void act() {	
    	super.act();
    }
}
