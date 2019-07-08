package com.dcba.httppartition.separate;

import android.support.annotation.Nullable;

import com.dcba.httppartition.request.BaseUrl;
import com.dcba.httppartition.request.HttpCall;
import com.dcba.httppartition.request.RequestFactory;
import com.dcba.httppartition.request.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HttpPartition {
    private BaseUrl baseUrl;
    private HttpClient httpClient;
    private Converter baseConverter;

    private HttpPartition(BaseUrl baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
    }

    public void setBaseConverter(Converter baseConverter) {
        this.baseConverter = baseConverter;
    }

    public <T> T create(final Class<T> service) {
        /*Utils.validateServiceInterface(service);
        if (validateEagerly) {
            eagerlyValidateMethods(service);
        }*/

        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    //private final Platform platform = Platform.get();
                    private final Object[] emptyArgs = new Object[0];

                    @Override
                    public Object invoke(Object proxy, Method method, @Nullable Object[] args)
                            throws Throwable {
                        // If the method is a method from Object then defer to normal invocation.
                        if (method.getDeclaringClass() == Object.class) {
                            return method.invoke(this, args);
                        }
                        /*if (platform.isDefaultMethod(method)) {
                            return platform.invokeDefaultMethod(method, service, proxy, args);
                        }*/
                        return loadServiceMethod(method, args);
                    }
                });
    }

    private Object loadServiceMethod(Method method, Object[] args) {
        RequestInfo requestInfo = RequestFactory.createRequestInfo(method, args);
        requestInfo.setUrl_firsthalf(baseUrl.getBaseurl());
        ResponseConverter responseConverter = new ResponseConverter();
        responseConverter.setBaseConverter(baseConverter);
        HttpCall httpCall = new HttpCall(httpClient, requestInfo, responseConverter);
        return httpCall;
    }


    public static final class Builder {
        private HttpClient httpClient;
        private BaseUrl baseUrl = new BaseUrl();

        public Builder baseUrl(String baseUrl) {
            this.baseUrl.setBaseurl(baseUrl);
            return this;
        }

        public Builder baseUrl2(String baseUrl) {
            this.baseUrl.setBaseurl2(baseUrl);
            return this;
        }

        public Builder baseUrl3(String baseUrl) {
            this.baseUrl.setBaseurl3(baseUrl);
            return this;
        }

        public Builder setHttpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public HttpPartition build() {
            if (baseUrl == null) {
                throw new IllegalStateException("Base URL required.");
            }
            return new HttpPartition(this.baseUrl, httpClient);
        }
    }
}
