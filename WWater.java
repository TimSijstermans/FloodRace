import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.System;
/**
 * Write a description of class water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WWater extends WWaterTypes
{
    int direction;
    private long timeStarted = System.currentTimeMillis();
    

    //set current direction, prefered route, 1=up 2=right 3=down 4=left
    public WWater()
    {
            // geef een random plaatje en zet de standaard direction (down)
        
            setDirection(3);
            int random = Greenfoot.getRandomNumber(5);
            switch(random)
            {
                case 1:     setImage("water1.png");
                            break;
                case 2:     setImage("water2.png");
                            break; 
                case 3:     setImage("water3.png");
                            break;
                case 4:     setImage("water4.png");
                            break;
                default:    setImage("Wwater.png");
                            break;
            }
    }
    
    // zet direction 
    public void setDirection(int x)
    {
        switch(x)
        {
            case 1:
                direction = 1;
                break;
            case 2: 
                direction = 2;
                break;
            case 3:
                direction = 3;
                break;
            case 4:
                direction = 4;
                break;
        }
    }

    // x = de direction waarin gespawnd gaat worden
    public void spawnWater(int x)
    {
        WWater w1 = new WWater();
        switch (x)
        {
            case 1:
                    getWorld().addObject(w1,getX(),getY()-2);
                    w1.setDirection(1);
                    break;
            case 2:
                    getWorld().addObject(w1,getX()+2,getY());
                    w1.setDirection(2);
                    break;
            case 3:
                    getWorld().addObject(w1,getX(),getY()+2);
                    w1.setDirection(3);
                    break;       
            case 4:
                    getWorld().addObject(w1,getX()-2,getY());
                    w1.setDirection(4);
                    break;                

        }
    }

    // x = de al gecheckte direction 
    public void checkForFreeSpace(int x)
    {
        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;

        boolean empty1 = false;
        boolean empty2 = false;
        boolean empty3 = false;
        boolean empty4 = false;

        if (x == 1)
        {
            check1 = false;
        }
        if (x == 2)
        {
            check2 = false;
        }
        if (x == 3)
        {
            check3 = false;
        }
        if (x == 4)
        {
            check4 = false;
        }
        
        // check in de gewenste richting op collidables. als het een auto of niet-geplaatst blok is wordt het genegeerd
        if (check1)
        {
            WCollidable b1 = (WCollidable)getOneObjectAtOffset (0,-2, WCollidable.class);
            WWater w1 = (WWater)getOneObjectAtOffset(0,-2, WWater.class);
            WStillWater ws1 = (WStillWater)getOneObjectAtOffset(0,-2, WStillWater.class);


            if((w1 == null && b1 == null && ws1 == null && getY()-2>0) || (w1 == null && (b1 != null &&  b1 instanceof WCars) && ws1 == null ) 
            || (w1 == null && (b1 != null &&  b1 instanceof WItems && !b1.isPlaced()) && ws1 == null ))
            {
                empty1 = true;
            }
        }
        if (check2)
        {
            WCollidable b2 = (WCollidable)getOneObjectAtOffset (2,0, WCollidable.class);
            WWater w2 = (WWater)getOneObjectAtOffset(2,0, WWater.class);
            WStillWater ws2 = (WStillWater)getOneObjectAtOffset(2,0, WStillWater.class);

            if((w2 == null && b2 == null && ws2 == null && getX()+2<760)  || (w2 == null && (b2 != null &&  b2 instanceof WCars) && ws2 == null ) 
            || (w2 == null && (b2 != null &&  b2 instanceof WItems && !b2.isPlaced()) && ws2 == null ))
            {
                empty2 = true;
            }
        }
        if (check3)
        {
            WCollidable b3 = (WCollidable)getOneObjectAtOffset (0,2, WCollidable.class);
            WWater w3 = (WWater)getOneObjectAtOffset(0,2, WWater.class);
            WStillWater ws3 = (WStillWater)getOneObjectAtOffset(0,2, WStillWater.class);

            if((w3 == null && b3 == null && ws3 == null && getY()+2<760) || (w3 == null && (b3 != null &&  b3 instanceof WCars) && ws3 == null )
            || (w3 == null && (b3 != null &&  b3 instanceof WItems && !b3.isPlaced()) && ws3 == null ))
            {
                empty3 = true;
            }
        }
        if (check4)
        {
            WCollidable b4 = (WCollidable)getOneObjectAtOffset (-2,0, WCollidable.class);
            WWater w4 = (WWater)getOneObjectAtOffset(-2,0, WWater.class);
            WStillWater ws4 = (WStillWater)getOneObjectAtOffset(-2,0, WStillWater.class);

            if((w4 == null && b4 == null && ws4 == null && getX()-2>0) || (w4 == null && (b4 != null &&  b4 instanceof WCars) && ws4 == null )
            || (w4 == null && (b4 != null &&  b4 instanceof WItems && !b4.isPlaced()) && ws4 == null ))
            {
                empty4 = true;
            }
        }
        chooseDirection(empty1,empty2,empty3,empty4);
    }
    
    //kies random een direction om in te stromen
    public void chooseDirection(boolean b1,boolean b2,boolean b3,boolean b4)
    {
        int amount=0;
        if(b1)
        {
            amount++;
        }
        if(b2)
        {
            amount++;
        }
        if(b3)
        {
            amount++;
        }
        if(b4)
        {
            amount++;
        }
        int[] array = new int[amount];
        int i=0;
        if(b1)
        {
            array[i]=1;
            i++;
        }
        if(b2)
        {
            array[i]=2;
            i++;
        }
        if(b3)
        {
            array[i]=3;
            i++;
        }
        if(b4)
        {
            array[i]=4;
            i++;
        }
        
        // als er meer dan 0 mogelijkheden zijn, dan wordt er random eentje uitgekozen, anders wordt het water object vervangen voor stilstaand water.
        if(amount >0)
        {
            int random = Greenfoot.getRandomNumber(amount);
            spawnWater(array[random]);
        }
        else
        {
            replace();
        }

    }

    public void act()
    {
        
        long currentTime = System.currentTimeMillis();  
        long elapsedTime = currentTime - timeStarted;  
        
        _World = (Wijk1) getWorld();
        if (!_World.gamePaused)
        {
            // water stroom delay
            if (elapsedTime > 250)
            {
                // check of het water bij 1 van de wijk uitgangen ligt ( wegen )
                if ((getX() <=2 && getY() >= 226 && getY() <= 282)||(getX() <=2 && getY() >= 452 && getY() <= 508)
                || (getX() >=758 && getY() >= 453 && getY() <= 509) || (getX() >=566 && getX() <= 623 && getY() >= 758))
                {
                    _World.createGameOverMenu();
                }
                // check of het water bij de put is
                else if((getX() == 73 && getY() >= 682 && getY() <= 703)||(getX() == 100 && getY() >= 682 && getY() <= 703)
                || (getY() == 682 && getX() >= 73 && getX() <= 100)||(getY() == 703 && getX() >= 73 && getX() <= 100)) {
                    _World.createWinMenu();    
                }
                timeStarted = currentTime;
                
                // check de richting die aangegeven is op vrije plek, zoja, spawn water, zonee, zoek een vrije plek.
                 switch (direction)
                 {
                     case 1: 
                        WCollidable b1 = (WCollidable)getOneObjectAtOffset (0,-2, WCollidable.class);
                        WWater w1 = (WWater)getOneObjectAtOffset(0,-2, WWater.class);
                        WStillWater ws1 = (WStillWater)getOneObjectAtOffset(0,-2, WStillWater.class);
    
    
                        if((w1 == null && b1 == null && ws1 == null && getY()-2>0) || (w1 == null && (b1 != null &&  b1 instanceof WCars) && ws1 == null ) 
                        || (w1 == null && (b1 != null &&  b1 instanceof WItems && !b1.isPlaced()) && ws1 == null ))
                        {
                            spawnWater(1);
                        }
                       
                        else
                        {
                            checkForFreeSpace(1);
                        }
                        break;
                     case 2: 
                        WCollidable b2 = (WCollidable)getOneObjectAtOffset (2,0, WCollidable.class);
                        WWater w2 = (WWater)getOneObjectAtOffset(2,0, WWater.class);
                        WStillWater ws2 = (WStillWater)getOneObjectAtOffset(2,0, WStillWater.class);
    
                        if((w2 == null && b2 == null && ws2 == null && getX()+2<760) || (w2 == null && (b2 != null &&  b2 instanceof WCars) && ws2 == null ) 
                        || (w2 == null && (b2 != null &&  b2 instanceof WItems && !b2.isPlaced()) && ws2 == null ))
                         {
                            spawnWater(2);
                         }
                         else
                         {
                            checkForFreeSpace(2);
                         }
                         break;
                     case 3: 
                        WCollidable b3 = (WCollidable)getOneObjectAtOffset (0,2, WCollidable.class);
                        WWater w3 = (WWater)getOneObjectAtOffset(0,2, WWater.class);
                        WStillWater ws3 = (WStillWater)getOneObjectAtOffset(0,2, WStillWater.class);
    
                        if((w3 == null && b3 == null && ws3 == null && getY()+2<760) || (w3 == null && (b3 != null &&  b3 instanceof WCars) && ws3 == null )
                        || (w3 == null && (b3 != null &&  b3 instanceof WItems && !b3.isPlaced()) && ws3 == null ))
                         {
                            spawnWater(3);
                         }
                         else
                         {
                            checkForFreeSpace(3);
                         }
                         break;
                     case 4: 
                        WCollidable b4 = (WCollidable)getOneObjectAtOffset (-2,0, WCollidable.class);
                        WWater w4 = (WWater)getOneObjectAtOffset(-2,0, WWater.class);
                        WStillWater ws4 = (WStillWater)getOneObjectAtOffset(-2,0, WStillWater.class);
    
                        if((w4 == null && b4 == null && ws4 == null && getX()-2>0) || (w4 == null && (b4 != null &&  b4 instanceof WCars) && ws4 == null )
                        || (w4 == null && (b4 != null &&  b4 instanceof WItems && !b4.isPlaced()) && ws4 == null ))
                         {
                            spawnWater(4);
                         }
                         else
                         {
                            checkForFreeSpace(4);
                         }
                         break;
                }
            }
        }
    }
    
    // vervang dit object voor een stilstaand waterobject
    public void replace()
    {
        getWorld().addObject(new WStillWater(),getX(),getY());
        getWorld().removeObject(this);
    }
}
