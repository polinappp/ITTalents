package elections.candidate;

import elections.campaign.Campaign;
import elections.candidate.education.iEducation;

public abstract class Candidate {
    private String name;
    protected double money;
    protected Campaign campaign;
    private iEducation education;

    public Candidate(String name, double money, iEducation education) {
        this.name = name;
        this.money = money;
        this.education=education;
    }

    public void generateVoters() {
        for (int i = 0; i < campaign.getDays(); i++) {
               campaign.makeVoters();
        }
    }
    public abstract void startCampaign();

    public String getName() {
        return name;
    }
}
