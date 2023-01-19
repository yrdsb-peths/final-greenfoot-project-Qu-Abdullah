import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world where the actual game is played.
 * 
 * @author Qureshi
 * @version 17 January 2023
 */
public class MyWorld extends World
{
    //Lose sound
    GreenfootSound loseSound = new GreenfootSound("GameOverSound.mp3");
    
    //counts the amount of times the act method is complete
    int counter = 0;
    
    //Variable that increases the frequency of obstacle spawns.
    double amplifier = 1.00;
    
    //Score and it's label
    int score;
    Label scoreLabel;

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        
        Character character = new Character();
        addObject(character, getWidth()/2, getHeight()/2);
        
        scoreLabel = new Label(0,60);
        addObject(scoreLabel, getWidth()/2, 50);        
    }

    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        
        counter++;
        if(counter == (int) 100 * amplifier){
            
            Obstacles obstacle = new Obstacles();
            Ghost ghost = new Ghost();
            
            // Spawns the object underneath the world, and moves it up by a randomly generated value to create random 
            addObject(obstacle, getWidth(), getHeight()/2 + obstacle.getImage().getHeight() - Greenfoot.getRandomNumber(300));
            
            //Makes the ghost spawn at a random position
            int randomSpawn = Greenfoot.getRandomNumber(2);
            if(randomSpawn == 1){
                addObject(ghost, getWidth(), Greenfoot.getRandomNumber(250));
            }
            else {
                addObject(ghost, 0, Greenfoot.getRandomNumber(250));
            }
            
            counter = 0;
            
            if(score % 10 == 0){
                
                if(amplifier > 0.50){
                    amplifier -=0.10;
                }
                
            }
            
        }
    }
    
    /**
     * Increases the score.
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * Game over appears and the game stops.
     */
    public void gameOver(){
        Label gameOver = new Label("Game Over",100);
        
        loseSound.play();
        
        addObject(gameOver, getWidth()/2, getHeight()/2);
        
        Greenfoot.stop();
    }
}
