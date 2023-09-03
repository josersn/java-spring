package com.backend.healthserviceasservice.application.core;

public abstract class UseCase<Data, Response> {
    public  abstract Response exec(Data data);
}
