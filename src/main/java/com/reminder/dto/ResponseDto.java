package com.reminder.dto;

public class ResponseDto {
    private Object body;
    private boolean status;

    public ResponseDto(Object body, boolean status) {
        this.body = body;
        this.status = status;
    }

    public static ResponseDtoBuilder builder() {
        return new ResponseDtoBuilder();
    }

    public Object getBody() {
        return this.body;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class ResponseDtoBuilder {
        private Object body;
        private boolean status;

        ResponseDtoBuilder() {
        }

        public ResponseDtoBuilder body(Object body) {
            this.body = body;
            return this;
        }

        public ResponseDtoBuilder status(boolean status) {
            this.status = status;
            return this;
        }

        public ResponseDto build() {
            return new ResponseDto(this.body, this.status);
        }

        public String toString() {
            return "ResponseDto.ResponseDtoBuilder(body=" + this.body + ", status=" + this.status + ")";
        }
    }
}
