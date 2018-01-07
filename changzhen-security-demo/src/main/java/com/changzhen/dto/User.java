package com.changzhen.dto;

import com.changzhen.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2017/12/22
 * @Time: 上午9:36
 */
public class User {
    public interface userSimpleView{};
    public interface userDetailView extends userSimpleView{};
    @MyConstraint(message = "this is new constraint")
    @ApiModelProperty(value = "用户名2222")
    private String username;
    @NotBlank
    private String password;
    private String id;
    private Date birthday;

    @JsonView(userSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    @JsonView(userSimpleView.class)
    public void setId(String id) {
        this.id = id;
    }

    @JsonView(userSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(userDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
