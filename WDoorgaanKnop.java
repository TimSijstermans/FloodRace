import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WDoorgaanKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WDoorgaanKnop extends Actor
{
    public int hasWon = 0;
    
    public WDoorgaanKnop(int winning){
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
                Greenfoot.setWorld(new RunningWorld());
            }
            else{
                Wijk1 world = (Wijk1) getWorld();
                world.setPaused(false);
                world.removePauseMenu();
            }
        }
    }       
}
