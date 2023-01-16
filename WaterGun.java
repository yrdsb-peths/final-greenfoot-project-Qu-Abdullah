import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterGun extends Actor
{
    /**
     * Act - do whatever the WaterGun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image = new GreenfootImage("images/Water_gun.png");
    
    public WaterGun(){
        setImage(image);
    }
    
    public void addedToWorld(World world){
        int x = getWorld().getHeight()/2;
        int y = getWorld().getWidth()/2;
        setLocation(x,y);
    }
    
    public void act()
    {
        
    }
    
    public void autoOrient(){
        
    }
    
    
}
