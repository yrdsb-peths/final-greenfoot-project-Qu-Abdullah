import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();

            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Press Space to avoid Obstacles", 40);
        addObject(label,288,238);
        label.setLocation(310,248);
        Label label2 = new Label("Aim with your Mouse", 40);
        addObject(label2,297,300);
        label2.setLocation(297,286);
        Label label3 = new Label("Shoot by pressing Left Click", 40);
        addObject(label3,289,317);
        label3.setLocation(303,314);
        label2.setLocation(315,284);
        label3.setLocation(315,302);
        label3.setLocation(320,318);
        Label label4 = new Label("Press Space to Start...", 40);
        addObject(label4,262,369);
        label4.setLocation(319,367);
    }
}
