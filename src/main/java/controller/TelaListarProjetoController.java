package controller;

import java.net.URL;
import java.util.ResourceBundle;

import data.ProjetoLIST;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Projeto;

public class TelaListarProjetoController implements Initializable {

	private ProjetoLIST gerenciador = ProjetoLIST.getInstance();
	
	

	  @FXML
	    private Hyperlink hl_pesquisaProjeto;

	  @FXML
	    private ComboBox<String> cbxTipoPesquisa;

	    @FXML
	    private TableView<Projeto> tb_Projetos;

	    @FXML
	    private TextField txt_pesquisaProjeto;


 
	public ObservableList<Projeto> obsProjetos = FXCollections.observableArrayList();
	

	public TelaListarProjetoController() {
		obsProjetos.addAll(gerenciador.listarProjeto());
		
	}

	@FXML
	private void cadastrarProduto(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaCadastroDeProduto.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("");
		stage.show();

	}

	  @FXML
	   private void pesquisaProjeto(ActionEvent event) {
		  
		
		  
		  obsProjetos.clear();
		  
		  switch (cbxTipoPesquisa.getValue()){
		  
		  case "Título":
			  
			  obsProjetos.addAll(gerenciador.pesquisarProjetoTitulo(txt_pesquisaProjeto.getText()));
			  
			 break;
		  case "Tecnologia":
			  
			  obsProjetos.addAll(gerenciador.pesquisarProjetoTecnologia(txt_pesquisaProjeto.getText()));
			  
			  break;
		  case "Responsável":
			  
			  obsProjetos.add(gerenciador.pesquisarProjetoResponsavel(txt_pesquisaProjeto.getText()));
			
			  
			  break; 
		  
		  case "Data Início":
			  
			  obsProjetos.addAll(gerenciador.pesquisarProjetoDataInicio(txt_pesquisaProjeto.getText()));
			  
			  break;
			  
		  case "Data Conclusão":
			  
			  obsProjetos.addAll(gerenciador.pesquisarProjetoDataConclusao(txt_pesquisaProjeto.getText()));
			  
			  break;
			  
		   default:
               break;          
       }
		  
			
	}

	@SuppressWarnings("unchecked")
	private void colunas() {

		TableColumn<Projeto, String> cln_projeto = new TableColumn<Projeto, String>("Título Projeto");
		cln_projeto.setCellValueFactory(new PropertyValueFactory<Projeto, String>("titulo"));
		
		TableColumn<Projeto, String> cln_nomeResponsavel = new TableColumn<Projeto, String>("Responsável");
		cln_nomeResponsavel.setCellValueFactory(new PropertyValueFactory<Projeto, String>("responsavel"));
	

		tb_Projetos.setItems(obsProjetos);
		tb_Projetos.getColumns().addAll(cln_projeto, cln_nomeResponsavel );
		
	
		

	}

	@FXML
	public void mouseClicado(MouseEvent e) throws Exception{
		
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunas();
		cbxTipoPesquisa.getItems().addAll("Título","Responsável","Tecnologia","Data Início", "Data Conclusão");

	}

}
