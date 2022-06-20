//package com.qaprosoft.carina.demo.api.weather;
//
//import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
//import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
//import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
//import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
//import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
//import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
//import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
//import com.qaprosoft.carina.core.foundation.utils.Configuration;
//
//@Endpoint(url = "${base_url}", methodType = HttpMethodType.DELETE)
//@RequestTemplatePath(path = "api/users/_delete/rq.json")
//@ResponseTemplatePath(path = "api/users/_delete/rs.json")
//@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
//
//public class DeleteCityWeather extends AbstractApiMethodV2 {
//    public DeleteCityWeather () {
//        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
//    }
//
//}
