package converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ConverterRequestTest {

    @Spy
    ConverterRequest request;

    @Test
    public void tCconvert(){
        String res = request.convert("26C", "", "");
        JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();

        Assert.assertTrue(jsonObject.isJsonObject());
        Assert.assertTrue(jsonObject.get("F").getAsString().equals("79"));
        Assert.assertTrue(jsonObject.get("K").getAsString().equals("299"));

    }

    @Test
    public void tFconvert(){
        String res = request.convert("", "79F", "");
        JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();

        Assert.assertTrue(jsonObject.isJsonObject());
        Assert.assertEquals("26", jsonObject.get("C").getAsString());
        Assert.assertEquals("299", jsonObject.get("K").getAsString());

    }

    @Test
    public void tKconvert(){
        String res = request.convert("", "", "299K");
        JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();

        Assert.assertTrue(jsonObject.isJsonObject());
        Assert.assertTrue(jsonObject.get("C").getAsString().equals("26"));
        Assert.assertTrue(jsonObject.get("F").getAsString().equals("79"));

    }

    @Test
    public void emptyConvert(){
        String res = request.convert("", "", "");
        JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();

        Assert.assertTrue(jsonObject.isJsonObject());
    }

    @Test
    public void getSet(){
        request.getRes();
        request.gettC();
        request.gettF();
        request.gettK();
        request.setRes(any());
        request.settC(any());
        request.settF(any());
        request.settK(any());
        request.toString();

    }
}
