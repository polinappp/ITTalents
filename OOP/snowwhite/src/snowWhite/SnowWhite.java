package snowWhite;

import snowWhite.present.Present;

import java.util.*;

public class SnowWhite {
    private Factory factory;

    public SnowWhite(Factory factory) {
        this.factory = factory;
    }

    public void startWork() {
        distributeWork();
        prepareSleigh();
        makeReport();
    }

    private void makeReport() {
        allLetters();
        childWithMostPresents();
        cityWithMostKids();
        dwarfWithMostPresents();
        tallestDwarf();
        mostWantedPresent();
        colors();
        presentsPerQuantity();
        allDwarfs();
        townsWithChimneys();
        expenses();
        mostExpensiveChild();
        denials();
    }

    private void mostExpensiveChild() {
        Map<String, Double> kids = new HashMap<>();

        for ( Map.Entry<String, ArrayList<Present>> town : factory.getSleight().entrySet()
             ) {
            for (int i = 0; i < town.getValue().size(); i++) {
                Child child = town.getValue().get(i).getOwner();
                Present present = town.getValue().get(i);

                if(!kids.containsKey(child.getName())) {
                    kids.put(child.getName(), present.getPrice());
                } else {
                    Double count = kids.get(child.getName());
                    kids.put(child.getName(), count+present.getPrice());
                }
            }
        }

        ArrayList<Map.Entry<String, Double>> list = new ArrayList<>();
        list.addAll(kids.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });

        System.out.println(list.get(0).getKey() + " - " + list.get(0).getValue());
    }

    private void allDwarfs() {
        ArrayList<Map.Entry<Dwarf, Integer>> dwarves = new ArrayList<>();

        for ( Dwarf dwarf : factory.getDwarves()) {
            dwarves.add(new AbstractMap.SimpleEntry<>(dwarf, dwarf.getPresentsMade().size()));
        }

        Collections.sort(dwarves, new Comparator<Map.Entry<Dwarf, Integer>>() {
            @Override
            public int compare(Map.Entry<Dwarf, Integer> o1, Map.Entry<Dwarf, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        System.out.println(    );
        System.out.println("List of dwarves");
        for (int i = 0; i < dwarves.size(); i++) {
            System.out.println(dwarves.get(i).getKey().getName() + " - " + dwarves.get(i).getValue());
        }
        System.out.println();
    }

    private void presentsPerQuantity() {
        Map<String, Integer> presents = new HashMap<>();

        for (Map.Entry<String, ArrayList<Present>> gradove : factory.getSleight().entrySet()) {
            for (int i = 0; i < gradove.getValue().size(); i++) {
                Present present = gradove.getValue().get(i);
                if(!presents.containsKey(present.getClass().getSimpleName())) {
                    presents.put(present.getClass().getSimpleName(), 1);
                } else {
                    Integer count = presents.get(present.getClass().getSimpleName());
                    presents.put(present.getClass().getSimpleName(), count+1);
                }
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(presents.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        System.out.println("\nPresent - Quantity");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " - " + list.get(i).getValue());
        }
    }

    private void mostWantedPresent() {

        Map<String, Integer> mostWanted = new HashMap<>();

        for (int i = 0; i < factory.getPostBox().size(); i++) {
            Letter letter = factory.getPostBox().get(i);

            for (int j = 0; j < letter.getPresents().size(); j++) {
                if(!mostWanted.containsKey(letter.getPresents().get(j).getClass().getSimpleName())) {
                    mostWanted.put(letter.getPresents().get(j).getClass().getSimpleName(), 1);
                } else {
                    Integer count = mostWanted.get(letter.getPresents().get(j).getClass().getSimpleName());
                    mostWanted.put(letter.getPresents().get(j).getClass().getSimpleName(), count+1);
                }
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(mostWanted.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        System.out.println("Most wanted present: " + list.get(0).getKey());
    }

    private void tallestDwarf() {
        TreeSet<Dwarf> dwarves = new TreeSet<>((o1, o2) -> o2.getHeight()-o1.getHeight());
        dwarves.addAll(factory.getDwarves());

        for ( Dwarf dwarf : dwarves) {
            if(dwarf.getPresentsMade().size() >= 10) {
                System.out.println("Tallest dwarf with >= 10 presents: " + dwarf.getName() + "-" + dwarf.getHeight());
                break;
            }
        }
    }

    private void cityWithMostKids() {
        String city = "";
        int maxSize = 0;

        for (Map.Entry<String, ArrayList<Present>> gradove : factory.getSleight().entrySet()) {
            HashSet<Child> children = new HashSet<>();
            for (int i = 0; i < gradove.getValue().size(); i++) {
                children.add(gradove.getValue().get(i).getOwner());
            }

            if(children.size() > maxSize) {
                city = gradove.getKey();
                maxSize = children.size();
            }
        }

        System.out.println("City with most children: " + city);
    }

    private void allLetters() {
        System.out.println("All Letters: " + factory.getPostBox().size());

        int good = 0;
        int bad = 0;
        for (int i = 0; i < factory.getPostBox().size(); i++) {
            if(factory.getPostBox().get(i).getWriter().isNaughty()) {
                bad++;
            } else {
                good++;
            }
        }

        System.out.println("Good : Naughty = " + good + " : " + bad);
    }

    private void childWithMostPresents() {
        TreeSet<Letter> children = new TreeSet<>(new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                if(Boolean.compare(o2.getWriter().hasChimney(), o1.getWriter().hasChimney()) < 0) {
                    if(o2.getPresents().size()-o1.getPresents().size() < 0) {
                        return -1;
                    } else if (o2.getPresents().size()-o1.getPresents().size() > 0){
                        return 1;
                    }
                    return 0;
                } else if(Boolean.compare(o2.getWriter().hasChimney(), o1.getWriter().hasChimney()) > 0) {
                    return 1;
                }
                return 0;
            }
        });

        children.addAll(factory.getPostBox());
        System.out.println("Child with most presents: " + children.first().getWriter());
    }

    private void colors() {
        int count = 0;

        for ( Map.Entry<String, ArrayList<Present>> chuval : factory.getSleight().entrySet()) {
                TreeSet<Present> cvqt = new TreeSet<>((o1, o2) -> o1.getPackageColor().compareTo(o2.getPackageColor()));
                cvqt.addAll(chuval.getValue());
                if(cvqt.size() > count) {
                    count = cvqt.size();
                }
        }

        System.out.println("Number of colors: " + count);
    }

    private void dwarfWithMostPresents() {
        TreeSet<Dwarf> dwarves = new TreeSet<>((o1, o2) -> o2.getPresentsMade().size() - o1.getPresentsMade().size());
        dwarves.addAll(factory.getDwarves());
        System.out.println("Dwarf with most presents: " + dwarves.first().getName());
    }

    private void townsWithChimneys() {
        Map<String, Integer> towns = new HashMap<>();

        for ( Map.Entry<String, ArrayList<Present>> town : factory.getSleight().entrySet()
             ) {
            for (int i = 0; i < town.getValue().size(); i++) {
                if(town.getValue().get(i).getOwner().hasChimney()) {
                    if(!towns.containsKey(town.getKey())) {
                        towns.put(town.getKey(), 1);
                    } else {
                        Integer count = towns.get(town.getKey());
                        towns.put(town.getKey(), count+1);
                    }
                }
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(towns.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()- o1.getValue();
            }
        });

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println();
    }

    private void expenses() {
        System.out.println("Expenses " + factory.getExpenses());
    }

    private void denials() {
        System.out.println("Denials " + factory.getDenials());
    }

    private void prepareSleigh() {
        for (Map.Entry<String, Map<String, ArrayList<Present>>> storage: factory.getStorage().entrySet()) {
            for (Map.Entry<String, ArrayList<Present>> presents : storage.getValue().entrySet()){
                for (int i = 0; i < presents.getValue().size(); i++) {
                    Present present = presents.getValue().get(i);
                    factory.addToSleigh(present);
                }
            }
        }

        sortSleight();
        //factory.printSleigh();
    }

    private void sortSleight() {
        for (Map.Entry<String, ArrayList<Present>> chuval : factory.getSleight().entrySet()) {
            ArrayList<Present> unsorted = chuval.getValue();
            Collections.sort(unsorted, Present.byChimney);
        }
    }
    private void distributeWork() {

        for (int i = 0; i < factory.getPostBox().size(); i++) {
            int rand = Utility.getRandomInt(0, factory.getDwarves().size());
            Dwarf dwarf = factory.getDwarves().get(rand);
            Letter letter = factory.getPostBox().get(i);

            if(letter.getWriter().isNaughty()) {
                boolean deserves = Utility.getRandom().nextBoolean();
                if(!deserves) {
                    factory.increaseDenials();
                }
                dwarf.makePresent(letter.getPresents().get(0));

            } else {
                dwarf.makePresent(letter.getPresents());
            }
        }
    }
}
