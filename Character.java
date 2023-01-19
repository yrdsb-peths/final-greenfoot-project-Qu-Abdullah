import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Character class that creates a playable character.
 * 
 * @author Qureshi 
 * @version 17 January 2023
 */
public class Character extends Actor
{
    //Shoot sound
    GreenfootSound shootSound = new GreenfootSound("shoot.wav");
    
    //Frames for animation
    GreenfootImage[] rightView = new GreenfootImage[4];
    GreenfootImage[] leftView = new GreenfootImage[4];
    
    String facing = "Right";
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    private int clickCount = 0;
    
    /**
     * Constructor for Character.
     * 
     * Constructs a Character with arrays for the necessary animations.
     */
    
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
    
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        facing = trackMouse();
        
        // Fly when spacebar is pressed        
        if(Greenfoot.isKeyDown("space")){
            setLocation(getX(),getY()-6);
            animate();
        }
        
        // Gravity
        setLocation(getX(), getY()+4);
        
        // Shoot a Bullet ONCE if the left mouse button is clicked.
        if(mouse != null)
        
        if(mouse.getButton() == 1){
            shoot();
            shootSound.play();
        }
        
        // End the game if the Player touches the ground
        if(getY() > 360){
            MyWorld world = (MyWorld) getWorld();
            
            world.gameOver();
        }
        
        
    }
    
    /**
     * Tracks the mouse's horizontal position to see whether it is behind or infront of the player.
     * 
     * @return a String that determines the Characters point of view.
     */
    public String trackMouse(){
        // Horizontal positions for the Player and the Mouse
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
    
    /**
     * Animate the Character
     */
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
    
    /**
     * Shoots a bullet in the direction of the mouse, after the left mouse button is clicked.
     */
    public void shoot(){
        
        MyWorld world = (MyWorld) getWorld();
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            int y = mouse.getY();
            
            Bullet bullet = new Bullet();
            
            /*Adding 20 to the Y position to make the bullet appear from the
             * body rather than the characters face
             */ 
            world.addObject(bullet, getX(), getY()+20);
            
            
            bullet.turnTowards(x,y);
        }
    }    
}
