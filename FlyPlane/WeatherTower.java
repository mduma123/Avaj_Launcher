package FlyPlane;

import Aircraft.Coordinates;
import WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionChanged();
    }
}
