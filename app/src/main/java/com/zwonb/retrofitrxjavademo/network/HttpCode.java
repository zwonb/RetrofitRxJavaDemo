package com.zwonb.retrofitrxjavademo.network;

/**
 * HTTP错误的状态码
 * Created by zwonb on 2017/11/15.
 */

public interface HttpCode {
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int REQUEST_TIMEOUT = 408;
    int INTERNAL_SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAILABLE = 503;
    int GATEWAY_TIMEOUT = 504;
}
