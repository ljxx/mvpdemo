package com.example.ylx.mainfragment.model.model;

import com.example.ylx.mainfragment.model.bean.InformationBean;

import java.util.List;

/**
 * Created by chenguanming on 2017/2/8.
 */

public class RepoJoke {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"老张在昨天买了一头猪，谁知早上起来却发现猪在夜里被人偷了。"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<InformationBean> data;

        public List<InformationBean> getData() {
            return data;
        }

        public void setData(List<InformationBean> data) {
            this.data = data;
        }

    }
}
