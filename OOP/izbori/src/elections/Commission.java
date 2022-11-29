package elections;

import elections.candidate.Candidate;
import elections.voter.Voter;

import java.util.*;

public class Commission {
    private Map<String, List<Voter>> voters = new HashMap<>();
    private Map<String, ArrayList<Bulletin>> bulletins = new HashMap<>();
    private ArrayList<Candidate> candidates = new ArrayList<>();
    private Map<String, Map<String, Integer>> votes = new TreeMap<>();
    public void registerVoter(Voter voter) {
        if(!voters.containsKey(voter.getCity())){
            voters.put(voter.getCity(), new ArrayList<>());
        }
        voters.get(voter.getCity()).add(voter);
    }

    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void startElections() {
        for ( Map.Entry<String, List<Voter>> cities : voters.entrySet()
             ) {
            for (int i = 0; i < cities.getValue().size(); i++) {
                Voter voter = cities.getValue().get(i);
                if(voter.willVote()) {
                    if(!bulletins.containsKey(voter.getCity())) {
                        bulletins.put(voter.getCity(), new ArrayList<>());
                    }
                    bulletins.get(voter.getCity()).add(voter.vote());
                }
            }
        }
    }

    
    public Candidate getRandomCandidate() {
        return candidates.get(Utility.getRandom().nextInt(candidates.size()));
    }

    public void getStatistics() {
        ranking();
        winner();
        runnerUp();
        allBulletins();
        votersBulletins();
        invalidBulletins();
    }

    private void invalidBulletins() {
        int allBulletins = 0;

        for ( Map.Entry<String, ArrayList<Bulletin>> city : bulletins.entrySet()
        ) {
            allBulletins += city.getValue().size();
        }

        int allVoters = 0;
        for(Map.Entry<String, List<Voter>> city : voters.entrySet()) {
            allVoters += city.getValue().size();
        }

        System.out.println("Voted : Invalid votes = " + allBulletins + " : " + (allVoters-allBulletins));
    }

    private void votersBulletins() {
        int allBulletins = 0;

        for ( Map.Entry<String, ArrayList<Bulletin>> city : bulletins.entrySet()
        ) {
            allBulletins += city.getValue().size();
        }

        int allVoters = 0;
        for(Map.Entry<String, List<Voter>> city : voters.entrySet()) {
            allVoters += city.getValue().size();
        }

        System.out.println("Voters : Voted = " + allVoters + " : " + allBulletins);
    }

    private void allBulletins() {
        int allBulletins = 0;

        for ( Map.Entry<String, ArrayList<Bulletin>> city : bulletins.entrySet()
        ) {
            allBulletins += city.getValue().size();
        }

        System.out.println("All bulletins: " + allBulletins);
    }

    private void runnerUp() {
        int maxVotes = 0;
        int runnerUp = 0;
        String candidate = "";

        for(Map.Entry<String, Map<String, Integer>> c : this.votes.entrySet()) {
            int currVotes = 0;
            for (Map.Entry<String, Integer> city : c.getValue().entrySet()
            ) {
                currVotes += city.getValue();
            }

            if(maxVotes == 0 || currVotes > maxVotes) {
                maxVotes = currVotes;
            } else if(currVotes > runnerUp) {
                candidate = c.getKey();
                runnerUp = currVotes;
            }
        }

        System.out.println("Runner-up - " + candidate);
    }

    private void winner() {
        int maxVotes = 0;
        String candidate = "";

        for(Map.Entry<String, Map<String, Integer>> c : this.votes.entrySet()) {
            int currVotes = 0;
            for (Map.Entry<String, Integer> city : c.getValue().entrySet()
            ) {
                currVotes += city.getValue();
            }

            if(currVotes > maxVotes) {
                candidate = c.getKey();
                maxVotes = currVotes;
            }
        }

        System.out.println("\nWinner - " + candidate);
    }

    private void ranking() {
        countVotes();

        System.out.println("Ranking:\n");
        for (Map.Entry<String, Map<String, Integer>> candidate : votes.entrySet()
             ) {
            System.out.println(candidate.getKey());
            for (Map.Entry<String, Integer> city : candidate.getValue().entrySet()
                 ) {
                System.out.println("    " + city.getKey() + " - " + city.getValue());
            }
        }
    }


    private void countVotes() {
        for ( Map.Entry<String, ArrayList<Bulletin>> city : bulletins.entrySet()
             ) {
            for (int i = 0; i < city.getValue().size(); i++) {
                Bulletin b = city.getValue().get(i);
                String candidate = b.getCandidate().getName();
                if(b.isValid()) {
                    if(!votes.containsKey(candidate)) {
                        votes.put(candidate, new HashMap<>());
                    }

                    if(!votes.get(candidate).containsKey(city.getKey())) {
                        votes.get(candidate).put(city.getKey(), 1);
                    }
                    Integer count = votes.get(candidate).get(city.getKey());
                    votes.get(candidate).put(city.getKey(), count+1);
                }
            }
        }
    }


}
