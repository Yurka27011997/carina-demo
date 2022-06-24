package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetCityWeather;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class MyApiTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeather() {
        GetCityWeather getCityWeather = new GetCityWeather();
        getCityWeather.callAPIExpectSuccess();
        getCityWeather.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCityWeather.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }
}
