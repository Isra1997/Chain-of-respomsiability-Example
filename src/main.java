import java.util.UUID;

public class main {
  public static void main(String[] args) {
    //create a request
    Invoice invoice = new Invoice(100,UUID.randomUUID(),true);

    calculateTotalAmountWithChainOfResponsibility(invoice);
    calculateTotalAmountWithOutChainOfResponsibility(invoice);

  }

  public static void calculateTotalAmountWithChainOfResponsibility(Invoice invoice){


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


  public static void calculateTotalAmountWithOutChainOfResponsibility(Invoice invoice){
    invoice.setTax(invoice.getAmount()*0.14);
    invoice.setTotalAmount(invoice.getAmount() + invoice.getTax());
    System.out.println("Vat tax:" + invoice.getTotalAmount());
    if(invoice.isDineIn()){
      invoice.setTotalAmount(invoice.getTotalAmount()+ invoice.getAmount()*0.12);
      System.out.println("Service :" + invoice.getTotalAmount());
    }else if(invoice.getAmount() > 200){
      invoice.setTotalAmount(invoice.getTotalAmount()+ invoice.getAmount()*0.20);
      System.out.println("Tips:" + invoice.getTotalAmount());
    }

  }


}
