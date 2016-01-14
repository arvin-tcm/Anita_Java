
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arvin
 */
public class Grass extends FarmObject {

    protected int amount = 1;

    public Grass(int amount, int x, int y) {
        super(x, y);
        this.amount = amount;
    }

    public Grass(int x, int y) {
        super(x, y);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean doStuffInAHour(int hour) {
        amount += 1;
        return createNewGrass();
    }

    /**
     *
     * @return true if new grass is created
     */
    public boolean createNewGrass() {
        int p = (int) (10 * amount);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        return randomNumber <= p;
    }

    @Override
    public String toString() {
        return "Grass{" + super.toString() + ", amount=" + amount + '}';
    }

    @Override
    public void printObjectID() {
        System.out.print(GRASS);
    }
}
