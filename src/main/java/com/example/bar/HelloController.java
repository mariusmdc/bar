package com.example.bar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    // modèle
    private SimpleBar bar = new SimpleBar();
    private Barman barman = new Barman("Bob", 5, 5);
    private Order currentOrder;

    // composants FXML
    @FXML
    private TextField clientNameField;
    @FXML
    private TableView<Client> clientsTable;
    @FXML
    private TableColumn<Client, String> clientNameColumn;
    @FXML
    private TableColumn<Client, String> clientStatusColumn;

    @FXML
    private ComboBox<Cocktail> cocktailCombo;
    @FXML
    private TableColumn<Cocktail, Number> cocktailQuantityColumn;
    @FXML
    private TableView<Cocktail> orderCocktailsTable;
    @FXML
    private TableColumn<Cocktail, String> cocktailNameColumn;
    @FXML
    private TableColumn<Cocktail, Number> cocktailPriceColumn;
    

    @FXML
    private Label billLabel;

    private ObservableList<Client> clientsObservable;
    private ObservableList<Cocktail> cocktailsObservable;
    private ObservableList<Cocktail> orderCocktailsObservable;

    @FXML
    public void initialize() {
        // cocktails disponibles au bar
        bar.addCocktailToMenu(new CocktailWithAlcohol("Mojito", 8, 25.0, 12.0));
        bar.addCocktailToMenu(new CocktailWithAlcohol("Spritz", 7, 25.0, 11.0));
        bar.addCocktailToMenu(new CocktailWithAlcohol("Piña Colada", 9, 25.0, 15.0));
        bar.addCocktailToMenu(new CocktailWithAlcohol("Pint of Bush Caractère", 6, 50.0, 12.0));
        bar.addCocktailToMenu(new CocktailWithAlcohol("Virgin Mojito", 6, 25.0, 0.0));


        clientsObservable = FXCollections.observableArrayList(bar.getClients());
        cocktailsObservable = FXCollections.observableArrayList(bar.getCocktailMenu());
        orderCocktailsObservable = FXCollections.observableArrayList();

        clientsTable.setItems(clientsObservable);
        cocktailCombo.setItems(cocktailsObservable);
        orderCocktailsTable.setItems(orderCocktailsObservable);

        clientNameColumn.setCellValueFactory(
                data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName())
        );
        clientStatusColumn.setCellValueFactory(
                data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus().toString())
        );
        cocktailQuantityColumn.setCellValueFactory(
                data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getQuantity())
        );

        cocktailNameColumn.setCellValueFactory(
                data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName())
        );
        cocktailPriceColumn.setCellValueFactory(
                data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getPrice())
        );
    }

    @FXML
    private void onAddClient() {
        String name = clientNameField.getText();
        if (name == null || name.isBlank()) {
            return;
        }
        Client c = bar.addClient(name); // statut ARRIVED par défaut
        clientsObservable.add(c);
        clientNameField.clear();
    }

    @FXML
    private void onRemoveClient() {
        Client selected = clientsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        selected.setStatus(ClientStatus.LEFT);
        clientsTable.refresh();

        bar.removeClient(selected);
        clientsObservable.remove(selected);

        if (currentOrder != null && currentOrder.getClient() == selected) {
            currentOrder = null;
            orderCocktailsObservable.clear();
            billLabel.setText("Total : 0 €");
        }
    }

    @FXML
    private void onCreateOrder() {
        Client selected = clientsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        currentOrder = bar.createOrder(selected);
        selected.setStatus(ClientStatus.ORDERING);
        clientsTable.refresh();
        orderCocktailsObservable.clear();
        billLabel.setText("Total : 0 €");
    }

    @FXML
    private void onAddCocktailToOrder() {
        if (currentOrder == null) {
            return;
        }
        Cocktail selected = cocktailCombo.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        currentOrder.addCocktail(selected);
        orderCocktailsObservable.add(selected);
    }
    @FXML
    private void onRemoveCocktailFromOrder() {
        if (currentOrder == null) {
            return;
        }
        Cocktail selected = orderCocktailsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        currentOrder.removeCocktail(selected);
        orderCocktailsObservable.remove(selected);
        if (currentOrder.getBill() > 0) {
            double total = bar.billOrder(currentOrder);
            billLabel.setText("Total : " + total + " €");
        }
    }

    @FXML
    private void onServeOrder() {
        if (currentOrder == null) {
            return;
        }
        bar.prepareOrder(currentOrder, barman);
        Client client = currentOrder.getClient();
        client.setStatus(ClientStatus.DRINKING);
        clientsTable.refresh();
    }

    @FXML
    private void onBillOrder() {
        if (currentOrder == null) {
            return;
        }
        double total = bar.billOrder(currentOrder);
        billLabel.setText("Total : " + total + " €");
        Client client = currentOrder.getClient();
        client.setStatus(ClientStatus.PAID);
        clientsTable.refresh();
    }

    @FXML
    private void onStartHappyHour() {
        bar.startHappyHour();
        if (currentOrder != null) {
            double total = bar.billOrder(currentOrder);
            billLabel.setText("Total : " + total + " €");
        }
    }

    @FXML
    private void onEndHappyHour() {
        bar.endHappyHour();
        if (currentOrder != null) {
            double total = bar.billOrder(currentOrder);
            billLabel.setText("Total : " + total + " €");
        }
    }
}
