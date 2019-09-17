package controller;
import Model.Character;
import Model.MapModel;

/**
 *
 * @author Heidi
 */
public class Controller {
    
    private Character char1;
    private Character char2;
    private int timelimit;
    private int rounds;
    private MapModel map;
    
    public Controller() {
        this.char1 = new Character(true , "Jukka");
        this.char2 = new Character(false, "Pekka");
    }

    public Controller(String char1, String char2, MapModel map, int timelimit, int rounds) {
        this.char1 = new Character(true, char1);
        this.char2 = new Character(false, char2);
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the character
     */
    public Character getCharacter(int character) throws Exception { 
        if (character == 1) {
            return this.char1;
        }
        if (character == 2 ) {
            return this.char2;
        }
        return null;
    }

    /**
     * Checks are the hurtboxes  on top of each other. 
     * If they are, they will be moved/stopped.
     * @return 
     */
    public boolean checkCollision(){
        if (false){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkHitboxCollision(){
        if (true){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkHurtboxCollision(){
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

    public void checkNextFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void advance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
