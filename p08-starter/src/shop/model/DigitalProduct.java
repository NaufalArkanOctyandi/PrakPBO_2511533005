package shop.model;
public class DigitalProduct extends Product implements Downloadable {
 private final String downloadLink;
 public DigitalProduct(String sku,String name,long price,String downloadLink) {super(sku,name,price);this.downloadLink=downloadLink;}
 public String getDownloadLink(){return downloadLink;}
}
