package com.qaprosoft.carina.demo.api.user;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/myUser/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class DeleteUser extends AbstractApiMethodV2 {
    public DeleteUser() {
        super("api/myUser/_delete/rq.json", "api/myUser/_delete/rs.json",new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
