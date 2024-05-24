import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.*;
import org.json.*;

public class weather
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("****************WEATHER****************");
        System.out.println("Enter the location to know the weather=");
        String name;
        name=sc.next();
        System.out.println("--------------------------------------------------------------");
        System.out.println("Enter your specificity=");
        System.out.println("fulldetails"+"  temperature"+"  weather"+"  humidity"+"  wind"+"  timezone");
        System.out.println("--------------------------------------------------------------");
        String spec=sc.next();
        if(spec.equals("fulldetails"))
        {
            fulldetails(name);
        }
        else 
        {
            if(spec.equals("temperature"))
            {
                System.out.println("temperature="+temp(name));
            }
            else if(spec.equals("weather"))
            {
                System.out.println("weather="+weather(name));
            }
            else if (spec.equals("humidity"))
            {
                System.out.println("humidity="+hum(name));
            }
            if(spec.equals("wind"))
            {
                System.out.println("wind speed="+wind(name)+" "+"wind direction="+winddir(name));
            }
            else if(spec.equals("timezone"))
            {
                System.out.println("timezone="+timzone(name));
            }
        }
    }
    public static String temp(String name) throws Exception
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);

            double currtemp = result.getDouble("temp");
            return String.valueOf(currtemp);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return "specificity not available";
        }
    }
    public static String hum(String name) throws Exception 
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);
            double hm = result.getDouble("rh");
            return String.valueOf(hm);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return " specifity not available";
        }

    }
    public static String wind(String name) throws Exception 
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);
            double windspeed = result.getDouble("wind_spd");
            return String.valueOf(windspeed);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return " specifity not available";
        }

    }
    public static String winddir(String name) throws Exception 
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);
            String winddir = result.getString("wind_cdir_full");
            return String.valueOf(winddir);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return " specifity not available";
        }
    }
    public static String weather(String name) throws Exception 
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);
            JSONObject wt = result.getJSONObject("weather");
            String weather = wt.getString("description");
            return String.valueOf(weather);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return " specifity not available";
        }
    } 
    public static String timzone(String name) throws Exception 
    {
        String apikey="b0c5ab9cfd374967bc73d33dc38274d6";
        String res=name.replace(" ","%20");
        String apiurl="https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key="+apikey+"&city="+name;
        URL url = new URL(apiurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject json_obj = new JSONObject(response.toString());
        JSONArray dataArray = json_obj.getJSONArray("data");
        try 
        {
            JSONObject result = dataArray.getJSONObject(0);
            String timez = result.getString("timezone");
            return String.valueOf(timez);
        }
        catch(Exception e)
        {
            System.out.println("Requested specifity not Found!");
            return " specifity not available";
        }
    }
    public static void fulldetails(String name) throws Exception 
    {
        System.out.println("here's the full weather details of the location=");
        System.out.println();
        System.out.println("temperature="+temp(name));
        System.out.println();
        System.out.println("weather="+weather(name));
        System.out.println();
        System.out.println("humidity="+hum(name));
        System.out.println();
        System.out.println("wind speed="+wind(name)+","+"wind direction="+winddir(name));
        System.out.println();
        System.out.println("timezone="+timzone(name));
    }

}