import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    GreenfootImage[] rightView = new GreenfootImage[4];
    GreenfootImage[] leftView = new GreenfootImage[4];
    
    String facing = "Right";
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Character(){
        
        for(int i = 0; i < rightView.length; i++){
            rightView[i] = new GreenfootImage("images/Pixel_Character/Character" + i +".png");
            rightView[i].scale(150,100);
        }
        
        for(int i = 0; i < leftView.length; i++){
            leftView[i] = new GreenfootImage("images/Pixel_Character/Character" + i +".png");
            leftView[i].mirrorHorizontally();
            leftView[i].scale(150,100);
        }
        
        animationTimer.mark();
        
        setImage(rightView[0]);
    }
    
    
    /*
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        facing = trackMouse();
        
        
        if(Greenfoot.isKeyDown("space")){
            setLocation(getX(),getY()-6);
        }
        setLocation(getX(), getY()+4);
        animate();
        
        
    }
    
    public String trackMouse(){
        int xPlayer;
        int xMouse;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null){
            xMouse = mouse.getX();
            xPlayer = getX();
            
            if(xMouse > xPlayer){
                return "Right";
            }
            else{
                return "Left";
            }
 
        }
        
        return "Right";
    }
    
    int imageIndex = 0;
    
    public void animate(){
        if(animationTimer.millisElapsed() < 125){
            return;
        }
        
        animationTimer.mark();
        
        if(facing.equals("Right")){
            setImage(rightView[imageIndex]);
            imageIndex = (imageIndex + 1) % rightView.length;
        }
        else if(facing.equals("Left")){
            setImage(leftView[imageIndex]);
            imageIndex = (imageIndex + 1) % leftView.length;
        }
    }
}
