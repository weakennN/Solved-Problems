package InterfacesAndAbstraction.MilitaryElite;

import java.util.List;

public interface IEngineer {

    void addRepair(Repair repair);

    List<Repair> getRepairs();
}
