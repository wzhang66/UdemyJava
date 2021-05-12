package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

// Simulate a service
public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "Weiwei",
                        "Sophia",
                        "Ryan",
                        "Yi",
                        "Robert"};

                ObservableList<String> employees = FXCollections.observableArrayList();
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        ListView.setItems(employees);
//                    }
//                });
                // Trying to simulate a fetching process.
                for(int i = 0; i<5; i++){
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the List");
                    updateProgress(i+1, 5);
                    Thread.sleep(100);
                }
                updateMessage("Finished!");
                return employees;
            }
        };
    }
}
