import Database.DataWorker;
import Model.Vozilo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoziloRepo extends DataWorker implements IVoziloRepo {
    @Override
    public List<Vozilo> FindAll() {
        String query = "{call SelectAllDrivers}";


        try(Connection conn = get_database().CreateConnection()){
            CallableStatement statement = conn.prepareCall(query);
            ResultSet res= statement.executeQuery();
            List<Vozilo> li = new ArrayList<>();
            while(res.next()){
                Vozilo temp = new Vozilo();
                temp.setIDVozilo(res.getInt(1));
                temp.setTip(res.getString(2));
                temp.setMarka(res.getString(3));
                temp.setGodinaProizvodnje(res.getDate(4));
                temp.setInicijalKM(res.getInt(5));
                li.add(temp);
            }
            return li;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public Boolean Create(List<Vozilo> Voziloi) throws SQLException {
        PreparedStatement statement = null;
        String InsertString = "INSERT into tblVozilo (Tip,Marka,GodinaProizvodnje,InicijalniKM) VALUES(?,?,?,?)";

        try(Connection connection = get_database().CreateConnection()) {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(InsertString, Statement.RETURN_GENERATED_KEYS);
            for (Vozilo Vozilo : Voziloi){
                statement.setString(1,Vozilo.getTip());
                statement.setString(2,Vozilo.getMarka());
                statement.setDate(3,new java.sql.Date(Vozilo.getGodinaProizvodnje().getTime()));
                statement.setInt(4,Vozilo.getInicijalKM());
                statement.addBatch();
            }

            int [] batchexecints = statement.executeBatch();
            if (Arrays.stream(batchexecints).anyMatch(p-> p<=0))
            {
                connection.rollback();
                throw new SQLException("Not all Voziloi passed, rollback Executed");

            }else{
                connection.commit();

            }
            String FindMaxID = "SELECT MAX(IDVozilo) as maxid FROM tblVozilo";
            statement = connection.prepareStatement(FindMaxID);
            ResultSet rs =statement.executeQuery();
            connection.commit();
            int maxId = 0;
            while(rs.next())
            {
                maxId = rs.getInt(1);
            }
            int StartCounting = maxId-Voziloi.size()+1;


            Boolean result=true;
            int counter = 0;
            for (int i =StartCounting;i<=maxId;i++){

                Vozilo temp = FindById(i);
                Vozilo temp2 = Voziloi.get(counter);
                if (!temp.getGodinaProizvodnje().equals(temp2.getGodinaProizvodnje())){
                    result=false;
                }else if (!temp.getTip().equals(temp2.getTip())){
                    result=false;
                }else if (!temp.getMarka().equals(temp2.getMarka())){
                    result=false;
                }else if (!(temp.getInicijalKM() == (temp2.getInicijalKM()))){
                    result=false;
                }
                counter++;

            }



            return result;
        }
    }

    @Override
    public Vozilo FindById(int ID) {
        String query = "Select * from tblVozilo where IDVozilo= ?";


        Vozilo temp = new Vozilo();
        try(Connection conn = get_database().CreateConnection()){
            PreparedStatement statement = conn.prepareCall(query);
            statement.setInt(1,ID);
            ResultSet res= statement.executeQuery();
            res.next();
            temp.setIDVozilo(res.getInt(1));
            temp.setTip(res.getString(2));
            temp.setMarka(res.getString(3));
            temp.setGodinaProizvodnje(res.getDate(4));
            temp.setInicijalKM(res.getInt(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
