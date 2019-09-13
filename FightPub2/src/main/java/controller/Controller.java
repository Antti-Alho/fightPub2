package controller;
import Model.Character;

/**
 *
 * @author Heidi
 */
public class Controller {
    
    private Character player1;
    private Character player2;
    
    public Controller() {
        this.player1 = new Character(true , "Jukka");
        this.player2 = new Character(false, "Pekka");
    }

    /**
     * @return the player1
     */
    public Character getPlayer1() {
        return player1;
    }

    /**
     * @return the player2
     */
    public Character getPlayer2() {
        return player2;
    }
    
    /**
     * Checks are the hurtboxes  on top of each other. 
     * If they are, they will be moved/stopped.
     * @return 
     */
    public boolean checkCollission(){
        if (false){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkHitboxCollission(){
        if (true){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkHurtboxCollission(){
        if (true){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Listens inputs.
     */
    public void eventListener(){
        
    }
    
    /**
     * Listens if there have been keyboard commands.
     */
    /*
    public checkInputs(){
        return ;
    }
     */
    
    

    
}
