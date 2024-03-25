import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGamePlay() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Game game = new Game(playerA, playerB);
        game.play();
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
    }

    @Test
    public void testDiceRoll() {
        int rollResult = Dice.roll();
        assertTrue(rollResult >= 1 && rollResult <= 6);
    }

    @Test
    public void testDecreaseHealth() {
        Player player = new Player(100, 10, 5);
        int initialHealth = player.getHealth();
        player.decreaseHealth(20);
        assertEquals(initialHealth - 20, player.getHealth());
    }

    @Test
    public void testAttackDefenseMechanism() {
        Player playerA = new Player(50, 10, 20);
        Player playerB = new Player(100, 5, 10);
        int attackRoll = 5; // Assuming fixed roll for testing
        int defenseRoll = 3; // Assuming fixed roll for testing
        int attackDamage = attackRoll * playerA.getAttack();
        int defenseDamage = defenseRoll * playerB.getStrength();
        int damageTaken = Math.max(0, attackDamage - defenseDamage);
        playerB.setHealth(playerB.getHealth() - damageTaken);
        assertEquals(85, playerB.getHealth());
    }

    
}
