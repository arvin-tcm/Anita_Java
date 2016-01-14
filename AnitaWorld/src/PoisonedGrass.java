/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvin
 */
public class PoisonedGrass extends Grass {

    public PoisonedGrass(int amount, int x, int y) {
        super(amount, x, y);
    }

    public PoisonedGrass(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean doStuffInAHour(int hour) {
        amount += 2;
        return createNewGrass();
    }

    @Override
    public String toString() {
        String temp = super.toString();
        temp = temp.replaceAll("Grass", "PoisonedGrass");
        return temp;
    }

    @Override
    public void printObjectID() {
        System.out.print(POISONED_GRASS);
    }
}
