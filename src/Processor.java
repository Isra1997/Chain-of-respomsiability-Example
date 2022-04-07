public abstract class Processor {
  Processor nextProcessor;

  public abstract Invoice applyNextProcessor(Invoice invoice);

  public void setNextProcessor(Processor nextProcessor) {
    this.nextProcessor = nextProcessor;
  }
}
