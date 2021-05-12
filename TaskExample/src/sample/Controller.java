package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    @FXML private ListView ListView;
    @FXML private ProgressBar progressBar;
    @FXML private Label progressLabel;

//    private Task<ObservableList<String>> task;
    private Service<ObservableList<String>> service;

    public void initialize(){

//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
////                Thread.sleep(1000);
//                String[] names = {
//                        "Weiwei",
//                        "Sophia",
//                        "Ryan",
//                        "Yi",
//                        "Robert"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
////                Platform.runLater(new Runnable() {
////                    @Override
////                    public void run() {
////                        ListView.setItems(employees);
////                    }
////                });
//                // Trying to simulate a fetching process.
//                for(int i = 0; i<5; i++){
//                    employees.add(names[i]);
//                    updateMessage("Added " + names[i] + " to the List");
//                    updateProgress(i+1, 5);
//                    Thread.sleep(100);
//                }
//                updateMessage("Finished!");
//                return employees;
//            }
//        };

        //initialize service from other class, which is recommended
        service = new EmployeeService();

        // data binding way to update the UI with the task, since it does not need to know what should happened with the data in the UI
        ListView.itemsProperty().bind(service.valueProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());

//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(false);
//                progressBar.setVisible(false);
//            }
//        });
//
//        progressBar.setVisible(false);
//        progressLabel.setVisible(false);

        // A much cleaner way to set the visibility of the progress bar and label
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());

    }

    @FXML
    public void buttonPressed(){
        if(service.getState() == Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if (service.getState() == Worker.State.READY) {
            service.start();
        }

    }
}
