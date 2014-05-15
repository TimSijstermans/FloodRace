
/**
 * Write a description of class brand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overval extends Calimiteiten
{ 
    public Overval(boolean fake) {
        super();
    	_IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Overval[3];
        	_Fakes[0] = new Overval(true);
        	_Fakes[1] = new Overval(true);
        	_Fakes[2] = new Overval(true);
        }
    }
    
    public void act() {	
    	super.act();
    }
}
