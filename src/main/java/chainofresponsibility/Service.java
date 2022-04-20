package chainofresponsibility;

import chainofresponsibility.Invoice;
import chainofresponsibility.Processor;

public class Service extends Processor {

  @Override
  public Invoice applyProcessor(Invoice invoice) {
    if(invoice.isDineIn()){
      invoice.setTotalAmount(invoice.getTotalAmount()+ invoice.getAmount()*0.12);
      System.out.println("Service :" + invoice.getTotalAmount());
    }
    return nextProcessor.applyProcessor(invoice);
  }
}
