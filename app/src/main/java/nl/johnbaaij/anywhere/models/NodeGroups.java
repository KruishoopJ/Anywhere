package nl.johnbaaij.anywhere.models;

import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class NodeGroups implements Serializable {

    private String name;
    private String lightConfig;
    private ArrayList<String> scannedCodes;

    public NodeGroups(String name, String lightConfig, ArrayList<String> scannedCodes) {
        this.name = name;
        this.lightConfig = lightConfig;
        this.scannedCodes = scannedCodes;
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
}
