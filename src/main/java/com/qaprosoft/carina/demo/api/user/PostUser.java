package com.qaprosoft.carina.demo.api.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@ResponseTemplatePath(path = "api/myUser/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)


public class PostUser extends AbstractApiMethodV2 {
    public PostUser() {
        super("api/myUser/_post/rq.json", "api/myUser/_post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
