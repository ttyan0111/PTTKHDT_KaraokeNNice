package com.nnice.karaoke.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Tiện ích tạo response cho API
 */
public class ResponseUtil {
    
    /**
     * Tạo response thành công
     */
    public static Map<String, Object> success(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("code", 200);
        response.put("message", message);
        response.put("data", data);
        response.put("timestamp", DateTimeUtil.formatDateTime(DateTimeUtil.now()));
        return response;
    }
    
    /**
     * Tạo response thành công (chỉ message)
     */
    public static Map<String, Object> success(String message) {
        return success(message, null);
    }
    
    /**
     * Tạo response lỗi
     */
    public static Map<String, Object> error(String message, int code, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "ERROR");
        response.put("code", code);
        response.put("message", message);
        response.put("data", data);
        response.put("timestamp", DateTimeUtil.formatDateTime(DateTimeUtil.now()));
        return response;
    }
    
    /**
     * Tạo response lỗi (không có data)
     */
    public static Map<String, Object> error(String message, int code) {
        return error(message, code, null);
    }
    
    /**
     * Tạo response lỗi 400 (Bad Request)
     */
    public static Map<String, Object> badRequest(String message) {
        return error(message, 400);
    }
    
    /**
     * Tạo response lỗi 401 (Unauthorized)
     */
    public static Map<String, Object> unauthorized(String message) {
        return error(message, 401);
    }
    
    /**
     * Tạo response lỗi 403 (Forbidden)
     */
    public static Map<String, Object> forbidden(String message) {
        return error(message, 403);
    }
    
    /**
     * Tạo response lỗi 404 (Not Found)
     */
    public static Map<String, Object> notFound(String message) {
        return error(message, 404);
    }
    
    /**
     * Tạo response lỗi 500 (Internal Server Error)
     */
    public static Map<String, Object> internalError(String message) {
        return error(message, 500);
    }
    
    /**
     * Tạo response dữ liệu rỗng
     */
    public static Map<String, Object> noContent(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("code", 204);
        response.put("message", message);
        response.put("data", null);
        response.put("timestamp", DateTimeUtil.formatDateTime(DateTimeUtil.now()));
        return response;
    }
    
    /**
     * Tạo response với phân trang
     */
    public static Map<String, Object> successPaginated(String message, Object data, int page, int pageSize, long total) {
        Map<String, Object> pagination = new HashMap<>();
        pagination.put("page", page);
        pagination.put("pageSize", pageSize);
        pagination.put("total", total);
        pagination.put("totalPages", (int) Math.ceil((double) total / pageSize));
        
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("code", 200);
        response.put("message", message);
        response.put("data", data);
        response.put("pagination", pagination);
        response.put("timestamp", DateTimeUtil.formatDateTime(DateTimeUtil.now()));
        return response;
    }
}
