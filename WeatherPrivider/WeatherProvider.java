package WeatherPrivider;

import Aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};


    private WeatherProvider ()
    {

    }

    protected static WeatherProvider getProvider() {
        return weatherProvider;
    }

    protected String getCurrentWeather(Coordinates _coordinates) {
        return weather[(_coordinates.getLongitude() + _coordinates.getLatitude() + _coordinates.getHeight()) % 4];
    }

}
