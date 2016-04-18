//TimeSchedule.java
//2016-04-18

public interface TimeScheduleInterface {
  //TimeSchedule( void );

  public abstract void searchStation();
  public abstract void getStation();
  public abstract void putStation();

  public abstract void searchLine();
  public abstract void getLine();
  public abstract void putLine();

  public abstract void searchDirection();
  public abstract void getDirection();
  public abstract void putDirection();

  public abstract void getTimeSchedule();
  public abstract void storeDBTimeSchedule();
}

