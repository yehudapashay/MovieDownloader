public class File {

    private double size;
    private String name;

    public File(String name, double size){
        this.name =name;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public double getSize(){
        return this.size;
    }
}
