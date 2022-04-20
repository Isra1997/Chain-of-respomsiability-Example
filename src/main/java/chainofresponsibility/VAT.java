package chainofresponsibility;

import chainofresponsibility.Invoice;
import chainofresponsibility.Processor;

public class VAT extends Processor {
  @Override
  public Invoice applyProcessor(Invoice invoice) {
    invoice.setTax(invoice.getAmount()*0.14);
    invoice.setTotalAmount(invoice.getAmount() + invoice.getTax());
    System.out.println("Vat tax:" + invoice.getTotalAmount());
    return nextProcessor.applyProcessor(invoice);
  }
}
