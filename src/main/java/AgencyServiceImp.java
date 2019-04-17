import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Collection;
import java.util.HashMap;

public class AgencyServiceImp implements AgencyService{

    private HashMap<String, Agency> agenciesMap;

    public void addAgency() {

    }

    public Agency[] getAgencies(String data) {


    Gson gson = new Gson();
    JsonElement jelem = gson.fromJson(data, JsonElement.class);
    JsonObject jobj = jelem.getAsJsonObject();
    String data2 = jobj.get("results").toString();

    Agency[] agencies = new Gson().fromJson(data2, Agency[].class);

    return agencies;

    }


}

