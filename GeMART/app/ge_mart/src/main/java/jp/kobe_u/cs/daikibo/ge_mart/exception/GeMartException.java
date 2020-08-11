package jp.kobe_u.cs.daikibo.ge_mart.exception;

public class GeMartException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // エラーの内容が分かればええのでコードとか使わない。メッセージに全部入れる
    public GeMartException(String message) {
        super(message);
    }

}