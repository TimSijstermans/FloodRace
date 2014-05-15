import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buitendijk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buitendijk extends Actor
{
    /**
     * Act - do whatever the Buitendijk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int erosion; //Erosie van de health
    int buitenDijkHealth = Greenfoot.getRandomNumber(401); //Random base health voor buitendijk

    public Buitendijk()
    {
        buitenDijkHealth += 1000;
        int random = Greenfoot.getRandomNumber(3);
        switch (random)
        {
            case 0: 
            buitenDijkHealth /= 2;
            break;
            case 1: 
            buitenDijkHealth *= 2;
            break;
            case 2:
            break;
        }

    }

    public void act() 
    {
        DijkWorld theWorld = (DijkWorld) getWorld();  
        if(!theWorld.isPaused)  
        {  
            int random;
            Actor water1 = getOneObjectAtOffset (0,-1,Water.class);
            Actor water2 = getOneObjectAtOffset (-1,0,Water.class);
            Actor water3 = getOneObjectAtOffset (1,0,Water.class);
            Actor water4 = getOneObjectAtOffset (0,1,Water.class);

            Actor zandzak = getOneObjectAtOffset (0,0,Zandzak.class);

            random = Greenfoot.getRandomNumber(3);
            if (zandzak == null){

                if (random == 1)
                {
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

                buitenDijkHealth -= erosion;
                erosion = 0;
                if (buitenDijkHealth <= 0)
                {
                    Water w1 = new Water();
                    getWorld().addObject(w1,getX(),getY());
                    getWorld().removeObject(this);
                }   
            } 
        }
    }
}    

