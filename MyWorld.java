import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Qureshi
 * @17 January 2023
 */
public class MyWorld extends World
{
    int counter = 0;
    double amplifier = 1.00;
    int score;
    
    Label scoreLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        
        Character character = new Character();
        addObject(character, getWidth()/2, getHeight()/2);
        
        Label scoreLabel = new Label(0,60);
        addObject(scoreLabel, getWidth()/2, 50);        
    }

    
    public void act(){
        
        counter++;
        if(counter == 100*amplifier){
            Obstacles obstacle = new Obstacles();
            Ghost ghost = new Ghost();
            
            addObject(obstacle, getWidth(), getHeight()/2 + obstacle.getImage().getHeight() - Greenfoot.getRandomNumber(300));
            
            int randomSpawn = Greenfoot.getRandomNumber(2);
            if(randomSpawn == 1){
                addObject(ghost, getWidth(), Greenfoot.getRandomNumber(400));
            }
            else {
                addObject(ghost, 0, Greenfoot.getRandomNumber(400));
            }
            
            counter = 0;
            score++;
            
            if(score % 10 == 0){
                
                if(amplifier > 0.50){
                    amplifier -=0.25;
                }
                
            }
            
        }
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    public void gameOver(){
        Label gameOver = new Label("Game Over",100);
        
        addObject(gameOver, getWidth()/2, getHeight()/2);
        
        Greenfoot.stop();
    }
}
