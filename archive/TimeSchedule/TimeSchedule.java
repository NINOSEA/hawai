//TimeSchedule.java
//2016-04-18

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TimeSchedule implements TimeScheduleInterface {
  public boolean searchStation() {
    Matcher m = Pattern.compile( "" ).matcher( "" );
    String[] str = { "" };

    if( getStation( str, m ) == false ){
      System.out.println( "ERROR : in getStation" );
    }

    List<String> StationData = extractStation( str, m );
    for( String index : StationData ){
      System.out.println( index );
    }

    return true;
  }

  public boolean getStation( String[] str, Matcher m ){
    InputStreamReader is = new InputStreamReader( System.in );
    BufferedReader br = new BufferedReader( is );
    //Matcher m = Pattern.compile( "" ).matcher( "" );

    System.out.println( "駅名を入力してください." );

    //String str = new String();

    try{
      String keyword = br.readLine();
      // 指定したURLのソースファイルをテキストで取得
      str[0] = getSourceText( new URL( "http://transit.yahoo.co.jp/station/time/search?srtbl=on&kind=1&done=time&q=" + keyword ) );
    }
    catch( IOException e ){
      System.out.println( "in getStation method" );
    }

    // 駅検索のパート
    // 駅名が検索できなかった場合
    if( Pattern.compile( "で該当する駅はありませんでした。" ).matcher( str[0] ).find() ){
      System.out.println( "ERROR : 該当する駅がありませんでした." );
      return false;
    }
    return true;
  }

  public List<String> extractStation( String[] str, Matcher m ){
    // 駅名が検索できた場合
    List<String>listURL = new ArrayList<String>(); //複数マッチの文字列を格納するList
    m = Pattern.compile( "<ul class=\"elmSearchItem quad\">.*?</ul>" ).matcher( str[0] );
    if( m.find() ){
      String matcherStr = m.group();              // マッチした文字列を一時的に格納する変数

      m = Pattern.compile( "<a href=\"(.+?)\">(.+?)</a>" ).matcher( matcherStr );

      System.out.println( );
      //マッチした部分がなくなるまでwhile
      while( m.find() ){
        //リストにマッチしたURL部分を格納しいていく.
        listURL.add( m.group( 1 ) );
        listURL.add( m.group( 2 ) );
      }
      //selectStation();
      try {
        // 駅名から次のページのソースを取得
        str[0] = getSourceText( new URL( "http://transit.yahoo.co.jp" + listURL.get( 0 ) ) );
      } catch( IOException e ){
        System.out.println( "in searchStation method" );
      }
    }

    return listURL;
  }

  public boolean searchLine(){
    return true;
  }
  public boolean getLine(){
    return true;
  }
  public boolean putLine(){
    return true;
  }

  public boolean searchDirection(){
    return true;
  }
  public boolean getDirection(){
    return true;
  }
  public boolean putDirection(){
    return true;
  }

  public boolean getTimeSchedule(){
    return true;
  }
  public boolean storeDBTimeSchedule(){
    return true;
  }

  private static String getSourceText(URL url) throws IOException {
    InputStream in = url.openStream();
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader bf = new BufferedReader(new InputStreamReader(in));
      String s;
      while ((s=bf.readLine())!=null) {
        sb.append(s);
      }
    } finally {
      in.close();
    }
    return sb.toString();
  }
}

