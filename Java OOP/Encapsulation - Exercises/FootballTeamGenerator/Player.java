package Encapsulation.FootballTeamGenerator;

public class Player {

    private String name;
    private Integer endurance;
    private Integer sprint;
    private Integer dribble;
    private Integer passing;
    private Integer shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {

        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.isEmpty()) {

            System.out.println("A name should not be empty.");
            return;
        }

        this.name = name;
    }

    private void setEndurance(int endurance) {

        if (endurance < 0 || endurance > 100) {

            System.out.println("Endurance should be between 0 and 100.");
            return;
        }

        this.endurance = endurance;

    }

    private void setSprint(int sprint) {

        if (sprint < 0 || sprint > 100) {

            System.out.println("Sprint should be between 0 and 100.");
            return;
        }

        this.sprint = sprint;

    }

    private void setDribble(int dribble) {

        if (dribble < 0 || dribble > 100) {

            System.out.println("Dribble should be between 0 and 100.");
            return;
        }

        this.dribble = dribble;
    }

    private void setPassing(int passing) {

        if (passing < 0 || passing > 100) {

            System.out.println("Passing should be between 0 and 100.");
            return;
        }

        this.passing = passing;
    }

    private void setShooting(int shooting) {

        if (shooting < 0 || shooting > 100) {

            System.out.println("Shooting should be between 0 and 100.");
            return;
        }

        this.shooting = shooting;
    }

    public String getName() {

        return this.name;
    }

    public double overallSkillLevel() {

        return (this.endurance + this.shooting + this.passing + this.dribble + this.sprint) / 5.0;
    }

    public boolean isPlayerValid() {

        if (this.sprint == null || this.shooting == null || this.dribble == null
                || this.name == null || this.passing == null || this.endurance == null) {
            return false;
        }

        return true;
    }


}
