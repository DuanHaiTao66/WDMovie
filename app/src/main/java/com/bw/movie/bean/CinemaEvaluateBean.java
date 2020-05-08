package com.bw.movie.bean;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:20:20
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class CinemaEvaluateBean {

    /**
     * result : [{"commentContent":"很棒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":586,"commentTime":1588927141000,"commentUserId":13828,"commentUserName":"段海涛","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"Android","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ermNiacFa2CtwmMS7JL0vXNtRGxhEcQmBiaIjEA7aPX8a5jb9y9ZVkJjqQ1iaEq1XTGibI9Iu0LjOcxvw/132","commentId":575,"commentTime":1586566884000,"commentUserId":13867,"commentUserName":"Acolasia_8d7","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"叭叭叭","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":569,"commentTime":1586495719000,"commentUserId":13831,"commentUserName":"丁美丽","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"计算机自己","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/VVjmpg3oUichZp09ENrm0KZoZOYREzMibgcXibiauACeRich24L2Y9ZDcTN0djVJ4ycRGC5cubnBHsoJsAJ7VKToyoA/132","commentId":565,"commentTime":1586312127000,"commentUserId":13894,"commentUserName":"Deity_3D2","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"1","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/MHQjS55Skf8ppoO4RVAKmpp4Nka6e5dcqUX9OIHx9YZLOEUfTTI0HAFsCwjl3B67R0jX1BLCyWvYd7tpMPdGKg/132","commentId":563,"commentTime":1586158017000,"commentUserId":13869,"commentUserName":"DJ慢羊羊_T8k","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 很棒
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * commentId : 586
         * commentTime : 1588927141000
         * commentUserId : 13828
         * commentUserName : 段海涛
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
