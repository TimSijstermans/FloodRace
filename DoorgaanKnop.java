import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorgaanKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorgaanKnop extends Knoppen
{
    public int hasWon = 0;
    
    public DoorgaanKnop(int winning){
        if(winning == 1){
            hasWon = 1;
        }
    }

    /**
     * Als hasWon 1 is. Ga terug naar het menu. Anders ga terug naar het spel
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            if(hasWon == 1){
                Greenfoot.setWorld(new Wijk1());
            }
            else{
                DijkWorld world = (DijkWorld) getWorld();
                world.setPaused(false);
                world.removePauseMenu();
            }
        }
    }    
}
