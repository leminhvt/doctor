package com.example.doctor.until;

public class Constants {
    public static class RESPONSE_TYPE {
        public static final String SUCCESS = "SUCCESS";
        public static final String ERROR = "ERROR";
        public static final String WARNING = "WARNING";
        public static final String CONFIRM = "CONFIRM";
        public static final String ERROR_LOGIN = "ERROR LOGIN";
        public static final String INVALID_PERMISSION = "INVALID PERMISSION";
    }

    public static class RESPONSE_CODE {
        public static final String SUCCESS = "success";
        public static final String DELETE_SUCCESS = "deleteSuccess";
        public static final String CREATE_SUCCESS = "createSuccess";
        public static final String GET_DETAIL_SUCCESS = "getDetailSuccess";
        public static final String NO_RECORD = "no record";
        public static final String EXITS = "Exits";
        public static final String ERROR = "error";
        public static final String UNCHANGED = "unchanged";
        public static final String WARNING = "warning";
        public static final String ERROR_LOGIN = "error login";
        public static final String RECORD_DELETED = "record.deleted";
        public static final String invalidPermission = "Invalid Permission";
    }

    public static class IS_DELETED {
        public static final Boolean YES = true;
        public static final Boolean NO = false;

        private IS_DELETED() {
        }
    }

}
