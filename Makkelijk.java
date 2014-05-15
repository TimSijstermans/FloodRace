import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Makkelijk extends MoeilijkheidScherm
{
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
            DijkWorld world = (DijkWorld) getWorld();
//             Greenfoot.setSpeed(40); 
            zetSnelheid(40);
            world.setPaused(false);
            world.removeMoeilijkheidsScherm();
       }
    }    
}
