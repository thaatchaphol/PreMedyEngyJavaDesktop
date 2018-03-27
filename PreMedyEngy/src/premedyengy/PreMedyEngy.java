/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premedyengy;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;



import javafx.stage.Stage;







import javafx.application.Platform;








import javafx.scene.control.Alert.AlertType;






import javafx.scene.control.*;//ednote cannot replace import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;





import javafx.geometry.HPos;
import javafx.geometry.Insets;






import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.WindowEvent;




import premedyengy.engineering.*;

/**
 *
 * @author ed
 */
public class PreMedyEngy extends Application {
    
    
    
    private Addition additionObject;
    private String engineeringChoiceBoxSelectedString;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        
        createUI(primaryStage);
        
    }
    
    private void createUI(Stage stage){
        
        GridPane rootGridPane = new GridPane();
        

        
        
                rootGridPane.setHgap(20);
        rootGridPane.setVgap(20);
        rootGridPane.setPadding(new Insets(10));
        
        
        /*
        
        
        //-------the code below for constraint that make control change size when the size of stage/window is changed -----------------------------------------
        
        
        ColumnConstraints colConstrain1 = new ColumnConstraints();
       colConstrain1.setHgrow(Priority.NEVER);
      //      colConstrain1.setHgrow(Priority.ALWAYS);
        rootGridPane.getColumnConstraints().add(colConstrain1);

        ColumnConstraints colConstrain2 = new ColumnConstraints();
        colConstrain2.setHgrow(Priority.ALWAYS);                      //the controls in second colum (of rootGridPane)will change their sizes when users change the size of this stage(window)
        
        rootGridPane.getColumnConstraints().addAll(colConstrain1, colConstrain2);
        //Notice that these contrains just for the controls in the rootGridPane.In other words,they affect only the controls in the rootGridPane
        //In this case ,the controls in the rootGridPane are menubar,engineeringGridPane and medicineGridPane
        
        
        RowConstraints rowConstrain1 = new RowConstraints();
        rowConstrain1.setVgrow(Priority.NEVER);
        //rowConstrain1.setVgrow(Priority.ALWAYS);
        RowConstraints rowConstrain2 = new RowConstraints();
        rowConstrain2.setVgrow(Priority.ALWAYS);                         //the controls in second colum (of rootGridPane) will change their sizes when users change the size of this stage(window)
                RowConstraints rowConstrain3 = new RowConstraints();
        rowConstrain3.setVgrow(Priority.ALWAYS);  
        
        
   //     rootGridPane.getRowConstraints().addAll(rowConstrain1, rowConstrain2);
        
              rootGridPane.getRowConstraints().addAll(rowConstrain1, rowConstrain2, rowConstrain3);

        
        //Notice that these contrains just for the controls in the rootGridPane.In other words,they affect only the controls in the rootGridPane
         //In this case ,the controls in the rootGridPane are menubar,engineeringGridPane and medicineGridPane
        
         */
                 
                 
         //-------the above code  for constraint that make control change size when the size of stage/window is changed -----------------------------------------
        
        
        MenuBar menubar = new MenuBar();
        menubar.prefWidthProperty().bind(stage.widthProperty());

        doMenuHandler handler = new doMenuHandler();

        Menu aboutMenu = new Menu("About");
        menubar.getMenus().add(aboutMenu);

        MenuItem objectiveMenuItem = new MenuItem("Objective");
        objectiveMenuItem.setOnAction(handler);
        aboutMenu.getItems().add(objectiveMenuItem);

        MenuItem disclaimerMenuItem = new MenuItem("Disclaimer");
        disclaimerMenuItem.setOnAction(handler);
        aboutMenu.getItems().add(disclaimerMenuItem);

        
        
        
        

        Label engineeringLabel = new Label("Engineering");
            
        
                ChoiceBox engineeringChoiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "Addition"
                        , "Subtraction[TODO]"
                        ,"Multiplication[TODO]"
                        ,"Division[TODO]"
                        , "Function[TODO]"
                        ,"Probability[TODO]"
                        ,"Series[TODO]"
                        , "Calculus[TODO]"
                        , "Differential Equation[TODO]")
                );

        SingleSelectionModel engineeringChoiceBoxSelectionModel = engineeringChoiceBox.getSelectionModel();

        engineeringChoiceBoxSelectionModel.selectedItemProperty().addListener((ObservableValue observable, 
                Object oldValue, Object newValue) -> {

            
            
             System.out.println("select "+newValue.toString());
             engineeringChoiceBoxSelectedString = new String(newValue.toString());
             
        });
        
        
       
        
        
        
                Button openEngineeringButton = new Button();
        openEngineeringButton.setText("Open");
        openEngineeringButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
                System.out.println("click Open Engineering button");
                
                
                //ed note that every time user click this button it will create a new window but we want to create only one Addition window
//,so we check the Addiotion has already opened or not by boolean variable Addition.isOpened
     

if(engineeringChoiceBoxSelectedString!=null){

            if(engineeringChoiceBoxSelectedString.equals("Addition")){

                   
                   if(Addition.isOpened==false){ //ed work open new Stage only one time
                       
                       
                    //Addition additionObject = new Addition(); //ed work
                      additionObject = new Addition(); //ed work
                    
                  }
            }

/*
else if(engineeringChoiceBoxSelectedString.equals("Subtraction[TODO]")){
    
    System.out.println("TODO Subtraction");
}

*/
else{
    
    
                   Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("How to use PreMedyEngy");
                alert.setContentText("This version ,you can select only 'Addition' from 'Engineering' choicebox before clicking 'Open' button");

                alert.showAndWait(); 
                  
    
    
                   if(Addition.isOpened==false){ //ed work open new Stage/window only one time
                       
                       
                   
                      additionObject = new Addition(); //ed work
                    
                  }
}
}//if(engineeringChoiceBoxSelectedString!=null)

else{
      
    
                 Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("How to use PreMedyEngy");
                alert.setContentText("Please select item in choicebox of Engineering before clicking 'Open' button");

                alert.showAndWait(); 
                
                
                
}
                   
            }//handle(ActionEvent event)
            
        });
        
        GridPane engineeringGridPane = new GridPane();
        
        /*
        engineeringGridPane.setHgap(8);
        engineeringGridPane.setVgap(8);
        engineeringGridPane.setPadding(new Insets(5));
        */
        
                engineeringGridPane.setHgap(15);
        engineeringGridPane.setVgap(15);
        engineeringGridPane.setPadding(new Insets(8));
        
        
        engineeringGridPane.add(engineeringLabel, 0, 0);
          engineeringGridPane.add(engineeringChoiceBox, 0, 1);   
          
       
        
                                    engineeringGridPane.add(openEngineeringButton,0, 2); 
        
                                    

         
//         engineeringGridPane.setGridLinesVisible(true);//ed work // ednote show guide ,so you can see the resault from setHGap, setVGap, setPadding
         
         //---------------below for medicineGridPane---------------------------------
         
         
     
     
              Label medicineLabel = new Label("Medicine");
            
        
                ChoiceBox medicineChoiceBox = new ChoiceBox(FXCollections.observableArrayList(
                 "Cells[TODO]"
                        , "Buffers[TODO]"
                        , "Oxidative Energy[TODO]"
                        ,"Metabolics Controls[TODO]"
                        , "Proteins[TODO]"));

        SingleSelectionModel medicineChoiceBoxSelectionModel = medicineChoiceBox.getSelectionModel();

        medicineChoiceBoxSelectionModel.selectedItemProperty().addListener((ObservableValue observable, 
                Object oldValue, Object newValue) -> {

           
        });
        
        
  
        
        
        
                Button openMedicalButton = new Button();
        openMedicalButton.setText("Open");
        openMedicalButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
                System.out.println("click Open Medical button");
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("How to use PreMedyEngy");
                alert.setContentText("This version ,you can select only 'Addition' from 'Engineering' choicebox before clicking 'Open' button");

                alert.showAndWait(); 
                  
    
    
                   if(Addition.isOpened==false){ //ed work open new Stage only one time
                       
                       
                   
                    
                      additionObject = new Addition(); //ed work
                    
                  }
      

            }// handle(ActionEvent event) {
        });
        
        GridPane medicineGridPane = new GridPane();
        
        /*
                medicineGridPane.setHgap(8);
        medicineGridPane.setVgap(8);
        medicineGridPane.setPadding(new Insets(5));
        */
        
        
                        medicineGridPane.setHgap(15);
        medicineGridPane.setVgap(15);
        medicineGridPane.setPadding(new Insets(8));
        
        
        medicineGridPane.add(medicineLabel, 0, 0);
          medicineGridPane.add(medicineChoiceBox, 0, 1);   
          
       
        
        medicineGridPane.add(openMedicalButton,0, 2); 
    
  //       medicineGridPane.setGridLinesVisible(true);//ed work // ednote show guide ,so you can see the resault from setHGap, setVGap, setPadding
         
         
        //-----------------above for medicineGridPane--------------------------------------- 
        
        
        
        
        rootGridPane.add(menubar, 0, 0);
          rootGridPane.add(engineeringGridPane, 0, 1);
          
                    rootGridPane.add(medicineGridPane, 0, 2);
                    
    //                rootGridPane.setGridLinesVisible(true);//ed work // ednote show guide ,so you can see the resault from setHGap, setVGap, setPadding
         
                    
        

      //  Scene scene = new Scene(rootGridPane, 800, 600);
      //         Scene scene = new Scene(rootGridPane, 800, 300);
               Scene scene = new Scene(rootGridPane, 500, 300);

        stage.setTitle("PreMedyEngy-JavaDesktop is free and MIT open source software");
        
        stage.setMinWidth(500);
       stage.setMinHeight(350);
        
        stage.setScene(scene);
        stage.show();
        
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() { //ed work
          public void handle(WindowEvent we) {
              
             if(additionObject != null){ 
              additionObject.getStage().close();//ed work
             //additionObject = null; //ed note unlikely to help manage memory because the software will exit anyway 
             }
             
             
             
             
              System.out.println("PreMedyEngy Stage is closing");
          }
      });        
        
        
    }
    
    
        private class doMenuHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            
            createMessageDialog(event);
        }
        
        private void createMessageDialog(ActionEvent event) {

    
                    
                 MenuItem mi = (MenuItem) event.getSource();
            if(mi.getText().equalsIgnoreCase("Objective")){
                 Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Objective Dialog");
                alert.setHeaderText("Objective of this software");
                alert.setContentText("PreMedyEngy is a free and MIT open source software that tries to help anyone learn the basic knowledge in engineering and medicine.");

                alert.showAndWait();
            }else if(mi.getText().equalsIgnoreCase("Disclaimer"))  {
                               Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Disclaimer Dialog");
                alert.setHeaderText("Disclaimer");
                alert.setContentText("The contents in this software are not checked by engineers and doctors. \nPlease check accurate information with textbooks and experts");

                alert.showAndWait();          
                        
            }
                
            
            
        }//showMessageDialo
    }//class MyMenuhandeler

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
}//class PreMedyEngy



/////////////////////////////////////////////////////////



