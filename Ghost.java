import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BreadBoy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    /**
     * Act - do whatever the BreadBoy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage ghostRight = new GreenfootImage("images/Ghost.png");
    Greenfoot
    
    public Ghost(){
        ghostRight.scale(75,75);
        ghostRight.mirrorHorizontally();
        setImage(ghostRight);
        
    }
    
    public void act()
    {
        if(isTouching(Bullet.class)){
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }
        follow();
    }
    
    public void follow(){
        MyWorld world = (MyWorld) getWorld();
        int x;
        int y;
        
        List players = world.getObjects(Character.class);
        
        if(players.size() == 1){
            Actor player = (Actor) players.get(0);
            
            x = player.getX();
            y = player.getY();
            
            turnTowards(x,y);
            
        }
        
        
        
    }
    
    
}
