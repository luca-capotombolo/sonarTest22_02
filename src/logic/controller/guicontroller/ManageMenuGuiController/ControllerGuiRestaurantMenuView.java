/**
 * Sample Skeleton for 'RestaurantMenuView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;
import logic.controller.guicontroller.OwnerBaseGuiController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import logic.engineeringclasses.dao.RecipeDAO;
import logic.engineeringclasses.dao.RestaurantDAO;

public class ControllerGuiRestaurantMenuView  extends OwnerBaseGuiController{

	private String username;
	
	public ControllerGuiRestaurantMenuView(String username) {
		this.username = username;
	}
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="deleteDishButton"
    private Button deleteDishButton; // Value injected by FXMLLoader

    @FXML // fx:id="addADishButton"
    private Button addADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="modifyADishButton"
    private Button modifyADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="getAdviceButton"
    private Button getAdviceButton; // Value injected by FXMLLoader

    /**
     * Ottiene i piatti disponibili e i ristoranti di sua proprietÃƒÂ  
     * per poi passarli al costruttore del controller grafico di AddDishView
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    void addADish(ActionEvent event) throws IOException, ClassNotFoundException {    	
    	
    	//ottengo le ricette che possono essere aggiunte
    	RecipeDAO recipeDAO = new RecipeDAO();
    	final ObservableList<String> obs1 = recipeDAO.selectAllRecipe(); 

    	//ottengo i ristoranti dell'utente
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	final ObservableList<String> obs2 = restaurantDAO.selectOwnRestaurant("liuk");
    	
    	//carico la gerarchia dei nodi
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AddDish.fxml"));
    	    	
    	//setto il nuovo controller grafico
    	loader.setControllerFactory(c -> {return new ControllerGuiAddDishView(obs1,obs2,nomeUtenteLabel.getText());});
    	Parent rootParent = loader.load();    	
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void deleteADish(ActionEvent event) throws IOException, ClassNotFoundException {    	
    	
    	//ottengo tutte le ricette di tutti i ristoranti dell'utente
    	RecipeDAO recipeDAO = new RecipeDAO();
    	ObservableList<String> obs1;
    	obs1 = recipeDAO.selectOwnRecipe(nomeUtenteLabel.getText());
    	
    	//ottengo tutti i ristoranti dell'utente
    	ObservableList<String> obs2;   	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	obs2 = restaurantDAO.selectOwnRestaurant(nomeUtenteLabel.getText());
    	
    	//FXMLLoader e setto il nuovo controller grafico
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/DeleteDishView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiDeleteDish(nomeUtenteLabel.getText(),obs1,obs2);});
    	Parent rootParent = loader.load();    	
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void getAdvice(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AdviceView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

   

    @FXML
    void modifyADish(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	RecipeDAO recipeDAO = new RecipeDAO();
    	
    	//ottengo le ricette dei ristoranti del proprietario
    	ObservableList<String> obs = recipeDAO.selectOwnRecipe(nomeUtenteLabel.getText());
    	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	
    	ObservableList<String> obs2 = restaurantDAO.selectOwnRestaurant(username);
    
    	//FXMLLoader e setto il nuovo controller grafico
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ModifyDishView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiModifyDishView(nomeUtenteLabel.getText(),obs,obs2);});
    	Parent rootParent = loader.load();      	
    	
    	//carica GUI successiva
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert deleteDishButton != null : "fx:id=\"deleteDishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert addADishButton != null : "fx:id=\"addADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert modifyADishButton != null : "fx:id=\"modifyADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert getAdviceButton != null : "fx:id=\"getAdviceButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        nomeUtenteLabel.setText(this.username);
    }
}
