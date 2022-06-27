package com.qaprosoft.carina.demo.api.user;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.PATCH)
@ResponseTemplatePath(path = "api/myUser/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class PatchUser extends AbstractApiMethodV2 {
    public PatchUser() {
        super("api/myUser/_patch/rq.json", "api/myUser/_patch/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
