package com.project1.controller.web;

import com.project1.constant.SystemConstant;
import com.project1.model.CategoryModel;
import com.project1.model.NewModel;
import com.project1.service.ICategoryService;
import com.project1.service.ICelebrityService;
import com.project1.service.INewService;
import com.project1.service.IUserService;
import com.project1.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/post"})
public class PostController extends HttpServlet {
    private static final long serialVersionUID = 2686801510274002166L;

    @Inject
    private INewService newService;
    @Inject
    private IUserService userService;
    @Inject
    private ICategoryService categoryService;
    @Inject
    private ICelebrityService celebrityService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewModel newModel = FormUtil.toModel(NewModel.class, request);
        if (newModel.getId() != null) {
            NewModel updateView = newService.findOne(newModel.getId());
            newModel = newService.updateView(updateView);
        }
        request.setAttribute(SystemConstant.MODEL, newModel);
        request.setAttribute("users", userService.findAll());
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("celebrities", celebrityService.findAll());
        request.setAttribute("popularPosts", newService.popularPost(3));
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/page.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
