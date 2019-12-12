
package model;

import view.Timer;

/**
 * This class is used to set attack values of playerEntitys hitbox when he uses
 * Attack
 *
 * @see PlayerEntity
 * @author Pate, Joonas
 *
 */
public class Attack {

    final int damage;
    final int width;
    final int height;
    final int xOffset;
    final int yOffset;
    final int hitStun;
    final int blockStun;
    final int activationTime; // when time of (activation + activationTime = frameclock.getFpcCounter) the attack activates
    int activation; //when the attack button was pressed. measured in frames.
    final int deactivationTimeFINAL; //deactiovanTimeFinal + activation = deactivation time
    int deactivationTime; // when deactivationTime <= frameclock.getFpscounter() deactivate the attack.
    HitBox.HitLocation loc;
    PlayerEntity player;
    Timer frameClock;

    /**
     *
     * @param damage how much damage the hit does
     * @param width how wide the hitbox is
     * @param height how tall the hitbox is
     * @param xOffset distance form characters outer corner in relation to the
     * other charactter
     * @param yOffset distance from the floor to the hitbox's left bottom corner
     * @param hitStun how long the player who gets hit by this attack will be in
     * hitStun state in frames
     * @param blockStun how long the player who blocks this attack will be in
     * blockStun state in frames
     * @param activationTime how long in frames it takes for the attack to activate
     * @param deactivationTimeFINAL how long it takes for the hit to deactivate
     * @param loc defines is the attack low mid or high so can it be blocked in
     * which positions
     * @param player wich player owns this attack
     */
    public Attack(int damage, int width, int height, int xOffset, int yOffset, int hitStun, int blockStun, int activationTime, int deactivationTimeFINAL, HitBox.HitLocation loc, PlayerEntity player) {
        this.damage = damage;
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.hitStun = hitStun;
        this.blockStun = blockStun;
        this.activationTime = activationTime;
        this.deactivationTimeFINAL = deactivationTimeFINAL;
        this.loc = loc;
        this.player = player;
        this.frameClock = frameClock.getInstance();
    }

    /**
     * Sets the hitbox values of the hitbox object when the character uses a
     * specific attack
     */
    public void updateHitbox() {
        if (player.getState() == PlayerEntity.State.ATTACKING) {
            if (deactivationTime <= frameClock.getFpsCounter()) {
                player.getHitBox().deactivate();
                player.setState(PlayerEntity.State.NEUTRAL);
            } else if (activation + activationTime == frameClock.getFpsCounter()) {
                int tempXoffSet = this.xOffset;
                if (player.getFacing() == PlayerEntity.Facing.LEFT) {
                    tempXoffSet = player.getWidth() - this.xOffset - this.width;
                }
                player.getHitBox().setAll(this.damage, this.width, this.height, tempXoffSet, this.yOffset, this.hitStun, this.blockStun, this.loc);
            }
        }

    }

    /**
     * Sets the attacking player into attacking state. activation is the time
     * when the attack is pressed. for instance if 1000 frames of game has gone
     * forward and you press attack at frame 1001 the activation will be = 1001
     * deactivation time is the time when the hit will be deactivated.

     */
    public void activateAttack() {
        player.setState(PlayerEntity.State.ATTACKING);
        activation = frameClock.getFpsCounter();

        deactivationTime = deactivationTimeFINAL + activationTime + activation;
    }

}
