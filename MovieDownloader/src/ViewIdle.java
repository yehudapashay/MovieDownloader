public class ViewIdle extends View {

    public ViewIdle() {
        super();
        this.stateName = "ViewIdle";
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
    public View internetOn() {
        return this;
    }

    @Override
    public View internetOff() {
        return this;
    }

    @Override
    public View movieOn() {
        return this;
    }

    @Override
    public View movieOff() {
        return this;
    }

    @Override
    public View holdMovie() {
        return this;
    }

    @Override
    public View resume() {
        return this;
    }

    @Override
    public View downloadError() {
        return this;
    }

    @Override
    public View errorFixed() {
        return this;
    }

    @Override
    public View restartMovie() {
        return this;
    }

}
