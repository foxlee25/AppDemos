package com.infifox.fox.howhelper.base;

import com.infifox.fox.howhelper.apis.ApiServices;
import com.infifox.fox.howhelper.apis.HSNetWorkClient;
import com.infifox.fox.howhelper.apis.NetworkClient;

/**
 * Created by jili on 12/21/16.
 */

public class BaseRepository  implements BaseSource{
    protected ApiServices mApiService = HSNetWorkClient.getApiService();
}
