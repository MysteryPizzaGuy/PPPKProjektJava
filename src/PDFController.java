import Hibernate.TblPutniNalogEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

public class PDFController  {


    private static SessionFactory factory;


    @FXML
    private ListView lvPutniNalog;

    @FXML
    private ComboBox cbPutniList;

    @FXML
    private void onClickGeneratePDF(ActionEvent action) {
        try (PDDocument doc = new PDDocument()) {


            PDPage mypage = new PDPage();
            doc.addPage(mypage);
            try (PDPageContentStream cont = new PDPageContentStream(doc, mypage)) {
                cont.beginText();
                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                try (Session session = factory.openSession()) {
                    if (cbPutniList.getValue() != null) {
                        int id = (int) cbPutniList.getValue();
                        Query query = session.createQuery("FROM TblPutniNalogEntity where idPutniNalog= :idpn");
                        query.setParameter("idpn", id);

                        List<TblPutniNalogEntity> putniNalogEntities = query.getResultList();

                        TblPutniNalogEntity putniNalog = putniNalogEntities.get(0);
                        cont.setFont(PDType1Font.TIMES_ROMAN, 12);

                        cont.setLeading(14.5f);
                        cont.newLineAtOffset(25, 700);

                        String line = putniNalog.getVozac().getIme() + " " + putniNalog.getVozac().getPrezime();
                        cont.showText(line);
                        cont.newLine();
                        String line2 = putniNalog.getVozilo().getMarka() + " " + putniNalog.getVozilo().getMarka();
                        cont.showText(line2);
                        cont.newLine();
                        String line3 = "Start Grad: " + putniNalog.getStartGrad() + " Stop Grad: " + putniNalog.getStopGrad();
                        String line4 = "Start Date: " + putniNalog.getStartDate() + " Stop Date:: " + putniNalog.getStopDate();
                        cont.showText(line3);
                        cont.newLine();
                        cont.showText(line4);
                        cont.newLine();
                        cont.endText();


                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            doc.save("PutniNalog.pdf");

            } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public PDFController() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public void initialize(){

        SetUpListView();
        try(Session session=factory.openSession()){
            List<TblPutniNalogEntity> putniNalogEntities= session.createQuery("FROM TblPutniNalogEntity ").list();
            for (TblPutniNalogEntity pn:putniNalogEntities
                 ) {
                cbPutniList.getItems().add(pn.getIdPutniNalog());
            }

        }
    }


    public void SetUpListView(){

        try(Session session = factory.openSession()){

            List<TblPutniNalogEntity> putniNalogEntities= session.createQuery("FROM TblPutniNalogEntity ").list();

//            ObservableList<TblPutniNalogEntity> observableList = FXCollections.observableArrayList(employeess);
//
//            lvPutniNalog.setItems(observableList);

            for (TblPutniNalogEntity pn:putniNalogEntities
                 ) {
                String item = pn.getIdPutniNalog()+" "+pn.getVozac().getIme()+" "+pn.getVozac().getPrezime()+" "+pn.getStartGrad()+" "+pn.getStopGrad()+" "+pn.getStartDate()+" "+pn.getStopDate();
                lvPutniNalog.getItems().add(item);
                lvPutniNalog.refresh();
            }

        }
    }
}
