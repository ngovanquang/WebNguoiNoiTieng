package com.project1.controller.admin.api;

import com.project1.model.UserModel;
import com.project1.service.IUserService;
import com.project1.utils.HttpUtil;
import com.project1.utils.SessionUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-users"})
public class UserAPI extends HttpServlet {
    @Inject
    private IUserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
        userModel.setCreatedby(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        userModel = userService.save(userModel);
        mapper.writeValue(response.getOutputStream(), userModel);
    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        UserModel updateUser = HttpUtil.of(request.getReader()).toModel(UserModel.class);
        updateUser.setModifiedby(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        updateUser = userService.update(updateUser);
        mapper.writeValue(response.getOutputStream(), updateUser);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
        userService.delete(userModel.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
