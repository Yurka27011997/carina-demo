package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.animals.GetPandasFactMethod;
import com.qaprosoft.carina.demo.api.user.*;
import com.qaprosoft.carina.demo.api.weather.GetCityWeather;
import com.qaprosoft.carina.demo.api.weather.GetWeatherByGeoCoordinates;
import com.qaprosoft.carina.demo.api.weather.GetWeatherById;
import com.qaprosoft.carina.demo.api.weather.GetWeatherByZipCode;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class MyApiTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeather() {
        GetCityWeather getCityWeather = new GetCityWeather();
        getCityWeather.callAPIExpectSuccess();
        getCityWeather.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCityWeather.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeatherByZipCode() {
        GetWeatherByZipCode getWeatherByZipCode = new GetWeatherByZipCode();
        getWeatherByZipCode.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByZipCode.callAPI();
        getWeatherByZipCode.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByZipCode.validateResponseAgainstSchema("api/weather/_getByZipCode/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeatherById() {
        GetWeatherById getWeatherById = new GetWeatherById();
        getWeatherById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherById.callAPI();
        getWeatherById.validateResponseAgainstSchema("api/weather/_getById/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeatherByGeoCoordinates() {
        GetWeatherByGeoCoordinates getWeatherByGeoCoordinates = new GetWeatherByGeoCoordinates();
        getWeatherByGeoCoordinates.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByGeoCoordinates.callAPI();
        getWeatherByGeoCoordinates.validateResponseAgainstSchema("api/weather/_getByGeoCoordinates/rs.schema");
    }

    @Test()
    public void GetPandasFactTest(){
        GetPandasFactMethod getPandasFactMethod = new GetPandasFactMethod();
        getPandasFactMethod.callAPIExpectSuccess();
        getPandasFactMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPandasFactMethod.validateResponseAgainstSchema("api/animals/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostUser api = new PostUser();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testPatchUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PatchUser api = new PatchUser();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testRegisterUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostRegisterUser api = new PostRegisterUser();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateLogin() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostLoginUser api = new PostLoginUser();
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testDeleteUser() {
        DeleteUser deleteUserMethod = new DeleteUser();
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }



}
