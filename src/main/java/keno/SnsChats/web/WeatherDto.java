package keno.SnsChats.web;

import lombok.Data;

@Data
public class WeatherDto {
    private Double temperature;
    private Forecast forecast;

    public static WeatherDto createMock() {
        WeatherDto dto = new WeatherDto();
        dto.temperature = 25.5;
        dto.forecast = Forecast.SUNNY;
        return dto;
    }
}

