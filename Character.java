import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        
        while(Greenfoot.isKeyDown("space")){
            setLocation(getX(),getY()-2);
            Greenfoot.delay(100);
        }
        
        setLocation(getX(), getY()+4);
        
        
    }
}
