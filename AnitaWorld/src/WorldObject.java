
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arvin
 */
public class WorldObject {

    private Farm[] farmList;
    public static int currentHour;

    public WorldObject() {
        farmList = new Farm[10];
    }

    public WorldObject(Farm[] farmList, int currentHour) {
        this.farmList = farmList;
        WorldObject.currentHour = currentHour;
    }

    public Farm[] getFarmList() {
        return farmList;
    }

    public void setFarmList(Farm[] farmList) {
        this.farmList = farmList;
    }

    public int getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(int currentHour) {
        WorldObject.currentHour = currentHour;
    }

    @Override
    public String toString() {
        return "WorldObject{" + "farmList=" + Arrays.toString(farmList) + ", currentHour=" + currentHour + '}';
    }

    public void incrementHour() {
        currentHour++;
        if (currentHour >= 24) {
            currentHour = 0;
        }
        for (Farm f : farmList) {
            if (f != null) {
                f.processTime();
            }
        }
    }

    private void trace(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        WorldObject wo = new WorldObject();
        wo.getFarmList()[0] = new Farm(10, 10);
        wo.setCurrentHour(10);
        wo.getFarmList()[0].add(new Cow(2, 2));
        wo.getFarmList()[0].add(new Grass(2, 3));
        wo.getFarmList()[0].printFarm();
        System.out.println("");
        wo.incrementHour();
        wo.getFarmList()[0].printFarm();
        System.out.println(wo.getFarmList()[0].toString());
    }
}
