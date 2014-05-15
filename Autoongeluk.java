
/**
 * Write a description of class brand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Autoongeluk extends Calimiteiten
{ 
    public Autoongeluk(boolean fake) {
        super();
    	_IsFake = fake;
        
        if (!_IsFake)
        {
        	_Fakes = new Autoongeluk[3];
        	_Fakes[0] = new Autoongeluk(true);
        	_Fakes[1] = new Autoongeluk(true);
        	_Fakes[2] = new Autoongeluk(true);
        }
    }
    
    public void act() {	
    	super.act();
    }
}
