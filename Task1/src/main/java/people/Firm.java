package people;

public class Firm {

    private CeoDirector ceoDirector
                = new CeoDirector("default",100);
    private final String name;

    public Firm(String firmName){
        name = firmName;
    }

    public CeoDirector getCeoDirector(){
        return ceoDirector;
    }

    public void setCeoDirector (CeoDirector newCeoDirector){
        ceoDirector = newCeoDirector;
    }
}
