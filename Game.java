
public class Game {
    private Player playerA;
    private Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void play() {
        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            Player attacker = decideAttacker();
            Player defender = (attacker == playerA) ? playerB : playerA;
            int attackRoll = Dice.roll();
            int defenseRoll = Dice.roll();
            int attackDamage = attackRoll * attacker.getAttack();
            int defenseDamage = defenseRoll * defender.getStrength();
            int damageTaken = Math.max(0, attackDamage - defenseDamage);
            defender.setHealth(defender.getHealth() - damageTaken);
            System.out.println(attacker + " attacks with roll " + attackRoll + ", " + defender + " defends with roll "
                    + defenseRoll);
            System.out.println("Damage dealt: " + damageTaken);
            System.out.println(
                    "Remaining health - Player A: " + playerA.getHealth() + ", Player B: " + playerB.getHealth());
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        System.out.println("Game over!");
        System.out.println((playerA.getHealth() > 0) ? "Player A wins!" : "Player B wins!");
    }

    private Player decideAttacker() {
        return (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
    }
}
