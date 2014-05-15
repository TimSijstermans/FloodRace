
/**
 * Write a description of class brand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brand extends Calimiteiten
{ 
    public Brand(boolean fake) {
        super();
    	_IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Brand[3];
        	_Fakes[0] = new Brand(true);
        	_Fakes[1] = new Brand(true);
        	_Fakes[2] = new Brand(true);
        }
    }
    
    public void act() {	
    	super.act();
    }
}
