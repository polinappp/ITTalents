package elections.candidate;

import elections.Utility;
import elections.campaign.CorruptCampaign;
import elections.campaign.NormalCampaign;
import elections.candidate.education.PoliticianInterface;

import java.util.Random;

public class Politician extends Candidate {

    public Politician(String name, double money, PoliticianInterface education) {
        super(name, money, education);
    }

    @Override
    public void startCampaign() {
        makeCampaign();
        generateVoters();
    }

    private void makeCampaign() {
        boolean isCorrupt = new Random().nextBoolean();
        if(isCorrupt) {
            campaign = new CorruptCampaign(Utility.getRandomInt(20, 25), money, this);
        } else {
            campaign = new NormalCampaign(Utility.getRandomInt(20,25), money,this);
        }
    }

}
