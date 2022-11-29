package elections.campaign;

import elections.Commission;
import elections.Utility;
import elections.candidate.Candidate;
import elections.voter.Educated;
import elections.voter.Uneducated;
import elections.voter.Voter;
import elections.voter.Wealthy;

public abstract class Campaign {
    private int days;
    private double budget;
    private Candidate candidate;
    public static Commission CIK;

    public Campaign(int days, double budget, Candidate candidate) {
        this.days = days;
        this.budget = budget;
        this.candidate=candidate;
    }

    public int getDays() {
        return days;
    }


    public abstract int getVotersPerDay();

    public void makeVoters() {
        for (int j = 0; j < getVotersPerDay(); j++) {
            Voter voter;

            int chance = Utility.getRandom().nextInt(100);
            if(chance < 33) {
                voter = new Uneducated("Voter"+j, Utility.getRandom().nextBoolean(), Utility.getRandomCity(), candidate);
            } else if(chance < 66) {
                voter = new Educated("Voter"+j, Utility.getRandom().nextBoolean(), Utility.getRandomCity(), candidate);
            } else {
                voter = new Wealthy("Voter"+j, Utility.getRandom().nextBoolean(), Utility.getRandomCity(), candidate);
            }

            CIK.registerVoter(voter);
        }
    }


}
