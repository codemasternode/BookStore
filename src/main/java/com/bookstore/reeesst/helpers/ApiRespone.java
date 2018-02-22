package com.bookstore.reeesst.helpers;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ApiRespone {


    private final Status status;
    private final ApiError error;

    public ApiRespone(Status status, ApiError error) {
        this.status = status;
        this.error = error;
    }

    public enum Status {
        Ok,
        Error
    }

    public static final class ApiError {
        private final String error;
        private final String description;

        public ApiError(String error, String description) {
            this.error = error;
            this.description = description;
        }

        public String getError() {
            return error;
        }

        public String getDescription() {
            return description;
        }
    }

    public Status getStatus() {
        return status;
    }
    public ApiError getError() {
        return error;
    }
}
