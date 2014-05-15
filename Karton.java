import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Karton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Karton extends Objecten
{

    int strenght;
    int health = 150;
    
    public Karton(boolean fake) {
        _isFake = fake;
        _Type = 4;
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
                    getWorld().removeObject(this);
                }
            }
        }
    }
}    

