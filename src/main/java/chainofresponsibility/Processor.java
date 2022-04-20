package chainofresponsibility;

public abstract class Processor {
  Processor nextProcessor;

  public abstract Invoice applyProcessor(Invoice invoice);

  public void setNextProcessor(Processor nextProcessor) {
    this.nextProcessor = nextProcessor;
  }
}
