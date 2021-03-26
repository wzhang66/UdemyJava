package com.weiwei.todolist;

import com.weiwei.todolist.datamodel.TodoData;
import com.weiwei.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML private TextField shortDescription;
    @FXML private TextArea details;
    @FXML private DatePicker deadline;

    public TodoItem processResults(){
        String shortDescriptionData = shortDescription.getText().trim();
        String detailsData = details.getText().trim();
        LocalDate deadlineData = deadline.getValue();
        TodoItem newItem = new TodoItem(shortDescriptionData, detailsData,deadlineData);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;

    }
}
