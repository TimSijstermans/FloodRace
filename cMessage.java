import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.Color;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cMessage extends Actor{

	public cMessage(String text, int size, Color color) {
		setImage(new GreenfootImage(text, size, color, Color.BLACK));
	}
}

