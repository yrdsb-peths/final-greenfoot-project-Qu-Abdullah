import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Obstacles class that creates objects for the player to avoid
 * 
 * @author Qureshi
 * @version 18 Jan 2023
 */
public class Obstacles extends Actor
{
    
    int speed = 3;
    
    public Obstacles(){
        getImage().scale(130, 400);
    }
    
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //Horizontal speed of the object.
        setLocation(getX()-speed,getY());
        
        //ends game if the object is in contact with the player.
        if(isTouching(Character.class)){
            world.gameOver();
        }
    }
}
