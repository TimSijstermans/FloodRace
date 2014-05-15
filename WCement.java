import java.util.List;
/**
 * Write a description of class WCement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WCement extends WItems
{
    private int health = 1500;
    
    private Wijk1 _World;
    boolean placed;
    
     public WCement(boolean isPlaced){ 
            setPlaced(isPlaced);
        }
        
    public void act()
    {
        placed = isPlaced();
        
        //als het geplaatst is, en de game staat niet op pauze
        if (placed)
        {
            _World = (Wijk1) getWorld();
            if (!_World.gamePaused)
            {
                _World = (Wijk1) getWorld();
                
                //vervang bewegend water in de buurt voor stilstaand water
                replaceWaters();
                
                // trek health eraf
                List<WWaterTypes> waters = getObjectsInRange(21, WWaterTypes.class);          
                if (!waters.isEmpty())
                {
                     health -=1;
                }
                
                // als de health 0 is, vervang omliggend stilstaand water voor bewegend water en verwijder het object
                if (health <=0)
                {
                    replaceSW();
                                
                    getWorld().removeObject(this);
                    _World.getCementCounter().add();
                }
            }
        }
    }
    

}
