//ControlDB.java
//2016-04-18

//電車の時刻表を格納するDBの管理を行うクラス
public interface ControlDBInterface {
  //constract( DBName, PassWord );

  // 成功時にtrueを返し,失敗したらfalseを返す
  public abstract boolean InsertTimeTable(String Station, String Line, String Direction, String[] TimeTable );
  public abstract boolean DeleteTimeTable(String Station, String Line, String Direction );
  public abstract boolean SelectTimeTable(String Station, String Line, String Direction );
}

