
import java.util.Objects;
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
public class Cow extends FarmObject {

    private String name;
    private int hungriness, sicknessLevel, age;

    public Cow(String name, int hungriness, int sicknessLevel, int age, int x, int y) {
        super(x, y);
        this.name = name;
        this.hungriness = hungriness;
        this.sicknessLevel = sicknessLevel;
        this.age = age;
    }

    public Cow(int x, int y) {
        super(x, y);
        name = "Empty";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHungriness() {
        return hungriness;
    }

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
    }

    public int getSicknessLevel() {
        return sicknessLevel;
    }

    public void setSicknessLevel(int sicknessLevel) {
        this.sicknessLevel = sicknessLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.hungriness;
        hash = 23 * hash + this.sicknessLevel;
        hash = 23 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cow other = (Cow) obj;
        return this.name.equals(other.getName());
    }

    /**
     *
     * @param hour
     * @return true means cow need to die
     */
    @Override
    public boolean doStuffInAHour(int hour) {
        hungriness += 2;
        age += 1;
        return hungriness >= 100 || age >= 90001 || dieOfSickness();
    }

    /**
     *
     * @return true if cow need to die because of random chance
     */
    public boolean dieOfSickness() {
        int p = (int) (0.01 * age * sicknessLevel);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        return randomNumber <= p;
    }

    /**
     * update cow new location
     */
    public void UpdateToNewLocation() {
        this.setX(newX);
        this.setY(newY);
    }

    public boolean awake() {
        return WorldObject.currentHour >= 6 && WorldObject.currentHour < 18;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + ", name=" + name + ", hungriness=" + hungriness + ", sicknessLevel=" + sicknessLevel + ", age=" + age + '}';
    }

    @Override
    public void printObjectID() {
        System.out.print(COW);
    }
}
