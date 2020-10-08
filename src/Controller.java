import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {
    @FXML TextField tfFrase1, tfFrase2pt1, tfFrase2pt2;
    @FXML Label lbResultado;
    @FXML ChoiceBox cbOpcionesString;
    @FXML
    protected void initialize(){
        cbOpcionesString.getItems().addAll("charAt","compareTo","equalsIgnoreCase","indexOf","lastIndexOf","replace","replaceFirst","split","startsWith","substring");
    }
    public void ejecutarComandoDeString(ActionEvent event){
        String frase1=tfFrase1.getText();
        String frase2pt1=tfFrase2pt1.getText();
        String frase2pt2=tfFrase2pt2.getText();
        switch(cbOpcionesString.getSelectionModel().getSelectedIndex()){
            //charAt
            case 0:
                if(frase2pt1.length()!=0){
                    int pos=Integer.parseInt(frase2pt1);
                    char c=frase1.charAt(pos);
                    lbResultado.setText("charAt "+pos+": "+String.valueOf(c));
                }
                else{
                    Alert a=new Alert(Alert.AlertType.ERROR,"El primer campo de la segunda frase está vacío",ButtonType.OK);
                    a.setHeaderText("Texto vacío");
                    a.setTitle("ERROR");
                    a.show();
                }
                break;
            //compareTo
            case 1:
                int compareTo=frase1.compareTo(frase2pt1);
                lbResultado.setText("compareTo "+frase2pt1+": "+String.valueOf(compareTo));
                break;
            //equalsIgnoreCase
            case 2:
                boolean equalsIgnoreCase=frase1.equalsIgnoreCase(frase2pt1);
                lbResultado.setText("equalsIgnoreCase "+frase2pt1+": "+String.valueOf(equalsIgnoreCase));
                break;
            //indexOf
            case 3:
                int indexOf=frase1.indexOf(frase2pt1);
                lbResultado.setText("indexOf "+frase2pt1+": "+String.valueOf(indexOf));
                break;
            //lastIndexOf
            case 4:
                int lastIndexOf=frase1.lastIndexOf(frase2pt1);
                lbResultado.setText("lastIndexOf "+frase2pt1+": "+String.valueOf(lastIndexOf));
                break;
            //replace
            case 5:
                if(frase2pt1.length()!=0&&frase2pt2.length()!=0){
                    String replace=frase1.replace(frase2pt1,frase2pt2);
                    lbResultado.setText("replace "+frase2pt1+" por "+frase2pt2+": "+replace);
                }
                else{
                    Alert a=new Alert(Alert.AlertType.ERROR,"Uno o varios campos de la segunda frase están vacíos.",ButtonType.OK);
                    a.setHeaderText("Texto vacío");
                    a.setTitle("ERROR");
                    a.show();
                }
                break;
            //replaceFirst
            case 6:
                if(frase2pt1.length()!=0&&frase2pt2.length()!=0){
                    String replaceFirst=frase1.replaceFirst(frase2pt1,frase2pt2);
                    lbResultado.setText("replaceFirst "+frase2pt1+" por "+frase2pt2+": "+replaceFirst);
                }
                else{
                    Alert a=new Alert(Alert.AlertType.ERROR,"Uno o varios campos de la segunda frase están vacíos.",ButtonType.OK);
                    a.setHeaderText("Texto vacío");
                    a.setTitle("ERROR");
                    a.show();
                }
                break;
            //split
            case 7:
                if(frase2pt2.length()!=0){
                    int limit=Integer.parseInt(frase2pt2);
                    String[] split=frase1.split(frase2pt1,limit);
                    lbResultado.setText("split por "+frase2pt1+", limite "+String.valueOf(limit)+": "+ Arrays.toString(split));
                }
                else{
                    String[] split=frase1.split(frase2pt1);
                    lbResultado.setText("split por "+frase2pt1+": "+Arrays.toString(split));
                }
                break;
            //startsWith
            case 8:
                boolean startsWith=frase1.startsWith(frase2pt1);
                lbResultado.setText("startsWith "+frase2pt1+": "+String.valueOf(startsWith));
                break;
            //substring
            case 9:
                if(frase2pt1.length()!=0){
                    if(frase2pt2.length()!=0){
                        int pos1=Integer.valueOf(frase2pt1);
                        int pos2=Integer.valueOf(frase2pt2);
                        try{
                            String substring=frase1.substring(pos1,pos2);
                            lbResultado.setText("substring desde la posición "+String.valueOf(pos1)+" hasta la "+String.valueOf(pos2)+": "+substring);
                        }catch(Exception ex) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setContentText(ex.getLocalizedMessage());
                            a.setTitle("ERROR");
                            a.setHeaderText("Excepción en la ejecución");
                            a.show();
                        }
                    }
                    else{
                        int pos1=Integer.valueOf(frase2pt1);
                        try{
                            String substring=frase1.substring(pos1);
                            lbResultado.setText("substring desde la posición "+String.valueOf(pos1)+": "+substring);
                        }catch(Exception ex){
                            Alert a=new Alert(Alert.AlertType.ERROR);
                            a.setContentText(ex.getLocalizedMessage());
                            a.setTitle("ERROR");
                            a.setHeaderText("Excepción en la ejecución");
                        }
                    }
                }
                else{
                    Alert a=new Alert(Alert.AlertType.ERROR,"El primer campo de la segunda frase está vacío",ButtonType.OK);
                    a.setHeaderText("Texto vacío");
                    a.setTitle("ERROR");
                    a.show();
                }
                break;

        }
    }
}
