package elections.voter;

import elections.Bulletin;
import elections.Commission;
import elections.candidate.Candidate;

public abstract class Voter {
    public static Commission CIK;
    private String name;
    private boolean isMale;
    private String city;
    protected Candidate candidate;
    private boolean isCorrupt;
    private boolean willVote;

    public Voter(String name, boolean isMale, String city, Candidate candidate) {
        this.name = name;
        this.isMale = isMale;
        this.city = city;
        this.candidate = candidate;
    }

    public String getCity() {
        return city;
    }

    public abstract boolean willVote();
    public abstract boolean isValid();
    public abstract Candidate votedForCandidate();

    public Bulletin vote() {
        return new Bulletin(votedForCandidate(),isValid(),getCity());
    }
}
