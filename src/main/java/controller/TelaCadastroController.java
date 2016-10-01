package controller;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Aluno;
import model.Tecnologia;

public class TelaCadastroController implements Initializable {

    @FXML
    private TextField txt_tituloProjeto;

    @FXML
    private TextField txt_descricaoProjeto;

    @FXML
    private DatePicker dtp_dataInicio;

    @FXML
    private TextField txt_nomeProfessor;

    @FXML
    private Button btn_addTecnologia;

    @FXML
    private TableView<Aluno> tbl_AlunosParticipantes;

    @FXML
    private TableView<Tecnologia> tbl_tecnologiaUsadas;

    @FXML
    private DatePicker dtp_dataConclusao;

    @FXML
    private TextField txt_linkProjeto;

    @FXML
    private ComboBox<String> cbx_areaProjeto;

    @FXML
    private Button btn_addAluno;

    @FXML
    void adicionarAluno(ActionEvent event) {

    }

    @FXML
    void adicionarTecnologia(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

