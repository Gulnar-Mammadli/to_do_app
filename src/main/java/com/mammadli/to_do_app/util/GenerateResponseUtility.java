package com.mammadli.to_do_app.util;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.db.entity.User;

import java.util.List;

public class GenerateResponseUtility {
    public static GenerateResponse<Integer, String, User, ResponseData<User>> userFunc = (code, message, data) ->
            ResponseData.<User>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

    public static GenerateResponse<Integer, String, String, ResponseData<String>> func = (code, message, data) ->
            ResponseData.<String>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

    public static GenerateResponse<Integer, String, Task, ResponseData<Task>> taskFunc = (code, message, data) ->
            ResponseData.<Task>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

    public static GenerateResponse<Integer, String, List<Task>, ResponseData<List<Task>>> tasksFunc = (code, message, data) ->
            ResponseData.<List<Task>>builder()
                    .code(code)
                    .message(message)
                    .data(data)
                    .build();

}
