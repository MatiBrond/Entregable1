import com.google.gson.Gson;
import java.util.Collection;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;
import java.util.Arrays;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        port(8070);

        final AgencyService agenciaService = new AgencyServiceImp();
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./log_api.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        get("/agencies/:siteID/:payment_method_id/:id", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.type("application/json");
            String site_id = request.params(":siteID");
            String payment_method_id = request.params(":payment_method_id");
            String id = request.params(":id");
            String data = readUrl("https://api.mercadolibre.com/sites/" + site_id + "/payment_methods/" + payment_method_id);
            Agency[] agencies = agenciaService.getAgencies(data);

        return new Gson().toJson(
                new StandardResponse(
                        StatusResponse.SUCCESS,
                        new Gson().toJsonTree(agencies)));

        });


        get("/agencies", (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "*");
            response.header("Header set Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");

            response.type("application/json");
            //logger.info(request.url()+request.raw().getQueryString());
            String site_id = request.queryParams("site_id");
            String payment_method_id = request.queryParams("payment_method_id");
            String id = request.queryParams("id");
            String par= "";
            boolean flag = true;

            if(id == null){
                String limit = request.queryParams("limit");
                String offset = request.queryParams("offset");
                String sort_by = request.queryParams("sort_by");
                String near_to = request.queryParams("near_to");

                if (limit != null) {
                    par += ( flag ? "?" : "&" ) + "limit=" + limit;
                    flag = false;
                }
                if (offset != null) {
                    par += ( flag ? "?" : "&" ) + "offset=" + offset;
                    flag = false;
                }
                if (sort_by != null) {
                    agenciaService.getCriterio(sort_by);
                    flag = false;
                }
                if(near_to != null){
                    par+= (flag ? "?" : "&" ) + "near_to=" + near_to;
                    flag=false;
                }
                else{
                    sort_by="address_line";
                    agenciaService.getCriterio(sort_by);
                }
            }

            String data = readUrl("https://api.mercadolibre.com/sites/" + site_id + "/payment_methods/" + payment_method_id + "/agencies"+par);
            Agency[] agencies = agenciaService.getAgencies(data);
            Agency[] agenciesOrder = Ordenador.order(agencies);
            return new Gson().toJson(
                    new StandardResponse(
                            StatusResponse.SUCCESS,
                            new Gson().toJsonTree(agenciesOrder)));

        });
    }

    private static String readUrl( String urlString) throws IOException {

        BufferedReader reader = null;
        try{
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            reader = new BufferedReader( new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            int read = 0;
            while(( read = reader.read(chars)) != -1 ){
                buffer.append(chars, 0, read);
            }
            return buffer.toString();

        }   finally {
            if (reader != null){
                reader.close();
            }
        }




    }
}