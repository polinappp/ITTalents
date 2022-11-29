package elections;

import elections.candidate.Candidate;

public class Bulletin {
    private Candidate candidate;
    private boolean isValid;
    private String city;

    public Bulletin(Candidate candidate, boolean isValid, String city) {
        this.candidate = candidate;
        this.isValid = isValid;
        this.city = city;
    }

    public boolean isValid() {
        return isValid;
    }

    public Candidate getCandidate() {
        return candidate;
    }
}
