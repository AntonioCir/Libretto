/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package libretto;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Esame;
import model.Model;

public class LibrettoController 
{

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) 
    {
    	// recupero dati dall'interfaccia
    	String codice = txtCodice.getText();
    	
    	// controllo validità dati
    	if(codice.length()<4)
    	{
    		txtMessage.appendText("Codice non valido \n");
    		return;
    	}
    	
    	// chiedo al Model di effettuare l'operazione
    	Esame e = model.trovaEsame(codice);
    	
    	// aggiorno la View con il risultato dell'operazione
    	if (e==null)
    	{
    		txtMessage.appendText("Esame con codice:'"+ codice +"' non trovato \n");
    	}
    	else
    	{
    		txtMessage.appendText("Esame con codice:'"+ codice +"' trovato \n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) 
    {
    	// recupero dati dall'interfaccia
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// controllo validità dati
    	if(codice.length()<4 || titolo.length()==0 || docente.length()==0)
    	{
    		txtMessage.appendText("Dati esame insufficienti \n");
    		return;
    	}
    	
    	// chiedo al Model di effettuare l'operazione
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	// aggiorno la View con il risultato dell'operazione
    	if (result)
    	{
    		txtMessage.appendText("Esame aggiunto con successo \n");
    	}
    	else
    	{
    		txtMessage.appendText("Esame non aggiunto (codice duplicato) \n");
    	}
    	
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) 
	{
		this.model = model;
	}
}
