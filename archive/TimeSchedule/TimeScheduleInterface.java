//TimeSchedule.java
//2016-04-18

public interface TimeScheduleInterface {
  //TimeSchedule( void );

  // 成功時にture, 失敗時にfalseを返す
  public abstract boolean searchStation();
  public abstract boolean getStation();
  public abstract boolean putStation();

  public abstract boolean searchLine();
  public abstract boolean getLine();
  public abstract boolean putLine();

  public abstract boolean searchDirection();
  public abstract boolean getDirection();
  public abstract boolean putDirection();

  public abstract boolean getTimeSchedule();
  public abstract boolean storeDBTimeSchedule();
}

