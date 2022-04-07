public class Tips extends Processor{
  //assuming that it is preferred that if the check
  // exceeds a specific amount it is important to tip

  @Override
  public Invoice applyNextProcessor(Invoice invoice) {
    if(invoice.getAmount() > 200){
      invoice.setTotalAmount(invoice.getTotalAmount()+ invoice.getAmount()*0.20);
      System.out.println("Tips:" + invoice.getTotalAmount());
    }
    return invoice;
  }

}
