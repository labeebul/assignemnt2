package mavi1;

@SuppressWarnings("serial")
public class SeatsExceedLimit extends RuntimeException {
      public SeatsExceedLimit(String msg) {
    	  super(msg);
      }
}
