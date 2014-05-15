import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class cGemiddeld extends MoeilijkheidScherm
{

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Map world = (Map) getWorld();
//             Greenfoot.setSpeed(55); 
            zetSnelheid(55);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
        }
    }    
}
