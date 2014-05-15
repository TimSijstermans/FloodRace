import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Gemiddeld extends MoeilijkheidScherm
{

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            DijkWorld world = (DijkWorld) getWorld();
//             Greenfoot.setSpeed(55); 
            zetSnelheid(55);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
        }
    }    
}
