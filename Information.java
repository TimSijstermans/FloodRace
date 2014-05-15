import greenfoot.*;

// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Information here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Information extends Actor {

	private String [] _Information;
	
	public Information() {
		_Information = new String[2];
		
		 // setImage(new GreenfootImage(info, 18, Color.GREEN, Color.BLACK));
	}
	
	public void add(String value) {
		if (_Information[0] == null) {
			_Information[0] = value;
		}
		else if (_Information[0] != null){
			String temp;
			temp = _Information[0];
			_Information[0] = value;
			_Information[1] = temp;
		}
	}
	
	public String getOldInformation() {
		return _Information[1];
	}
	
	public String getNewInformation() {
		return _Information[0];
	}
}
