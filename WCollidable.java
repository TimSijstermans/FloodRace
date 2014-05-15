import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WCollidable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WCollidable extends Actor
{
    private int     _WCollidableX, 
                    _WCollidableY, 
                    _WCollidableHeight, 
                    _WCollidableWidth,
                    _heightWCollidable,
                    _widthWCollidable, 
                    _outerWCollidableRight, 
                    _outerWCollidableBottom, 
                    _outerWCollidableLeft, 
                    _outerWCollidableTop;
                              
    private boolean _isPlaced;
    
    public WCollidable() { }    
    
    // Setters
    public void setPlaced(boolean value) {
    	_isPlaced = value;
    }
    
	public void setDimensions(int x, int y) {
		_WCollidableX = x;
		_WCollidableY = y;
		
        _WCollidableHeight = getImage().getHeight();
        _WCollidableWidth = getImage().getWidth();
        
        _heightWCollidable =  _WCollidableHeight / 2;
        _widthWCollidable = _WCollidableWidth / 2;
        
        // Used to define the edges
        _outerWCollidableRight = _WCollidableX + _widthWCollidable;
        _outerWCollidableBottom = _WCollidableY + _heightWCollidable;
        _outerWCollidableLeft = _WCollidableX - _widthWCollidable;
        _outerWCollidableTop = _WCollidableY - _heightWCollidable;
        
        _isPlaced = true;
	}
    
    // Getters
	public boolean isPlaced() {
		return _isPlaced;
	}
	
    public int getHeight() {
        return _WCollidableHeight;
    }
    
    public int getWidth() {
        return _WCollidableWidth;
    }
    
    public int getOuterRight() {
        return _outerWCollidableRight;
    }
    
    public int getOuterLeft() {
        return _outerWCollidableLeft;
    }
    
    public int getOuterTop() {
        return _outerWCollidableTop;
    }   
    
    public int getOuterBottom() {
        return _outerWCollidableBottom;
    } 
}
