import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen which gives basic instructions and leads to the main world
 * 
 * @author Qureshi
 * @version 19 Jan 2023
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

        Button button = new Button();
        addObject(button,298,365);
        button.setLocation(314,370);
        button.setLocation(289,364);
        label2.setLocation(311,302);
        label2.setLocation(304,303);
        label2.setLocation(304,303);
        label2.setLocation(299,283);
        label.setLocation(306,257);
        label.setLocation(308,239);
        label2.setLocation(301,273);
        label3.setLocation(316,310);
        label2.setLocation(291,285);
        label2.setLocation(281,268);
        label2.setLocation(281,268);
        label3.setLocation(273,304);
    }
}
