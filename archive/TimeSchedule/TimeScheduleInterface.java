//TimeSchedule.java
//2016-04-18

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public interface TimeScheduleInterface {
  //TimeSchedule( void );

  // 成功時にture, 失敗時にfalseを返す
  public abstract boolean searchStation();
  public abstract boolean getStation( String[] str, Matcher m );
  public abstract List<String> extractStation( String[] str, Matcher m );

  public abstract boolean searchLine();
  public abstract boolean getLine();
  public abstract boolean putLine();

  public abstract boolean searchDirection();
  public abstract boolean getDirection();
  public abstract boolean putDirection();

  public abstract boolean getTimeSchedule();
  public abstract boolean storeDBTimeSchedule();
}

