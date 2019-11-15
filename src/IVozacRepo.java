import Model.Vozac;

import java.sql.SQLException;
import java.util.List;

public interface IVozacRepo {
    public List<Vozac> FindAll();
    public Boolean Create(List<Vozac> vozaci) throws SQLException;
    public Vozac FindById(int ID);
}
