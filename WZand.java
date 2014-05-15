import java.util.List;
/**
 * Write a description of class WZand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WZand extends WItems
{
    private int health = 1000;
    private Wijk1 _World;
    boolean placed;
    
    public WZand(boolean isPlaced){ 
        setPlaced(isPlaced);
    }
    
    public void act()
    {
        placed = isPlaced();
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
                     health -=5;
                }
                
                // als de health 0 is, vervang omliggend stilstaand water voor bewegend water en verwijder het object
                if (health <=0)
                {
                    replaceSW();
                    getWorld().removeObject(this);
                    _World.getZandCounter().add();
                }
            }
        }
    }
}
