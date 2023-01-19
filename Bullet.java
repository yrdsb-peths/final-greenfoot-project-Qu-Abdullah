import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * A Bullet class that allows you to spawn a bullet in order to eliminate ghosts.
 * 
 * Removes itself after touching an edge or a ghost.
 * 
 * @author Qureshi
 * @version 17 January 2023
 */
public class Bullet extends Actor
{
    
    /*
     * Create a new Bullet
     */
    public Bullet(){
        getImage().scale(10,10);
    }
    
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    MouseInfo mouse = Greenfoot.getMouseInfo();
    
    public void act()
    {
        move(8);
        if(isAtEdge() || isTouching(Ghost.class)){
            
            MyWorld world = (MyWorld) getWorld();
            
            if(isTouching(Ghost.class)){
            
                removeTouching(Ghost.class); 
                world.increaseScore();
            }
            
            world.removeObject(this);
        } 
        
    } 
    
}
