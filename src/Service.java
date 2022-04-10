public class Service extends Processor{

  @Override
  public Invoice applyNextProcessor(Invoice invoice) {
    if(invoice.isDineIn()){
      invoice.setTotalAmount(invoice.getTotalAmount()+ invoice.getAmount()*0.12);
      System.out.println("Service :" + invoice.getTotalAmount());
    }
    return nextProcessor.applyNextProcessor(invoice);
  }
}
