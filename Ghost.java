import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BreadBoy here.
 * 
 * @Qureshi 
 * @17 January 2023
 */
public class Ghost extends Actor
{
    /**
     * Act - do whatever the BreadBoy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage ghostLeft = new GreenfootImage("images/Ghost.png");
    GreenfootImage ghostRight = new GreenfootImage("images/Ghost.png");
    
    
    public Ghost(){
        ghostLeft.scale(75,75);
        ghostRight.scale(75,75);
        
        ghostLeft.mirrorVertically();
        ghostLeft.mirrorHorizontally();
        
        ghostRight.mirrorVertically();
        
        setImage(ghostLeft);
        
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        if(isTouching(Bullet.class)){
            world.removeObject(this);
        }
        
        follow();
    }
    
    public void follow(){
        MyWorld world = (MyWorld) getWorld();
        int x;
        int y;
        
        List players = world.getObjects(Character.class);
        
        if(!players.isEmpty()){
            Actor player = (Actor) players.get(0);
            
            x = player.getX();
            y = player.getY();
            
            if(x> getX()){
                setImage(ghostRight);
            } 
            else {
                setImage(ghostLeft);
            }
            
            move(4);
            turnTowards(x,y);
        }
        
        if(isTouching(Character.class)){
            removeTouching(Character.class);
            world.gameOver();
        }
    
    }   
    
}
