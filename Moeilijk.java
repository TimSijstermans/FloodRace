import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Moeilijk extends MoeilijkheidScherm
{

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            DijkWorld world = (DijkWorld) getWorld();
//             Greenfoot.setSpeed(65); 
            zetSnelheid(65);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
        }
    }    
}
