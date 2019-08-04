public class Score extends UserScore {

    public Score() {
        super();
        this.stateName = "Score";
        printIn();
    }

    @Override
    public void printIn() {
        System.out.println("enter " + this.stateName + " state");
    }

    @Override
    public void printOut() {
        System.out.println("exit " + this.stateName + " state");
    }

    @Override
    public UserScore handleUpgrade() {
        points++;
        printOut();
        if (points >= BT && points < AT && !(level.getStateName().equals("Advanced"))) {
            level.printOut();
            level = new Advanced();
        } else if (points >= AT && !(level.getStateName().equals("Expert"))) {
            level.printOut();
            level = new Expert();
        }
        return new Score();
    }

    @Override
    public UserScore handleDowngrade() {
        printOut();
        if (points > 0) {
            points--;
        }
        if (points < AT && points >= BT && !(level.getStateName().equals("Advanced"))) {
            level.printOut();
            level = new Advanced();
        } else if (points < BT && !(level.getStateName().equals("Beginner"))) {
            level.printOut();
            level = new Beginner();
        }
        return new Score();
    }

}
