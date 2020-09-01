package Weather;

import Aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};


     WeatherProvider ()
    {

    }

    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates _coordinates) {
         if(_coordinates.getHeight() < 0)
         {
             _coordinates.setHeight(3);
         }
        return weather[(_coordinates.getLongitude() + _coordinates.getLatitude() + _coordinates.getHeight()) % 4];

}

}
