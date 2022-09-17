package vn.edu.nlu.beans;

public class Connector {
    private String connector;
    private String connectWithoutLine;
    private String memoryCard;
    private String opticalStorage;
    private String keyBoard;
    private String webCam;
    private String feature;
    private String lightKeyboard;

    public Connector() {
    }

    public Connector(String connector, String connectWithoutLine, String memoryCard, String opticalStorage, String keyBoard, String webCam, String feature, String lightKeyboard) {
        this.connector = connector;
        this.connectWithoutLine = connectWithoutLine;
        this.memoryCard = memoryCard;
        this.opticalStorage = opticalStorage;
        this.keyBoard = keyBoard;
        this.webCam = webCam;
        this.feature = feature;
        this.lightKeyboard = lightKeyboard;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getConnectWithoutLine() {
        return connectWithoutLine;
    }

    public void setConnectWithoutLine(String connectWithoutLine) {
        this.connectWithoutLine = connectWithoutLine;
    }

    public String getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(String memoryCard) {
        this.memoryCard = memoryCard;
    }

    public String getOpticalStorage() {
        return opticalStorage;
    }

    public void setOpticalStorage(String opticalStorage) {
        this.opticalStorage = opticalStorage;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getWebCam() {
        return webCam;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getLightKeyboard() {
        return lightKeyboard;
    }

    public void setLightKeyboard(String lightKeyboard) {
        this.lightKeyboard = lightKeyboard;
    }
}
