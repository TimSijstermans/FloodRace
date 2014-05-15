
/**
 * Write a description of class brand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overstroming extends Calimiteiten
{ 
    public Overstroming(boolean fake) {
        super();
    	_IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Overstroming[3];
        	_Fakes[0] = new Overstroming(true);
        	_Fakes[1] = new Overstroming(true);
        	_Fakes[2] = new Overstroming(true);
        }
    }
    
    public void act() {	
    	super.act();
    }
}
