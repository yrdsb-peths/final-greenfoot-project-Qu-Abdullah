import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class that creates a button which swaps to the main world.
 * 
 * @author Qureshi
 * @version 18 Jan 2023
 */
public class Button extends Actor
{
    GreenfootImage button = new GreenfootImage("images/Button.png");
    
    public Button(){
        button.scale(150,75);
        
        setImage(button);
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            MyWorld gameWorld = new MyWorld();
    
            Greenfoot.setWorld(gameWorld);
        }
    }
}
