package com.calculator;

import java.text.NumberFormat;

public class LengthConvert {

    final double metres = 1;
    final double centimetres = 100;
    final double kilometres = 0.001;
    final double feet = 3.281;
    final double miles = 0.0006214;
    final double millimetres = 1000;
    final double yards = 1.093613;

    private double beginning_qty;
    private double ending_qty;
    private String from_unit;
    private String to_unit;

    public LengthConvert(){
        beginning_qty = 0;
        ending_qty = 0;
        from_unit ="";
        to_unit = "";
    }

    public double getBeginning_qty() {
        return beginning_qty;
    }

    public void setBeginning_qty(double beginning_qty) {
        this.beginning_qty = beginning_qty;
    }

    public double getEnding_qty() {
        return ending_qty;
    }

    public void setEnding_qty(double ending_qty) {
        this.ending_qty = ending_qty;
    }

    public String getFrom_unit() {
        return from_unit;
    }

    public void setFrom_unit(String from_unit) {
        this.from_unit = from_unit;
    }

    public String getTo_unit() {
        return to_unit;
    }

    public void setTo_unit(String to_unit) {
        this.to_unit = to_unit;
    }

    public double getUnitTypeConstant(String unit_type){
        if(unit_type == "metres"){return metres;}
        if (unit_type == "centimetres"){return centimetres;}
        if(unit_type == "kilometres"){return kilometres;}
        if(unit_type == "feet"){return feet;}
        if(unit_type == "miles"){return miles;}
        if(unit_type == "millimetres"){return millimetres;}
        if(unit_type == "yards"){return yards;}
        return 0;
    }

    public double calculateEnding_qty(){
        double beginning_qty = getBeginning_qty();
        double ending_qty = getEnding_qty();
        double beginning_unit_type = getUnitTypeConstant(getFrom_unit());
        double ending_unit_type = getUnitTypeConstant(getTo_unit());

        ending_qty = metres/beginning_unit_type;

        ending_qty = ending_qty * ending_unit_type;

        ending_qty = ending_qty * beginning_qty;

        return ending_qty;
    }

    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();

        if(to_unit.equals("feet") || to_unit.equals("yards")){
            nf.setMaximumFractionDigits(2);
        }else{
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getEnding_qty()) + " " + getTo_unit();
    }
}
