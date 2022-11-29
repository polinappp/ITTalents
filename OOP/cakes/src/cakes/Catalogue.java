package cakes;

import cakes.cake.*;

import java.util.*;

public class Catalogue {

    Map<String, Map<String, ArrayList<Cake>>> catalogue;

    public Catalogue() {
        this.catalogue = new HashMap<>();
        makeCakes();
    }

    private void makeCakes() {
        Cake cake;

        for (int i = 0; i < 30; i++) {
            int chance = new Random().nextInt(100);
            if(chance < 25) {
                cake = new StandardCake("Standard Cake" + (i+1), Utility.getRandomInt(15, 25),  Utility.getRandomStandard(), Utility.getRandomInt(8, 32), Utility.getR().nextBoolean());
            } else if(chance < 50) {
                cake = new WeddingCake("Wedding Cake" + (i+1), Utility.getRandomInt(80, 180), Utility.getRandomWedding(), Utility.getRandomInt(100, 250), Utility.getR().nextInt(5));
            } else if(chance < 75) {
                cake = new SpecialCake("Special Cake" + (i+1), Utility.getRandomInt(60, 100),  Utility.getRandomSpecial(), Utility.getRandomInt(16, 64), "Event" + (i+1));
            } else {
                cake = new KidCake("Kid Cake" + (i+1), Utility.getRandomInt(40, 80),  Utility.getRandomKids(), Utility.getRandomInt(16, 32), "Kid" + (i+1));
            }

            addCake(cake);
        }
    }

    private void addCake(Cake cake) {
        String cakeKind = cake.getClass().getSimpleName();
        String cakeType = cake.getType();

        if(!catalogue.containsKey(cakeKind)) {
            catalogue.put(cakeKind, new HashMap<>());
        }
        if(!catalogue.get(cakeKind).containsKey(cakeType)) {
            catalogue.get(cakeKind).put(cakeType, new ArrayList<>());
        }

//        if(!catalogue.get(cakeKind).containsKey(cakeType)) {
//            if(cakeKind.equals("StandardCake") || cakeKind.equals("SpecialCake")) {
//                catalogue.get(cakeKind).put(cakeType, new TreeSet<>((o1, o2) -> {
//                    if(Double.compare(o2.getPrice(),o1.getPrice()) == 0) {
//                        if(o1.getName().compareTo(o2.getName()) > 0) {
//                            return 1;
//                        } else if(o1.getName().compareTo(o2.getName()) < 0) {
//                            return -1;
//                        }
//                        return 0;
//                    } else if (Double.compare(o2.getPrice(),o1.getPrice()) > 0) {
//                        return 1;
//                    }
//                    return -1;
//                }));
//            } else {
//                catalogue.get(cakeKind).put(cakeType, new TreeSet<>((o1, o2) -> {
//                    if(o2.getPieces()-o1.getPieces() == 0){
//                        if(o1.getName().compareTo(o2.getName()) > 0) {
//                            return 1;
//                        } else if(o1.getName().compareTo(o2.getName()) < 0) {
//                            return -1;
//                        }
//                        return 0;
//                    } else if(o2.getPieces()-o1.getPieces() > 0) {
//                        return 1;
//                    }
//                    return -1;
//                }));
//            }
        //}

        catalogue.get(cakeKind).get(cakeType).add(cake);
    }

    public void print() {
        for ( Map.Entry<String, Map<String, ArrayList<Cake>>> category : catalogue.entrySet()
             ) {
            System.out.println(category.getKey());
            for ( Map.Entry<String, ArrayList<Cake>> type : category.getValue().entrySet()
                 ) {
                System.out.println("\t" + type.getKey());
                for ( Cake cake : type.getValue()
                     ) {
                    System.out.println("\t\t" + cake);
                }
            }
        }
    }

    public Cake getRandomCake() {
        Cake cake = null;
        String cakeType;
        int chance = Utility.getR().nextInt(100);
        if(chance < 25) {
            if(catalogue.containsKey("StandardCake")) {
                cakeType = Utility.getRandomStandard();
                if(catalogue.get("StandardCake").containsKey(cakeType)) {
                    if(catalogue.get("StandardCake").get(cakeType).size() != 0) {
                        cake = catalogue.get("StandardCake").get(cakeType).get(0);
                    }
                }
            }
        } else if(chance < 50) {
            if(catalogue.containsKey("WeddingCake")) {
                cakeType = Utility.getRandomWedding();
                if(catalogue.get("WeddingCake").containsKey(cakeType)) {
                    if(catalogue.get("WeddingCake").get(cakeType).size() != 0) {
                        cake = catalogue.get("WeddingCake").get(cakeType).get(0);
                    }
                }
            }
        } else if(chance < 75) {
            if(catalogue.containsKey("SpecialCake")) {
                cakeType = Utility.getRandomSpecial();
                if(catalogue.get("SpecialCake").containsKey(cakeType)) {
                    if(catalogue.get("SpecialCake").get(cakeType).size() != 0) {
                        cake = catalogue.get("SpecialCake").get(cakeType).get(0);
                    }
                }
            }
        } else {
            if(catalogue.containsKey("KidCake")) {
                cakeType = Utility.getRandomKids();
                if(catalogue.get("KidCake").containsKey(cakeType)) {
                    if(catalogue.get("KidCake").get(cakeType).size() != 0) {
                        cake = catalogue.get("KidCake").get(cakeType).get(0);
                    }
                }
            }
        }

        return cake;
    }

    public void removeCake(Cake cake) {
        if(catalogue.get(cake.getClass().getSimpleName()).containsKey(cake.getType())) {
            catalogue.get(cake.getClass().getSimpleName()).get(cake.getType()).remove(cake);
        }
    }
}
