import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class cMoeilijk extends MoeilijkheidScherm
{

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Map world = (Map) getWorld();
//             Greenfoot.setSpeed(65); 
            zetSnelheid(65);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
        }
    }    
}
