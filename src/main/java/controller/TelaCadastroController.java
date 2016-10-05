package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.facisa.projetoBD2.dao.ProjetoLIST;

import exception.AlunolNullException;
import exception.AlunolPeriodoInvalidoException;
import exception.ProfessorIndisponivelException;
import exception.ResponsavelNullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Aluno;
import model.Professor;
import model.Projeto;
import model.Tecnologia;

public class TelaCadastroController implements Initializable {
	
	
	private ProjetoLIST gerenciador = ProjetoLIST.getInstance();

	@FXML
	private TextField txt_tituloProjeto;

	@FXML
	private TextField txt_descricaoProjeto;

	@FXML
	private TextField txt_dataInicio;

	@FXML
	private TextField txt_nomeProfessor;

	@FXML
	private Button btn_addTecnologia;
	
    @FXML
    private Button btn_salvar;

	@FXML
	private TableView<Aluno> tbl_AlunosParticipantes;

	@FXML
	private TableView<Tecnologia> tbl_tecnologiaUsadas;

	@FXML
	private TextField txt_dataConclusao;

	@FXML
	private TextField txt_linkProjeto;

	@FXML
	private TextField txt_areaProjeto;

	@FXML
	private Button btn_addAluno;

	@FXML
	void adicionarAluno(ActionEvent event) throws Exception {
		
		Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaAdicionarAluno.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("");
		stage.show();

	}

	@FXML
	void adicionarTecnologia(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaAdicionarAluno.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("");
		stage.show();

	}
	

    @FXML
    void salvarProjeto(ActionEvent event) {
    	
    	Projeto projeto = new Projeto();
    	try {
			Professor.professorLogado.setProjeto(projeto);
		    projeto.setArea(txt_areaProjeto.getText());
		    projeto.setDataInicio(txt_dataInicio.getText());
		    projeto.setDataConclusao(txt_dataConclusao.getText());
		    projeto.setDescricao(txt_descricaoProjeto.getText());
		    projeto.setLink(txt_linkProjeto.getText());
		    projeto.setTitulo(txt_tituloProjeto.getText());
		    
		    for (Aluno aluno : gerenciador.alunos) {
		    	 try {
					projeto.setAluno(aluno);
				} catch (AlunolNullException | AlunolPeriodoInvalidoException e) {
					criaAlert(AlertType.ERROR, "Informação", e.getMessage() ).show();
				}
			}
		    
		   
			gerenciador.cadastrarProjeto(projeto);
			
			
			
			
		} catch (ResponsavelNullException | ProfessorIndisponivelException e) {
			criaAlert(AlertType.ERROR, "Informação", e.getMessage() ).show();	
		}
    	
    	
    	
    	
    	
    	
    	
    	

    	
    }
	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		txt_nomeProfessor.setText(Professor.professorLogado.getNome());

		if (Professor.professorLogado.getDisponibilidade() == false) {
			txt_tituloProjeto.setText(Professor.professorLogado.getProjeto().getTitulo());
			txt_descricaoProjeto.setText(Professor.professorLogado.getProjeto().getDescricao());
			txt_dataInicio.setText(Professor.professorLogado.getProjeto().getDataInicio());
			txt_nomeProfessor.setText(Professor.professorLogado.getNome());
			txt_dataConclusao.setText(Professor.professorLogado.getProjeto().getDataConclusao());
			txt_linkProjeto.setText(Professor.professorLogado.getProjeto().getLink());
			txt_areaProjeto.setText(Professor.professorLogado.getProjeto().getArea());
			
			
			TableColumn<Aluno, String> cln_aluno = new TableColumn<Aluno, String>("Alunos Participantes");
			cln_aluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
			
			TableColumn<Tecnologia, String> cln_tecnologia = new TableColumn<Tecnologia, String>("Tecnologia Utilizadas");
			cln_tecnologia.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("nome"));
		

			tbl_AlunosParticipantes.setItems(Professor.professorLogado.getProjeto().getEquipe());
			tbl_AlunosParticipantes.getColumns().add(cln_aluno);
			cln_aluno.setPrefWidth(562.0);
			
			tbl_tecnologiaUsadas.setItems(Professor.professorLogado.getProjeto().getTecnologia());
			tbl_tecnologiaUsadas.getColumns().add(cln_tecnologia);
			cln_tecnologia.setPrefWidth(562.0);
			

		}

	}

}
