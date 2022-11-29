package elections.campaign;

import elections.candidate.Candidate;

public class CorruptCampaign extends Campaign{
    public CorruptCampaign(int days, double money, Candidate candidate) {
        super(days, money, candidate);
    }

    @Override
    public int getVotersPerDay() {
        return 120;
    }
}
