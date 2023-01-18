import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    
    int speed = 3;
    
    public Obstacles(){
        getImage().scale(getImage().getWidth(), 400);
    }
    
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        setLocation(getX()-speed,getY());
        
        if(isTouching(Character.class)){
            world.gameOver();
        }
    }
}
