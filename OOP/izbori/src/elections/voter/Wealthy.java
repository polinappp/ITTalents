package elections.voter;

import elections.Utility;
import elections.candidate.Candidate;

public class Wealthy extends Voter{

    public Wealthy(String name, boolean isMale, String city, Candidate candidate) {
        super(name, isMale, city, candidate);
    }

    @Override
    public boolean willVote() {
        return Utility.getChance(50);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Candidate votedForCandidate() {
        boolean willVoteForCandidate = Utility.getChance(50);
        if(!willVoteForCandidate) {
            candidate = CIK.getRandomCandidate();
        }
        return candidate;
    }
}
