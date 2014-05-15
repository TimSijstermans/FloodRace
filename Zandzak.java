import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zandzak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zandzak extends Objecten
{
    int strenght;
    int health = 350;
    
    public Zandzak(boolean fake) {
        _isFake = fake;
        _Type = 1;
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

//     /**
//      * WERKT GVD NIET KUT PROGRAMMA :@:@:@
//      */
//     private boolean checkForObject(int x, int y){
//         Actor Zandzak = getOneObjectAtOffset(x,y,Zandzak.class);
//         Actor Papier = getOneObjectAtOffset(x,y,Papier.class);
//         Actor Grind = getOneObjectAtOffset(x,y,Grind.class);
//         
//         if(Zandzak != null && Papier != null && Grind != null){
//             return true;
//         }else{
//             return false;
//         }
//     }
     
}    


