package restaurant.menuItem;

import restaurant.Utility;
import restaurant.menuItem.beverage.Alcohol;
import restaurant.menuItem.beverage.SoftDrink;
import restaurant.menuItem.food.Dessert;
import restaurant.menuItem.food.MainMeal;
import restaurant.menuItem.food.Salad;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<String, HashMap<String, ArrayList<IMenuItem>>> menu;
    ArrayList<IVeganItem> forVegans = new ArrayList<>();
    ArrayList<IThugItem> forThugs = new ArrayList<>();

    public Menu() {
        this.menu = new HashMap<>();
        fillMenu();
    }

    private void addItem(IMenuItem item) {
        if(!menu.containsKey(item.getKind())) {
            menu.put(item.getKind(), new HashMap<>());
        }
        if(!menu.get(item.getKind()).containsKey(item.getType())) {
            menu.get(item.getKind()).put(item.getType(), new ArrayList<>());
        }
            menu.get(item.getKind()).get(item.getType()).add(item);

        if(item instanceof IThugItem) {
            forThugs.add((IThugItem) item);
        }
        if(item instanceof IVeganItem) {
            forVegans.add((IVeganItem) item);
        }
    }

    private void fillMenu() {
        for (int i = 0; i < 10; i++) {
            addItem(new Salad("Salad" + (i+1), Utility.getRandomInt(300, 600)));
            addItem(new MainMeal("MainMeal"+(i+1), Utility.getRandomInt(400, 800)));
            addItem(new Dessert("Dessert" + (i+1), Utility.getRandomInt(200, 300)));
        }
        for (int i = 0; i < 20; i++) {
            addItem(new Alcohol("Alcohol" + (i+1)));
            addItem(new SoftDrink("SoftDrink" + (i+1)));
        }
    }

    public void removeItem(IMenuItem item) {
        if(menu.get(item.getKind()).containsKey(item.getType())) {
            menu.get(item.getKind()).get(item.getType()).remove(item);
        }
    }
    public IMenuItem getRandomItem(){
        String kind;
        String type;
        if(Utility.getRandom().nextBoolean()) {
            kind = "Food";

            int chance = Utility.getRandom().nextInt();
            if(chance < 33) {
                type = "Salad";
            } else if(chance < 66){
                type = "Main Meal";
            } else {
                type = "Dessert";
            }
        } else {
            kind = "Beverage";
            if(Utility.getRandom().nextBoolean()) {
                type = "Alcohol";
            } else {
                type = "Soft Drink";
            }
        }

        int random = Utility.getRandom().nextInt(menu.get(kind).get(type).size());
        return menu.get(kind).get(type).get(random);

    }
    public IVeganItem getRandomVeganItem(){
        return forVegans.stream().findAny().get();
    }
    public IThugItem getRandomThugItem(){
        return forThugs.stream().findAny().get();
    }

    public HashMap<String, HashMap<String, ArrayList<IMenuItem>>> getMenu() {
        return menu;
    }
}
