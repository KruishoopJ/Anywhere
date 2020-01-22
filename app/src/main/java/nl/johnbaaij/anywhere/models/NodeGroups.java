package nl.johnbaaij.anywhere.models;

import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
//This is required for the database
public class NodeGroups implements Serializable {

    private String name;
    private String lightConfig;
    private ArrayList<String> scannedCodes;
    private boolean hasWrenchError;
    private boolean hasWarning;
    private boolean hasBatteryError;

    public NodeGroups(){

    }


    public NodeGroups(String name, String lightConfig, ArrayList<String> scannedCodes, boolean hasWrenchError, boolean hasWarning, boolean hasBatteryError) {
        this.name = name;
        this.lightConfig = lightConfig;
        this.scannedCodes = scannedCodes;
        this.hasWrenchError = hasWrenchError;
        this.hasWarning = hasWarning;
        this.hasBatteryError = hasBatteryError;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLightConfig() {
        return lightConfig;
    }

    public void setLightConfig(String lightConfig) {
        this.lightConfig = lightConfig;
    }

    public ArrayList<String> getScannedCodes() {
        return scannedCodes;
    }

    public void setScannedCodes(ArrayList<String> scannedCodes) {
        this.scannedCodes = scannedCodes;
    }

    public boolean isHasWrenchError() {
        return hasWrenchError;
    }

    public void setHasWrenchError(boolean hasWrenchError) {
        this.hasWrenchError = hasWrenchError;
    }

    public boolean isHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    public boolean isHasBatteryError() {
        return hasBatteryError;
    }

    public void setHasBatteryError(boolean hadBatteryError) {
        this.hasBatteryError = hadBatteryError;
    }
}
