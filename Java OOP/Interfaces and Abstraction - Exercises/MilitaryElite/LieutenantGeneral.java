package InterfacesAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneral extends Private {

    private List<Private> privates;

    public LieutenantGeneral(String fistName, String lastName, int id, double salary) {
        super(fistName, lastName, id, salary);

        this.privates = new ArrayList<>();
    }


    public void addPrivate(Private priv) {

        this.privates.add(priv);
    }
}
