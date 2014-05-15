import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pauseknop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cPauseknop extends cKnoppen
{
     public void act() 
        {
            if(Greenfoot.mouseClicked(this))
            {  
                Map world = (Map) getWorld();
    
                //Check of het spel op pauze staat
                if(world.isPaused()){
                    //Zo ja, unpause
                    world.setPaused(false);
                    world.removePauseMenu();
                }else{
                    //Zo nee, pause.
                    world.setPaused(true);
                    world.createPauseMenu();
                }
            }  
        }      
}
