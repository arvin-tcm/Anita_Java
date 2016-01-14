/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvin
 */
public class NocturnalCow extends Cow {

    public NocturnalCow(String name, int hungriness, int sicknessLevel, int age, int x, int y) {
        super(name, hungriness, sicknessLevel, age, x, y);
    }

    public NocturnalCow(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        String temp = super.toString();
        temp = temp.replaceAll("Cow", "NocTurnalCow");
        return temp;
    }

    @Override
    public boolean awake() {
        return WorldObject.currentHour < 6 || WorldObject.currentHour >= 18;
    }

    @Override
    public void printObjectID() {
        System.out.print(NOCTURNAL_COW);
    }
}
