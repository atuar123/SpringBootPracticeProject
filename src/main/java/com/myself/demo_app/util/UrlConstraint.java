package com.myself.demo_app.util;

public final class UrlConstraint {
    private UrlConstraint(){

    }
    public static final String VERSION = "/v1";
    public static final String API = "/api";

    public static class ProductManagement{
        public static final String ROOT = API+VERSION+"/products";
        public static final String CREATE = "/create";
        public static final String UPDATE = "/{id}";
        public static final String DELETE = "/{id}";
        public static final String GET = "/{id}";
        public static final String GET_ALL = "/all";

    }
}
