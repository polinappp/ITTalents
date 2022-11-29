package elections.candidate;

import elections.Utility;
import elections.campaign.CorruptCampaign;
import elections.candidate.education.GangsterInterface;

public class Gangster extends Candidate {
    public Gangster(String name, double money, GangsterInterface education) {
        super(name, money, education);
    }

    @Override
    public void startCampaign() {
        campaign = new CorruptCampaign(Utility.getRandomInt(20,25), money, this);
        money = 0;

        generateVoters();
    }

}
