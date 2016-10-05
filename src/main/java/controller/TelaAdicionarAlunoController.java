package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.facisa.projetoBD2.dao.ProjetoLIST;

import exception.AlunolNullException;
import exception.AlunolPeriodoInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Aluno;
import model.Professor;

public class TelaAdicionarAlunoController implements Initializable {

	Aluno selecionado = null;

	private ProjetoLIST gerenciador = ProjetoLIST.getInstance();

	@FXML
	private Button btn_adicionarAlunoEquipe;

	@FXML
	private TableView<Aluno> tabelaAlunos;

	@FXML
	void mouseClicado(MouseEvent event) {
		if (event.getClickCount() == 1) {
			selecionado = (Aluno) tabelaAlunos.getSelectionModel().getSelectedItem();

		}

	}

	@FXML
	void adicionarAlunoEquipe(ActionEvent event) {
		if (selecionado != null) {

			if (Professor.professorLogado.getProjeto().getEquipe() != null) {

				if (Professor.professorLogado.getProjeto().getEquipe().contains(selecionado) == true) {

					selecionado = null;
					criaAlert(AlertType.INFORMATION, "Informação", "Aluno já se encontra cadastro nesse Projeto")
							.show();
				} else {
					try {
						Professor.professorLogado.getProjeto().setAluno(selecionado);
					} catch (AlunolNullException | AlunolPeriodoInvalidoException e) {
						criaAlert(AlertType.INFORMATION, "Informação", e.getMessage()).show();
					}
					selecionado = null;
				}

			}else {
				try {
					Professor.professorLogado.getProjeto().setAluno(selecionado);
				} catch (AlunolNullException | AlunolPeriodoInvalidoException e) {
					criaAlert(AlertType.INFORMATION, "Informação", e.getMessage()).show();
				}
				selecionado = null;

			}

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
		TableColumn<Aluno, String> cln_aluno = new TableColumn<Aluno, String>("Alunos Participantes");
		cln_aluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));

		tabelaAlunos.setItems(gerenciador.alunos);
		tabelaAlunos.getColumns().add(cln_aluno);
		cln_aluno.setPrefWidth(599.0);

	}

}
