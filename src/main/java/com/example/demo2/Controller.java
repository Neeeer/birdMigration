package com.example.demo2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button suomi;

    @FXML
    private Button svenska;

    @FXML
    private Button english;


    @FXML
    private HBox kurkiHbox;

    @FXML
    private HBox sinitiainenHbox;

    @FXML
    private HBox tervapääskyHbox;

    @FXML
    private HBox tilhiHbox;


    @FXML
    private VBox kurkiDescription;

    @FXML
    private VBox sinitiainenDescription;

    @FXML
    private VBox tervapääskyDescription;

    @FXML
    private VBox tilhiDescription;




    @FXML
    private Label heading;

    @FXML
    private Label subheading;

    @FXML
    private Label kurkiSpeciesLabel;

    @FXML
    private Label sinitiainenSpeciesLabel;

    @FXML
    private Label tervapääskySpeciesLabel;

    @FXML
    private Label tilhiSpeciesLabel;


    @FXML
    private TextArea textarea1;

    @FXML
    private TextArea textarea2;

    @FXML
    private TextArea textarea3;

    @FXML
    private TextArea textarea4;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView logoView1;

    @FXML
    private ImageView logoView2;

    @FXML
    private ImageView logoView3;

    @FXML
    private Label km1;
    @FXML
    private Label km2;
    @FXML
    private Label km3;
    @FXML
    private Label km4;

    @FXML
    private Label capturer1;
    @FXML
    private Label capturer2;
    @FXML
    private Label capturer3;
    @FXML
    private Label capturer4;


    @FXML
    private VBox descriptionVBox;


    ArrayList<String> headings = new ArrayList<>();
    ArrayList<String> subheadings = new ArrayList<>();


    ArrayList<Button> languages = new ArrayList<>();

    ArrayList<String> speciesSuomi = new ArrayList<>();
    ArrayList<String> speciesSvenska = new ArrayList<>();
    ArrayList<String> speciesEnglish = new ArrayList<>();

    ArrayList<String> descriptionsSuomi  = new ArrayList<>();
    ArrayList<String> descriptionsSvenska = new ArrayList<>();
    ArrayList<String> descriptionsEnglish  = new ArrayList<>();

    ArrayList<String> kmFinnish  = new ArrayList<>();
    ArrayList<String> kmSvenska  = new ArrayList<>();
    ArrayList<String> kmEnglish  = new ArrayList<>();

    ArrayList<String> pictureText = new ArrayList<>();

    ArrayList<Label> kmLabels  = new ArrayList<>();
    ArrayList<Label> capturers = new ArrayList<>();

    ArrayList<TextArea> textareas = new ArrayList<>();
    ArrayList<Label> speciesLabels = new ArrayList<>();
    ArrayList<VBox> speciesDescriptions = new ArrayList<>();
    ArrayList<HBox> speciesHbox = new ArrayList<>();
    private MediaPlayer mediaplayer1;
    private MediaPlayer mediaplayer2;
    private MediaPlayer mediaplayer3;
    private MediaPlayer mediaplayer4;
    private MediaView mediaView;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {

        languages.add(suomi);
        languages.add(svenska);
        languages.add(english);


        speciesDescriptions.add(tervapääskyDescription);
        speciesDescriptions.add(tilhiDescription);
        speciesDescriptions.add(sinitiainenDescription);
        speciesDescriptions.add(kurkiDescription);

        speciesHbox.add(tervapääskyHbox);
        speciesHbox.add(tilhiHbox);
        speciesHbox.add(sinitiainenHbox);
        speciesHbox.add(kurkiHbox);

        speciesLabels.add(tervapääskySpeciesLabel);
        speciesLabels.add(tilhiSpeciesLabel);
        speciesLabels.add(sinitiainenSpeciesLabel);
        speciesLabels.add(kurkiSpeciesLabel);

        textareas.add(textarea1);
        textareas.add(textarea2);
        textareas.add(textarea3);
        textareas.add(textarea4);



        kmLabels.add(km1);
        kmLabels.add(km2);
        kmLabels.add(km3);
        kmLabels.add(km4);

        capturers.add(capturer1);
        capturers.add(capturer2);
        capturers.add(capturer3);
        capturers.add(capturer4);

        descriptionVBox.getChildren().removeAll(speciesDescriptions);

        setMediaPlayers();
        setImages();
        setheadings();
        setSpeciesLists();
        setDescriptionsLists();
        setKmDescriptions();
        setPictureText();
        setLanguageSuomi();
        

    }

    private void setPictureText() {
        pictureText.add("Kuva: ");
        pictureText.add("Bild: ");
        pictureText.add("Photo: ");
    }


    public void selectFirstSpecies() {

        ArrayList<VBox> areas = new ArrayList<>();
        areas.addAll(speciesDescriptions);

        tervapääskyHbox.getStyleClass().clear();
        tervapääskyHbox.getStyleClass().add("selected-species");
        if(!descriptionVBox.getChildren().contains(tervapääskyDescription)){
            areas.remove(tervapääskyDescription);
            descriptionVBox.getChildren().removeAll(areas);
            descriptionVBox.getChildren().add(1,tervapääskyDescription);
        }

        setBackground(1);
    }


    private void setImages() {

        InputStream is = null;
        is = getClass().getResourceAsStream("/com/example/demo2/images/apusApus_ImranShahFlicker.jpg");
        imageView1.setImage(new Image(is));
        Circle circle1 =new Circle(35,35,30);
        imageView1.setClip(circle1);

        is = getClass().getResourceAsStream("/com/example/demo2/images/Bohemian_Waxwing_Silver_Leapers_flickr.jpg");
        imageView2.setImage(new Image(is));
        Circle circle2 =new Circle(35,35,30);
        imageView2.setClip(circle2);

        is = getClass().getResourceAsStream("/com/example/demo2/images/cyanister_caeruleus_Xulescu_G_Flicker.jpg");
        imageView3.setImage(new Image(is));
        Circle circle3 =new Circle(35,35,30);
        imageView3.setClip(circle3);

        is = getClass().getResourceAsStream("/com/example/demo2/images/Grugru20180906_Kalajoki_D4_8847_sanna_mäkeläinen.jpg");
        imageView4.setImage(new Image(is));
        Circle circle4 =new Circle(35,35,30);
        imageView4.setClip(circle4);

    }

    private void setKmDescriptions() {
        kmFinnish.add("Kaukomuuttaja, muuttomatka: 6000–8000 km");
        kmFinnish.add("Osittaismuuttaja, muuttomatka: 500–5000 km");
        kmFinnish.add("Osittaismuuttaja, muuttomatka: 0-1000 km");
        kmFinnish.add("Lähimuuttaja, muuttomatka: 2000–3500 km");

        kmSvenska.add("Långdistansflyttare, flyttningsavstånd: 6000–8000 km.");
        kmSvenska.add("Partiell flyttfågel, flyttningsavstånd: 500–5000 km.");
        kmSvenska.add("Partiell flyttfågel, flyttningsavstånd: 0–1000 km.");
        kmSvenska.add("Kortdistansflyttare, flyttningsavstånd: 2000–3500 km.");

        kmEnglish.add("A long-distance migrant, migration distance: 6,000–8,000 km");
        kmEnglish.add("A short-distance migrant, migration distance: 2,000–3,500 km");
        kmEnglish.add("Partial migrant, migration distance: 0–1,000 km");
        kmEnglish.add("A short-distance migrant, migration distance: 2,000–3,500 km");
    }


    private void setDescriptionsLists() {
        descriptionsSuomi.add("Pihapiireissämme pesivät tervapääskyt viettävät talvikauden Afrikan keskiosissa päiväntasaajan ympäristössä. Hurja muuttomatka vaatii paljon lentotaidoilta, ja pesintää lukuun ottamatta tervapääsky viettääkin koko elämänsä – jopa nukkuu – lentäen. Tervapääskyt saapuvat Suomeen toukokuussa ja lähtevät paluumatkalleen elokuun jälkipuoliskolla. Pitkäikäisenä lintuna tervapääskyt ehtivät lentää elämänsä aikana jopa yli kaksi miljoonaa kilometriä eli noin 40 kertaa maapallon ympäri.");
        descriptionsSuomi.add("Suomessa tilhet pesivät lähinnä maan pohjoisosan havumetsissä. Syksyn saapuessa – syys-lokakuussa –tilhiparvet vaeltavat päiväaikaan kohti etelää. Runsas pihlajanmarjasato saa ne jäämään pidemmäksi aikaa tai koko talveksi Etelä-Suomeen tai Pohjois-Eurooppaan. Huonoina marjavuosina ne jatkavat Välimeren maihin ja Kaukasukselle asti. Suomeen saapuu tilhiä syysmuutolla myös kaukaa idästä, jopa Keski-Siperiasta saakka. Paluumuutto pohjoiseen tapahtuu maalis-toukokuussa.");
        descriptionsSuomi.add("Lehti- ja sekametsissä pesivistä sinitiaisista valtaosa jää talveksi Suomeen. Osa, etenkin nuoret linnut ja pienikokoiset naaraat, suuntaa syys-lokakuussa kohti Ruotsia ja Baltiaa. Vanhat kokeneet yksilöt selviävät talvesta paremmin, ja ovat useammin paikkalintuja. Talvella etelän ruokintapaikoilla runsaina parveilevat tintit voivat olla kotoisin myös Pohjois-Suomesta. Kartan havainnoissa näkyy hyvin Birdlifen piha- ja pönttöbongauspäivät tammikuussa ja kesäkuussa, jolloin havaintoja kirjautuu järjestelmiin tavallista enemmän.");
        descriptionsSuomi.add("Huhtikuussa komeat kurkiparvet saapuvat Keski-Euroopasta ja Välimeren ympäristöstä Suomeen. Ne siirtyvät pian pesimään soille ja kosteikoille sekä kosteiden peltojen ja hakkuuaukkojen reunoille. Syksyisen paluumuuton aikana kurkia nähdään taas runsaasti pelloilla ja lentämässä auramuodostelmissa kohti eteläisiä talvenviettopaikkojaan. Muuttopäivät valikoituvat säiden mukaan. Pohjoistuulet houkuttelevat muuttoparvia liikkeelle jo elo-syyskuun vaihteessa, mutta muutto jatkuu yleensä lokakuun alkuun asti.");

        descriptionsSvenska.add("Tornseglarna som häckar runtom våra gårdar spenderar vintersäsongen i centrala Afrika runt ekvatorn. Det enorma flyttningsavståndet kräver mycket av flygförmågan, och med undantag för häckningen spenderar tornseglaren hela sitt liv flygande – den till och med sover flygande. Tornseglarna anländer till Finland i maj och börjar sin återvändsresa under andra hälften av augusti. Som långlivade fåglar kan tornseglarna under sina liv hinna flyga till och med mer än två miljoner kilometer, vilket är cirka 40 gånger jorden runt.");
        descriptionsSvenska.add("I Finland häckar sidensvansar huvudsakligen i våra norra barrskogar. När hösten kommer i september–oktober vandrar sidensvansflockarna söderut under dagtid. En rik rönnbärsskörd får dem att stanna längre, eller till och med hela vintern i Södra Finland eller norra Europa. Under dåliga bärår fortsätter de till Medelhavsländerna och till och med Kaukasus. Under höstflyttningen kommer sidensvansar till Finland också långt österifrån, till och med från mellersta Sibirien. Återflyttningen norrut sker i mars–maj.");
        descriptionsSvenska.add("De flesta blåmesar som häckar i löv- och blandskogar övervintrar i Finland. En del, i synnerhet unga fåglar och små honor, styr i september–oktober mot Sverige och Baltikum. Gamla erfarna individer klarar vintern bättre och är oftare stannfåglar. De stora mesflockarna som vi under vintern ser på matplatser i Södra Finland kan också härstamma från norra Finland. I observationerna på kartan märks tydligt Birdlifes dagar för gårdsplanskrysset och holkspaningen i januari och juni, då fler observationer än vanligt registreras i systemen.");
        descriptionsSvenska.add("I april anländer de stiliga tranflockarna från Centraleuropa och Medelhavet till Finland. Snart börjar de häcka vid träsk och våtmarker samt i kanterna av fuktiga åkrar och kalhyggen. Under höstens återflyttning kan du igen se mängder av tranor på åkrar och flygande i plogformationer mot sina sydliga övervintringsplatser. Flyttdagarna bestäms efter vädret. Nordliga vindar lockar iväg flyttflockarna redan i månadsskiftet mellan augusti och september, men vanligtvis fortsätter flyttningen till början av oktober.");

        descriptionsEnglish.add("The common swift nests in our yards and gardens but migrates to equatorial central Africa for the winter. The strenuous migration requires excellent flight skills. Indeed, when not nesting the bird spends its whole life in the air, not landing even to sleep. Swifts arrive in Finland in May and leave in late August. As birds with long life expectancies, swifts can, in their lifetime, fly up to two million kilometres or more – enough to travel around the Earth some 40 times.");
        descriptionsEnglish.add("In Finland, the Bohemian waxwing nests mostly in the coniferous forests of the north. As autumn arrives in September and October, flocks of waxwing head south. A bumper crop of rowan berries can delay their stay, even over winter, in Southern Finland or Northern Europe. If the berry crop is poor, however, they migrate to the Mediterranean countries and the Caucasus. Some Bohemian waxwings also arrive in Finland in the autumn from as far east as Central Siberia. The return migration to the north takes place between March and May.");
        descriptionsEnglish.add("Nesting in deciduous and mixed forests, most blue tits overwinter in Finland. Some of them, particularly juveniles and small adult females, set off towards Sweden and the Baltic countries in September and October. Resident birds are usually older, more experienced individuals, who are better able to survive the winter period. The blue tits converging on southern feeding sites in winter may be from Northern Finland. As is apparent from the map, more observations than usual are recorded during BirdLife Finland’s bird watch and nest watch events in January and June.");
        descriptionsEnglish.add("In April, impressive flocks of common cranes arrive in Finland from Central Europe and the Mediterranean area. Soon they begin nesting in bogs, swamps and other wetlands and on the edges of wet fields and clear-cut areas. During their return migration in the autumn, a great number of common cranes can again be seen on fields and flying in V formation towards their southern winter habitats. The itinerary depends on the weather. Northern winds encourage departure in late August and early September, but migration usually continues until early October.");
    }

    private void setheadings() {
        headings.add("Minne menit muuttolintu?");
        headings.add("Vart tog du vägen flyttfågel?");
        headings.add("Where are you now, migratory bird?");

        subheadings.add("Lintuhavainnot kertovat, missä linnut milloinkin liikkuvat.");
        subheadings.add("Fågelobservationer visar var och när fåglar rör sig.");
        subheadings.add("Observations help us keep track of birds.");
    }


    private void setSpeciesLists() {
        speciesSuomi.add("Tervapääsky");
        speciesSuomi.add("Tilhi");
        speciesSuomi.add("Sinitiainen");
        speciesSuomi.add("Kurki");

        speciesSvenska.add("Tornseglare");
        speciesSvenska.add("Sidensvans");
        speciesSvenska.add("Blåmes");
        speciesSvenska.add("Trana");

        speciesEnglish.add("Common swift");
        speciesEnglish.add("Bohemian waxwing");
        speciesEnglish.add("Blue tit");
        speciesEnglish.add("Common crane");
    }

    @FXML
    protected void setLanguageSuomi() {

        for (int i = 0; i<speciesLabels.size() ; i++){
            speciesLabels.get(i).setText(speciesSuomi.get(i));
        }
        for (int i = 0; i< textareas.size() ; i++){
            textareas.get(i).setText(descriptionsSuomi.get(i));
            textareas.get(i).setPrefHeight(230);
        }
        for (int i = 0; i< kmLabels.size() ; i++){
            kmLabels.get(i).setText(kmFinnish.get(i));
        }
        for (int i = 0; i< capturers.size() ; i++){
            capturers.get(i).setText(pictureText.get(0));
        }

        textareas.get(2).setPrefHeight(255);
        textareas.get(3).setPrefHeight(255);


        heading.setText(headings.get(0));
        subheading.setText(subheadings.get(0));

        changeLanguagesLabels(suomi);
    }
    @FXML
    protected void setLanguageSvenska() {
        for (int i = 0; i<speciesLabels.size() ; i++){
            speciesLabels.get(i).setText(speciesSvenska.get(i));
        }
        for (int i = 0; i< textareas.size() ; i++){
            textareas.get(i).setText(descriptionsSvenska.get(i));
            textareas.get(i).setPrefHeight(255);
        }
        for (int i = 0; i< kmLabels.size() ; i++){
            kmLabels.get(i).setText(kmSvenska.get(i));
        }
        for (int i = 0; i< capturers.size() ; i++){
            capturers.get(i).setText(pictureText.get(1));
        }

        heading.setText(headings.get(1));
        subheading.setText(subheadings.get(1));
        changeLanguagesLabels(svenska);
    }
    @FXML
    protected void setLanguageEnglish() {

        for (int i = 0; i<speciesLabels.size() ; i++){
            speciesLabels.get(i).setText(speciesEnglish.get(i));
        }
        for (int i = 0; i< textareas.size() ; i++){
            textareas.get(i).setText(descriptionsEnglish.get(i));
            textareas.get(i).setPrefHeight(255);
        }
        for (int i = 0; i< kmLabels.size() ; i++){
            kmLabels.get(i).setText(kmEnglish.get(i));
        }
        for (int i = 0; i< capturers.size() ; i++){
            capturers.get(i).setText(pictureText.get(2));
        }
        textareas.get(0).setPrefHeight(230);

        heading.setText(headings.get(2));
        subheading.setText(subheadings.get(2));
        changeLanguagesLabels(english);
    }

    public void changeLanguagesLabels(Button selectedButton){

        for (Button button: languages) {
            button.getStyleClass().remove("selected-language");
            button.getStyleClass().remove("non-selected-language");
            if(button == selectedButton){
                button.getStyleClass().add("selected-language");
            }
            else {
                button.getStyleClass().add("non-selected-language");
            }
        }
    }

    @FXML
    protected void onExitButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        Platform.exit();
    }

    @FXML
    protected void onSpeciesTouch(MouseEvent event) {

        ArrayList<VBox> areas = new ArrayList<>();
        areas.addAll(speciesDescriptions);
        HBox hBox = (HBox) event.getSource();

        for (HBox i:speciesHbox) {
            i.getStyleClass().clear();
            i.getStyleClass().add("unselected-species");
        }

        if(hBox == kurkiHbox){
            hBox.getStyleClass().clear();
            hBox.getStyleClass().add("selected-species");
            if(!descriptionVBox.getChildren().contains(kurkiDescription)){
                areas.remove(kurkiDescription);
                descriptionVBox.getChildren().removeAll(areas);
                descriptionVBox.getChildren().add(4,kurkiDescription);

            }
            setBackground(4);

        }
        else if(hBox == sinitiainenHbox){
            hBox.getStyleClass().clear();
            hBox.getStyleClass().add("selected-species");
            if(!descriptionVBox.getChildren().contains(sinitiainenDescription)){
                areas.remove(sinitiainenDescription);
                descriptionVBox.getChildren().removeAll(areas);
                descriptionVBox.getChildren().add(3,sinitiainenDescription);
            }
            setBackground(3);
        }
        else if(hBox == tervapääskyHbox){
            hBox.getStyleClass().clear();
            hBox.getStyleClass().add("selected-species");
            if(!descriptionVBox.getChildren().contains(tervapääskyDescription)){
                areas.remove(tervapääskyDescription);
                descriptionVBox.getChildren().removeAll(areas);
                descriptionVBox.getChildren().add(1,tervapääskyDescription);
            }
            setBackground(1);

        }
        else if(hBox == tilhiHbox){
            hBox.getStyleClass().clear();
            hBox.getStyleClass().add("selected-species");
            if(!descriptionVBox.getChildren().contains(tilhiDescription)){
                areas.remove(tilhiDescription);
                descriptionVBox.getChildren().removeAll(areas);
                descriptionVBox.getChildren().add(2,tilhiDescription);
                descriptionVBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
                descriptionVBox.setMaxHeight(Region.USE_COMPUTED_SIZE);
                descriptionVBox.setMinHeight(Region.USE_COMPUTED_SIZE);
            }
            setBackground(2);
        }
    }

    private void setBackground(int i){

    if(i == 1){
        mediaView.setMediaPlayer(mediaplayer1);
        mediaplayer1.seek(Duration.ZERO);
    }
    else if(i == 2){
        mediaView.setMediaPlayer(mediaplayer2);
        mediaplayer2.seek(Duration.ZERO);
    }
    else if(i == 3){
        mediaView.setMediaPlayer(mediaplayer3);
        mediaplayer3.seek(Duration.ZERO);
    }
    else if(i == 4){
        mediaView.setMediaPlayer(mediaplayer4);
        mediaplayer4.seek(Duration.ZERO);
    }

    }

    public void setMediaPlayers() {


        //Media media1  = new Media("file:///C:/Users/nerst/Desktop/birdMigrationTest/Captures/" + "Tervapääsky.mp4");
        //Media media1  = new Media("file:///home/pi/birdMigrationTest/Captures/" + "Tervapääsky.mp4");
        Media media1 = new Media(getClass().getResource("/com/example/demo2/Captures/" + "Tervapääsky.mp4").toExternalForm());


        mediaplayer1 = new MediaPlayer(media1);
        mediaplayer1.setAutoPlay(true);
        mediaplayer1.setCycleCount(MediaPlayer.INDEFINITE);

        Media media2 = new Media(getClass().getResource("/com/example/demo2/Captures/" + "Tilhi.mp4").toExternalForm());

        mediaplayer2 = new MediaPlayer(media2);
        mediaplayer2.setAutoPlay(true);
        mediaplayer2.setCycleCount(MediaPlayer.INDEFINITE);

        Media media3 = new Media(getClass().getResource("/com/example/demo2/Captures/" + "Sinitiainen.mp4").toExternalForm());
        mediaplayer3 = new MediaPlayer(media3);
        mediaplayer3.setAutoPlay(true);
        mediaplayer3.setCycleCount(MediaPlayer.INDEFINITE);

        Media media4  = new Media(getClass().getResource("/com/example/demo2/Captures/" + "Kurki.mp4").toExternalForm());
        mediaplayer4 = new MediaPlayer(media4);
        mediaplayer4.setAutoPlay(true);
        mediaplayer4.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void setMediaView(MediaView view) {
        this.mediaView = view;
    }


    public void start() {
        selectFirstSpecies();
    }
}