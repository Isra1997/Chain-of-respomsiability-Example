import java.util.UUID;

public class main {
  public static void main(String[] args) {
    Invoice invoice = new Invoice(100,UUID.randomUUID(),true);

    VAT vat = new VAT();
    Service service = new Service();
    Tips tips = new Tips();

    vat.setNextProcessor(service);
    service.setNextProcessor(tips);


    vat.applyNextProcessor(invoice);

  }
}
