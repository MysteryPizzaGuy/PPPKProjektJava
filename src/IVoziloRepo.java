import Model.Vozilo;

import java.sql.SQLException;
import java.util.List;

public interface IVoziloRepo {
    public List<Vozilo> FindAll();
    public Boolean Create(List<Vozilo> vozaci) throws SQLException;
    public Vozilo FindById(int ID);
}
