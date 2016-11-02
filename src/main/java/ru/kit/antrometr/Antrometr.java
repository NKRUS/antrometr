package ru.kit.antrometr;


import java.util.HashMap;
import java.util.Map;

public class Antrometr {

    private boolean isMan;
    private boolean isWoman;
    private double height;
    private double weight;
    private double IMT;
    private double thoraxAlone;
    private double horaxOnInspiration;
    private double thoraxOnExhalation;
    private double waistAboveNavel;
    private double waistAtNavel;
    private double buttocks;
    private double volumeLeftFemur;
    private double volumeRightFemur;
    private double volumeLeftShoulder;
    private double volumeRightshoulder;
    private double flexibilitySpine;
    private double abdominalMuscles;
    private double backMuscles;
    private double flexibilityJoints;



    Map<InspectionName, Double> inspections = new HashMap<>();

    public Antrometr(boolean isMan, boolean isWoman, double height, double weight) {
        this.isMan = isMan;
        this.isWoman = isWoman;
        this.height = height;
        this.weight = weight;
        this.IMT = weight / Math.pow(height / 100, 2);
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIMT(double IMT) {
        this.IMT = IMT;
        inspections.put(InspectionName.IMT, IMT);
    }

    public void setThoraxAlone(String sThoraxAlone) {
        this.thoraxAlone = Double.parseDouble(sThoraxAlone);
        inspections.put(InspectionName.thorax_alone, thoraxAlone);
    }

    public void setHoraxOnInspiration(String sHoraxOnInspiration) {
        this.horaxOnInspiration = Double.parseDouble(sHoraxOnInspiration);
        inspections.put(InspectionName.horax_on_inspiration, horaxOnInspiration);
    }

    public void setThoraxOnExhalation(String sThoraxOnExhalation) {
        this.thoraxOnExhalation = Double.parseDouble(sThoraxOnExhalation);
        inspections.put(InspectionName.thorax_on_exhalation, thoraxOnExhalation);
    }

    public void setWaistAboveNavel(String sWaistAboveNavel) {
        this.waistAboveNavel = Double.parseDouble(sWaistAboveNavel);
        inspections.put(InspectionName.waist_above_navel, waistAboveNavel);
    }

    public void setWaistAtNavel(String sWaistAtNavel) {
        this.waistAtNavel = Double.parseDouble(sWaistAtNavel);
        inspections.put(InspectionName.waist_at_navel, waistAtNavel);
    }

    public void setButtocks(String sButtocks) {
        this.buttocks = Double.parseDouble(sButtocks);
        inspections.put(InspectionName.buttocks, buttocks);
    }

    public void setVolumeLeftFemur(String sVolumeLeftFemur) {
        this.volumeLeftFemur = Double.parseDouble(sVolumeLeftFemur);
        inspections.put(InspectionName.volume_left_femur, volumeLeftFemur);
    }

    public void setVolumeRightFemur(String sVolumeRightFemur) {
        this.volumeRightFemur = Double.parseDouble(sVolumeRightFemur);
        inspections.put(InspectionName.volume_right_femur, volumeRightFemur);
    }

    public void setVolumeLeftShoulder(String sVolumeLeftShoulder) {
        this.volumeLeftShoulder = Double.parseDouble(sVolumeLeftShoulder);
        inspections.put(InspectionName.volume_left_shoulder, volumeLeftShoulder);
    }

    public void setVolumeRightshoulder(String sVolumeRightshoulder) {
        this.volumeRightshoulder = Double.parseDouble(sVolumeRightshoulder);
        inspections.put(InspectionName.volume_right_shoulder, volumeRightshoulder);
    }

    public void setFlexibilitySpine(String sFlexibilitySpine) {
        double flexibilitySpine = Double.parseDouble(sFlexibilitySpine);
        checkData(flexibilitySpine);
        this.flexibilitySpine = flexibilitySpine;
        inspections.put(InspectionName.flexibility_spine, flexibilitySpine);
    }

    public void setAbdominalMuscles(String sAbdominalMuscles) {
        double abdominalMuscles = Double.parseDouble(sAbdominalMuscles);
        checkData(abdominalMuscles);
        this.abdominalMuscles = abdominalMuscles;
        inspections.put(InspectionName.abdominal_muscles, abdominalMuscles);
    }

    public void setBackMuscles(String sBackMuscles) {
        double backMuscles = Double.parseDouble(sBackMuscles);
        checkData(backMuscles);
        this.backMuscles = backMuscles;
        inspections.put(InspectionName.back_muscles, backMuscles);
    }

    public void setFlexibilityJoints(String sFlexibilityJoints) {
        double flexibilityJoints = Double.parseDouble(sFlexibilityJoints);
        checkData(flexibilityJoints);
        this.flexibilityJoints = flexibilityJoints;
        inspections.put(InspectionName.flexibility_joints, flexibilityJoints);
    }

    public void checkData(double data)
    {
        if (data < -10 || data > 10) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMan() {
        return isMan;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getIMT() {
        return IMT;
    }

    public double getThoraxAlone() {
        return thoraxAlone;
    }

    public double getHoraxOnInspiration() {
        return horaxOnInspiration;
    }

    public double getThoraxOnExhalation() {
        return thoraxOnExhalation;
    }

    public double getWaistAboveNavel() {
        return waistAboveNavel;
    }

    public double getWaistAtNavel() {
        return waistAtNavel;
    }

    public double getButtocks() {
        return buttocks;
    }

    public double getVolumeLeftFemur() {
        return volumeLeftFemur;
    }

    public double getVolumeRightFemur() {
        return volumeRightFemur;
    }

    public double getVolumeLeftShoulder() {
        return volumeLeftShoulder;
    }

    public double getVolumeRightshoulder() {
        return volumeRightshoulder;
    }

    public double getFlexibilitySpine() {
        return flexibilitySpine;
    }

    public double getAbdominalMuscles() {
        return abdominalMuscles;
    }

    public double getBackMuscles() {
        return backMuscles;
    }

    public double getFlexibilityJoints() {
        return flexibilityJoints;
    }

    public Map<InspectionName, Double> getInspections() {
        return inspections;
    }
}
