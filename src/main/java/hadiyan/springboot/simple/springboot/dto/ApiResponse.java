package hadiyan.springboot.simple.springboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private Object meta;

    // Success tanpa meta
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", data, null);
    }

    // Success dengan meta (pagination, dsb)
    public static <T> ApiResponse<T> success(T data, Object meta) {
        return new ApiResponse<>(true, "Success", data, meta);
    }

    // Error
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null, null);
    }

    // Error
    public static <T> ApiResponse<T> errorCustom(String message,T data,Object meta) {
        return new ApiResponse<>(false, message, data, meta);
    }
}
