package elections;

import elections.campaign.Campaign;
import elections.candidate.Candidate;
import elections.candidate.Gangster;
import elections.candidate.Politician;
import elections.candidate.Showman;
import elections.candidate.education.HighSchoolEducation;
import elections.candidate.education.NoEducation;
import elections.candidate.education.PrimaryEducation;
import elections.candidate.education.UniversityEducation;
import elections.voter.Voter;

public class Demo {
    public static void main(String[] args) {

        Commission cik = new Commission();

        for (int i = 0; i < 10; i++) {
            Candidate candidate;
            int chance = Utility.getRandom().nextInt(100);

            if(chance < 33) {
                candidate = new Gangster(Utility.getRandomName()+i, Utility.getRandomInt(50000, 300000), Utility.getRandom().nextBoolean() ? new PrimaryEducation() : new NoEducation());
            } else if(chance < 66) {
                candidate = new Politician(Utility.getRandomName()+i, Utility.getRandomInt(50000, 300000), Utility.getRandom().nextBoolean() ? new HighSchoolEducation() : new UniversityEducation());
            } else {
                int bound = Utility.getRandom().nextInt(100);
                if(bound < 33) {
                    candidate = new Showman(Utility.getRandomName()+i, Utility.getRandomInt(50000, 300000), new PrimaryEducation());

                } else if(bound < 66) {
                    candidate = new Showman(Utility.getRandomName()+i, Utility.getRandomInt(50000, 300000), new UniversityEducation());

                } else {
                    candidate = new Showman(Utility.getRandomName()+i, Utility.getRandomInt(50000, 300000), new NoEducation());
                }
            }

            cik.addCandidate(candidate);
        }

        Campaign.CIK = cik;
        Voter.CIK = cik;

        for (int i = 0; i < cik.getCandidates().size(); i++) {
            cik.getCandidates().get(i).startCampaign();
        }

        cik.startElections();
        cik.getStatistics();
    }
}
