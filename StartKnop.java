import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class StartKnop extends Knoppen
{
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            DijkWorld world = (DijkWorld) getWorld();
            world.setPaused(false);
            world.removeStartMenu();
        }
    }    
}
