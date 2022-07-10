package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {
    private final Store store;
    private final Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  // get current window

            // set new scene for current stage
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    /*
    The FXML controller can define an initialize() method,
    which will be called once on an implementing controller
    when the contents of its associated document have been completely loaded.

    TL;DR: The constructor is called first -> @FXML annotated fields are populated -> initialize() is called.
     */
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for(int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                // load fxml file of each media item to an fxml component
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                ItemController itemController = new ItemController();
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();

                itemController.setData(store.getItemsInStore().get(i));   // set data for item component and add to GridPane

                if(column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
