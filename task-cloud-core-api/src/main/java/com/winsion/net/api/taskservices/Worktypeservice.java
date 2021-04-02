package com.winsion.net.api.taskservices;

import java.util.concurrent.CompletableFuture;

public interface Worktypeservice {

    String getareas();

    String getareas2();

    String getUsers();

    String getareatypes();


    String updateTask();

    //异步执行
    CompletableFuture<String> sayHello(String name);
}
