import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    GreenfootImage button = new GreenfootImage("images/Button.png");
    
    public Button(){
        button.scale(100,50);
        
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
