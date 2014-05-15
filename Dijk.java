import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dijk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dijk extends Actor
{
    int erosion;
    int dijkhealth = Greenfoot.getRandomNumber(150);
    
    boolean run = true;

    public Dijk()
    {
        dijkhealth += 600;
        int random = Greenfoot.getRandomNumber(3);
        switch (random)
        {
            case 0: 
            dijkhealth /= 2;
            break;
            case 1: 
            dijkhealth *= 2;
            break;
            case 2:
            break;
        }
    }
    

    public void act() 
    {
        //Checkt of het spel gepauzeerd is.
        DijkWorld theWorld = (DijkWorld) getWorld();  
        if(!theWorld.isPaused)  
        {  
            Actor zandzak = getOneObjectAtOffset (0,0,Zandzak.class);
            Actor papier = getOneObjectAtOffset(0, 0, Papier.class);
            Actor grind = getOneObjectAtOffset(0, 0, Grind.class);
            Actor karton = getOneObjectAtOffset(0, 0, Karton.class);
            Actor cement = getOneObjectAtOffset(0, 0, Cement.class);
    
            if (zandzak == null && papier == null && grind == null && karton == null && cement == null){
                
                int random;
                random = Greenfoot.getRandomNumber(3); //Kans op erosie    
                
                if (random == 1)
                {
                    Actor water1 = getOneObjectAtOffset (0,-1,Water.class);
                    Actor water2 = getOneObjectAtOffset (-1,0,Water.class);
                    Actor water3 = getOneObjectAtOffset (1,0,Water.class);
                    Actor water4 = getOneObjectAtOffset (0,1,Water.class);

                    if(water1 != null)
                    {
                        erosion += Greenfoot.getRandomNumber(25);
                    }
                    else if(water2 != null)
                    {
                        erosion += Greenfoot.getRandomNumber(25);
                    }
                    else if(water3 != null)
                    {
                        erosion += Greenfoot.getRandomNumber(25);
                    }
                    else if(water4 != null)
                    {
                        erosion += Greenfoot.getRandomNumber(25);
                    }
                }
    
                dijkhealth -= erosion;
                
                // Imagecontrol aanroepen ******
                // Voor statusen van de dijk
                
                erosion = 0;
                if (dijkhealth <= 0)
                {
                    Water w1 = new Water();
                    getWorld().addObject(w1,getX(),getY());
                    getWorld().removeObject(this);
                }   
            }
        }
    }
    
}