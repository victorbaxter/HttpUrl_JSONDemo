package com.example.kiz.httpurl_jsondemo;

import java.util.List;

public interface IAsyncResponse {
    void processFinish(List<Repo> repos);
}
