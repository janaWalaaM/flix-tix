package in.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import java.time.LocalDate;
import javafx.scene.layout.Region;
import static java.time.temporal.TemporalQueries.localDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.TextAlignment;

/**
 * JavaFX App
 */
public class App extends Application {
    
//    List<User> users = null;
//    User user = new User();
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    Transaction tx = session.beginTransaction();

   private double basePrice = 45; // price for a seat
    private double totalPrice = 0; // Total price including selected seats
//     private static AtomicInteger bookingCounter = new AtomicInteger(0);

    Scene Seatscene ;
    Scene Paymentscene ;
         int ID = 0;


//    private Object session;

    @Override
    public void start(Stage stage)  throws FileNotFoundException {
      
       ///////////////////////HOME PAGE  
         
        BorderPane pane   =new BorderPane();
        
///////////// .  TOP        
         HBox searchhb=new HBox(10);
         
        VBox top=new VBox();
        top.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/logo_p.PNG"))); 
        imageView.setFitHeight(130);
        imageView.setFitWidth(130);
searchhb.setAlignment(Pos.CENTER);
        top.getChildren().addAll(imageView,searchhb);
        top.setStyle("-fx-background-color:   rgb(44, 44,52);");
        top.setAlignment(Pos.CENTER);
 
         ComboBox searchgenre = new ComboBox();
        searchgenre.getItems().addAll("Action", "Comedy", "Drama", "Romance","Horror","Science Fiction","Animation","Fantasy","Documentary");
searchgenre.setValue("genre");
searchgenre.setStyle("-fx-base: rgb(253, 164,0);-fx-background-color:rgb(56, 56,59); -fx-text-fill: rgb(253, 164,0);");
searchgenre.setPrefSize(20, 20);


/////////////// .  LEFT        
           VBox left =new VBox(50);
        
           Button home = new Button("\n\n\n\n\nHOME");
           Button search= new Button("SEARCH");
           
           Button administration   = new Button("ADMINISTRATION");
           Button  profile= new Button("PROFILE");
           Button about_us = new Button("ABOUT US");
           
           search.setStyle("-fx-background-color:   rgb(44, 44,52);");
           home.setStyle("-fx-background-color:   rgb(44, 44,52);");
           about_us.setStyle("-fx-background-color:   rgb(44, 44,52);");
           profile.setStyle("-fx-background-color:   rgb(44, 44,52);");
   administration.setStyle("-fx-background-color:   rgb(44, 44,52);");
  
   
   search.setTextFill(  rgb(253, 164,0));
   home.setTextFill(rgb(253, 164,0));
   about_us.setTextFill(rgb(253, 164,0));
   profile.setTextFill(rgb(253, 164,0));
   administration.setTextFill(rgb(253, 164,0));
  
   left.getChildren().addAll(home,profile,about_us,administration);
        
        
 left.setStyle("-fx-background-color:   rgb(44, 44,52);");
        left.setAlignment(Pos.TOP_CENTER);

 /////////////// .  CENTER       
//       
        FlowPane center= new FlowPane( Orientation.VERTICAL);
        ScrollPane scrollPane = new ScrollPane(center);
        scrollPane.setStyle(
                "-fx-control-inner-background: rgb(44, 44,52);" + // Background color
                "-fx-background: rgb(44, 44,52);" +               // Track color
                "-fx-background-color: rgb(44, 44,52);"           // Thumb color
        );
        
//center.setPadding(new Insets(50,50,50,50));
       scrollPane.setPadding(new Insets(50,30,80,40));
//center.setAlignment(Pos.CENTER);
        scrollPane.setPrefSize(50, 50);

center.setStyle("-fx-background-color:   rgb(44, 44,52);");
        center.setHgap(20);
        center.setVgap(20);

      center. setAlignment(Pos.TOP_CENTER);
     
////////////search TextField      
      TextField tf = new TextField();  
    
       tf .setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
       tf.setPrefWidth(250);
       tf.setPrefHeight(30);
     
       Image image = new Image(new FileInputStream("/Users/janawalaa/Desktop/filter_logo.png"));
        ImageView imageViewn = new ImageView(image);
        imageViewn.setFitHeight(20);
        imageViewn.setFitWidth(20);

        
        Image images = new Image(new FileInputStream("/Users/janawalaa/Desktop/search_logo.png"));
        ImageView imageViewsb = new ImageView(images);
        imageViewsb.setFitHeight(40);
        imageViewsb.setFitWidth(40);
        
        Button filter = new Button("", imageViewn);
        Button searchb = new Button("", imageViewsb);
       
        filter.setPrefSize(40, 40);
       filter.setStyle("-fx-background-color:   rgb(44, 44,52);");
      
       
        searchb .setPrefSize(40, 40);
    searchb.setStyle("-fx-background-color:   rgb(44, 44,52);");
      
       
       center.getChildren().addAll();
        
        searchhb.getChildren().addAll(searchgenre,tf,searchb);
        
        
        
        center.setStyle("-fx-background-color:   rgb(44, 44,52);");
      
  ////////////// BOTTOM      
        VBox bottom =new VBox();
 
        ScrollBar sbHorizontal = new ScrollBar(); 
       
      bottom.getChildren().addAll(sbHorizontal);
      sbHorizontal.setStyle("-fx-background-color:   rgb(44, 44,52);");
        
//////////////// . RIGHT        

        HBox right =new HBox();

        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);
        right.getChildren().addAll(sbVertical);
        sbVertical.setStyle("-fx-background-color:   rgb(44, 44,52);");
       
        
 //////////////////// search pane       
//      
//  pane.setRight(right);
//      pane.setBottom(bottom);
        pane.setCenter(scrollPane);
        pane.setLeft(left);
        pane.setTop(top);
         
        
//////////////////////////////////////////////////////////////////////// payment pane        
  ////////top      
BorderPane pane_pay   =new BorderPane();

 VBox top_pay=new VBox(10);
Text payd=new Text("   Payment details\n\n\n");
 payd.setFill(rgb(253, 164,0));
 payd.setFont(new javafx.scene.text.Font(20));
 
 ImageView imageView_pay = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/logo_p.PNG"))); 
        imageView_pay.setFitHeight(80);
        imageView_pay.setFitWidth(80);
 

 top_pay.getChildren().addAll(imageView_pay,payd);
 
 
  top_pay.setStyle("-fx-background-color:   rgb(44, 44,52);");
        top_pay.setAlignment(Pos.TOP_LEFT);
        
 //////////////////// center       
        

GridPane center_pay=new GridPane();
 center_pay.setVgap(35); 
    center_pay.setHgap(30);
       

Text l1 = new Text("Name on card *") ;   
    
l1.setFill(rgb(126, 123,120));
l1.setFont(new javafx.scene.text.Font(15));


 TextField tfp = new TextField();  
    
       tfp .setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
       tfp.setPrefWidth(240);
       tfp.setPrefHeight(30);
       
       Text l2 = new Text("Credit card number *") ;   
    
l2.setFill(rgb(126, 123,120));
l2.setFont(new javafx.scene.text.Font(15));
       
 Text l3 = new Text("accepted cards *") ;   
    
l3.setFill(rgb(126, 123,120));
l3.setFont(new javafx.scene.text.Font(15));

TextField tfp2 = new TextField();  
    
       tfp2 .setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
       tfp2.setPrefWidth(240);
       tfp2.setPrefHeight(30);
       
       ImageView imgcard = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/card.Png"))); 
        imgcard.setFitHeight(30);
        imgcard.setFitWidth(100);
       
        
        
        Text l4 = new Text("Security code *") ;   
    
l4.setFill(rgb(126, 123,120));
l4.setFont(new javafx.scene.text.Font(15));

     Text l5 = new Text("Expiration date *") ;   
    
l5.setFill(rgb(126, 123,120));
l5.setFont(new javafx.scene.text.Font(15));    
        
        
        ComboBox mon = new ComboBox();
        mon.getItems().addAll("1", "2", "3", "4","5","6","7","8","9","10","11","12");
        mon.setValue("Month");
        
      mon.setStyle("-fx-base: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
        
        
      
        ComboBox yee = new ComboBox();
        yee.getItems().addAll("24", "25", "26", "27","28","29","30","31","32","33","34","35");
        yee.setValue("Year");
        
      yee.setStyle("-fx-base: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");


      TextField tfp3 = new TextField();  
    
     tfp3 .setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
       tfp3 .setPrefWidth(20);
       tfp3 .setPrefHeight(30);
         
   
       
       ImageView images_pay = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/pay.png"))); 
       images_pay.setFitHeight(50);
       images_pay.setFitWidth(60);
       
       Button pay_button  = new Button("",images_pay);
pay_button.setStyle("-fx-background-color:   rgb(44, 44,52);");

 Button pay_buttonback  = new Button("back");
pay_buttonback .setStyle("-fx-background-color:   rgb(44, 44,52);");
pay_buttonback.setTextFill(  rgb(253, 164,0));
 
center_pay.add(l1,0,0);
center_pay.add(tfp,0, 1);
center_pay.add(l2,0, 2);
center_pay.add(l3,1, 2);
center_pay.add(tfp2,0, 3);
center_pay.add(imgcard,1, 3);
center_pay.add(l4,0, 4);
center_pay.add(l5,1, 4);
center_pay.add(tfp3,0, 5);
center_pay.add(mon,1, 5);
center_pay.add(yee,2, 5);
center_pay.add(pay_button,1, 6);
center_pay.add(pay_buttonback,0, 6);



center_pay.setStyle("-fx-background-color:   rgb(44, 44,52);");
center_pay.setAlignment(Pos.TOP_CENTER);
pane_pay.setCenter(center_pay);
pane_pay.setTop(top_pay);
/////////////////////////////////////////////////////////ADMINISTRATION pane

       
BorderPane pane_add   =new BorderPane();

 VBox top_add=new VBox(10);
Text addmt=new Text("   Add Movie\n\n\n");
 addmt.setFill(rgb(253, 164,0));
 addmt.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));
 
 ImageView imageView_add = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/logo_add.PNG"))); 
        imageView_add.setFitHeight(80);
        imageView_add.setFitWidth(80);
 

 top_add.getChildren().addAll(imageView_add,addmt);
 
 
  top_add.setStyle("-fx-background-color:   rgb(44, 44,52);");
        top_add.setAlignment(Pos.TOP_LEFT);

//////////////////////////center


GridPane addMovie=new GridPane();
addMovie.setVgap(35); 
    addMovie.setHgap(30);

 Text movieIDlb = new Text("Movie ID") ; 

 TextField movieIDtf = new TextField(); 


Text movieNamelb = new Text("Movie Name") ; 

TextField movieNametf = new TextField(); 


Text descriptionlb = new Text("Movie description") ; 

TextArea descriptiontf = new TextArea(); 


Text movieGenrelb = new Text("Movie Genre") ; 
 ComboBox genre = new ComboBox();
        genre.getItems().addAll("Action", "Comedy", "Drama", "Romance","Horror","Science Fiction","Animation","Fantasy","Documentary");
genre.setValue("genre");
Text movieTrailerlb = new Text("URL Movie Trailer ") ; 
TextField movieTrailertf = new TextField(); 



Text posterlb  = new Text("Movie a poster");
TextField postertf = new TextField(); 

//
//Text moviePricelb = new Text("Movie Price") ; 
//TextField moviePricetf = new TextField(); 

Button homeb  = new Button("HOME");
Button addm  = new Button("ADD");
///////////////
addMovie.add(movieIDlb, 1, 0);
addMovie.add(movieIDtf, 1, 1);
   
movieIDlb.setFill(rgb(126, 123,120));
movieIDlb.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));


movieIDtf .setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
movieIDtf .setPrefWidth(240);
      movieIDtf.setPrefHeight(30);
 /////////////////      
addMovie.add(movieNamelb, 1, 2);
addMovie.add(movieNametf, 1, 3);
       
movieNamelb.setFill(rgb(126, 123,120));
movieNamelb.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));

movieNametf.setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
       movieNametf .setPrefWidth(240);
      movieNametf.setPrefHeight(30);
/////////////////      
addMovie.add(descriptionlb, 1, 4);
addMovie.add(descriptiontf, 1, 5);
       
descriptionlb.setFill(rgb(126, 123,120));
descriptionlb.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));

descriptiontf.setStyle("-fx-text-fill: rgb(253, 164,0); -fx-control-inner-background:   rgb(56, 56,59);-fx-background-color:   rgb(56, 56,59);-fx-border-color: rgb(56, 56,59);");
      descriptiontf .setPrefWidth(240);
  descriptiontf.setPrefHeight(100);
 ///////////////////    
addMovie.add(movieTrailerlb, 1, 6);
addMovie.add(movieTrailertf, 1, 7);
      
movieTrailerlb.setFill(rgb(126, 123,120));
movieTrailerlb.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));

movieTrailertf.setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
  movieTrailertf.setPrefWidth(240);
movieTrailertf.setPrefHeight(30);
///////////////////




addMovie.add(postertf, 2, 7);

addMovie.add(posterlb, 2, 6);
posterlb.setFill(rgb(126, 123,120));
posterlb.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));

postertf.setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
 postertf.setPrefWidth(240);
postertf.setPrefHeight(30);
/////////////////
 addMovie.add(genre, 2, 3);
genre.setStyle("-fx-base: rgb(253, 164,0);-fx-background-color:rgb(56, 56,59);-fx-text-fill: rgb(253, 164,0);");
///////////////

addMovie.add(homeb , 1, 8);
homeb.setStyle("-fx-background-color:   rgb(44, 44,52); ");
homeb.setTextFill(  rgb(253, 164,0));
/////////////////
addMovie.add(addm , 2, 8);

addm .setStyle("-fx-background-color:   rgb(44, 44,52);");
addm .setTextFill(  rgb(253, 164,0));




addMovie.setAlignment(Pos.TOP_CENTER);
addMovie.setStyle("-fx-background-color:   rgb(44, 44,52);");



pane_add.setTop(top_add);
pane_add.setCenter(addMovie);


//////////////////////////////////////////////////password pane
BorderPane password_pane= new BorderPane();

VBox psswordvb =new VBox(30);
psswordvb.setPadding(new Insets(20,100,20,100));
Text past  = new Text("Enter the password");
past.setFill(rgb(126, 123,120));
past.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));

PasswordField pastf = new PasswordField(); 
pastf.setPrefWidth(20);
pastf.setPrefHeight(30);
pastf.setStyle("-fx-text-fill: rgb(253, 164,0); -fx-background-color:   rgb(56, 56,59);");
Button pasb = new Button("Enter");
Button pasbackhom = new Button("home");

psswordvb.setAlignment(Pos.CENTER);
psswordvb.getChildren().addAll(past,pastf,pasb,pasbackhom);
pasb.setStyle("-fx-background-color:   rgb(44, 44,52); ");
pasb.setTextFill(  rgb(253, 164,0));
 pasbackhom.setStyle("-fx-background-color:   rgb(44, 44,52); ");
 pasbackhom.setTextFill(  rgb(253, 164,0));


 psswordvb.setStyle("-fx-background-color:   rgb(44, 44,52);");
 password_pane.setCenter(psswordvb);
////////////////////////////////////////////////////////////////aboutus
 BorderPane paneAboutUs = new BorderPane();
        paneAboutUs.setPadding(new Insets(0, 10, 10, 10));
        
        HBox TopAbotUs = new HBox ();
        TopAbotUs.setPadding(new Insets(20, 15, 15, 15));
        ImageView logoaboutUs = new ImageView(new Image(new FileInputStream("/Users/janawalaa/Desktop/logoaboutus.PNG")));
        TopAbotUs.setAlignment(Pos.CENTER);
        logoaboutUs.setFitHeight(250);
        logoaboutUs.setFitWidth(280);
        TopAbotUs.getChildren().add(logoaboutUs);
        
        VBox CenterAboutUs = new VBox (10);
        CenterAboutUs.setPadding(new Insets(10, 15, 15, 15));
        //CenterAboutUs.setAlignment(Pos.CENTER);
        
        HBox t1AU = new HBox (0);
        Text t11 = new Text ("'About Us'");
        t11.setFill(Color.web("#FEA401"));
        t11.setFont(Font.font("Trebuchet MS", 30));
        t1AU.setAlignment(Pos.CENTER);
        t1AU.getChildren().add(t11);
        
         //StackPane t2AU = new StackPane();
        //stackPane.getChildren().add(text);
        
        VBox t2AU = new VBox (0);
        Text t12 = new Text ("  We are computer science students,"
                + "\n and we have worked together to complete a project "
                + "\n for the Advanced Programming course. Our project idea is "
                + "\n 'FLIX-TIX' which is a movie reservation application for "
                + "\n cinema. Through this application, users can create an "
                + "\n account, log in, explore the available movies, and reserve "
                + "\n a film with the option for electronic payment.");
        
        t12.setTextAlignment(TextAlignment.CENTER);
        //t12.setStyle("-fx-text-fill:rgb(126, 123, 120); -fx-font-size: 20px; -fx-font-weight: bold; -fx-alignment: Center");
        t12.setFill(Color.rgb(126, 123, 120));
        t12.setFont(Font.font("Trebuchet MS", 20));
        t2AU.setAlignment(Pos.CENTER);
        t2AU.getChildren().add(t12);

        CenterAboutUs.getChildren().addAll(t1AU,t2AU);
        
        
        HBox BottomAbotUs = new HBox ();
        BottomAbotUs.setPadding(new Insets(15, 15, 15, 15));
        Button backAU = new Button("Back");
        BottomAbotUs.getChildren().addAll(backAU);
        backAU.setStyle("-fx-text-fill: #FEA401; -fx-background-color:   rgb(44, 44,52); -fx-font-size: 13; -fx-font-weight: bold;");
        
        paneAboutUs.setStyle("-fx-background-color:   rgb(44, 44,52);");
        
        paneAboutUs.setTop(TopAbotUs);
        paneAboutUs.setCenter(CenterAboutUs);
        paneAboutUs.setBottom(BottomAbotUs);
          var scene_AboutUs = new Scene(paneAboutUs, 625, 700);
//////////////////////////////////////////////////////////afnan code

        Text textCHpage = new Text("Booking");
        textCHpage.setFill(Color.web("#FEA401"));
        textCHpage.setFont(Font.font("Trebuchet MS", 20));

        StackPane stackPane0 = new StackPane();
        stackPane0.setAlignment(Pos.CENTER);
        stackPane0.getChildren().add(textCHpage);
        StackPane.setMargin(textCHpage, new javafx.geometry.Insets(0, 0, 0, 0));

        Text textScreen = new Text("SCREEN");
        Rectangle rect1 = new Rectangle();
        rect1.setWidth(350);
        rect1.setHeight(85);
        rect1.setStroke(Color.web("#FEA401"));
        rect1.setFill(Color.rgb(220, 240, 255));

        StackPane stackPane1 = new StackPane();
        stackPane1.setAlignment(Pos.CENTER);
        stackPane1.getChildren().addAll(rect1, textScreen);
        StackPane.setMargin(textScreen, new javafx.geometry.Insets(0, 0, 0, 0));

        BorderPane pane0 = new BorderPane();
        pane0.setTop(stackPane0);
        pane0.setCenter(stackPane1);
        BorderPane.setMargin(stackPane1, new Insets(15, 0, 0, 0));

        HBox hBox1CH = new HBox(45);
        hBox1CH.setPadding(new Insets(10, 10, 10, 10));
        Button backSCofCH = new Button("Back");
        hBox1CH.setAlignment(Pos.CENTER);
        hBox1CH.getChildren().add(pane0);

        HBox hBox2CH = new HBox(60);
        hBox2CH.setPadding(new Insets(0, 0, 0, 0));
        Image imageCH1 = new Image(new FileInputStream("/Users/janawalaa/Desktop/logoaboutus.PNG"));
        ImageView imageView0 = new ImageView(imageCH1);
        imageView0.setFitWidth(60);
        imageView0.setFitHeight(60);
        hBox2CH.getChildren().add(imageView0);

        Image imageCH2 = new Image(new FileInputStream("/Users/janawalaa/Desktop/Ci chair2.png"));
        ImageView imageView1CH = new ImageView(imageCH2);
        imageView1CH.setFitWidth(35);
        imageView1CH.setFitHeight(35);
        ImageView imageView2CH = new ImageView(imageCH2);
        imageView2CH.setFitWidth(35);
        imageView2CH.setFitHeight(35);
        ImageView imageView3CH = new ImageView(imageCH2);
        imageView3CH.setFitWidth(35);
        imageView3CH.setFitHeight(35);
        ImageView imageView4CH = new ImageView(imageCH2);
        imageView4CH.setFitWidth(35);
        imageView4CH.setFitHeight(35);
        ImageView imageView5CH = new ImageView(imageCH2);
        imageView5CH.setFitWidth(35);
        imageView5CH.setFitHeight(35);
        ImageView imageView6CH = new ImageView(imageCH2);
        imageView6CH.setFitWidth(35);
        imageView6CH.setFitHeight(35);
        ImageView imageView7CH = new ImageView(imageCH2);
        imageView7CH.setFitWidth(35);
        imageView7CH.setFitHeight(35);
        ImageView imageView8CH = new ImageView(imageCH2);
        imageView8CH.setFitWidth(35);
        imageView8CH.setFitHeight(35);
        ImageView imageView9CH = new ImageView(imageCH2);
        imageView9CH.setFitWidth(35);
        imageView9CH.setFitHeight(35);
        ImageView imageView10CH = new ImageView(imageCH2);
        imageView10CH.setFitWidth(35);
        imageView10CH.setFitHeight(35);
        ImageView imageView11CH = new ImageView(imageCH2);
        imageView11CH.setFitWidth(35);
        imageView11CH.setFitHeight(35);
        ImageView imageView12CH = new ImageView(imageCH2);
        imageView12CH.setFitWidth(35);
        imageView12CH.setFitHeight(35);
        ImageView imageView13CH = new ImageView(imageCH2);
        imageView13CH.setFitWidth(35);
        imageView13CH.setFitHeight(35);
        ImageView imageView14CH = new ImageView(imageCH2);
        imageView14CH.setFitWidth(35);
        imageView14CH.setFitHeight(35);
        ImageView imageView15CH = new ImageView(imageCH2);
        imageView15CH.setFitWidth(35);
        imageView15CH.setFitHeight(35);
        ImageView imageView16CH = new ImageView(imageCH2);
        imageView16CH.setFitWidth(35);
        imageView16CH.setFitHeight(35);
        ImageView imageView17CH = new ImageView(imageCH2);
        imageView17CH.setFitWidth(35);
        imageView17CH.setFitHeight(35);
        ImageView imageView18CH = new ImageView(imageCH2);
        imageView18CH.setFitWidth(35);
        imageView18CH.setFitHeight(35);
        ImageView imageView19CH = new ImageView(imageCH2);
        imageView19CH.setFitWidth(35);
        imageView19CH.setFitHeight(35);
        ImageView imageView20CH = new ImageView(imageCH2);
        imageView20CH.setFitWidth(35);
        imageView20CH.setFitHeight(35);

        Label seattext = new Label("Choose the Seat ");

        CheckBox A1TB = new CheckBox("A1");
        A1TB.setGraphic(imageView1CH);
        CheckBox A2TB = new CheckBox("A2");
        A2TB.setGraphic(imageView2CH);
        CheckBox A3TB = new CheckBox("A3");
        A3TB.setGraphic(imageView3CH);
        CheckBox A4TB = new CheckBox("A4");
        A4TB.setGraphic(imageView4CH);
        CheckBox A5TB = new CheckBox("A5");
        A5TB.setGraphic(imageView5CH);

        CheckBox B1TB = new CheckBox("B1");
        B1TB.setGraphic(imageView6CH);
        CheckBox B2TB = new CheckBox("B2");
        B2TB.setGraphic(imageView7CH);
        CheckBox B3TB = new CheckBox("B3");
        B3TB.setGraphic(imageView8CH);
        CheckBox B4TB = new CheckBox("B4");
        B4TB.setGraphic(imageView9CH);
        CheckBox B5TB = new CheckBox("B5");
        B5TB.setGraphic(imageView10CH);

        CheckBox C1TB = new CheckBox("C1");
        C1TB.setGraphic(imageView11CH);
        CheckBox C2TB = new CheckBox("C2");
        C2TB.setGraphic(imageView12CH);
        CheckBox C3TB = new CheckBox("C3");
        C3TB.setGraphic(imageView13CH);
        CheckBox C4TB = new CheckBox("C4");
        C4TB.setGraphic(imageView14CH);
        CheckBox C5TB = new CheckBox("C5");
        C5TB.setGraphic(imageView15CH);

        CheckBox D1TB = new CheckBox("D1");
        D1TB.setGraphic(imageView16CH);
        CheckBox D2TB = new CheckBox("D2");
        D2TB.setGraphic(imageView17CH);
        CheckBox D3TB = new CheckBox("D3");
        D3TB.setGraphic(imageView18CH);
        CheckBox D4TB = new CheckBox("D4");
        D4TB.setGraphic(imageView19CH);
        CheckBox D5TB = new CheckBox("D5");
        D5TB.setGraphic(imageView20CH);

        Label theday = new Label("Set the Day ");
        DatePicker date = new DatePicker();

        date.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.isBefore(LocalDate.now())) {
                date.setValue(LocalDate.now());
            }
        });

        Label timetext = new Label("Choose the Time ");
//        ChoiceBox timechoices = new ChoiceBox();
//        timechoices.getItems().addAll("9:30AM", "1:00PM", "4:30PM", "7:00PM", "10:40PM");
        ComboBox timechoices = new ComboBox();
        timechoices.getItems().addAll("9:30AM", "1:00PM", "4:30PM", "7:00PM", "10:40PM");  
        
        
        Button CancelCH = new Button("Cancel");
        Button NextCH = new Button("Next");

        GridPane gridPane1 = new GridPane();
        gridPane1.setMinSize(10, 10);
        gridPane1.setPadding(new Insets(5, 5, 5, 25));
        gridPane1.setVgap(5);
        gridPane1.setHgap(15);
        //gridPane1.setAlignment(Pos.CENTER);

        GridPane gridPane2 = new GridPane();
        gridPane2.setMinSize(10, 10);
        gridPane2.setPadding(new Insets(0, 5, 5, 0));
        gridPane2.setVgap(20);
        gridPane2.setHgap(18);
        gridPane2.setAlignment(Pos.CENTER);
        Region leftRegion = new Region();
        gridPane1.add(leftRegion, 1, 1);

        GridPane gridPane3 = new GridPane();
        gridPane3.setMinSize(10, 10);
        gridPane3.setPadding(new Insets(5, 5, 5, 0));
        gridPane3.setVgap(18);
        gridPane3.setHgap(15);
        gridPane3.setAlignment(Pos.CENTER);

        gridPane3.add(theday, 0, 0);
        gridPane3.add(date, 1, 0);
        gridPane3.add(timetext, 0, 1);
        gridPane3.add(timechoices, 1, 1);
        gridPane3.add(CancelCH, 1, 2);
        gridPane3.add(NextCH, 2, 2);

        gridPane2.add(A1TB, 0, 1);
        gridPane2.add(A2TB, 1, 1);
        gridPane2.add(A3TB, 2, 1);
        gridPane2.add(A4TB, 3, 1);
        gridPane2.add(A5TB, 4, 1);

        gridPane2.add(B1TB, 0, 2);
        gridPane2.add(B2TB, 1, 2);
        gridPane2.add(B3TB, 2, 2);
        gridPane2.add(B4TB, 3, 2);
        gridPane2.add(B5TB, 4, 2);

        gridPane2.add(C1TB, 0, 3);
        gridPane2.add(C2TB, 1, 3);
        gridPane2.add(C3TB, 2, 3);
        gridPane2.add(C4TB, 3, 3);
        gridPane2.add(C5TB, 4, 3);

        gridPane2.add(D1TB, 0, 4);
        gridPane2.add(D2TB, 1, 4);
        gridPane2.add(D3TB, 2, 4);
        gridPane2.add(D4TB, 3, 4);
        gridPane2.add(D5TB, 4, 4);

        gridPane1.add(seattext, 2, 0);
        gridPane1.add(gridPane2, 2, 1);
        gridPane1.add(gridPane3, 2, 2);
        gridPane1.add(backSCofCH, 2, 3);

        BorderPane paneCH = new BorderPane();
        paneCH.setPadding(new Insets(10, 20, 10, 20));

        ///////style//////////////////////////////////
        textScreen.setFont(new Font("Trebuchet MS", 18));
        backSCofCH.setStyle("-fx-text-fill: #FEA401; -fx-background-color:   rgb(44, 44,52); -fx-font-size: 13; -fx-font-weight: bold;");

        seattext.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 18; -fx-font-weight: bold;");
        seattext.setAlignment(Pos.CENTER);

        A1TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        A2TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        A3TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        A4TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        A5TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        B1TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        B2TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        B3TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        B4TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        B5TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        C1TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        C2TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        C3TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        C4TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        C5TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        D1TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        D2TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        D3TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        D4TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");
        D5TB.setStyle("-fx-text-fill: white; -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        theday.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 18; -fx-font-weight: bold;");

        timetext.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 18; -fx-font-weight: bold;");
        timechoices.setStyle("-fx-base: rgb(253, 164,0); -fx-background-color: #fce9c9; -fx-font-weight: bold;");
        date.setStyle("-fx-base: rgb(253, 164,0); -fx-background-color: white; -fx-font-weight: bold;");
        
        CancelCH.setStyle("-fx-text-fill: #FEA401;-fx-background-color:   rgb(44, 44,52); -fx-font-size: 13; -fx-font-weight: bold");
        NextCH.setStyle("-fx-text-fill: #FEA401; -fx-background-color:   rgb(44, 44,52); -fx-font-size: 13; -fx-font-weight: bold");

        paneCH.setStyle("-fx-background-color:   rgb(44, 44,52);");

        //////////////////////////////////////////////////
        List<String> selectedChairs = new ArrayList<>();

        //the price
        Label totalPriceLabel = new Label("Total Price: $" +  String.valueOf(totalPrice));
        totalPriceLabel.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        Label seatNUM = new Label("the Seat Number: ");
        seatNUM.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        Label selectedDayLabel = new Label("Selected Day:");
        selectedDayLabel.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        Label selectedTimeLabel = new Label("Selected Time:");
        selectedTimeLabel.setStyle("-fx-text-fill: rgb(126, 123, 120); -fx-font-family: 'Trebuchet MS'; -fx-font-size: 14; -fx-font-weight: bold;");

        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        
        
        
        Booking booking = new Booking();
        
        Query<Integer> maxBookingIdQuery = session.createQuery("SELECT MAX(b.bookingID) FROM Booking b", Integer.class);
        Integer maxBookingId = maxBookingIdQuery.uniqueResult();


        int newBookingId = ((maxBookingId != null) ? maxBookingId + 1 : 1);
        booking.setBookingID(newBookingId);

        
EventHandler<ActionEvent> seatSelectionHandler = e -> {
    CheckBox selectedSeat = (CheckBox) e.getSource();
    String seatName = selectedSeat.getText();

    if (selectedSeat.isSelected()) {
        selectedChairs.add(seatName);
        totalPrice += basePrice;
    } else {
        selectedChairs.remove(seatName);
        totalPrice -= basePrice;
    }

    for (String selectedChair : selectedChairs) {

        booking.setMovieprice("Total Price: $" + String.valueOf(basePrice));
        booking.setSeatNum("Seat Number: " + selectedChair);


        int savedBookingId = (Integer) session.save(booking);
        System.out.println("Inserted Booking with ID: " + savedBookingId);


        booking.setMovieprice("Total Price: $" + String.valueOf(totalPrice));
        booking.setSeatNum(String.join(", ", selectedChairs));

        session.update(booking);
        
    }

    String selectedChairsString = String.join(", ", selectedChairs);
    String pricestring = "Total Price: $" + String.valueOf(totalPrice);
    totalPriceLabel.setText(pricestring);
    seatNUM.setText("the Seat Number: " + " (" + selectedChairsString + ")");
};

        A1TB.setOnAction(seatSelectionHandler);
        A2TB.setOnAction(seatSelectionHandler);
        A3TB.setOnAction(seatSelectionHandler);
        A4TB.setOnAction(seatSelectionHandler);
        A5TB.setOnAction(seatSelectionHandler);

        B1TB.setOnAction(seatSelectionHandler);
        B2TB.setOnAction(seatSelectionHandler);
        B3TB.setOnAction(seatSelectionHandler);
        B4TB.setOnAction(seatSelectionHandler);
        B5TB.setOnAction(seatSelectionHandler);

        C1TB.setOnAction(seatSelectionHandler);
        C2TB.setOnAction(seatSelectionHandler);
        C3TB.setOnAction(seatSelectionHandler);
        C4TB.setOnAction(seatSelectionHandler);
        C5TB.setOnAction(seatSelectionHandler);

        D1TB.setOnAction(seatSelectionHandler);
        D2TB.setOnAction(seatSelectionHandler);
        D3TB.setOnAction(seatSelectionHandler);
        D4TB.setOnAction(seatSelectionHandler);
        D5TB.setOnAction(seatSelectionHandler);

        //select date and time 
        date.setOnAction(e -> {
            LocalDate selectedDate = date.getValue();
            //String dateString1 = selectedDate.toString();
            selectedDayLabel.setText("Selected Day: " + selectedDate.getDayOfWeek() + " (" + selectedDate.toString() + ")");

            booking.setDate(selectedDate.toString());
           
            
            
            session.update(booking);
            tx.commit();
            System.out.print("--->" + selectedDate.toString());
            System.out.println("Updated Date: " + booking.getDate());
        });

        timechoices.setOnAction(e -> {           
                       
                selectedTimeLabel.setText("Selected Time: " + timechoices.getValue().toString());
            booking.setTime("3:30");            
            
                 
                });

        
        VBox vBoxSelectedInfo1 = new VBox(5);
        vBoxSelectedInfo1.setAlignment(Pos.CENTER_LEFT);
        vBoxSelectedInfo1.getChildren().addAll(selectedDayLabel, selectedTimeLabel);

        VBox vBoxSelectedInfo2 = new VBox(5);
        vBoxSelectedInfo2.setAlignment(Pos.CENTER_LEFT);
        vBoxSelectedInfo2.getChildren().addAll(totalPriceLabel, seatNUM);

        HBox hBoxTotalPrice = new HBox(10);
        hBoxTotalPrice.setAlignment(Pos.CENTER);
        hBoxTotalPrice.getChildren().addAll(hBox2CH, vBoxSelectedInfo1, vBoxSelectedInfo2);

        //null selected 
        EventHandler<ActionEvent> cancelHandler = e -> {

            selectedChairs.clear();

            A1TB.setSelected(false);
            A2TB.setSelected(false);
            A3TB.setSelected(false);
            A4TB.setSelected(false);
            A5TB.setSelected(false);
            B1TB.setSelected(false);
            B2TB.setSelected(false);
            B3TB.setSelected(false);
            B4TB.setSelected(false);
            B5TB.setSelected(false);
            C1TB.setSelected(false);
            C2TB.setSelected(false);
            C3TB.setSelected(false);
            C4TB.setSelected(false);
            C5TB.setSelected(false);
            D1TB.setSelected(false);
            D2TB.setSelected(false);
            D3TB.setSelected(false);
            D4TB.setSelected(false);
            D5TB.setSelected(false);

            date.setValue(null);

            timechoices.getSelectionModel().clearSelection();

            totalPrice = 0;
            String selectedChairsString = "";
            totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
            seatNUM.setText("the Seat Number: " + " (" + selectedChairsString + ")");
            selectedDayLabel.setText("Selected Day:");
            selectedTimeLabel.setText("Selected Time:");

        };
        
        CancelCH.setOnAction(cancelHandler);

        ///////////////////////////////////////////////
        paneCH.setTop(hBox1CH);
        paneCH.setCenter(gridPane1);
        paneCH.setBottom(hBoxTotalPrice);

///////////////////////////////////////////////////DB/////////////////////////////////////////////////
        Seatscene = new Scene(paneCH, 625, 700);

////////////////////////////////////////////////////////////////sozan code
 
     
        ////////// Log In Page
        FlowPane logInPage = new FlowPane(Orientation.VERTICAL);
        logInPage.setPadding(new Insets(85, 0, 50, 0));
        logInPage.setVgap(25);
        
        VBox vBoxEmailLogIn = new VBox(5);
        VBox vBoxPasswordLogIn = new VBox(5);
        VBox massegeLogIn = new VBox();
        
        
        Scene scene = new Scene(logInPage, 625, 700);
        
      
        Image logo = new Image(new FileInputStream("/Users/janawalaa/Desktop/logolog.PNG"));
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(176);
        logoView.setFitWidth(249);
        
        
        Text welcomeMassege = new Text("Welcome to Cinema Flix-Tix! Go to Log In");
        
        
        Text emailLogIn = new Text("Email :");
        TextField emailTextFieldLogIn = new TextField();
        emailTextFieldLogIn.setPromptText("Enter your email");
               
        vBoxEmailLogIn.getChildren().addAll(emailLogIn, emailTextFieldLogIn);
        
         
        Text passwordLogIn = new Text("Password :");
        PasswordField passwordFieldLogIn = new PasswordField();
        passwordFieldLogIn.setPromptText("Enter your password");
        
        
        
        vBoxPasswordLogIn.getChildren().addAll(passwordLogIn, passwordFieldLogIn);
        
        
        Button buttonLogIn = new Button("Log In");
        buttonLogIn.setMaxWidth(100);
        buttonLogIn.setTranslateX(80);
           
        
        Button buttonSignUpPage = new Button("Sign Up");
        buttonSignUpPage.setMaxWidth(100);
        buttonSignUpPage.setTranslateX(80);
       
        Text massege1 = new Text("");
        
        massegeLogIn.getChildren().add(massege1);
        massegeLogIn.setAlignment(Pos.CENTER);
        
        logInPage.getChildren().addAll(logoView, welcomeMassege, vBoxEmailLogIn, vBoxPasswordLogIn, buttonLogIn, buttonSignUpPage, massegeLogIn);
        
        
        
        
        
       
        
        ////////// Sign Up Page
        FlowPane signUpPage = new FlowPane(Orientation.VERTICAL);
        signUpPage.setPadding(new Insets(50));
        signUpPage.setVgap(25);
        
        VBox vBoxFNameSignUp = new VBox(5);
        VBox vBoxLNameSignUp = new VBox(5);
        VBox vBoxEmailSignUp = new VBox(5);
        VBox vBoxPasswordSignUp = new VBox(5);
        VBox vBoxDateSignUp = new VBox(5);
        VBox vBoxPhoneNumSignUp = new VBox(5);
        VBox massegSignUp = new VBox();
        
        
        Button backToLogInPage = new Button("Back");
        backToLogInPage.setTranslateX(345);
        backToLogInPage.setTranslateY(-40);
        
        
        Text JoinMassege = new Text("Join to us, Go to Sign Up");
        
        
        Text FNameSignUp = new Text("*First Name : ");
        TextField FNameSignUpTextField = new TextField();
        FNameSignUpTextField.setPromptText("Enter your first name");
        
        vBoxFNameSignUp.getChildren().addAll(FNameSignUp, FNameSignUpTextField);
               
                
        Text LNameSignUp = new Text("Last Name : \"Not request\" ");
        TextField LNameSignUpTextField = new TextField();
        LNameSignUpTextField.setPromptText("Enter your last name");
        
        vBoxLNameSignUp.getChildren().addAll(LNameSignUp, LNameSignUpTextField);
        
        
        Text emailSignUp = new Text("*Email :");
        TextField emailSignUpTxField = new TextField();
        emailSignUpTxField.setPromptText("Enter your email");
        
        vBoxEmailSignUp.getChildren().addAll(emailSignUp, emailSignUpTxField);
         
        
        Text passwordSignUp = new Text("*Password :");
        PasswordField passwordSignUpField = new PasswordField();
        passwordSignUpField.setPromptText("Enter your password");
       
        vBoxPasswordSignUp.getChildren().addAll(passwordSignUp, passwordSignUpField);
        
        
        Text dateOfBirthSignUp = new Text("*Date of birth : ");
        DatePicker dateSignUp = new DatePicker(); 
  
        vBoxDateSignUp.getChildren().addAll(dateOfBirthSignUp, dateSignUp);
        
        
        Text phoneNumSignUp = new Text("*Phone Number : ");
        TextField phoneNumSignUpTextField = new TextField();
        phoneNumSignUpTextField.setPromptText("0588888888");
        
        vBoxPhoneNumSignUp.getChildren().addAll(phoneNumSignUp, phoneNumSignUpTextField);
               
        
        Button buttonSignUp = new Button("Sign Up");
        buttonSignUp.setMaxWidth(100);
        buttonSignUp.setTranslateX(35);
        
  
        Text massege2 = new Text();
        
        massegSignUp.getChildren().add(massege2);
        massegSignUp.setAlignment(Pos.CENTER);
        
        
        signUpPage.getChildren().addAll(backToLogInPage, JoinMassege, vBoxFNameSignUp, vBoxLNameSignUp, vBoxEmailSignUp, vBoxPasswordSignUp, vBoxDateSignUp, vBoxPhoneNumSignUp, buttonSignUp, massegSignUp);
        
        
        
        
        
        
        
        ////////// CSS
        
        //// CSS Log In Page
        welcomeMassege.setFill(Color.WHITE);
        welcomeMassege.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 14));
       
        emailLogIn.setFill(Color.WHITE);
        emailLogIn.setFont(Font.font("Trebuchet MS", 12));
        
        emailTextFieldLogIn.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        passwordLogIn.setFill(Color.WHITE);
        passwordLogIn.setFont(Font.font("Trebuchet MS", 12));
        
        passwordFieldLogIn.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        buttonLogIn.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
        
        buttonSignUpPage.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
        
        massege1.setFill(Color.BURLYWOOD);
        massege1.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));
                
        logInPage.setStyle("-fx-background-color: linear-gradient(from 30% 45% to 100% 100%, #2C2C34, #FEA401)");
        logInPage.setAlignment(Pos.CENTER);
        
        
        //// CSS Sign Up Page
        backToLogInPage.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #FEA401;");
        
        JoinMassege.setFill(Color.WHITE);
        JoinMassege.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 14));
        
        FNameSignUp.setFill(Color.WHITE);
        FNameSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        FNameSignUpTextField.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        LNameSignUp.setFill(Color.WHITE);
        LNameSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        LNameSignUpTextField.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        emailSignUp.setFill(Color.WHITE);
        emailSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        emailSignUpTxField.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        passwordSignUp.setFill(Color.WHITE);
        passwordSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        passwordSignUpField.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        dateOfBirthSignUp.setFill(Color.WHITE);
        dateOfBirthSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        dateSignUp.setStyle("-fx-control-inner-background : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        phoneNumSignUp.setFill(Color.WHITE);
        phoneNumSignUp.setFont(Font.font("Trebuchet MS", 12));
        
        phoneNumSignUpTextField.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #7C7C7C;");
        
        buttonSignUp.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
        
        massege2.setFill(Color.BURLYWOOD);
        massege2.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 15));
        
        signUpPage.setStyle("-fx-background-color: linear-gradient(from 30% 45% to 100% 100%, #2C2C34, #FEA401)");
        signUpPage.setAlignment(Pos.CENTER);
        
        
////////////////////////////////////////////////////////////////////////////////////////////////events

       Scene search_scene = new Scene(pane,625, 700);
       
//  
//       
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    Transaction tx = session.beginTransaction();

         List<User> users ;
         
          User user = new User();
 Query qu = session.createQuery("From User");      
 users = qu.list();
 
   System.out.println("student list size: " + users.size());


//        emailTextFieldLogIn
//        passwordFieldLogIn 
        
       

//////////////////////////////////////////////////////////////////////mayasem codr
        
       // ImageView imageView = new ImageView(new Image(new FileInputStream("C:\\Users\\maiil\\Downloads\\icons8-customer-16.png")));
        //imageView.setFitHeight(25);
        //imageView.setFitWidth(25);
    BorderPane allContent = new BorderPane();
        allContent.setPadding(new Insets(30));
        
        VBox vbProfile = new VBox();
        
        Label profilee = new Label("Profile");
        
        vbProfile.getChildren().add(profilee);
        vbProfile.setAlignment(Pos.CENTER);
        allContent.setTop(vbProfile);
        
        
        //Label for name , Email ,  PhoneNumber and Text field for them
        Label FirstName = new Label("First Name*");
        TextField Firstname = new TextField();
        Firstname.setPromptText("Enter your first name..");

        Label LastName = new Label("Last Name*");
        TextField Lastname = new TextField();
        Lastname.setPromptText("Enter your last name..");

        Label pass = new Label("Password*");
        TextField pas = new TextField();
        
        //Label for date of birth and date picker to choose date
        Label dobLabel = new Label("Date of birth*");
        DatePicker datePicker = new DatePicker();
       
        //Label Settings = new Label("Settings : ");

        GridPane gridPane = new GridPane();
        // gridPane.setMinSize(500, 500);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);

        //Add all UI controls to the gridPane
        //gridPane.add(profile, 0, 0);
        gridPane.add(FirstName, 1, 1);
        gridPane.add(Firstname, 2, 1);
        gridPane.add(LastName, 1, 2);
        gridPane.add(Lastname, 2, 2);
        gridPane.add(pass, 1, 3);
        gridPane.add(pas, 2, 3);

        gridPane.add(dobLabel, 1, 4);
        gridPane.add(datePicker, 2, 4);
       
        allContent.setCenter(gridPane);
        
//        .("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
        HBox allButtons = new HBox(40);
        
        Button delete = new Button("Delete");
        Button logOut = new Button("Log Out");
        Button update = new Button("Update");
        Button backHome = new Button("Back");
      Firstname.setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
       Lastname.setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
        pas.setStyle("-fx-text-fill: rgb(253, 164,0);-fx-background-color:   rgb(56, 56,59);");
       
         
        allButtons.getChildren().addAll(delete, logOut, update, backHome);
        allButtons.setAlignment(Pos.CENTER);
        allContent.setBottom(allButtons);
        

        //Styling the Form
        profilee.setTextFill(Color.ORANGE);
        profilee.setStyle("-fx-font: normal bold 20px 'Trebuchet MS'");
        //Settings.setTextFill(Color.WHITE);
        //  buttonSave.setStyle("-fx-background-color:white  ; -fx-textfill: white;");
        FirstName.setTextFill(Color.WHITE);
        FirstName.setStyle("-fx-font: normal bold 15px 'Trebuchet MS'");
        LastName.setTextFill(Color.WHITE);
        LastName.setStyle("-fx-font: normal bold 15px 'Trebuchet MS'");
        pass.setTextFill(Color.WHITE);
        pass.setStyle("-fx-font: normal bold 15px 'Trebuchet MS'");
        dobLabel.setTextFill(Color.WHITE);
        dobLabel.setStyle("-fx-font: normal bold 15px 'Trebuchet MS'");

//        Settings.setTextFill(Color.WHITE);
//        Settings.setStyle("-fx-font: normal bold 15px 'Trebuchet MS'");
//        
        delete.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #FEA401;");
        logOut.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #FEA401;");
       update.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #FEA401;");
        backHome.setStyle("-fx-background-color : #2C2C34; -fx-text-fill : #FEA401;");
        

        allContent.setStyle("-fx-background-color: #2C2C34");
        
        
        
        
        Scene sceneacc = new Scene(allContent,  700, 625);
        
 /////////////////////////////////////////////////////////  M   end  
        
homeb.setOnAction(e-> { stage.setScene(search_scene)  ;  });

///////add movie event


ArrayList <Label> movielable =new ArrayList <>();

  
        
//       
//Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();

Movie s = new Movie();
List <Movie> mlist;
      

 


String querystr="from Movie";
Query query = session.createQuery(querystr); 
mlist = query.list();

System.out.println("Movielist size: "+mlist.size());

for(Movie m: mlist){
 
     movielable.add(toLabel(m.getMoviePoster(),m.getMovieName()));

} 

// List<Movie> getmlist= mlist   ;
 


/////////////////////////// add movie event      
        

addm.setOnAction(e-> {   
   

s.setMovieID(Integer.parseInt(movieIDtf.getText()));  ////string to int
s.setMovieName(movieNametf.getText());
s.setDescription(descriptiontf.getText());
s.setMovieTrailer(movieTrailertf.getText());
s.setMoviePoster(postertf.getText());

s.setMovieGenre((String) genre.getValue());

int sId2 = (Integer) session.save(s);
tx.commit();


System.out.println("inserted movie: "+s.getMovieName());

   movielable.add(toLabel(s.getMoviePoster(),s.getMovieName()));
  


  
movieNametf.clear();
movieIDtf.clear();
movieTrailertf.clear();
postertf.clear();
descriptiontf.clear();

center.getChildren().clear();
 for(Label l:movielable){
 
       center.getChildren().addAll(l);
    if(!movielable.contains(l)){
    
    movielable.add(l);
    
    }
       
       
}    

});


 for(Label l:movielable){
  
       center.getChildren().addAll(l);
    
}            
   
  
///////////////////////////////////////// movie page

Button f= new Button();
 f.setOnAction(e-> { stage.setScene(search_scene)  ;        });
 
 Button bokb= new Button();
 bokb.setOnAction(e-> { stage.setScene(Seatscene)  ;        });
 
 
 for(Label l:movielable) {

     l .setOnMousePressed (e-> {  


         int t= movielable.indexOf(l);
  
    String dis= mlist.get(t).getDescription() ;  
     
     String gen= mlist.get(t).getMovieGenre();
     String trel= mlist.get(t).getMovieTrailer();
     String poster= mlist.get(t).getMoviePoster();
     String name= mlist.get(t).getMovieName();
      
//    toscene (Button f,String dis,String gen,String trel,String name,String poster)
       backSCofCH.setOnAction(event-> {  stage.setScene(toscene(f,dis,gen,trel,name,poster,bokb))  ;  }); 
        stage.setScene(toscene(f,dis,gen,trel,name,poster,bokb))  ; 
        
        
  });
           }
 
 

 

 ///////////////////////////////////////////// search event
// tosceneSearch
List<Label>shSh=movielable;
 
List<Label>shlab=new ArrayList <>();
 
 Button q= new Button();
 q.setOnAction(e-> { stage.setScene(search_scene)  ;    
 shlab.clear();
 tf.clear();
 });
 
search_scene.setOnKeyPressed(e -> {

            if (e.getCode().equals(KeyCode.ENTER)) 
            {
    
center.getChildren().clear();

 for(Label l:movielable){

center.getChildren().addAll(l);
            }

          }});
 
        
        
 searchb.setOnAction(e -> {

     String movieName = tf.getText();
 center.getChildren().clear();

 for(Label l:movielable){
  
     
     for (Movie d:mlist) {
    
            if (d.getMovieGenre().equals(searchgenre.getValue().toString())&& movieName.isEmpty()){
             if (!center.getChildren().contains(movielable.get(mlist.indexOf(d)))) {    
                
         center.getChildren().addAll(movielable.get(mlist.indexOf(d)));
            }
           
           
            }

      }
 
         
       
  if(movieName.isEmpty()) {
      return;
      } 
       
        
  if (l.getText().contains(movieName)) {   
//    center.getChildren().clear();
           center.getChildren().addAll(l);
     
       }
  
     
    }     
 
 });
 
 



///////////////////////////////////updat the data base
// Movie supdat = null;
//int id =8;
//supdat = (Movie)session.get(Movie.class, id);
//supdat.setMoviePoster("https://s3.amazonaws.com/nightjarprod/content/uploads/sites/130/2023/03/14120624/vIeu8WysZrTSFb2uhPViKjX9EcC-scaled.jpg");
//tx.commit();
//session.close();
//System.out.println("Student "+ id +" was updated by:"+supdat.getMovieID());



Scene payment_scene = new Scene(pane_pay,625, 700); 

Scene add_scene = new Scene(pane_add,625, 700);

Scene password_scene =new Scene(password_pane,625, 700);

//
// 
//
//
 //// Action Event for Log In Page
        buttonLogIn.setOnAction(e -> {
            
//            session.close();
            for (User user1 : users) 
            {
                
               if (emailTextFieldLogIn.getText().equals(user1.getEmail()) && passwordFieldLogIn.getText().equals(user1.getPassword())) 
                {
                    ////////// go home page
                     Firstname.setText(user1.getFirstName());
                    Lastname.setText(user1.getLastName());
                    pas.setText(user1.getPassword());
                    LocalDate dateOfBirthToLocalDate = LocalDate.parse(user1.getDateOfBirth());
                    datePicker.setValue(dateOfBirthToLocalDate);

                    System.out.println("User Log In : " + user1.getFirstName() + " " + user1.getLastName());

                    ID = user1.getUserID();
                    
                    
                     stage.setScene(search_scene)  ;
                  
                } 
               if (emailTextFieldLogIn.getText() != user1.getEmail() || passwordFieldLogIn.getText() != user1.getPassword()) 
                {
                    massege1.setText("Your email or password not correct !");
                }
                
            }

      });
        
        
        buttonSignUpPage.setOnAction(e -> {
            
            
            scene.setRoot(signUpPage);
        
        
        });
        
        logInPage.setOnKeyPressed(e -> {

            if(e.getCode().equals(KeyCode.ENTER)) 
            {
           
            System.out.println("student list size: " + users.size());
            for(User user1 : users) 
            {
                /// If the user has been sign up before
                if (emailTextFieldLogIn.getText().equals(user1.getEmail()) && passwordFieldLogIn.getText().equals(user1.getPassword())) 
                {
                         Firstname.setText(user1.getFirstName());
                    Lastname.setText(user1.getLastName());
                    pas.setText(user1.getPassword());
                    LocalDate dateOfBirthToLocalDate = LocalDate.parse(user1.getDateOfBirth());
                    datePicker.setValue(dateOfBirthToLocalDate);

                    System.out.println("User Log In : " + user1.getFirstName() + " " + user1.getLastName());

                    ID = user1.getUserID();
                    
                      System.out.println(user1.getFirstName() + " " + user1.getLastName());
                     stage.setScene(search_scene)  ;
                    
                } 
               
            }
            }

        });
        
        
        //// Action Event for Sign Up Page
        
        buttonSignUp.setOnAction(e -> {
            
            
            /// If the user not write all requests "*"
            if(FNameSignUpTextField.getText().equals("") || emailSignUpTxField.getText().equals("") || passwordSignUpField.getText().equals("") || 
                    dateSignUp.getValue() == null || phoneNumSignUpTextField.getText().equals("")) 
            {
                massege2.setText("You not write all requests !");return;
                
            }
            /// If the user write short password 
            else if(passwordSignUpField.getText().length() < 4)
            {
                massege2.setText("Your password is too short"
                        + "\n\"Must be 4 characters\"");return;
            }
            /// If the user write long password 
            else if(passwordSignUpField.getText().length() > 4)
            {
                massege2.setText("Your password is too long"
                        + "\n\"Must be 4 characters\"");return;
            }
            /// If the user not write correct phone number
            else if(phoneNumSignUpTextField.getText().length() != 10)
            {
                massege2.setText("Your phone number is not correct !"
                        + "\n\"Must be 10 numbers\"");return;
            }
            
            user.setUserID(users.size() + 1);
            user.setFirstName(FNameSignUpTextField.getText());
            user.setLastName(LNameSignUpTextField.getText());
            user.setDateOfBirth(dateSignUp.getValue().toString());
            int phoneNumInt = Integer.parseInt(phoneNumSignUpTextField.getText());
            user.setPhoneNum(phoneNumInt);
            user.setEmail(emailSignUpTxField.getText());
            user.setPassword(passwordSignUpField.getText());

            int sId2 = (Integer) session.save(user);
            tx.commit();
//            session.close();
            System.out.println("inserted User : " + user.getFirstName());
            
             stage.setScene(search_scene)  ;
        });
        
        
        backToLogInPage.setOnAction(e -> {
        
            scene.setRoot(logInPage);
        
        });
        
   
        signUpPage.setOnKeyPressed(e -> {
            
            if(e.getCode().equals(KeyCode.ENTER))
            {
            if(FNameSignUpTextField.getText().equals("") || emailSignUpTxField.getText().equals("") || passwordSignUpField.getText().equals("") || 
                     dateSignUp.getValue() == null || phoneNumSignUpTextField.getText().equals("")) 
            {
                massege2.setText("You not write all requests !");
            }
            else if(passwordSignUpField.getText().length() < 4)
            {
                massege2.setText("Your password is too short"
                        + "\n\"Must be 8 characters\"");
            }
            else if(passwordSignUpField.getText().length() > 4)
            {
                massege2.setText("Your password is too long"
                        + "\n\"Must be 8 characters\"");
            }
            else if(phoneNumSignUpTextField.getText().length() != 10)
            {
                massege2.setText("Your phone number is not correct !"
                        + "\n\"Must be 10 numbers\"");
            }
            user.setUserID(users.size()+ 1);
            user.setFirstName(FNameSignUpTextField.getText());
            user.setLastName(LNameSignUpTextField.getText());
            user.setDateOfBirth(dateSignUp.getValue().toString());
            int phoneNumInt = Integer.parseInt(phoneNumSignUpTextField.getText());
            user.setPhoneNum(phoneNumInt);
            user.setEmail(emailSignUpTxField.getText());
            user.setPassword(passwordSignUpField.getText());

            int sId2 = (Integer) session.save(user);
            tx.commit();
//            session.close();
            System.out.println("inserted User : " + user.getFirstName());
             stage.setScene(search_scene)  ;
            }
        
        });


Payment payment = new Payment();

 pay_button.setOnAction(e->{
           
           if(tfp.getText().equals( "")&&!tfp2.getText().matches("^[0-9]+$")&&mon.valueProperty().equals( "")&& yee.valueProperty().equals( "")&&!tfp3.getText().matches( "\\d{3}")){
               
               tfp.clear();
               tfp2.clear();
               tfp3.clear();
               tfp.setPromptText( "Pleas Enter The Credit Card Name  ");
               tfp2.setPromptText("Pleas Enter The Credit Card Number  ");
               tfp3.setPromptText("Pleas Enter The Credit Card Security Code  ");
               
             

            }else if (tfp.getText().equals( "")){
             tfp.clear();
             tfp.setPromptText( "Pleas Enter The Credit Card Name  ");
             

            }else if (!tfp2.getText().matches("^[0-9]+$")){
             tfp2.clear();
             tfp2.setPromptText("Pleas Enter The Credit Card Number  ");
             

            }else if (!tfp3.getText().matches("\\d{3}")){
             tfp3.clear();
             tfp3.setPromptText("Pleas Enter The Credit Card Security Code  ");
             

            }
           
          
           else{
               
             payment.setNameOnCard(tfp.getText());
            payment.setCreditCardNum(Integer.parseInt(tfp2.getText()));
            payment.setMonth(mon.getValue().toString());
            payment.setYear(yee.getValue().toString());
            payment.setSecurityCode(Integer.parseInt(tfp3.getText()));
            int sId2 = (Integer) session.save(payment);
            tx.commit();
           
            System.out.println("inserted User : " + payment.getNameOnCard());
             
            }
        });

  

             update.setOnAction(e -> {
                 
                 User user2 = (User) session.get(User.class, ID);
                 user2.setFirstName(Firstname.getText());
                 user2.setLastName(Lastname.getText());
                 user2.setDateOfBirth(datePicker.getValue().toString());
                 user2.setPassword(pas.getText());
                 session.update(user2);
                 tx.commit();
                 
                 System.out.println("Updated : " + user2.getFirstName() + user2.getLastName() 
                         + user2.getDateOfBirth() + user2.getPassword() + " for user id : " + ID);
        });
             

        logOut.setOnAction(e -> {

            stage.setScene(scene)  ;   
        });

        delete.setOnAction(e -> {
            
                User user3 = (User) session.get(User.class, ID);
                session.delete(user3);
                tx.commit();
                
                System.out.println("Deleted User : " + user3.getFirstName());
            
        });
        
     
        backHome.setOnAction(e -> {
        
        //////////////////// back home
        stage.setScene(search_scene)  ;   
        
        });

NextCH.setOnAction(e-> { stage.setScene(payment_scene)  ;        });
////////////
 home.setOnAction(e-> { stage.setScene(search_scene)  ;        });
pasbackhom.setOnAction(e-> { stage.setScene(search_scene)  ;        });

administration.setOnAction(e-> {   


stage.setScene(password_scene)  ;

});
backAU.setOnAction(e-> { stage.setScene(search_scene)  ;        });

pasb.setOnAction(e-> { 
if(pastf.getText().equals("12345")){

  stage.setScene(add_scene)  ;   
    
    
}

});

pay_buttonback.setOnAction(e-> {      stage.setScene( Seatscene )  ;   });
       
profile.setOnAction(e-> {  stage.setScene( sceneacc )  ;    });


about_us.setOnAction(e-> {    stage.setScene(scene_AboutUs)  ;     });

/////////////////



////////////////////////////////////////
/////payment scene

   
        
 //    search 
 //scene
     
 
        stage.setTitle("PROJECT");
         stage.setScene(scene);
        stage.show();
    
    }
    
    
    

  ////////////////////////////////////////////////////////////////////////////////methods    

public Label toLabel(String poster,String name ){
ImageView imageView_add = new ImageView(new Image(poster)); 
        imageView_add.setFitHeight(160);
        imageView_add.setFitWidth(120);
  Label  mlable=new Label(name,imageView_add);
    mlable.setContentDisplay(ContentDisplay.TOP);
     mlable.setTextFill(rgb(253, 164,0));
 return   mlable; 
}

public Scene toscene(Button f,String dis,String gen,String trel,String name,String poster,Button bok){
 BorderPane movieDetails = new BorderPane();
        movieDetails.setPadding(new Insets(30));
       
        VBox allCenter = new VBox(10);
        allCenter.setPadding(new Insets(35, 0, 0 ,0));
        VBox trailar = new VBox(5);
        HBox postarAndTrailar = new HBox(20);
        postarAndTrailar.setPadding(new Insets(40));
        HBox story = new HBox(2);
        HBox genres = new HBox(2);
        HBox duration = new HBox(2);
        VBox buttons = new VBox(5);
       
        Text movieName = new Text(name);
       
        
        HBox hbMovieName = new HBox();
        hbMovieName.getChildren().add(movieName);
        hbMovieName.setAlignment(Pos.CENTER);
        movieDetails.setTop(hbMovieName);

       
        
       
        
       ImageView posterView = new ImageView(new Image(poster)); 
        posterView.setFitWidth(175);
        posterView.setFitHeight(220);
        
        
        Text textTrailar = new Text("\t \t \t \t Trailar :");
        
        Hyperlink linkTrailar = new Hyperlink(trel);
        
        trailar.setTranslateX(30);
        trailar.setTranslateY(70);
        trailar.getChildren().addAll(textTrailar, linkTrailar);
        
        postarAndTrailar.getChildren().addAll(posterView, trailar);
        
        
        Text textStory = new Text("Story :");
        Text theStory = new Text(dis);
        
        story.getChildren().addAll(textStory, theStory);
        
   
        Text textGenres = new Text("Genres :");
        Text theGenres = new Text(gen);
       
        genres.getChildren().addAll(textGenres, theGenres);
        
        
     
        
      
        
        
        allCenter.getChildren().addAll(postarAndTrailar, story, genres, duration);
        movieDetails.setCenter(allCenter);
        
        
       bok .setText("Book the Movie");
        bok.setMaxWidth(100);
                
        f .setText("Back");
        f.setTranslateX(275);
        
        buttons.getChildren().addAll(bok, f);
        movieDetails.setBottom(buttons);
        buttons.setAlignment(Pos.CENTER);
   
        
        
        //// CSS
        movieDetails.setStyle("-fx-background-color : #2C2C34;");
        
        Color neworange = Color.rgb(253, 164, 0);
        Color newgray = Color.rgb(124, 124, 124);
        Color newwhite = Color.rgb(255, 244, 236);
        
        movieName.setFill(neworange);
        movieName.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 20));
        
        textTrailar.setFill(Color.WHITE);
        
        textStory.setFont(Font.font("Trebuchet MS", 13));
        textStory.setFill(newwhite);
        theStory.setFont(Font.font("Trebuchet MS", 13));
        theStory.setFill(newgray);
        
        textGenres.setFont(Font.font("Trebuchet MS", 13));
        textGenres.setFill(newwhite);
        theGenres.setFont(Font.font("Trebuchet MS", 13));
        theGenres.setFill(newgray);
        
        
        
        f.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
        bok.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
                
       f.setStyle("-fx-background-color : #FEA401; -fx-text-fill : #2C2C34;");
        
        
        
        
        
        //// Action
        linkTrailar.setOnAction(e -> 
        {
        
            getHostServices().showDocument(linkTrailar.getText());
            
        });
        
//         bookingPage.setOnAction(e -> {
//       
//            // Booking Page
//
//        });       
//                
//                
//        backHomePage.setOnAction(e -> {
////        
////          stage.setScene(search_scene) ;
////        
//        });
        
        
        
Scene scene = new Scene(movieDetails,625, 700);


return scene;
}



  public static void main(String[] args) {
        launch();
    }


}