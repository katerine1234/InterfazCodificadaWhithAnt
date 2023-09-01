/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dogsss;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ivana
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



public class Dogsss extends JFrame {

     JLabel labelHours, labelBigDogs, labelMediumDogs, labelSmallDogs;
     JComboBox<String> hoursComboBox, bigDogsComboBox, mediumDogsComboBox, smallDogsComboBox;
     JButton calculateButton;
     JTextField totalCostField;

     int bigDogCost = 10000;
     int mediumDogCost = 5000;
     int smallDogCost = 3000;
     double discount = 0.1;

    public Dogsss() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Paseo de Perros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        setupComponents();

        setVisible(true);
    }

    private void setupComponents() {
        labelHours = new JLabel("Cuantas horas de paseo:");
        hoursComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});

        labelBigDogs = new JLabel("Número de perros grandes:");
        bigDogsComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        labelMediumDogs = new JLabel("Número de perros medianos:");
        mediumDogsComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        labelSmallDogs = new JLabel("Número de perros pequeños:");
        smallDogsComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        calculateButton = new JButton("Calcular");
        totalCostField = new JTextField();
        totalCostField.setEditable(false);

        calculateButton.addActionListener(e -> calculateTotalCost());

        addComponentsToLayout();
    }

    void addComponentsToLayout() {
        add(labelHours);
        add(hoursComboBox);
        add(labelBigDogs);
        add(bigDogsComboBox);
        add(labelMediumDogs);
        add(mediumDogsComboBox);
        add(labelSmallDogs);
        add(smallDogsComboBox);
        add(calculateButton);
        add(totalCostField);
    }

    void calculateTotalCost() {
        int numHours = Integer.parseInt((String) hoursComboBox.getSelectedItem());
        int numBigDogs = Integer.parseInt((String) bigDogsComboBox.getSelectedItem());
        int numMediumDogs = Integer.parseInt((String) mediumDogsComboBox.getSelectedItem());
        int numSmallDogs = Integer.parseInt((String) smallDogsComboBox.getSelectedItem());

        int totalCost = (numBigDogs * bigDogCost) + (numMediumDogs * mediumDogCost) + (numSmallDogs * smallDogCost);

        int totalDogs = numBigDogs + numMediumDogs + numSmallDogs;
        if (totalDogs > 1) {
            totalCost -= totalCost * discount;
        }

        totalCost *= numHours;

        totalCostField.setText(String.valueOf(totalCost));
    }

    public static void main(String[] args) {
        new Dogsss().setVisible(true);
    }
}

