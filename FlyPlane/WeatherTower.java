package FlyPlane;

import Aircraft.Coordinates;
import Weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}
