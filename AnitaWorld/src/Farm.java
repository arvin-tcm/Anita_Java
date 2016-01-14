
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
public class Farm {
    
    private FarmObject[][] grid;
    private FarmObject[] list;
    private int listLength;
    
    public Farm() {
        this.grid = new FarmObject[50][50];
        this.list = new FarmObject[20];
        this.listLength = 0;
    }
    
    public Farm(int gridSize, int listSize) {
        this.grid = new FarmObject[gridSize][gridSize];
        this.list = new FarmObject[listSize];
        this.listLength = 0;
    }
    
    public Farm(FarmObject[][] grid, FarmObject[] list) {
        this.grid = grid;
        this.list = list;
        this.listLength = list.length;
    }
    
    public FarmObject[][] getGrid() {
        return grid;
    }
    
    public void setGrid(FarmObject[][] grid) {
        this.grid = grid;
    }
    
    public FarmObject[] getList() {
        return list;
    }
    
    public void setList(FarmObject[] list) {
        this.list = list;
    }
    
    public int getListLength() {
        return listLength;
    }
    
    public void setListLength(int listLength) {
        this.listLength = listLength;
    }
    
    public void processTime() {
        for (FarmObject obj : list) {
            if (obj instanceof Cow) {
                Cow temp = (Cow) obj;
                // dead
                if (obj.doStuffInAHour(WorldObject.currentHour)) {
                    obj.removeObjectFromFarm(this);
                }
                if (temp.awake() && obj.generateNewLocation(grid.length)) {
                    if (grid[obj.getNewX()][obj.getNewY()] == null) {
                        move(obj);
                        temp.UpdateToNewLocation();
                    } else if (grid[obj.getNewX()][obj.getNewY()] instanceof Grass) {
                        Grass grass = (Grass) grid[obj.getNewX()][obj.getNewY()];
                        if (grid[obj.getNewX()][obj.getNewY()] instanceof PoisonedGrass) {
                            temp.setSicknessLevel(temp.getSicknessLevel() + grass.getAmount());
                        }
                        temp.setHungriness(temp.getHungriness() - grass.getAmount());
                        grass.removeObjectFromFarm(this);
                        move(obj);
                        temp.UpdateToNewLocation();
                    }
                }
            }
            if (obj instanceof Grass) {
                Grass grass = (Grass) obj;
                if (grass.doStuffInAHour(WorldObject.currentHour)) {
                    if (grass.generateNewLocation(grid.length)) {
                        Grass newGrass = new Grass(grass.getNewX(), grass.getNewY());
                        addFarmObjectToGrid(newGrass);
                        addFarmObjectToList(newGrass);
                    }
                }
            }
        }
    }
    
    public void add(FarmObject obj) {
        addFarmObjectToGrid(obj);
        addFarmObjectToList(obj);
    }
    
    public boolean addFarmObjectToGrid(FarmObject obj) {
        if (grid[obj.getX()][obj.getY()] != null) {
            return false;
        }
        grid[obj.getX()][obj.getY()] = obj;
        return true;
    }
    
    private void addFarmObjectToList(FarmObject obj) {
        if (list.length == listLength) {
            extendsListSize();
        }
        list[listLength++] = obj;
    }
    
    private void extendsListSize() {
        FarmObject[] newArray = new FarmObject[listLength + 10];
        System.arraycopy(list, 0, newArray, 0, list.length);
        list = newArray;
    }
    
    private void move(FarmObject obj) {
        grid[obj.getX()][obj.getY()] = null;
        grid[obj.getNewX()][obj.getNewY()] = obj;
    }
    
    @Override
    public String toString() {
        return "Farm{" + "grid=" + Arrays.toString(grid) + ", list=" + Arrays.toString(list) + ", listLength=" + listLength + '}';
    }
    
    public void shrinkList() {
        int index = 0;
        while (index < listLength) {
            if (list[index] == null) {
                break;
            }
            index++;
        }
        for (int i = index; i < listLength - 1; i++) {
            swapElements(index);
        }
        listLength--;
    }
    
    private void swapElements(int index) {
        FarmObject obj = list[index];
        list[index] = list[index + 1];
        list[index + 1] = obj;
    }
    
    private void trace(String s) {
        System.out.println(s);
    }
    
    public void printFarm() {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != null) {
                    grid[i][j].printObjectID();
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
