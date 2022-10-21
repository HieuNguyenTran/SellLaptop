package vn.edu.nlu.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Product3 implements Serializable {
    private String id;
    private String name;
    private String img;
    private double price;
    private double phanTramKM;
    private double priceSale;
    private int quantity;
    private int star;
    private int ram;
    private String description;
    private String oCung;
    private List<Comment> comment;
    private List<Evaluate> evaluate;
    private Connector conector;
    private Cpu cpu;
    private Memory memory;
    private Monitor monitor;
    private OperatingSys o;
    private Size size;
    private Sound sound;
    private Pin pin;
    public Product3() {

    }



    public Product3(String id, String name, String img, double price, double priceSale) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.priceSale = priceSale;
    }
    public Product3(String id, String name, String img, double price, double priceSale,double phanTram,int star,int ram, String oCung) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.priceSale = priceSale;
        this.phanTramKM=phanTram;
        this.ram=ram;
        this.oCung=oCung;
        this.star=star;
    }

    public Product3(String id, String name, String img, double price, double priceSale, int star,String description, List<Comment> comment, List<Evaluate> evaluate, Connector conector, Cpu cpu, Memory memory, Monitor monitor, OperatingSys o, Size size, Sound sound, Pin pin) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;

        this.priceSale = priceSale;

        this.star = star;

        this.description = description;

        this.comment = comment;
        this.evaluate = evaluate;
        this.conector = conector;
        this.cpu = cpu;
        this.memory = memory;
        this.monitor = monitor;
        this.o = o;
        this.size = size;
        this.sound = sound;
        this.pin=pin;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(double phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Evaluate> getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(List<Evaluate> evaluate) {
        this.evaluate = evaluate;
    }

    public Connector getConector() {
        return conector;
    }

    public void setConector(Connector conector) {
        this.conector = conector;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public OperatingSys getO() {
        return o;
    }

    public void setO(OperatingSys o) {
        this.o = o;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product3)) return false;
        Product3 Product3 = (Product3) o;
        return Double.compare(Product3.price, price) == 0 &&
                Double.compare(Product3.phanTramKM, phanTramKM) == 0 &&
                Double.compare(Product3.priceSale, priceSale) == 0 &&
                quantity == Product3.quantity &&
                star == Product3.star &&
                ram == Product3.ram &&
                id.equals(Product3.id) &&
                name.equals(Product3.name) &&
                img.equals(Product3.img) &&
                oCung.equals(Product3.oCung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, img, price, phanTramKM, priceSale, quantity, star, ram, oCung);
    }
    public static String priceToString(double price){
        String result="";
        int price2 = (int) price;
        String price1 = String.valueOf(price2);
        char[] arr = price1.toCharArray();
        int count=0;
        for (int i = arr.length-1; i >=0; i--) {

            if (count%3==0&&count!=0)
                result= arr[i]+","+result;
            else
                result= arr[i]+result;
            count++;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Product3{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", phanTramKM=" + phanTramKM +
                ", priceSale=" + priceSale +
                ", quantity=" + quantity +
                ", star=" + star +
                ", ram=" + ram +
                ", description='" + description + '\'' +
                ", oCung='" + oCung + '\'' +
                ", comment=" + comment +
                ", evaluate=" + evaluate +
                ", conector=" + conector +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", monitor=" + monitor +
                ", o=" + o +
                ", size=" + size +
                ", sound=" + sound +
                '}';
    }

}