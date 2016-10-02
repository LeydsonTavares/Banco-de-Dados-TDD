package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Professor;

public class TelaMenuController implements Initializable {

	@FXML
	private Button btn_meusProjetos;

	@FXML
	private Button btn_otherProject;

	@FXML
	private Button btnAddTecnologias;

	@FXML
	private Button btnAddEstudantes;

	@FXML
	private ImageView imgCadastrarProjeto;

	@FXML
	private ImageView imgTecnologias;

	@FXML
	private ImageView imgOther;

	@FXML
	private ImageView imgAddEstudantes;

	@FXML
	private ImageView imgMyProject;

	@FXML
	public HBox conteudo;

	@FXML
	private void cadastrar(ActionEvent event) throws Exception {

		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaCadastro.fxml"));
		conteudo.getChildren().clear();
		conteudo.getChildren().add(prime);

	}

	@FXML
	void meusProjetos(ActionEvent event) throws Exception {

		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaCadastro.fxml"));
		conteudo.getChildren().clear();
		conteudo.getChildren().add(prime);
	}

	@FXML
	void adicionarTecnologias(ActionEvent event) throws Exception {

		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaListarProjetos.fxml"));
		conteudo.getChildren().clear();
		conteudo.getChildren().add(prime);

	}

	@FXML
	void outrosProjetos(ActionEvent event) throws Exception {

		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaListarProjetos.fxml"));
		conteudo.getChildren().clear();
		conteudo.getChildren().add(prime);

	}

	@FXML
	void adicionarEstudantes(ActionEvent event) throws Exception {

		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaListarProjetos.fxml"));
		conteudo.getChildren().clear();
		conteudo.getChildren().add(prime);

	}

	public void initialize(URL location, ResourceBundle resources) {

		if (Professor.professorLogado.getDisponibilidade()) {
			
			btn_meusProjetos.setDisable(true);
			imgMyProject.setOpacity(0.5);

		}

	}

}
