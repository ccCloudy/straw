package cyl.straw.ap.iuser.Util;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;
    public R(Integer state){
        this.state=state;
    }
    public R(){}

    public static R ok(){
        return new R(State.Ok);
    }
    public static <E> R ok(E data){
        R r = new R();
        r.setState(State.Ok);
        r.setData(data);
        return r;
    }
    public static R failure(Integer state,Throwable e){
        R r = new R();
        r.setState(state);
        r.setMessage(e.getMessage());
        return r;
    }

    public interface State{
        Integer Ok = 2000;

        Integer ERR_USERNAME_DUPLICATE = 4001;
        Integer ERR_PHONE_DUPLICATE = 4002;
        Integer ERR_INVITE_CODE = 4003;
        Integer ERR_CLASS_DISABLED = 4004;
        Integer ERR_INSERT = 4005;
        Integer ERR_ILLEGAL_PARAMETER = 4006;
        Integer ERR_UNKNOWN = 4000;
    }
}
