import java.util.UUID;

public class main {
  public static void main(String[] args) {
    calculateTotalAmountWithChainOfResponsibility();

  }

  public static void calculateTotalAmountWithChainOfResponsibility(){
    //create a request
    Invoice invoice = new Invoice(100,UUID.randomUUID(),true);

    //initializing  processors
    VAT vat = new VAT();
    Service service = new Service();
    Tips tips = new Tips();

    //creating the chain of responsibility
    vat.setNextProcessor(service);
    service.setNextProcessor(tips);

    //starting the chain and send a request
    vat.applyNextProcessor(invoice);
  }


  public static void calculateTotalAmountWithOutChainOfResponsibility(){


  }


}
