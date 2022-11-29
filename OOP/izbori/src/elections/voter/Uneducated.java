package elections.voter;

import elections.Utility;
import elections.candidate.Candidate;

public class Uneducated extends Voter{
    public Uneducated(String name, boolean isMale, String city, Candidate candidate) {
        super(name, isMale, city, candidate);
    }

    @Override
    public boolean willVote() {
        return Utility.getChance(90);
    }

    @Override
    public boolean isValid() {
        return Utility.getChance(60);
    }

    @Override
    public Candidate votedForCandidate() {
        return candidate;
    }


}
