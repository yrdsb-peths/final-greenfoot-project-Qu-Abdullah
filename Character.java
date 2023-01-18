import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @Qureshi 
 * @17 January 2023
 */
public class Character extends Actor
{
    GreenfootImage[] rightView = new GreenfootImage[4];
    GreenfootImage[] leftView = new GreenfootImage[4];
    
    String facing = "Right";
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    private int clickCount = 0;
    
    public Character(){
        
        for(int i = 0; i < rightView.length; i++){
            rightView[i] = new GreenfootImage("images/Pixel_Character/Character" + i +".png");
            rightView[i].scale(70,80);
        }
        
        for(int i = 0; i < leftView.length; i++){
            leftView[i] = new GreenfootImage("images/Pixel_Character/Character" + i +".png");
            leftView[i].mirrorHorizontally();
            leftView[i].scale(70,70);
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
        MouseInfo mouse = Greenfoot.getMouseInfo();
        facing = trackMouse();
        
        
        if(Greenfoot.isKeyDown("space")){
            setLocation(getX(),getY()-6);
            animate();
        }
        setLocation(getX(), getY()+4);
        
        if(mouse != null)
        
        if(mouse.getButton() == 1){
            shoot();            
        }
        
        if(getY() > 360){
            MyWorld world = (MyWorld) getWorld();
            
            world.gameOver();
        }
        
        
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
    
    public void shoot(){
        MyWorld world = (MyWorld) getWorld();
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            int y = mouse.getY();
            
            Bullet bullet = new Bullet();
            world.addObject(bullet, getX(), getY());
            bullet.turnTowards(x,y);
        }
    }
    
    
}
