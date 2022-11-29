package elections.candidate;

import elections.Utility;
import elections.campaign.NormalCampaign;
import elections.candidate.education.ShowmanInterface;

public class Showman extends Candidate {

    public Showman(String name, double money, ShowmanInterface education) {
        super(name, money, education);
    }

    @Override
    public void startCampaign() {
        campaign = new NormalCampaign(Utility.getRandomInt(20,25), money, this);
        money = 0;

        generateVoters();
    }

}
