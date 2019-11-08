package converter;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class ConverterRequest {

    private String tC;
    private String tF;
    private String tK;
    private String res;

    public ConverterRequest() {
        this.tC = "";
        this.tF = "";
        this.tK = "";
        this.res = "";
    }

    public ConverterRequest(String tC, String tF, String tK) {
        this.tC = tC;
        this.tF = tF;
        this.tK = tK;
        this.res = convert(tC, tF, tK);
    }

    public String getRes() {
        return res;
    }

    public String gettC() {
        return tC;
    }

    public String gettF() {
        return tF;
    }

    public String gettK() {
        return tK;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public void settC(String tC) {
        this.tC = tC;
    }

    public void settF(String tF) {
        this.tF = tF;
    }

    public void settK(String tK) {
        this.tK = tK;
    }

    @Override
    public String toString() {
        return "{" + "tC:" + tC + ",tF:" + tF + ",tK:" + tK + "}";
    }

    public String convert(String tempC, String tempF, String tempK){
        String res = "";
        JSONObject jo = new JSONObject();
        String[] numbers;
        if(StringUtils.isNotBlank(tempC)){
            numbers = tempC.split("");
            for (int i = 0; i < tempC.length(); i++) {
                if(StringUtils.isNumeric(numbers[i])){
                    res = res + numbers[i];
                } else{
                    break;
                }
            }
            tempF = String.valueOf(Math.round(Integer.valueOf(res) * 1.8) + 32);
            tempK = String.valueOf(Math.round(Integer.valueOf(res) + 273.15));
            jo.put("F", Integer.valueOf(tempF));
            jo.put("K", Integer.valueOf(tempK));
            return String.valueOf(jo);
        } else if(StringUtils.isNotBlank(tempF)){
            numbers = tempF.split("");
            for (int i = 0; i < tempF.length(); i++) {
                if(StringUtils.isNumeric(numbers[i])){
                    res = res + numbers[i];
                } else{
                    break;
                }
            }
            tempC = String.valueOf(Math.round((Integer.valueOf(res) - 32) / 1.8));
            tempK = String.valueOf(Math.round((Integer.valueOf(res) + 459.67) / 1.8));
            jo.put("C", Integer.valueOf(tempC));
            jo.put("K", Integer.valueOf(tempK));
            return String.valueOf(jo);
        } else if(StringUtils.isNotBlank(tempK)){
            numbers = tempK.split("");
            for (int i = 0; i < tempK.length(); i++) {
                if(StringUtils.isNumeric(numbers[i])){
                    res = res + numbers[i];
                } else{
                    break;
                }
            }
            tempF = String.valueOf(Math.round(Integer.valueOf(res) * 1.8 - 459.67));
            tempC = String.valueOf(Math.round(Integer.valueOf(res) - 273.15));
            jo.put("C", Integer.valueOf(tempC));
            jo.put("F", Integer.valueOf(tempF));
            return String.valueOf(jo);
        }
        else return String.valueOf(jo);
    }
}
