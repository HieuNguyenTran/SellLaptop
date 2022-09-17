package vn.edu.nlu.beans;

public class Sound {
    private String designOfCard;
    private String graphicCard;
    private String techOfSound;

    public Sound() {
    }

    public Sound(String designOfCard, String graphicCard, String techOfSound) {
        this.designOfCard = designOfCard;
        this.graphicCard = graphicCard;
        this.techOfSound = techOfSound;
    }

    public String getDesignOfCard() {
        return designOfCard;
    }

    public void setDesignOfCard(String designOfCard) {
        this.designOfCard = designOfCard;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getTechOfSound() {
        return techOfSound;
    }

    public void setTechOfSound(String techOfSound) {
        this.techOfSound = techOfSound;
    }
}
