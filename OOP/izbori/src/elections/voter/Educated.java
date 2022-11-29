package elections.voter;

import elections.Utility;
import elections.candidate.Candidate;

public class Educated extends Voter{

    public Educated(String name, boolean isMale, String city, Candidate candidate) {
        super(name, isMale, city, candidate);
    }

    @Override
    public boolean willVote() {
        return Utility.getChance(70);
    }

    @Override
    public boolean isValid() {
        return Utility.getChance(90);
    }

    @Override
    public Candidate votedForCandidate() {
        boolean willVoteForCandidate = Utility.getChance(70);
        if(!willVoteForCandidate) {
            candidate = CIK.getRandomCandidate();
        }
        return candidate;
    }

}

