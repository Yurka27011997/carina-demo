package com.qaprosoft.carina.demo.api.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/login", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/myUser/_postLogin/rq.json")
@ResponseTemplatePath(path = "api/myUser/_postLogin/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class PostLoginUser extends AbstractApiMethodV2 {
    public PostLoginUser() {
        super("api/myUser/_postLogin/rq.json", "api/myUser/_postLogin/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
