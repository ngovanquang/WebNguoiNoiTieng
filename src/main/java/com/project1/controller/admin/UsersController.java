package com.project1.controller.admin;


import com.project1.constant.SystemConstant;
import com.project1.model.UserModel;
import com.project1.paging.PageRequest;
import com.project1.paging.Pageble;
import com.project1.service.IRoleService;
import com.project1.service.IUserService;
import com.project1.sort.Sorter;
import com.project1.utils.FormUtil;
import com.project1.utils.MessageUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-users"})
public class UsersController extends HttpServlet {

    private static final long serialVersionUID = 2686801510274002166L;

    @Inject
    private IUserService userService;
    @Inject
    private IRoleService roleService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel userModel = FormUtil.toModel(UserModel.class, request);
        String view ="";
        if (userModel.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(userModel.getPage(), userModel.getMaxPageItem(),
                    new Sorter(userModel.getSortName(),userModel.getSortBy()));
            userModel.setListResult(userService.findAll(pageble));
            userModel.setTotalItem(userService.getTotalItem());
            userModel.setTotalPage((int) Math.ceil((double) userModel.getTotalItem()/userModel.getMaxPageItem()));
            view = "/views/admin/users/list.jsp";
        } else if (userModel.getType().equals(SystemConstant.EDIT)) {
            if (userModel.getId() != null) {
                userModel = userService.findOne(userModel.getId());
            }
            request.setAttribute("roles", roleService.findAll());
            view = "/views/admin/users/edit.jsp";
        }
        MessageUtil.showMessage(request);

        request.setAttribute(SystemConstant.MODEL, userModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }
}
