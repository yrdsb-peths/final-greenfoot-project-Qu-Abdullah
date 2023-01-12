import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int xSpeed;
    private int ySpeed;
    private int collisions;
    
    public Bullet(){
        xSpeed = 8;
        ySpeed = 8;
        GreenfootImage image = new GreenfootImage(10,10);
        image.fillOval(0,0,10,10);
        setImage(image);
        
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        setLocation(getX()+xSpeed, getY()+ySpeed);
        if(getX() > 590 || getX() < 10){
            xSpeed = xSpeed * -1;
            collisions++;
        }
        
        if(getY() < 10 || getY() > 390){
            ySpeed = ySpeed * -1;
            collisions++;
        }
        
        if(collisions == 4){
            world.removeObject(this);
        }
        
        
    }
    
    
    
}
