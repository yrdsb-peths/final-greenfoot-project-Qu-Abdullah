import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Ghost class that behaves as an enemy.
 * 
 * @author Qureshi 
 * @version 17 January 2023
 */
public class Ghost extends Actor
{
    //Images for the Ghost
    GreenfootImage ghostLeft = new GreenfootImage("images/Ghost.png");
    GreenfootImage ghostRight = new GreenfootImage("images/Ghost.png");
    
    /**
     * Contructor for Ghost
     */
    public Ghost(){
        ghostLeft.scale(75,75);
        ghostRight.scale(75,75);
        
        ghostLeft.mirrorVertically();
        ghostLeft.mirrorHorizontally();
        
        ghostRight.mirrorHorizontally();
        
        setImage(ghostLeft);
        
    }
    
     /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act(){
        MyWorld world = (MyWorld) getWorld();
        
        if(isTouching(Bullet.class)){
            world.removeObject(this);
        }
        
        follow();
    }
    
    /**
     * follows the player and turns towards it.
     */
    public void follow(){
        MyWorld world = (MyWorld) getWorld();
        int x;
        int y;
        
        //Getting the player in the world.
        List players = world.getObjects(Character.class);
        
        //Avoiding a NullPointerException.
        if(!players.isEmpty()){ 
            
            //Getting the first (and only) player.
            Actor player = (Actor) players.get(0);
        
            x = player.getX();
            y = player.getY();
            move(4);
            turnTowards(x,y);
            
            if(x> getX()){
                setImage(ghostRight);
            } 
            else{
                setImage(ghostLeft);
            }
        }
        
        if(isTouching(Character.class)){
            removeTouching(Character.class);
            world.gameOver();
        }
        
    }   
    
}
