package com.project1.controller.admin.api;

import com.project1.model.CategoryModel;
import com.project1.model.NewModel;
import com.project1.model.UserModel;
import com.project1.service.ICategoryService;
import com.project1.service.INewService;
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

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
    @Inject
    private INewService newService;
    @Inject
    private ICategoryService categoryService;

    private static final long serialVersionUID = -915988021506484384L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewModel newModel =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
        newModel.setCreatedby(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        newModel.setModifiedby(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        newModel = newService.save(newModel);
        mapper.writeValue(response.getOutputStream(), newModel);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
        updateNew.setModifiedby(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        NewModel updateNeww = newService.update(updateNew);
        mapper.writeValue(response.getOutputStream(), updateNeww);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
        newService.delete(newModel.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
