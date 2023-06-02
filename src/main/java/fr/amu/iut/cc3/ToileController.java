package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    public TextField inptUn;
    @FXML
    public TextField inptDeux;
    @FXML
    public TextField inptTrois;
    @FXML
    public TextField inptQuatre;
    @FXML
    public TextField inptCinq;
    @FXML
    public TextField inptSix;
    @FXML
    public Pane toile;
    public List<Circle> fixedList = Arrays.asList(new Circle[6]);
    @FXML
    public Label errorText;
    @FXML
    public Label errorText2;

    public void vider() {
        fixedList = Arrays.asList(new Circle[6]);
        inptUn.clear();
        inptDeux.clear();
        inptTrois.clear();
        inptQuatre.clear();
        inptCinq.clear();
        inptSix.clear();
        toile.getChildren().clear();
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());

        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());

    }

    public void viderline(){
        toile.getChildren().remove(11);
        toile.getChildren().remove(10);
        toile.getChildren().remove(9);
        toile.getChildren().remove(8);
        toile.getChildren().remove(7);
        toile.getChildren().remove(6);

        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
    }

    public void tracer() {


        if (fixedList.get(0) != null && fixedList.get(1) != null) {
            Line l1 = new Line(fixedList.get(0).getCenterX(), fixedList.get(0).getCenterY(),
                    fixedList.get(1).getCenterX(), fixedList.get(1).getCenterY());
            l1.setStyle("-fx-stroke: black;");
            toile.getChildren().set(6,l1);

        }

        if (fixedList.get(1) != null && fixedList.get(2) != null) {

            Line l2 = new Line(fixedList.get(1).getCenterX(), fixedList.get(1).getCenterY(),
                    fixedList.get(2).getCenterX(), fixedList.get(2).getCenterY());
            l2.setStyle("-fx-stroke: black;");
            toile.getChildren().set(7,l2);

        }

        if (fixedList.get(2) != null && fixedList.get(3) != null) {

            Line l3 = new Line(fixedList.get(2).getCenterX(), fixedList.get(2).getCenterY(),
                    fixedList.get(3).getCenterX(), fixedList.get(3).getCenterY());
            l3.setStyle("-fx-stroke: black;");
            toile.getChildren().set(8,l3);

        }

        if (fixedList.get(3) != null && fixedList.get(4) != null) {

            Line l4 = new Line(fixedList.get(3).getCenterX(), fixedList.get(3).getCenterY(),
                    fixedList.get(4).getCenterX(), fixedList.get(4).getCenterY());
            l4.setStyle("-fx-stroke: black;");
            toile.getChildren().set(9,l4);

        }

        if (fixedList.get(4) != null && fixedList.get(5) != null) {

            Line l5 = new Line(fixedList.get(4).getCenterX(), fixedList.get(4).getCenterY(),
                    fixedList.get(5).getCenterX(), fixedList.get(5).getCenterY());
            l5.setStyle("-fx-stroke: black;");
            toile.getChildren().set(10,l5);
        }
        if (fixedList.get(5) != null && fixedList.get(0) != null) {

            Line l6 = new Line(fixedList.get(5).getCenterX(), fixedList.get(5).getCenterY(),
                    fixedList.get(0).getCenterX(), fixedList.get(0).getCenterY());
            l6.setStyle("-fx-stroke: black;");
            toile.getChildren().set(11,l6);
        }



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorText.setVisible(false);
        errorText2.setVisible(false);

        toile.getChildren().clear();
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());
        toile.getChildren().add(new Circle());

        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());
        toile.getChildren().add(new Line());

        inptUn.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().

                errorText.setVisible(false);
                errorText2.setVisible(false);

                Double value = Double.parseDouble(inptUn.getText());
                if (value <= 20 && value >= 0 && fixedList.get(0) == null) {
                    int resX = getXRadarChart(value, 1);
                    int resY = getYRadarChart(value, 1);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(0, point);

                    toile.getChildren().set(0,point);
                } else if (value <= 20 && value >= 0 && fixedList.get(0)!=null) {
                    value = Double.parseDouble(inptUn.getText());

                    fixedList.get(0).setCenterX(getXRadarChart(value, 1));
                    fixedList.get(0).setCenterY(getYRadarChart(value, 1));
                    toile.getChildren().set(0,fixedList.get(0));
                    viderline();
                    tracer();
                }else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });


        inptDeux.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().
                errorText.setVisible(false);
                errorText2.setVisible(false);
                Double value = Double.parseDouble(inptDeux.getText());
                if (value <= 20 && value >= 0 && fixedList.get(1) == null) {
                    int resX = getXRadarChart(value, 2);
                    int resY = getYRadarChart(value, 2);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(1, point);

                    toile.getChildren().set(1,point);
                } else if (value <= 20 && value >= 0 && fixedList.get(1)!=null) {
                    value = Double.parseDouble(inptDeux.getText());

                    fixedList.get(1).setCenterX(getXRadarChart(value, 2));
                    fixedList.get(1).setCenterY(getYRadarChart(value, 2));
                    toile.getChildren().set(1,fixedList.get(1));
                    viderline();
                    tracer();
                }else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });
        inptTrois.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().
                errorText.setVisible(false);
                errorText2.setVisible(false);
                Double value = Double.parseDouble(inptTrois.getText());
                if (value <= 20 && value >= 0 && fixedList.get(2) == null) {
                    int resX = getXRadarChart(value, 3);
                    int resY = getYRadarChart(value, 3);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(2, point);

                    toile.getChildren().set(2,point);
                } else if (value <= 20 && value >= 0 && fixedList.get(2)!=null) {
                    value = Double.parseDouble(inptTrois.getText());

                    fixedList.get(2).setCenterX(getXRadarChart(value, 3));
                    fixedList.get(2).setCenterY(getYRadarChart(value, 3));
                    toile.getChildren().set(2,fixedList.get(2));
                    viderline();
                    tracer();
                }else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });
        inptQuatre.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().
                errorText.setVisible(false);
                errorText2.setVisible(false);
                Double value = Double.parseDouble(inptQuatre.getText());
                if (value <= 20 && value >= 0 && fixedList.get(3) == null) {
                    int resX = getXRadarChart(value, 4);
                    int resY = getYRadarChart(value, 4);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(3, point);

                    toile.getChildren().set(3,point);
                } else if (value <= 20 && value >= 0 && fixedList.get(3)!=null) {
                    value = Double.parseDouble(inptQuatre.getText());

                    fixedList.get(3).setCenterX(getXRadarChart(value, 4));
                    fixedList.get(3).setCenterY(getYRadarChart(value, 4));
                    toile.getChildren().set(3,fixedList.get(3));
                    viderline();
                    tracer();
                }else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });
        inptCinq.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().
                errorText.setVisible(false);
                errorText2.setVisible(false);
                Double value = Double.parseDouble(inptCinq.getText());
                if (value <= 20 && value >= 0 && fixedList.get(4) == null) {
                    int resX = getXRadarChart(value, 5);
                    int resY = getYRadarChart(value, 5);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(4, point);

                    toile.getChildren().set(4,point);
                } else if (value <= 20 && value >= 0 && fixedList.get(4)!=null) {
                    value = Double.parseDouble(inptCinq.getText());

                    fixedList.get(4).setCenterX(getXRadarChart(value, 5));
                    fixedList.get(4).setCenterY(getYRadarChart(value, 5));
                    toile.getChildren().set(4,fixedList.get(4));
                    viderline();
                    tracer();
                }else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });
        inptSix.setOnKeyPressed(event ->
        {

            if (event.getCode() == KeyCode.ENTER) {
                //toile.getChildren().
                errorText.setVisible(false);
                errorText2.setVisible(false);
                Double value = Double.parseDouble(inptSix.getText());
                if (value <= 20 && value >= 0 && fixedList.get(5) == null) {
                    int resX = getXRadarChart(value, 6);
                    int resY = getYRadarChart(value, 6);

                    Circle point = new Circle(resX, resY, 5);

                    fixedList.set(5, point);

                    toile.getChildren().add(point);
                } else if (value <= 20 && value >= 0 && fixedList.get(5)!=null) {
                    value = Double.parseDouble(inptSix.getText());

                    fixedList.get(5).setCenterX(getXRadarChart(value, 6));
                    fixedList.get(5).setCenterY(getYRadarChart(value, 6));

                    toile.getChildren().set(5,fixedList.get(5));
                    viderline();
                    tracer();
                } else {
                    errorText.setVisible(true);
                    errorText2.setVisible(true);
                }
            }
        });
    }

    int getXRadarChart(double value, int axe) {
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe - 1) * angleEnDegre)) * rayonCercleExterieur
                * (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe) {
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe - 1) * angleEnDegre)) * rayonCercleExterieur
                * (value / noteMaximale));
    }

}
