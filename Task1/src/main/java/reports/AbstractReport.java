package reports;

public abstract class AbstractReport implements Report {

    private String description = "no description";

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void showDescription() {
        System.out.println(description);
    }

}
