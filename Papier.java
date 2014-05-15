import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Muis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Papier extends Objecten
{
    int strenght;
    int health = 100;

    public Papier(boolean fake) {
        _isFake = fake;
        _Type = 2;
    }
    
    public void act() 
    {
        super.act();
        //Checkt of het spel gepauzeerd is.
        DijkWorld theWorld = (DijkWorld) getWorld();  
        if(!theWorld.isPaused) {
            Actor Water = getOneObjectAtOffset(0,-1,Water.class);
            if (!_isSelected)
            {
                if(Water != null){
                    strenght = Greenfoot.getRandomNumber(5);
                    health -= strenght;
                }
                if(health <= 0){
                    Dijk d1 = new Dijk();
                    getWorld().addObject(d1,getX(),getY());
                    getWorld().removeObject(this);
                }
            }
        }
    }
}   

