package Ej_Matrix;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    private String code = null;
    private int value = 0;

    public MessageInfo(String c, int v) {
        this.code = c;
        this.value = v;
    }

    public void setCode(String c) {
        this.code = c;
    }

    public String getCode() {
        return this.code;
    }

    public void setValue(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

}
