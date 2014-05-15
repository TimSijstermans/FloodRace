import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorgaanKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cDoorgaanKnop extends cKnoppen
{
public int hasWon = 0;
    
    public cDoorgaanKnop(int winning){
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
                Greenfoot.setWorld(new DijkWorld());
            }
            else{
                Map world = (Map) getWorld();
                world.setPaused(false);
                world.removePauseMenu();
            }
        }
    }       
}
