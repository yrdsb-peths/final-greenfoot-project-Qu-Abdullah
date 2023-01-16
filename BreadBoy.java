import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class BreadBoy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreadBoy extends Actor
{
    /**
     * Act - do whatever the BreadBoy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage BreadBoyImage = new GreenfootImage("images/BreadBoyIdle.png");
    public void act()
    {
        BreadBoyImage.scale(50,50);
        
        setImage(BreadBoyImage);
        changeOrientation();
        
    }
    
    public void changeOrientation(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            int x = mouse.getX();
            int y = mouse.getY();
            
            turnTowards(x,y);
        }
    }
}
