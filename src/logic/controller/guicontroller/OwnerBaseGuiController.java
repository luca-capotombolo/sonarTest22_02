package logic.controller.guicontroller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import logic.controller.guicontroller.ManageMenuGuiController.ControllerGuiRestaurantMenuView;

public class OwnerBaseGuiController extends BaseGuiController{

	@FXML
	public Button manageMenuButton; 

	@FXML
	public Button sponsorRestaurantButton;
	
	@FXML
	@Override
	public void goHomePage(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/HomePageOwnerView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
	}
	
	@FXML
	void goToManageMenu(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
		loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView("liuk");});
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
	}
	
	@FXML
	void goToSponsorRestaurant(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/HomePageOwnerView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
	}
}



