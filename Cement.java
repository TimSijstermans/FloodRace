import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cement extends Objecten
{
    int strenght;
    int health = 500;

    public Cement(boolean fake) {
        _isFake = fake;
        _Type = 5;
    }
    
    public void act() 
    {      
        super.act();
        
        //Checkt of het spel gepauzeerd is.
        DijkWorld theWorld = (DijkWorld) getWorld();  
        if(!theWorld.isPaused) {
        
            Actor Water = getOneObjectAtOffset(0,0,Water.class);
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
