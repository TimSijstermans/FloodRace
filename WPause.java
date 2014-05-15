import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WPause extends Actor
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {  
            Wijk1 world = (Wijk1) getWorld();
            world.createPauseScherm();
            //Check of het spel op pauze staat
            if(world.getPaused()){
                //Zo ja, unpause
                world.setPaused(false);
                //world.removePauseMenu();
            }else{
                //Zo nee, pause.
                world.setPaused(true);
                //world.createPauseMenu();
            }
        }
    }    
}