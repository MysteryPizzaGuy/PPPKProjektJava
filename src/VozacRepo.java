import Database.DataWorker;
import Model.Vozac;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VozacRepo extends DataWorker implements IVozacRepo {
    @Override
    public List<Vozac> FindAll() {
        String query = "{call SelectAllDrivers}";


        try(Connection conn = get_database().CreateConnection()){
            CallableStatement statement = conn.prepareCall(query);
            ResultSet res= statement.executeQuery();
            List<Vozac> li = new ArrayList<>();
            while(res.next()){
                Vozac temp = new Vozac();
                temp.setIDVozac(res.getInt(1));
                temp.setIme(res.getString(2));
                temp.setPrezime(res.getString(3));
                temp.setBrojMobitela(res.getString(4));
                temp.setSerijskiBrojVozacke(res.getString(5));
                li.add(temp);
            }
            return li;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public Boolean Create(List<Vozac> vozaci) throws SQLException {
        PreparedStatement statement = null;
        String InsertString = "INSERT into tblVozac (IME,Prezime,BrojMobitela,SerijskiBrojVozacke) VALUES(?,?,?,?)";

        try(Connection connection = get_database().CreateConnection()) {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(InsertString, Statement.RETURN_GENERATED_KEYS);
            for (Vozac vozac : vozaci){
                statement.setString(1,vozac.getIme());
                statement.setString(2,vozac.getPrezime());
                statement.setString(3,vozac.getBrojMobitela());
                statement.setString(4,vozac.getSerijskiBrojVozacke());
                statement.addBatch();
            }

            int [] batchexecints = statement.executeBatch();
            if (Arrays.stream(batchexecints).anyMatch(p-> p<=0))
            {
                connection.rollback();
                throw new SQLException("Not all Vozaci passed, rollback Executed");

            }else{
                connection.commit();

            }
            String FindMaxID = "SELECT MAX(IDVozac) as maxid FROM tblVozac";
            statement = connection.prepareStatement(FindMaxID);
            ResultSet rs =statement.executeQuery();
            connection.commit();
            int maxId = 0;
            while(rs.next())
            {
                maxId = rs.getInt(1);
            }
            int StartCounting = maxId-vozaci.size()+1;


            Boolean result=true;
            int counter = 0;
            for (int i =StartCounting;i<=maxId;i++){

                Vozac temp = FindById(i);
                Vozac temp2 = vozaci.get(counter);
                if (!temp.getIme().equals(temp2.getIme())){
                    result=false;
                }else if (!temp.getPrezime().equals(temp2.getPrezime())){
                    result=false;
                }else if (!temp.getSerijskiBrojVozacke().equals(temp2.getSerijskiBrojVozacke())){
                    result=false;
                }else if (!temp.getBrojMobitela().equals(temp2.getBrojMobitela())){
                    result=false;
                }
                counter++;

            }



            return result;
        }
    }

    @Override
    public Vozac FindById(int ID) {
        String query = "Select * from tblVozac where IDVozac= ?";


        Vozac temp = new Vozac();
        try(Connection conn = get_database().CreateConnection()){
            PreparedStatement statement = conn.prepareCall(query);
            statement.setInt(1,ID);
            ResultSet res= statement.executeQuery();
            res.next();
            temp.setIDVozac(res.getInt(1));
            temp.setIme(res.getString(2));
            temp.setPrezime(res.getString(3));
            temp.setBrojMobitela(res.getString(4));
            temp.setSerijskiBrojVozacke(res.getString(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

}
