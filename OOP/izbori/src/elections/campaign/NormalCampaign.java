package elections.campaign;

import elections.candidate.Candidate;

public class NormalCampaign extends Campaign{
    public NormalCampaign(int days, double money, Candidate candidate) {
        super(days, money, candidate);
    }

    @Override
    public int getVotersPerDay() {
        return 100;
    }
}
