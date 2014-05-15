import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Timer extends Actor{

	private int _Time;
	private int _Target = 0;
	private Map _World;
    private long _PrevTime = System.currentTimeMillis();
	
	public Timer(int time) {
		_Time = time;
		setImage(new GreenfootImage("Tijd: ", 16, Color.GREEN, Color.BLACK));
	}
	
	public void act()
	{
		_World = (Map) getWorld();
        if (!_World.isPaused())
        {
           long currTime = System.currentTimeMillis();
            if (_Time == _Target)
            {
            	_World.setPaused(true);
            	_World.createSuccessMenu();
            }
        	if (currTime >= _PrevTime + 1000) {
    	        if (_Time >= _Target) {
    	            updateImage();
    	        }
    	        
    	        timedScore();
    	        
    	        _PrevTime = currTime;
        	} 
        }
	}
	
    private void updateImage()
    {
        setImage(new GreenfootImage(String.format("Tijd: %d", _Time), 16, Color.GREEN, Color.BLACK));
    }
    
    private void timedScore(){
        add(1);
    }
    
    /**
     * Add a new score to the current counter value.
     */
    public void add(int score)
    {
    	_Time -= score;
    }
}
