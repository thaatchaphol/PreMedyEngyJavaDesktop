/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premedyengy.engineering;



import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;





import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

///////////////////////////////////////

import javafx.scene.control.*;
import javafx.scene.layout.*;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;

import javafx.scene.control.ScrollPane;
import javafx.stage.WindowEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



/**
 *
 * @author ed
 */
public class Addition {
    
    public static boolean isOpened =false; //ed work //need to be public otherwise it cannot be used from premedyengy package
    private Stage stage;
    
    
    private GridPane contentInScrollPaneGridPane;
    
    private ScrollPane explainTabScrollPane;
    
    private GridPane scrollPaneGridPane;
    
    private  TextField augendTextField;
    private TextField addendTextField;
    private TextField sumTextField;
              

   
   
   private ArrayList<Label> explainLabelArrayList;
   
      private ArrayList<Integer> augendIntegerArrayList;
   
    private ArrayList<Integer> addendIntegerArrayList;
   
    private ArrayList<Integer> sumIntegerArrayList;
   
     private ArrayList<Integer> carryIntegerArrayList;
   
     
     
      
      
      private ArrayList<String> explainStringArrayList;
      
      
      private ScrollPane manualTabScrollPane;
      
      private ScrollPane basicKnowledgeTabScrollPane;
      
      
      
      
    
    public Addition(){ //need to be public otherwise it cannot be used from premedyengy package
                    
                    
                isOpened = true; //ed work
            

                
                stage = new Stage();
                    
                    
                 GridPane rootGridPane = new GridPane();
        
 
        
        
                rootGridPane.setHgap(20);
               rootGridPane.setVgap(20);
               rootGridPane.setPadding(new Insets(10));
        
        
               Label add1Label = new Label("Augend");
              Label add2Label = new Label("Addend");
               Label resultLabel = new Label("Result");
                       
                       

              
                      
                      
                      augendTextField = new TextField();
                      
                      //ed note need to align the text in the textfield because we want the rightmost digit to place at the right edge of the textfield
                      //otherwise the leftmost digit will place at the left edge of the textfield
                      
                     augendTextField.setAlignment(Pos.BASELINE_RIGHT);
                      
        //augendTextField.setPrefHeight(40);
        
                            
                            
                            
                              addendTextField = new TextField();
                              
                              addendTextField.setAlignment(Pos.BASELINE_RIGHT);
                              
                              
       // addendTextField.setPrefHeight(40);
       
      
       
       sumTextField = new TextField();
       
       sumTextField.setEditable(false);
       
       sumTextField.setAlignment(Pos.BASELINE_RIGHT);
       
       
        Button explainButton = new Button();
        explainButton.setText("Explain");
        
        

                
                    
           GridPane inputAdditionGridPane = new GridPane();
           
          inputAdditionGridPane.setHgap(15);//ednote set distance between col
                  //  inputAdditionGridPane.setHgap(50);
        inputAdditionGridPane.setVgap(15);//ednote set distance between row
                //inputAdditionGridPane.setVgap(50);
        inputAdditionGridPane.setPadding(new Insets(8));//ednote set distance around this GridPane object(the GridPane object is placed at top-left by default)
      //  inputAdditionGridPane.setPadding(new Insets(100));
        
        inputAdditionGridPane.add(add1Label, 0, 0);//ed note place the control at column,row //Note that there is a method that use can place control at at column,row,colspan,rowspan
         inputAdditionGridPane.add(augendTextField, 1, 0);
                         
        inputAdditionGridPane.add(add2Label, 0, 1);
       inputAdditionGridPane.add(addendTextField, 1, 1);
       
         inputAdditionGridPane.add(resultLabel, 0, 2);
          inputAdditionGridPane.add(sumTextField, 1, 2);
               
               
        inputAdditionGridPane.add(explainButton,0,3);
               
    //    inputAdditionGridPane.setGridLinesVisible(true);//ed work // ednote show guide ,so you can see the resault from setHGap, setVGap, setPadding
         

//---------------------------------
         
       GridPane tabGridPane = new GridPane();
        

        
        
        tabGridPane.setHgap(15);
        tabGridPane.setVgap(15);
        tabGridPane.setPadding(new Insets(8));
               
         TabPane additionTabPane = new TabPane();
        
        Tab explainTab = new Tab();
        explainTab.setText("Explain");
//        explainTab.setContent(new Rectangle(100, 100, Color.LIGHTSTEELBLUE));
//        explainTab.setContent(new Rectangle(100, 100, Color.CHARTREUSE));
        
        Tab manualTab = new Tab();
        manualTab.setText("Manual");
        //manualTab.setContent(new Line(20, 200, 600, 100));  
        
        Tab basicTab = new Tab();
        basicTab.setText("Basic Knowledge");
   //    basicTab.setText("Basics");
        //basicTab.setContent(new Circle(50, 50, 200));         
        
        
        
        
      //  additionTabPane.setPrefSize(500, 500); //edneed otherwise TabPane look too small
        
        additionTabPane.setPrefSize(1500, 500); //ed work//edneed otherwise TabPane look too small
        
//        additionTabPane.getSelectionModel().select(1);   //ednote show the second tab by default

      additionTabPane.getSelectionModel().select(0); //ednote show the first tab by default
      
        additionTabPane.getTabs().addAll(explainTab, manualTab, basicTab);
        
        additionTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); //ed work//need to remove close button at the top-right from each tab otherwise users can delete tab
        
        
        
        
        tabGridPane.add(additionTabPane,0,0); 
        
        
          
      
     
  //--------------------------------------------------------
  

            
        
        
        
         contentInScrollPaneGridPane = new GridPane();
                  
         contentInScrollPaneGridPane.setHgap(15);
        contentInScrollPaneGridPane.setVgap(15);
        contentInScrollPaneGridPane.setPadding(new Insets(8));    
        
        
        
        //ednote Graidpane inside ScrollPane needs to be bigger than ScrollPane to make the ScrollPane show its scrollbar
          //In other words,what is inside the ScrollPane needs to be bigger than the ScrollPane otherwise the ScrollPane does not show scrollbar
        //except that you set policy 'ALWAYS' like setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS)
         
        //contentInScrollPaneGridPane.setPrefSize(800,800);//not high enough to show explain label when adding more than 6 digits
      //    contentInScrollPaneGridPane.setPrefSize(800,1800);
          contentInScrollPaneGridPane.setPrefSize(800,2800);

           //do not need to add label here you can add all label to arraylist when user click explain button
                   
           
        

                  
         scrollPaneGridPane = new GridPane();
                  
                  
        scrollPaneGridPane.setHgap(15);
        scrollPaneGridPane.setVgap(15);
        scrollPaneGridPane.setPadding(new Insets(8)); 
        
        scrollPaneGridPane.setPrefSize(1500,1000);//ed work  
        
        
                  
             
                
                explainTabScrollPane = new ScrollPane();
                
       
        
      //         explainTabScrollPane.setPrefSize(400, 400); //ed work
            explainTabScrollPane.setPrefSize(800, 800); //ed work   

              explainTabScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
              
              
 

      explainTabScrollPane.setContent(contentInScrollPaneGridPane);  //ed work

       
       scrollPaneGridPane.add(explainTabScrollPane,0,0); //ed work
        
 //-----------------------------------------------------------------       
        
 
 manualTabScrollPane = new ScrollPane();
manualTabScrollPane.setPrefSize(800, 800); //ed work   

              
manualTabScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
 
          final WebView manualbrowser = new WebView();
        final WebEngine manualwebEngine = manualbrowser.getEngine();         
          manualTabScrollPane.setContent(manualbrowser);
        //manualwebEngine.loadContent("<b>In Manual Tab</b><br/><b>TODO</b>");
        manualwebEngine.loadContent("<b>In Manual Tab</b><br/><b>TODO</b><br/>TODO");
       // manualwebEngine.load("http://www.mywebname.com/index.html");//TODO
        
        
         //manualTab.setContent(new Line(20, 200, 600, 100));  
         
         
          manualTab.setContent(manualTabScrollPane);  
          
       //----------------------------------------------------------------- 
       
     
       
        basicKnowledgeTabScrollPane = new ScrollPane();
basicKnowledgeTabScrollPane.setPrefSize(800, 800); //ed work   

              
basicKnowledgeTabScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
 
          final WebView basicsbrowser = new WebView();
        final WebEngine basicswebEngine = basicsbrowser.getEngine();         
          basicKnowledgeTabScrollPane.setContent(basicsbrowser);
          
    //    basicswebEngine.loadContent("<b>In Basic Knowledge Tab</b><br/><b>TODO</b>");
        basicswebEngine.loadContent("<b>In Basic Knowledge Tab</b><br/><b>TODO</b><br/>TODO");
        
       // basicswebEngine.load("http://www.mywebname.com/index.html");//TODO
        
        
        //basicTab.setContent(new Circle(50, 50, 200));  
        
        
          basicTab.setContent(basicKnowledgeTabScrollPane);  
     
          
  //----------------------------------------------------------------- 
  
  explainButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
  
          
               
                                                        //ednote regular expression
                                //need '+' after \\d and \\D otherwise it means one digit or one nondigit respectively
                                //    "\\d+" is any number of numeric digits(at least one numeric digit)
                                 //   "\\D+" is any number of nondigit charaters
                                 //  "\\d+" is equivalent to "[0-9]+"
                                 //   "\\D+" is equivalent to "[^0-9]+" 
                                 //   "\\d" is equivalent to "[0-9]"
                                 //   "\\D" is equivalent to "[^0-9]" 
                              //       use "\\." to check there is  '.' in the string or not
                              // "\\d*" can be nothing or have any numeric digits. It is differnt from "\\d+" that need to have at least one numeric digit
                              
                              
             
                  
             
              if(augendTextField.getText().length()==0 || addendTextField.getText().length()==0 
                      || augendTextField.getText().matches("\\D+")
                      || addendTextField.getText().matches("[^0-9]+")
                      
                 

                      
                      || augendTextField.getText().matches("\\d*\\.\\d*")
                      || addendTextField.getText().matches("\\d*\\.\\d*")
                      
                      
           
                      
                      ){  
                
                                                                     
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("How to use Addition");
                alert.setContentText("Please fill out the whole number between 0 and 1,000,000"
                        + "\nin 'Augend' textfield and 'Addend' textfield"
                        + "\nbefore clicking 'Explain' button.");

                alert.showAndWait();   
                
                augendTextField.setText("");
                addendTextField.setText("");
                sumTextField.setText("");
                
                
             }else{
                  
                  /*
                   float augendValue,addendValue,sumValue;
                    augendValue = Float.parseFloat(augendTextField.getText());
                    */
                    
                    
                    int augendValue,addendValue,sumValue;
                    augendValue = Integer.parseInt(augendTextField.getText());
                    addendValue = Integer.parseInt(addendTextField.getText());
                    sumValue = augendValue + addendValue;
                    Integer resultInteger = Integer.valueOf(sumValue);
                    
                    sumTextField.setText(resultInteger.toString());
                    System.out.println("augendValue = "+augendValue);
                    System.out.println("addendValue = "+addendValue);
                   System.out.println("sumValue = "+sumValue);
                   
                   int numMaxDigit = resultInteger.toString().length();
                   System.out.println("numMaxDigit = "+numMaxDigit);
                   
                   
                   //------------------------------------
                   
                   
                   
  
                   if(augendIntegerArrayList != null){//reset UI and arraylist//use from the second time after augendIntegerArrayList is used to add at the first time
                       
                  

             
                       
                                             
                
//       for(int i=0;i<explainLabelArrayList.size();i++){explainLabelArrayList.remove(i);}//ed work //do not need because we will anyway assign null by explainLabelArrayList = null
                       
                
                
                
                //--------------------------------------------------------
                contentInScrollPaneGridPane = null;//ed work
                contentInScrollPaneGridPane = new GridPane();//ed work
                  
                contentInScrollPaneGridPane.setHgap(15);
        contentInScrollPaneGridPane.setVgap(15);
        contentInScrollPaneGridPane.setPadding(new Insets(8));             
          contentInScrollPaneGridPane.setPrefSize(800,800);
                
          
          scrollPaneGridPane = null;//ed work
          scrollPaneGridPane = new GridPane();//ed work
                  
                  
          scrollPaneGridPane.setHgap(15);
        scrollPaneGridPane.setVgap(15);
        scrollPaneGridPane.setPadding(new Insets(8));             
                  
              
                
              explainTabScrollPane = null;//ed work
                explainTabScrollPane = new ScrollPane();//ed work
                
        
             //explainTabScrollPane.setPrefSize(120, 120);//org
        
           //    explainTabScrollPane.setPrefSize(400, 400); //ed work
           
           
             explainTabScrollPane.setPrefSize(800, 800); //ed work   

              explainTabScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
              
              
 

      explainTabScrollPane.setContent(contentInScrollPaneGridPane);  //ed work

       
       scrollPaneGridPane.add(explainTabScrollPane,0,0); //ed work
        
                //------------------------------------------
                       explainLabelArrayList = null;//ed work
                                             
                       explainLabelArrayList = new ArrayList<>();//ed work
                       
                       augendIntegerArrayList = null;
                       
                       augendIntegerArrayList = new ArrayList<>();//ed work
                       
                       addendIntegerArrayList = null;
                        addendIntegerArrayList = new ArrayList<>();
                        
                        sumIntegerArrayList = null;
                        sumIntegerArrayList = new ArrayList<>();
                        
                        carryIntegerArrayList = null;
                         carryIntegerArrayList = new ArrayList<>();
                                                          
                         
                        explainStringArrayList = null;
                        explainStringArrayList = new ArrayList<>();
                        
                        
                        
        //Add each character from text field to arraylist but we need to change from a charater to a string first
        //ed note We want to add rightmost digit in arraylist first ,but charAt(0) is the first character from the left of the string
        //,so the loop variable need to start from the last charater of the string.In other words,the loop variable need to be decreased
                                                                     
                    
                    
                        for(int i=augendTextField.getText().length()-1 ; i >=0 ;i--){   
                           
                           char ch = augendTextField.getText().charAt(i);
                           
                          // Character charOblect = new Character(ch);//unnecessary boxing
                           Character charObject = ch;//ed work//autoboxing//from primitive to object data type
                       

                    
                       //    System.out.println("augendTextField.getText().charAt("+i+") = "+augendTextField.getText().charAt(i));//ed work
                      
                       
                           augendIntegerArrayList.add(Integer.parseInt(charObject.toString()));//ed work
                       //   augendIntegerArrayList.add(new Integer(Integer.parseInt(charObject.toString())));//ed also work
                          
                
                          //System.out.println("i = "+i);
                       }
                        
                        //add 0 to augendIntegerArrayList (at the left hand side column) when the number of digit of augend is less than the number of digit of the result
                        
                        if(numMaxDigit > augendTextField.getText().length()){
                            for(int j=1; j <= numMaxDigit-augendTextField.getText().length() ;j++){
                            //augendIntegerArrayList.add(Integer.parseInt(new String("0")));//ed work
                                augendIntegerArrayList.add(Integer.parseInt("0"));//ed also work
                            }
                        }
                        
                        for(int i=0;i<augendIntegerArrayList.size();i++){
                            
                            System.out.println("augendIntegerArrayList.get("+i+") ="+augendIntegerArrayList.get(i));
                        }
                        
                       
                     
                     
                     
                       for(int i=addendTextField.getText().length()-1 ; i >=0 ;i--){   
                           
                            char ch = addendTextField.getText().charAt(i);
                           
                          // Character charOblect = new Character(ch);//unnecessary boxing
                           Character charObject = ch;//ed work// autoboxing//from primitive to object data type
                           
                          //     System.out.println("addendTextField.getText().charAt("+i+") = "+addendTextField.getText().charAt(i));//ed work
                        
                          
                            addendIntegerArrayList.add(Integer.parseInt(charObject.toString()));//ed work
                          
                      
                            //System.out.println("i = "+i);

                       }
                       
                       
                       //add 0 to addendIntegerArrayList (at the left hand side column) when the number of digit of addend is less than the number of digit of the result
                        
                   
                       if(numMaxDigit > addendTextField.getText().length()){
                            for(int j=1; j <= numMaxDigit-addendTextField.getText().length() ;j++){
                            //addendIntegerArrayList.add(Integer.parseInt(new String("0")));//ed work
                              addendIntegerArrayList.add(Integer.parseInt("0"));//ed also work
                           }
                       }
                       
                       
                       for(int i=0;i<addendIntegerArrayList.size();i++){
                            
                            System.out.println("addendIntegerArrayList.get("+i+") ="+addendIntegerArrayList.get(i));
                        }       
 
                       
                      //----------the code below is used for creating carry arraylist and sum arraylist and explain-string arraylist  ------------------
                       
                         for(int i=0;i<numMaxDigit;i++){ 
                             carryIntegerArrayList.add(0);
                             
                         }
                       
                        for(int k=0;k<numMaxDigit;k++){ 
                            

                            
                            if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) < 10){
                                    sumIntegerArrayList.add(k,carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k));
                             
                            String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                           
                                           
                                             +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                           
                                            +"\nThe result of the addition of this column is less than 10 , place the result in this column."
                                           
                                                 
                                            ;
                            
                                   
                                    explainStringArrayList.add(k,str);
                            
                            }
                            else if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) == 10){
                                sumIntegerArrayList.add(k,0);
                                int idCarry = k + 1 ;
                                carryIntegerArrayList.remove(idCarry);
                                carryIntegerArrayList.add(idCarry,1);
                           
                            String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                          
                                             
                                              +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                        
                                                
                                            +"\nThe result of the addition of this column is equal to 10 , place 0 in this column and change the carry of the next left column from 0 to 1."
                                           
                                                 ;
                                        
                                    explainStringArrayList.add(k,str);
                                
                            
                            }else{
                                sumIntegerArrayList.add(k,(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k)-10));
                                int idCarry = k + 1 ;
                                carryIntegerArrayList.remove(idCarry);
                                carryIntegerArrayList.add(idCarry,1);
                            
                               String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                           // +"\nThe result of addition of this column = Carry + Augend + Addend = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))         
                                           
                                                       +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                    
                                                     
                                            +"\nThe result of the addition of this column is greater than 10 "
                                             +"\n, place the number that exceeds 10 "+" , ( "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))+" - 10 ) = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k)-10)+" ,"
                                                     + " in this column and change the carry of the next left column from 0 to 1."
                                           
                                                 ;
                                             
                                             
                                    explainStringArrayList.add(k,str);
                            
                            }//else after else if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) == 10)
                            
                        }//for
                       
                       System.out.println(carryIntegerArrayList);
    
                       System.out.println(augendIntegerArrayList);
                       System.out.println(addendIntegerArrayList);
                       System.out.println(sumIntegerArrayList);
                       
     
                       System.out.println(explainStringArrayList);
                       
                       
                        //----------the above code is used for creating carry arraylist and sum arraylist and explain-string arraylist  ------------------
                       
                        
                        
                        
                                         
                     
                     
                     for(int i=0;i<numMaxDigit;i++){ //create and add explan label to  contentInScrollPaneGridPane   
                            
                           explainLabelArrayList.add(new Label());
                        //   explainLabelArrayList.get(i).setText("Label"+i);
                        
                             explainLabelArrayList.get(i).setText(explainStringArrayList.get(i));//ed work
                        
                        
                           contentInScrollPaneGridPane.add(explainLabelArrayList.get(i), 0, i);
                           System.out.println("ArrayList id = "+i+" , object = "+explainLabelArrayList.get(i));//ed work
                       
                           
                           
                           
                           
                        }//for(int i=0;i<numMaxDigit;i++){ //create and add explan label to  contentInScrollPaneGridPane   
                        
                        
                        
                        
                   }else{//use only one time,the first time  //else of if(augendIntegerArrayList != null)
                                  
                       
                       
                       explainLabelArrayList = new ArrayList<>();
                       
                       
                       //------------------------------
                       augendIntegerArrayList = new ArrayList<>();//ed work
                       
                    //   addendIntegerArrayList = null;
                        addendIntegerArrayList = new ArrayList<>();
                        
                      //  sumIntegerArrayList = null;
                        sumIntegerArrayList = new ArrayList<>();
                        
                       // carryIntegerArrayList = null;
                         carryIntegerArrayList = new ArrayList<>();
                                                          
                         explainStringArrayList = new ArrayList<>();
                         
                         
                         

        
                //Add each character from text field to arraylist but we need to change from a charater to a string first
        //ed note We want to add rightmost digit in arraylist first ,but charAt(0) is the first character from the left of the string
        //,so the loop variable need to start from the last charater of the string.In other words,the loop variable need to be decreased
         
                    
                    
                        for(int i=augendTextField.getText().length()-1 ; i >=0 ;i--){                      
                         
                                                                     
                   
                           char ch = augendTextField.getText().charAt(i);
                           
                          // Character charOblect = new Character(ch);//unnecessary boxing
                           Character charObject = ch;//ed work//autoboxing//from primitive to object data type
                           
                           
                        
                       //    System.out.println("augendTextField.getText().charAt("+i+") = "+augendTextField.getText().charAt(i));//ed work
                      
                       
                           augendIntegerArrayList.add(Integer.parseInt(charObject.toString()));//ed work
                       //   augendIntegerArrayList.add(new Integer(Integer.parseInt(charObject.toString())));//ed also work
                          
                        
                        
                        
                        
                   //       System.out.println("i = "+i);
                          
                       }
                        
                         //add 0 to augendIntegerArrayList (at the left hand side column) when the number of digit of augend is less than the number of digit of the result
              
                        
                        if(numMaxDigit > augendTextField.getText().length()){
                            for(int j=1; j <= numMaxDigit-augendTextField.getText().length() ;j++){
                            //augendIntegerArrayList.add(Integer.parseInt(new String("0")));//ed work
                                augendIntegerArrayList.add(Integer.parseInt("0"));//ed also work
                            }
                        }
                        
                        for(int i=0;i<augendIntegerArrayList.size();i++){
                            
                            System.out.println("augendIntegerArrayList.get("+i+") ="+augendIntegerArrayList.get(i));
                        }
                       
                        
                                //Add each character from text field to arraylist but we need to change from a charater to a string first
        //ed note We want to add rightmost digit in arraylist first ,but charAt(0) is the first character from the left of the string
        //,so the loop variable need to start from the last charater of the string.In other words,the loop variable need to be decreased
             
                        
                        
                        
                       for(int i=addendTextField.getText().length()-1 ; i >=0 ;i--){  
                           
             
                           
                            char ch = addendTextField.getText().charAt(i);
                           
                          // Character charOblect = new Character(ch);//unnecessary boxing
                           Character charObject = ch;//ed work//autoboxing//from primitive to object data type
                           
                          //     System.out.println("addendTextField.getText().charAt("+i+") = "+addendTextField.getText().charAt(i));//ed work
                        
                            addendIntegerArrayList.add(Integer.parseInt(charObject.toString()));//ed work
                          
                    
                         // System.out.println("i = "+i);
             

                       }
                       
                       
                        //add 0 to addendIntegerArrayList (at the left hand side column) when the number of digit of addend is less than the number of digit of the result
              
                       
                      if(numMaxDigit > addendTextField.getText().length()){
                            for(int j=1; j <= numMaxDigit-addendTextField.getText().length() ;j++){
                            //addendIntegerArrayList.add(Integer.parseInt(new String("0")));//ed work
                              addendIntegerArrayList.add(Integer.parseInt("0"));//ed also work
                           }
                       }
                       
                      for(int i=0;i<addendIntegerArrayList.size();i++){
                            
                            System.out.println("addendIntegerArrayList.get("+i+") ="+addendIntegerArrayList.get(i));
                        }  
                       
                      
   
                      
//----------the code below is used for creating carry arraylist and sum arraylist and explain-string arraylist  ------------------
                    


                         for(int i=0;i<numMaxDigit;i++){ 
                             carryIntegerArrayList.add(0);
                             
                         }
                       
                        for(int k=0;k<numMaxDigit;k++){ 
                            

                            
                            if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) < 10){
                                    sumIntegerArrayList.add(k,carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k));
                                   
                                    String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                           //+"\nThe result of addition of this column = Carry + Augend + Addend = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                           
                                             +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                           
                                            +"\nThe result of the addition of this column is less than 10 , place the result in this column."
                                           
                                                 
                                            ;
                                   // explainStringArrayList.add(str);//edwork
                                    explainStringArrayList.add(k,str);
                                    
                             }
                            else if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) == 10){
                                sumIntegerArrayList.add(k,0);
                                int idCarry = k + 1 ;
                                carryIntegerArrayList.remove(idCarry);
                                carryIntegerArrayList.add(idCarry,1);
                                
                                        String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                           // +"\nThe result of addition of this column = Carry + Augend + Addend = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))    
                                             
                                              +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                        
                                                
                                            +"\nThe result of the addition of this column is equal to 10 , place 0 in this column and change the carry of the next left column from 0 to 1."
                                           
                                                 ;
                                        
                                    explainStringArrayList.add(k,str);
                                
                                
                            }else{
                                sumIntegerArrayList.add(k,(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k)-10));
                                int idCarry = k + 1 ;
                                carryIntegerArrayList.remove(idCarry);
                                carryIntegerArrayList.add(idCarry,1);
                                
                                
                                             String str = "\nConsider column "+(k+1)+" from the right hand side."
                                                 +"\nCarry = "+carryIntegerArrayList.get(k)
                                            +"\nAugend = "+augendIntegerArrayList.get(k)
                                            +"\nAddend = "+addendIntegerArrayList.get(k)
                                            
                                           // +"\nThe result of addition of this column = Carry + Augend + Addend = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))         
                                           
                                                       +"\nThe result of the addition of this column = Carry + Augend + Addend = "
                                            +carryIntegerArrayList.get(k)+" + "+augendIntegerArrayList.get(k)+" + "+addendIntegerArrayList.get(k)+" = "
                                            +(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))
                                    
                                                     
                                            +"\nThe result of the addition of this column is greater than 10 "
                                             +"\n, place the number that exceeds 10 "+" , ( "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k))+" - 10 ) = "+(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k)-10)+" ,"
                                                     + " in this column and change the carry of the next left column from 0 to 1."
                                           
                                                 ;
                                             
                                             
                                    explainStringArrayList.add(k,str);
                                    
                                
                            } //else after else if(carryIntegerArrayList.get(k) + augendIntegerArrayList.get(k) + addendIntegerArrayList.get(k) == 10)
                            
                        }//for
                       
                       System.out.println(carryIntegerArrayList);
    
                       System.out.println(augendIntegerArrayList);
                       System.out.println(addendIntegerArrayList);
                       System.out.println(sumIntegerArrayList);
                       
                       
                       System.out.println(explainStringArrayList);
                       
                       
//----------the above code is used for creating carry arraylist and sum arraylist and explain-string arraylist  ------------------
                      
                       
                       
                       
                       //----------------------
                       
                      
                      
                      
                      
                         for(int i=0;i<numMaxDigit;i++){ //create and add explan label to  contentInScrollPaneGridPane   
                             
                           explainLabelArrayList.add(new Label());
                           
                         

                           
                           explainLabelArrayList.get(i).setText(explainStringArrayList.get(i));//ed work
                           
     
                      
                           contentInScrollPaneGridPane.add(explainLabelArrayList.get(i), 0, i);
                           System.out.println("ArrayList id = "+i+" , object = "+explainLabelArrayList.get(i));//ed work
            
                       }//for(int i=0;i<numMaxDigit;i++){ //create and add explan label to  contentInScrollPaneGridPane   
                         
                         
                         
                         
                         
                   }//else of if(augendIntegerArrayList != null)
                       
                   
                   
              }//else of if(augendTextField.getText().length()==0 || regular expression test ){
                              
                              
                              explainTab.setContent(scrollPaneGridPane); //ed work
                             System.out.println("Explain button is clicked");
                             
                             
                             
                             
                   
                        
               
            }//handle(ActionEvent event)
        });//explainButton.setOnAction
        
        
      //------------------------         
                    rootGridPane.add(inputAdditionGridPane, 0, 0);
          
                    rootGridPane.add(tabGridPane, 0, 1);
                    
                    
                    Scene scene = new Scene(rootGridPane, 800, 600);

        //stage.setTitle("Summation");
        
                stage.setTitle("Addition");
                
                stage.setMinWidth(800); //ed work
                stage.setMinHeight(600);
                
                
                stage.setScene(scene);
        
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() { //ed work
                   public void handle(WindowEvent we) {
              
                            isOpened = false;//users can open Addition stage(window) again after closing Addition stage(window) by clicking Open button in PreMedyEngy stage(window)
              
                           System.out.println("Addition Stage is closing");
              
          }//handle
      });     
        
        
        stage.show();
        
        
                    
                }//constructor of the class Addition
    
    
    public Stage getStage(){
        
        return stage;
        
    }
    
    
    
}//class Addition


