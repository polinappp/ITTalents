package archers;

import archers.archer.Archer;

import java.util.*;

public class Club {
    private String name;
    private String address;
    private String coach;
    private List<Archer> archers;
    private Map<String, Map<String, Integer>> diary;

    public Club(String name) {
        this.name = name;
        archers = new ArrayList<>();
        this.diary = new HashMap<>();
        this.diary.put("Rookies", new HashMap<>());
        this.diary.put("Advanced", new HashMap<>());
        this.diary.put("Veterans", new HashMap<>());
    }

    public void addArcher(Archer archer){
        archers.add(archer);
    }

    public void print() {
        for (int i = 0; i < archers.size(); i++) {
            System.out.println(archers.get(i));
        }
    }

    public void startTournament() {
        getParticipants();
        shootArrows();
        getResults();
        getStatistics();
        classifyMen();
    }

    private void classifyMen() {
        ArrayList<Archer> byExp = new ArrayList<>();
        byExp.addAll(archers);
        System.out.println();
        System.out.println("MEN BY EXPERIENCE");
        byExp.stream()
                .filter(c -> c.isMale())
                .sorted((a1, a2) -> a2.getExperience() - a1.getExperience())
                .forEach(c -> System.out.println(c.getName() + " - " + c.getExperience() + " years"));
    }

    private void getStatistics() {
        winnerPerCategory();
        averageScorePerCategory();
        mostMissed();

    }

    private void mostMissed() {
        ArrayList<Archer> byMissed = new ArrayList<>();
        byMissed.addAll(archers);
        Collections.sort(byMissed, (o1, o2) -> o2.getMisses()-o1.getMisses());
        System.out.println();
        System.out.println("Most missed shots : " + byMissed.get(0).getName());
    }

    private void averageScorePerCategory() {
        System.out.println(   );
        System.out.println("AVERAGE SCORES");
        for ( Map.Entry<String, Map<String, Integer>> category : diary.entrySet()
        ) {
            int score = 0;
            int participants=0;
            for ( Map.Entry<String, Integer> archer : category.getValue().entrySet()
                 ) {
                score+=archer.getValue();
                participants++;
            }

            System.out.println(category.getKey() + "'s average score : " + score/participants);
        }
    }

    private void winnerPerCategory() {
        System.out.println();
        System.out.println("WINNERS");

        for ( Map.Entry<String, Map<String, Integer>> category : diary.entrySet()
        ) {
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
            list.addAll(category.getValue().entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });


            System.out.println(category.getKey() + " Winner : " + list.get(0).getKey());

        }
    }

    private void getResults() {
        for (int i = 0; i < archers.size(); i++) {
            Archer archer = archers.get(i);
            if(archer.getClass().getSimpleName().equals("RookieArcher")) {
                diary.get("Rookies").put(archer.getName(), archer.getPoints());
            } else if(archer.getClass().getSimpleName().equals("AdvancedArcher")) {
                diary.get("Advanced").put(archer.getName(), archer.getPoints());
            } else {
                diary.get("Veterans").put(archer.getName(), archer.getPoints());
            }
        }

        printResults();
    }

    private void printResults() {
        for ( Map.Entry<String, Map<String, Integer>> category : diary.entrySet()
             ) {
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
            list.addAll(category.getValue().entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });

            System.out.println(category.getKey() + ":");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("\t" + list.get(i).getKey() + " - " + list.get(i).getValue());
            }
        }
    }

    private void shootArrows() {
        for (int i = 0; i < archers.size(); i++) {
            archers.get(i).shoot();
        }
    }
    private void getParticipants() {
        System.out.println("PARTICIPANTS");

        for (int i = 0; i < archers.size(); i++) {
            System.out.println("\t" + archers.get(i));
        }
        System.out.println();
    }


}
