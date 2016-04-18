//LocalPushAndroid.java
//2016-04-18

// ローカルプッシュ通知を行うメソッドの管理を行うクラス
public interface LocalPushAndroidInterface {

  // 成功時にtrueを返し,失敗したらfalseを返す
	public abstract boolean LocalPush( String PushWord );
}

