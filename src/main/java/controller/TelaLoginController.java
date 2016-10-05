package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.facisa.projetoBD2.dao.ProjetoLIST;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Professor;

public class TelaLoginController implements Initializable {

	private ProjetoLIST gerenciador = ProjetoLIST.getInstance();
	

	@FXML
	private TextField loginUsuario;

	@FXML
	private PasswordField senhaUsuario;

	@FXML
	private Button botaoChamarTelaUsuario;

	@FXML
	private Button botaoChamaTelaCriarUsuario;

	@FXML
	private Button botaoLimparText;

	@FXML
	public void ChamaTelaCriarUsuario(ActionEvent event) throws Exception {

	}

	@FXML
	public void ChamarTelaUsuario(ActionEvent event) throws Exception {
		autenticacao(event);
		

	}

	@SuppressWarnings("unused")
	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	@FXML
	public void LimparText(ActionEvent event) throws Exception {
		loginUsuario.clear();
		senhaUsuario.clear();
	}
	
	public void autenticacao(Event event)  throws Exception {

		for (Professor newProfessor : gerenciador.getProfessores()) {
			if (newProfessor.getNome().equals(loginUsuario.getText())
					&& newProfessor.getCodigo().equals(senhaUsuario.getText())) {
				Professor.professorLogado = newProfessor;
				Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaMenu.fxml"));
				Main.SCENE.setRoot(parent);
				

			}
			

		}
		

	}
	

	@FXML
	public void senhaDigitada(KeyEvent event) throws Exception {
		if (event.getCode() == KeyCode.ENTER) {
			autenticacao(event);
			
		
		}

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}



}
