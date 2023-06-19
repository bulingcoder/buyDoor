package com.whw.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

/**
 * 返回体
 *
 *
 * @param <T>
 */
@Builder
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
@JsonComponent
public class Response<T> {

    public String code;

    public String msg;

    /**
     * 表示,如果值为null,则不返回
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public T data;

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public static Response ok() {
        return new Response("0", "OK");
    }

    public static <T> Response<T> okWithResult(T result) {
        return new Response<>("0", "OK", result);
    }


}
